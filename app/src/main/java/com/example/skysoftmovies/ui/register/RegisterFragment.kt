package com.example.skysoftmovies.ui.register

import android.annotation.SuppressLint
import android.content.Intent
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.Toast
import androidx.fragment.app.Fragment
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import com.example.skysoftmovies.R
import com.example.skysoftmovies.db.database.UserDatabase
import com.example.skysoftmovies.db.modelorient.User
import com.example.skysoftmovies.db.viewModel.LoginViewModel
import com.example.skysoftmovies.ui.login.LoginActivity
import com.example.skysoftmovies.ui.main.MainViewModel
import kotlinx.android.synthetic.main.login_fragment.*

class RegisterFragment : Fragment() {

    var isExist = false

    val btnLogin2 by lazy { view?.findViewById<Button>(R.id.btn_login2) }
    val btn_register2 by lazy { view?.findViewById<Button>(R.id.btn_register2) }



    companion object {
        fun newInstance() = RegisterFragment()
    }


    private lateinit var viewModel: MainViewModel

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?,
                              savedInstanceState: Bundle?): View {
        return inflater.inflate(R.layout.fragment_register, container, false)

    }




    @SuppressLint("FragmentLiveDataObserve")
    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)

       // val userDetailsRepository = activity?.let { ViewModelProvider(it).get(LoginViewModel::class.java) }
        val userDetailsRepository = ViewModelProvider(activity!!).get(LoginViewModel::class.java)
        btnLogin2?.setOnClickListener {
            val intent = Intent(activity, LoginActivity::class.java)
            intent.addFlags(Intent.FLAG_ACTIVITY_NO_HISTORY)//no history flag
            // start your next activity
            startActivity(intent)
        }



        btn_register2?.setOnClickListener {
            if (validation()) {
                userDetailsRepository.getGetAllData().observe(this, object : Observer<List<User>> {
                    override fun onChanged(t: List<User>) {
                        var userObject = t

                        for (i in userObject.indices) {


                            if (userObject[i].mobillogin?.equals(et_user.text.toString())!!) {
                                isExist = true
                                //Toast.makeText(this@SignupActivity," User Already Registered ", Toast.LENGTH_LONG).show()
                                break

                            } else {
                                isExist = false
                                continue

                            }
                        }

                        if (isExist) {
                            Toast.makeText(activity, " User Already Registered !!! ", Toast.LENGTH_LONG)
                                .show()

                        } else {

                            val user = User()
                            user.mobillogin = et_user.text.toString()
                            user.password = et_pass.text.toString()
                            val userDatabase = UserDatabase
                            userDatabase.getDatabase(activity!!)?.daoAccess()?.insertUserData(user)
                            Toast.makeText(activity, " User  Registered Successfully", Toast.LENGTH_LONG)
                                .show()


                        }

                    }

                })
            }

        }


    }


    private fun validation(): Boolean {

        if (et_user.text.isNullOrEmpty()) {
            Toast.makeText(activity, " Enter Mobile Number ", Toast.LENGTH_LONG).show()
            return false
        }
//        if (et_user.text.toString().emailRegex.matcher("john.doe@mail.com").matches()) {
//            Toast.makeText(activity, " Enter valid email ", Toast.LENGTH_LONG).show()
//            return false
//        }


        if (et_pass.text.isNullOrEmpty()) {
            Toast.makeText(activity, " Enter Password ", Toast.LENGTH_LONG).show()
            return false
        }
        if (et_pass.text.toString().length < 4 ) {
            Toast.makeText(activity, " Enter minimum 4 symbol ", Toast.LENGTH_LONG).show()
            return false
        }
        if (et_pass.text.toString().length > 20 ) {
            Toast.makeText(activity, " Enter max 20 symbol ", Toast.LENGTH_LONG).show()
            return false
        }
        return true
    }


}


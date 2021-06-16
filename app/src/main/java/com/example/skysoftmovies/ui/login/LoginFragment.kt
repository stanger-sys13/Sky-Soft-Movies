package com.example.skysoftmovies.ui.login

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
import com.example.skysoftmovies.db.modelorient.User
import com.example.skysoftmovies.db.viewModel.LoginViewModel
import com.example.skysoftmovies.ui.list.ListMoviesActivity
import com.example.skysoftmovies.ui.main.MainViewModel
import com.example.skysoftmovies.ui.register.ActivityRegister
import kotlinx.android.synthetic.main.login_fragment.*
import java.util.regex.Pattern.compile


class LoginFragment: Fragment() {

    var isExist = false

    val btnLogin by lazy { view?.findViewById<Button>(R.id.btn_login) }
    val btn_register by lazy { view?.findViewById<Button>(R.id.btn_register) }

    companion object {
        fun newInstance() = LoginFragment()
    }


    private lateinit var viewModel: MainViewModel

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?,
                              savedInstanceState: Bundle?): View {
        return inflater.inflate(R.layout.login_fragment, container, false)
    }



    @SuppressLint("FragmentLiveDataObserve")
    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)

        val userDetailsRepository = ViewModelProvider(this).get(LoginViewModel::class.java)

        btn_register?.setOnClickListener {
            val intent = Intent(activity, ActivityRegister::class.java)
            intent.addFlags(Intent.FLAG_ACTIVITY_NO_HISTORY)//no history flag
            // start  next activity
            startActivity(intent)
        }



        btnLogin?.setOnClickListener {
            if (validation()) {

                userDetailsRepository.getGetAllData().observe(this, object : Observer<List<User>> {
                    override fun onChanged(t: List<User>) {
                        var userObject = t

                        for (i in userObject.indices) {
                            if (userObject[i].mobillogin?.equals(et_user.text.toString())!!) {

                                if (userObject[i].password?.equals(et_pass.text.toString())!!) {


                                    val intent = Intent(activity, ListMoviesActivity::class.java)
                                        .putExtra("UserDetials", userObject[i])
                                    // ListMoviesActivity -> ProfileActivity
                                    startActivity(intent)

                                } else {
                                    Toast.makeText(activity, " Password is Incorrect ", Toast.LENGTH_LONG)
                                        .show()

                                }
                                isExist = true
                                break

                            } else {
                                isExist = false
                            }
                        }

                        if (isExist) {

                        } else {

                            Toast.makeText(activity, " User Not Registered ", Toast.LENGTH_LONG).show()
                        }

                    }

                })
            }
        }


    }
    private val emailRegex = compile(
        "[a-zA-Z0-9\\+\\.\\_\\%\\-\\+]{1,256}" +
                "\\@" +
                "[a-zA-Z0-9][a-zA-Z0-9\\-]{0,64}" +
                "(" +
                "\\." +
                "[a-zA-Z0-9][a-zA-Z0-9\\-]{0,25}" +
                ")+"
    )
    private fun validation(): Boolean {

        if (et_user.text.isNullOrEmpty()) {
            Toast.makeText(activity, " Enter Login ", Toast.LENGTH_LONG).show()
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
        return true
    }


}










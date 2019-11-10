package sanaebadi.info.singleton

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.databinding.DataBindingUtil
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import kotlinx.android.synthetic.main.activity_main.*
import sanaebadi.info.singleton.databinding.ActivityMainBinding
import sanaebadi.info.singleton.model.User
import sanaebadi.info.singleton.viewModel.MainViewModel

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding

    lateinit var viewModel: MainViewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = DataBindingUtil.setContentView(this, R.layout.activity_main)

//        user = ExampleSingleton.user
//
//        binding.user = user

        binding.lifecycleOwner = this


        viewModel = ViewModelProvider(this).get(MainViewModel::class.java)



        binding.userModel = viewModel

        viewModel.user.observe(this, Observer { user ->
            println("DEBUG : ${user}")

            viewModel.setUserName(user.username)
            viewModel.setEmail(user.email)
            viewModel.setImage(user.image)

        })

        viewModel.setUserId("1")

        // println("DEBUG : {${ExampleSingleton.user}}")
    }

    override fun onDestroy() {
        super.onDestroy()
        viewModel.cancelJob()
    }
}

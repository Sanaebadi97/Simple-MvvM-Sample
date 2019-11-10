package sanaebadi.info.singleton

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.databinding.DataBindingUtil
import sanaebadi.info.singleton.databinding.ActivityMainBinding
import sanaebadi.info.singleton.model.User

class MainActivity : AppCompatActivity() {

    lateinit var binding: ActivityMainBinding

    lateinit var user: User

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = DataBindingUtil.setContentView(this, R.layout.activity_main)

        user = ExampleSingleton.user

        binding.user = user


        println("DEBUG : {${ExampleSingleton.user}}")
    }
}

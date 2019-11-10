package sanaebadi.info.singleton.viewModel

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.Transformations
import androidx.lifecycle.ViewModel
import sanaebadi.info.singleton.model.User
import sanaebadi.info.singleton.repository.Repository

class MainViewModel : ViewModel() {

    private val _userId: MutableLiveData<String> = MutableLiveData()

    val user: LiveData<User> = Transformations.switchMap(_userId) { userId ->
        Repository.getUser(userId)

    }


    private val _username: MutableLiveData<String> = MutableLiveData()

    val userName: LiveData<String>
        get() = _username


    private val _email: MutableLiveData<String> = MutableLiveData()

    val email: LiveData<String>
        get() = _email


    private val _image: MutableLiveData<String> = MutableLiveData()

    val image: LiveData<String>
        get() = _image

    fun setUserId(userId: String) {
        if (_userId.value == userId) {
            return
        }
        _userId.value = userId

    }

    fun setUserName(userName: String) {
        val update = userName
        if (_username.value == update) {
            return
        }
        _username.value = update
    }

    fun setEmail(email: String) {
        val update = email
        if (_email.value == update) {
            return
        }
        _email.value = update
    }

    fun setImage(image: String) {
        val update = image
        if (_image.value == update) {
            return
        }
        _image.value = update
    }



    fun cancelJob() {
        Repository.cancelJob()
    }
}
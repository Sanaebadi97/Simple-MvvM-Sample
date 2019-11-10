package sanaebadi.info.singleton.repository

import androidx.lifecycle.LiveData
import kotlinx.coroutines.*
import kotlinx.coroutines.Dispatchers.IO
import kotlinx.coroutines.Dispatchers.Main
import sanaebadi.info.singleton.api.RetrofitClient
import sanaebadi.info.singleton.model.User

object Repository {
    var job: CompletableJob? = null

    fun getUser(userId: String): LiveData<User> {
        job = Job()

        return object : LiveData<User>() {
            override fun onActive() {
                super.onActive()
                job?.let { theJob ->
                    CoroutineScope(IO + theJob).launch {
                        val user = RetrofitClient.apiService.getUser(userId)
                        withContext(Main) {
                            value = user
                            theJob.complete()
                        }
                    }

                }
            }
        }
    }

    fun cancelJob() {
        job?.cancel()
    }
}
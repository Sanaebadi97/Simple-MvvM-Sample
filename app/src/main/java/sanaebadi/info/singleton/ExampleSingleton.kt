package sanaebadi.info.singleton

import sanaebadi.info.singleton.model.User

object ExampleSingleton {
    val user: User by lazy {
        User("sanaebadi@gmail.com", "Sana Ebadi", "https://files.virgool.io/upload/users/13002/avatar/eliPcY.png?x-oss-process=image/resize,h_90,w_90,center")
    }
}
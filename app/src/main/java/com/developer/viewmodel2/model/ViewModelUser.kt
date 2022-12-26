package com.developer.viewmodel2.model

import androidx.compose.runtime.MutableState
import androidx.compose.runtime.mutableStateListOf
import androidx.lifecycle.ViewModel
import com.developer.viewmodel2.R

class ViewModelUser: ViewModel() {
    private var _dataUser = mutableStateListOf<User>()


    //Init data
    init {
        initDataUser()
    }

    //CRUD
    var dataUser
        get() = _dataUser
        set(value) {_dataUser = value}

    //Utils
    //ADD
    fun addUser(user: User) {
       _dataUser.add(user)
    }

    //Remove in index
    fun removeAtIndex(pos: Int) {
        _dataUser.removeAt(pos)

        //over loading
        _dataUser = _dataUser
    }

    //Edit in index
    fun editAtIndex(pos: Int, user: User) {
        _dataUser[pos] = user
        _dataUser = _dataUser
    }



    private fun initDataUser() {
        _dataUser.add(
            User(R.drawable.ic_launcher_background, "Thắng 716")
        )
        _dataUser.add(
            User(R.drawable.avatar, "Thắng Bmt")
        )
    }

}

data class User(
    var avatar: Int = R.drawable.avatar,
    var name: String = "Thắng"
)
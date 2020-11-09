package com.example.p03_locker

import kotlin.Boolean as KotlinBoolean

class Locker {
    var locked: KotlinBoolean = false
    var password: Int = 0
    var password_of_user_input: Int = 0

    fun set_password(num: Int): kotlin.Boolean {
        if (!this.locked) {
            this.password = num
            return true
        } else {
            return false
        }
    }

    fun lock(){
        this.locked = true
    }

    fun unlock(num: Int): kotlin.Boolean {
        this.password_of_user_input = num
        if (num == password){
            this.locked = false
            return true
        }else{
            return false
        }
    }

    fun get_diff(): Int {
        return this.password_of_user_input - this.password
    }

    fun get_hint_whether_is_it_bigger(): kotlin.Boolean {
        return this.get_diff() > 0

    }
}
package com.example.p03_locker

import org.junit.Test

import org.junit.Assert.*

/**
 * Example local unit test, which will execute on the development machine (host).
 *
 * See [testing documentation](http://d.android.com/tools/testing).
 */
class ExampleUnitTest {

    @Test
    fun test_Locker_init_is_unlocked() {
        val locker = Locker()
        assertEquals(false, locker.locked)
    }

    @Test
    fun test_Locker_try_to_set_password_when_opened() {
        val locker = Locker()
        val ret: Boolean = locker.set_password(5)
        assertEquals(true, ret)
    }

    @Test
    fun test_Locker_try_to_set_password_when_locked() {
        val locker = Locker()
        locker.lock()
        val ret: Boolean = locker.set_password(5)
        assertEquals(false, ret)
    }


    @Test
    fun test_unlock_default_password(){
        val locker = Locker()
        locker.lock()
        val ret: Boolean = locker.unlock(0)
        assertEquals(true, ret)
    }


    @Test
    fun test_unlock_with_correct_password(){
        val locker = Locker()
        locker.set_password(5)
        locker.lock()
        val ret: Boolean = locker.unlock(5)
        assertEquals(true, ret)
    }

    @Test
    fun test_unlock_with_error_password(){
        val locker = Locker()
        locker.set_password(5)
        locker.lock()
        val ret: Boolean = locker.unlock(4)
        assertEquals(false, ret)
    }

    @Test
    fun test_get_diff(){
        val locker = Locker()
        locker.set_password(5)
        locker.lock()
        locker.unlock(4)
        val hint: Int = locker.get_diff()
        assertEquals(1, hint)

        locker.unlock(7)
        assertEquals(-2, locker.get_diff())
    }

    @Test
    fun test_get_hint_whether_is_it_bigger() {
        val locker = Locker()
        locker.set_password(5)
        locker.lock()
        locker.unlock(4)
        assertEquals(false, locker.get_hint_whether_is_it_bigger())

        locker.unlock(6)
        assertEquals(true, locker.get_hint_whether_is_it_bigger())

    }

}
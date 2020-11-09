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
    fun addition_isCorrect() {
        assertEquals(4, 2 + 2)
    }

    @Test
    fun test_Locker_init_is_unlocked() {
        var locker = Locker()
        assertEquals(false, locker.locked)
    }

    @Test
    fun test_Locker_try_to_set_password_when_opened() {
        var locker = Locker()
        var ret: Boolean = locker.set_password(5)
        assertEquals(true, ret)
    }

    @Test
    fun test_Locker_try_to_set_password_when_locked() {
        var locker = Locker()
        locker.lock()
        var ret: Boolean = locker.set_password(5)
        assertEquals(false, ret)
    }


    @Test
    fun test_unlock_default_password(){
        var locker = Locker()
        locker.lock()
        var ret: Boolean = locker.unlock(0)
        assertEquals(true, ret)
    }


    @Test
    fun test_unlock_with_correct_password(){
        var locker = Locker()
        locker.set_password(5)
        locker.lock()
        var ret: Boolean = locker.unlock(5)
        assertEquals(true, ret)
    }

    @Test
    fun test_unlock_with_error_password(){
        var locker = Locker()
        locker.set_password(5)
        locker.lock()
        var ret: Boolean = locker.unlock(4)
        assertEquals(false, ret)
    }

    @Test
    fun test_get_diff(){
        var locker = Locker()
        locker.set_password(5)
        locker.lock()
        locker.unlock(4)
        var hint: Int = locker.get_diff()
        assertEquals(1, hint)

        locker.unlock(7)
        assertEquals(-2, locker.get_diff())
    }

    @Test
    fun test_get_hint_whether_is_it_bigger() {
        var locker = Locker()
        locker.set_password(5)
        locker.lock()
        locker.unlock(4)
        assertEquals(false, locker.get_hint_whether_is_it_bigger())

        //locker.unlock(6)
        //assertEquals(true, locker.get_hint_whether_is_it_bigger())

    }

}
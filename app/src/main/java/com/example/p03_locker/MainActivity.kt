package com.example.p03_locker

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.*
import kotlin.random.Random

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val imageview: ImageView = findViewById(R.id.imageView)
        imageview.setImageResource(R.drawable.lock)

        val guessnumTextView: TextView = findViewById(R.id.textview1)

        val locker = Locker()
        locker.set_password(10)
        locker.lock()


        val addbutton: Button = findViewById(R.id.addbutton)
        addbutton.setOnClickListener {
            var s: String = guessnumTextView.text as String
            var n: Int = s.toInt()
            if (n < 20){
                n += 1
            }
            guessnumTextView.setText(n.toString())
        }

        val decbutton: Button = findViewById(R.id.decbutton)
        decbutton.setOnClickListener {
            var s: String = guessnumTextView.text as String
            var n: Int = s.toInt()
            if (n > 0){
                n -= 1
            }
            guessnumTextView.setText(n.toString())
        }

        val guessbutton: Button = findViewById(R.id.guessbutton)
        guessbutton.setOnClickListener {
            var s: String = guessnumTextView.text as String
            var n: Int = s.toInt()

            val ret: Boolean = locker.unlock(n)
            val toast = Toast.makeText(this, ret.toString(), Toast.LENGTH_SHORT)
            toast.show()
            if (ret) {
                imageview.setImageResource(R.drawable._1)
            } else {
                imageview.setImageResource(R.drawable.lock)

            }
        }

        val resetbutton: Button = findViewById(R.id.resetbutton)
        resetbutton.setOnClickListener {
            imageview.setImageResource(R.drawable.lock)

            var n: Int = Random.nextInt(0, 20)
            locker.set_password(n)
            locker.lock()
        }

    }
}
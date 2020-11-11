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

        val imageList = listOf(R.drawable.achi,
                R.drawable.hwehwe,
                R.drawable.luma,
                R.drawable.tenten,
                R.drawable.xiaoli,
                R.drawable.yakult)

        val addbutton: Button = findViewById(R.id.addbutton)
        addbutton.setOnClickListener {
            val s: String = guessnumTextView.text as String
            var n: Int = s.toInt()
            if (n < 20){
                n += 1
            }
            guessnumTextView.setText(n.toString())
        }

        val decbutton: Button = findViewById(R.id.decbutton)
        decbutton.setOnClickListener {
            val s: String = guessnumTextView.text as String
            var n: Int = s.toInt()
            if (n > 0){
                n -= 1
            }
            guessnumTextView.setText(n.toString())
        }


        val guessbutton: Button = findViewById(R.id.guessbutton)
        guessbutton.setOnClickListener {
            val s: String = guessnumTextView.text as String
            val n: Int = s.toInt()

            val ret: Boolean = locker.unlock(n)
            if (ret) {
                val img = imageList[Random.nextInt(0, imageList.size)]
                imageview.setImageResource(img)
            } else {
                imageview.setImageResource(R.drawable.lock)
                val hint = locker.get_hint_whether_is_it_bigger()
                if (hint) {
                    val toast = Toast.makeText(this, "Too Big", Toast.LENGTH_SHORT)
                    toast.show()
                } else {
                    val toast = Toast.makeText(this, "Too Small", Toast.LENGTH_SHORT)
                    toast.show()
                }
            }
        }

        val resetbutton: Button = findViewById(R.id.resetbutton)
        resetbutton.setOnClickListener {
            imageview.setImageResource(R.drawable.lock)

            val n: Int = Random.nextInt(0, 20)
            locker.set_password(n)
            locker.lock()
        }

    }
}
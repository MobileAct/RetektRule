package retekt.app

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity

class MainActivity : AppCompatActivity(), IActivity {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
    }

    class Success<T, TResult> {

        companion object {

            const val value1 = ""
            val value2 = ""
            private val _value3 = ""
        }

        val value4 = ""
        private val value5 = ""
    }

    enum class Entry {
        Value
    }
}

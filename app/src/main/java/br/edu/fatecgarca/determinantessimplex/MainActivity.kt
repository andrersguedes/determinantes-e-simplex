package br.edu.fatecgarca.determinantessimplex

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import androidx.appcompat.app.AppCompatActivity
import androidx.core.splashscreen.SplashScreen.Companion.installSplashScreen

class MainActivity : AppCompatActivity() {

    private lateinit var btnDet2: Button
    private lateinit var btnDet3: Button
    private lateinit var btnDet4: Button

    override fun onCreate(savedInstanceState: Bundle?) {
        // Handle the splash screen transition.
        installSplashScreen()

        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        btnDet2 = findViewById(R.id.btnDet2)
        btnDet3 = findViewById(R.id.btnDet3)
        btnDet4 = findViewById(R.id.btnDet4)

        val intent = Intent(this, Det2::class.java)

        btnDet2.setOnClickListener {
            intent.putExtra("nome", btnDet2.text.toString())
            startActivity(intent)
        }
        btnDet3.setOnClickListener {
            intent.putExtra("nome", btnDet3.text.toString())
            startActivity(intent)
        }
        btnDet4.setOnClickListener {
            intent.putExtra("nome", btnDet4.text.toString())
            startActivity(intent)
        }
    }
}

package br.edu.fatecgarca.determinantessimplex

import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import br.edu.fatecgarca.determinantessimplex.calculos.Calculos

class Det4 : AppCompatActivity(), View.OnClickListener {

    private lateinit var btnCalcDet4: Button
    private lateinit var edtDet1: EditText
    private lateinit var edtDet2: EditText
    private lateinit var edtDet3: EditText
    private lateinit var edtDet4: EditText
    private lateinit var edtDet5: EditText
    private lateinit var edtDet6: EditText
    private lateinit var edtDet7: EditText
    private lateinit var edtDet8: EditText
    private lateinit var edtDet9: EditText
    private lateinit var edtDet10: EditText
    private lateinit var edtDet11: EditText
    private lateinit var edtDet12: EditText
    private lateinit var edtDet13: EditText
    private lateinit var edtDet14: EditText
    private lateinit var edtDet15: EditText
    private lateinit var edtDet16: EditText
    private var res: Double = 0.0
    private lateinit var txtRes: TextView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.det4)

        intent.extras?.getString("nome")?.let {
            title = it
        }

        edtDet1 = findViewById(R.id.det4_00)
        edtDet2 = findViewById(R.id.det4_01)
        edtDet3 = findViewById(R.id.det4_02)
        edtDet4 = findViewById(R.id.det4_03)
        edtDet5 = findViewById(R.id.det4_10)
        edtDet6 = findViewById(R.id.det4_11)
        edtDet7 = findViewById(R.id.det4_12)
        edtDet8 = findViewById(R.id.det4_13)
        edtDet9 = findViewById(R.id.det4_20)
        edtDet10 = findViewById(R.id.det4_21)
        edtDet11 = findViewById(R.id.det4_22)
        edtDet12 = findViewById(R.id.det4_23)
        edtDet13 = findViewById(R.id.det4_30)
        edtDet14 = findViewById(R.id.det4_31)
        edtDet15 = findViewById(R.id.det4_32)
        edtDet16 = findViewById(R.id.det4_33)
        txtRes = findViewById(R.id.txtResDet3)
        btnCalcDet4 = findViewById(R.id.btnCalcDet4)
        btnCalcDet4.setOnClickListener(this)
    }

    override fun onClick(v: View) {
        if (v.id == R.id.btnCalcDet4) {
            if (edtDet1.text.toString().isEmpty() ||
                edtDet2.text.toString().isEmpty() ||
                edtDet3.text.toString().isEmpty() ||
                edtDet4.text.toString().isEmpty() ||
                edtDet5.text.toString().isEmpty() ||
                edtDet6.text.toString().isEmpty() ||
                edtDet7.text.toString().isEmpty() ||
                edtDet8.text.toString().isEmpty() ||
                edtDet9.text.toString().isEmpty() ||
                edtDet10.text.toString().isEmpty() ||
                edtDet11.text.toString().isEmpty() ||
                edtDet12.text.toString().isEmpty() ||
                edtDet13.text.toString().isEmpty() ||
                edtDet14.text.toString().isEmpty() ||
                edtDet15.text.toString().isEmpty() ||
                edtDet16.text.toString().isEmpty()
            ) {
                Toast.makeText(this, getString(R.string.fill_all_values_error), Toast.LENGTH_SHORT).show()
            } else {
                val matriz = arrayOf(
                    doubleArrayOf(
                        edtDet1.text.toString().toDouble(),
                        edtDet2.text.toString().toDouble(),
                        edtDet3.text.toString().toDouble(),
                        edtDet4.text.toString().toDouble()
                    ),
                    doubleArrayOf(
                        edtDet5.text.toString().toDouble(),
                        edtDet6.text.toString().toDouble(),
                        edtDet7.text.toString().toDouble(),
                        edtDet8.text.toString().toDouble()
                    ),
                    doubleArrayOf(
                        edtDet9.text.toString().toDouble(),
                        edtDet10.text.toString().toDouble(),
                        edtDet11.text.toString().toDouble(),
                        edtDet12.text.toString().toDouble()
                    ),
                    doubleArrayOf(
                        edtDet13.text.toString().toDouble(),
                        edtDet14.text.toString().toDouble(),
                        edtDet15.text.toString().toDouble(),
                        edtDet16.text.toString().toDouble()
                    )
                )

                val calculos = Calculos()
                res = calculos.det4(matriz)
                txtRes.text = res.toString()
            }
        }
    }
}

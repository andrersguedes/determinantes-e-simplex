package br.edu.fatecgarca.determinantessimplex

import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import br.edu.fatecgarca.determinantessimplex.calculos.Calculos

class Det3 : AppCompatActivity(), View.OnClickListener {

    private lateinit var btnCalcDet3: Button
    private lateinit var edtDet1: EditText
    private lateinit var edtDet2: EditText
    private lateinit var edtDet3: EditText
    private lateinit var edtDet4: EditText
    private lateinit var edtDet5: EditText
    private lateinit var edtDet6: EditText
    private lateinit var edtDet7: EditText
    private lateinit var edtDet8: EditText
    private lateinit var edtDet9: EditText
    private var res: Double = 0.0
    private lateinit var txtRes: TextView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.det3)

        intent.extras?.getString("nome")?.let {
            title = it
        }

        edtDet1 = findViewById(R.id.det3_00)
        edtDet2 = findViewById(R.id.det3_01)
        edtDet3 = findViewById(R.id.det3_02)
        edtDet4 = findViewById(R.id.det3_10)
        edtDet5 = findViewById(R.id.det3_11)
        edtDet6 = findViewById(R.id.det3_12)
        edtDet7 = findViewById(R.id.det3_20)
        edtDet8 = findViewById(R.id.det3_21)
        edtDet9 = findViewById(R.id.det3_22)
        txtRes = findViewById(R.id.txtResDet3)
        btnCalcDet3 = findViewById(R.id.btnCalcDet3)
        btnCalcDet3.setOnClickListener(this)
    }

    override fun onClick(v: View) {
        if (v.id == R.id.btnCalcDet3) {
            if (edtDet1.text.toString().isEmpty() ||
                edtDet2.text.toString().isEmpty() ||
                edtDet3.text.toString().isEmpty() ||
                edtDet4.text.toString().isEmpty() ||
                edtDet5.text.toString().isEmpty() ||
                edtDet6.text.toString().isEmpty() ||
                edtDet7.text.toString().isEmpty() ||
                edtDet8.text.toString().isEmpty() ||
                edtDet9.text.toString().isEmpty()
            ) {
                Toast.makeText(this, getString(R.string.fill_all_values_error), Toast.LENGTH_SHORT).show()
            } else {
                val matriz = arrayOf(
                    doubleArrayOf(
                        edtDet1.text.toString().toDouble(),
                        edtDet2.text.toString().toDouble(),
                        edtDet3.text.toString().toDouble()
                    ),
                    doubleArrayOf(
                        edtDet4.text.toString().toDouble(),
                        edtDet5.text.toString().toDouble(),
                        edtDet6.text.toString().toDouble()
                    ),
                    doubleArrayOf(
                        edtDet7.text.toString().toDouble(),
                        edtDet8.text.toString().toDouble(),
                        edtDet9.text.toString().toDouble()
                    )
                )

                val calculos = Calculos()
                res = calculos.det3(matriz)
                txtRes.text = res.toString()
            }
        }
    }
}

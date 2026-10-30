package br.edu.fatecgarca.determinantessimplex

import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import br.edu.fatecgarca.determinantessimplex.calculos.Calculos

class Det2 : AppCompatActivity(), View.OnClickListener {

    private lateinit var btnCalcDet2: Button
    private lateinit var edtDet1: EditText
    private lateinit var edtDet2: EditText
    private lateinit var edtDet3: EditText
    private lateinit var edtDet4: EditText
    private lateinit var txtRes: TextView
    private var res: Double = 0.0

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.det2)

        intent.extras?.getString("nome")?.let {
            title = it
        }

        edtDet1 = findViewById(R.id.det2_00)
        edtDet2 = findViewById(R.id.det2_01)
        edtDet3 = findViewById(R.id.det2_10)
        edtDet4 = findViewById(R.id.det2_11)
        txtRes = findViewById(R.id.txtResDet2)
        btnCalcDet2 = findViewById(R.id.btnCalcDet2)
        btnCalcDet2.setOnClickListener(this)
    }

    override fun onClick(v: View) {
        if (v.id == R.id.btnCalcDet2) {
            if (edtDet1.text.toString().isEmpty() ||
                edtDet2.text.toString().isEmpty() ||
                edtDet3.text.toString().isEmpty() ||
                edtDet4.text.toString().isEmpty()
            ) {
                Toast.makeText(this, getString(R.string.fill_all_values_error), Toast.LENGTH_SHORT).show()
            } else {
                val matriz = arrayOf(
                    doubleArrayOf(
                        edtDet1.text.toString().toDouble(),
                        edtDet2.text.toString().toDouble()
                    ),
                    doubleArrayOf(
                        edtDet3.text.toString().toDouble(),
                        edtDet4.text.toString().toDouble()
                    )
                )

                val calculos = Calculos()
                res = calculos.det2(matriz)
                txtRes.text = res.toString()
            }
        }
    }
}

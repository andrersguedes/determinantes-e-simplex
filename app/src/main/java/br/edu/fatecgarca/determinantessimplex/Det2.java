package br.edu.fatecgarca.determinantessimplex;

import br.edu.fatecgarca.determinantessimplex.calculos.Calculos;
import androidx.appcompat.app.AppCompatActivity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class Det2 extends AppCompatActivity implements OnClickListener {

	Button btnCalcDet2;
	EditText edtDet1, edtDet2, edtDet3, edtDet4;
	double res = 0;
	TextView txtRes;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		super.onCreate(savedInstanceState);
		setContentView(R.layout.det2);

		Intent intent = getIntent();
		this.setTitle(intent.getExtras().getString("nome"));

		edtDet1 = (EditText) findViewById(R.id.det2_00);
		edtDet2 = (EditText) findViewById(R.id.det2_01);
		edtDet3 = (EditText) findViewById(R.id.det2_10);
		edtDet4 = (EditText) findViewById(R.id.det2_11);
		txtRes = (TextView) findViewById(R.id.txtResDet2);
		btnCalcDet2 = (Button) findViewById(R.id.btnCalcDet2);
		btnCalcDet2.setOnClickListener(this);
	}

	@Override
	public void onClick(View v) {
		if (v.getId() == R.id.btnCalcDet2) {
			if (edtDet1.getText().toString().equals("")
					|| edtDet2.getText().toString().equals("")
					|| edtDet3.getText().toString().equals("")
					|| edtDet4.getText().toString().equals("")) {
				Toast.makeText(this, "Digite todos os valores da matriz!",
						Toast.LENGTH_SHORT).show();
			} else {
				double[][] matriz = new double[2][2];
				matriz[0][0] = Double.parseDouble(edtDet1.getText().toString());
				matriz[0][1] = Double.parseDouble(edtDet2.getText().toString());
				matriz[1][0] = Double.parseDouble(edtDet3.getText().toString());
				matriz[1][1] = Double.parseDouble(edtDet4.getText().toString());

				Calculos calculos = new Calculos();
				res = calculos.det2(matriz);
				txtRes.setText(String.valueOf(res));
			}
		}
	}
}

package br.edu.fatecgarca.determinantes;

import androidx.appcompat.app.AppCompatActivity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;
import br.edu.fatecgarca.determinantes.calculos.Calculos;

public class Det3 extends AppCompatActivity implements OnClickListener {

	Button btnCalcDet3;
	EditText edtDet1, edtDet2, edtDet3, edtDet4, edtDet5, edtDet6, edtDet7,
			edtDet8, edtDet9;
	double res = 0;
	TextView txtRes;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		super.onCreate(savedInstanceState);
		setContentView(R.layout.det3);
		
		Intent intent = getIntent();
		this.setTitle(intent.getExtras().getString("nome"));

		edtDet1 = (EditText) findViewById(R.id.det3_00);
		edtDet2 = (EditText) findViewById(R.id.det3_01);
		edtDet3 = (EditText) findViewById(R.id.det3_02);
		edtDet4 = (EditText) findViewById(R.id.det3_10);
		edtDet5 = (EditText) findViewById(R.id.det3_11);
		edtDet6 = (EditText) findViewById(R.id.det3_12);
		edtDet7 = (EditText) findViewById(R.id.det3_20);
		edtDet8 = (EditText) findViewById(R.id.det3_21);
		edtDet9 = (EditText) findViewById(R.id.det3_22);
		txtRes = (TextView) findViewById(R.id.txtResDet3);
		btnCalcDet3 = (Button) findViewById(R.id.btnCalcDet3);
		btnCalcDet3.setOnClickListener(this);
	}

	@Override
	public void onClick(View v) {
		if (v.getId() == R.id.btnCalcDet3) {
			if (edtDet1.getText().toString().equals("")
					|| edtDet2.getText().toString().equals("")
					|| edtDet3.getText().toString().equals("")
					|| edtDet4.getText().toString().equals("")
					|| edtDet5.getText().toString().equals("")
					|| edtDet6.getText().toString().equals("")
					|| edtDet7.getText().toString().equals("")
					|| edtDet8.getText().toString().equals("")
					|| edtDet9.getText().toString().equals("")) {
				Toast.makeText(this, "Digite todos os valores da matriz!",
						Toast.LENGTH_SHORT).show();
			} else {
				double[][] matriz = new double[3][3];
				matriz[0][0] = Double.parseDouble(edtDet1.getText().toString());
				matriz[0][1] = Double.parseDouble(edtDet2.getText().toString());
				matriz[0][2] = Double.parseDouble(edtDet3.getText().toString());
				matriz[1][0] = Double.parseDouble(edtDet4.getText().toString());
				matriz[1][1] = Double.parseDouble(edtDet5.getText().toString());
				matriz[1][2] = Double.parseDouble(edtDet6.getText().toString());
				matriz[2][0] = Double.parseDouble(edtDet7.getText().toString());
				matriz[2][1] = Double.parseDouble(edtDet8.getText().toString());
				matriz[2][2] = Double.parseDouble(edtDet9.getText().toString());

				Calculos calculos = new Calculos();
				res = calculos.det3(matriz);
				txtRes.setText(String.valueOf(res));
			}
		}
	}
}

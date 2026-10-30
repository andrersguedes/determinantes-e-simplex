package br.edu.fatecgarca.determinantessimplex;

import androidx.appcompat.app.AppCompatActivity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;
import br.edu.fatecgarca.determinantessimplex.calculos.Calculos;

public class Det4 extends AppCompatActivity implements OnClickListener {

	Button btnCalcDet4;
	EditText edtDet1, edtDet2, edtDet3, edtDet4, edtDet5, edtDet6, edtDet7,
			edtDet8, edtDet9, edtDet10, edtDet11, edtDet12, edtDet13, edtDet14,
			edtDet15, edtDet16;
	double res = 0;
	TextView txtRes;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		super.onCreate(savedInstanceState);
		setContentView(R.layout.det4);

		Intent intent = getIntent();
		this.setTitle(intent.getExtras().getString("nome"));

		edtDet1 = (EditText) findViewById(R.id.det4_00);
		edtDet2 = (EditText) findViewById(R.id.det4_01);
		edtDet3 = (EditText) findViewById(R.id.det4_02);
		edtDet4 = (EditText) findViewById(R.id.det4_03);
		edtDet5 = (EditText) findViewById(R.id.det4_10);
		edtDet6 = (EditText) findViewById(R.id.det4_11);
		edtDet7 = (EditText) findViewById(R.id.det4_12);
		edtDet8 = (EditText) findViewById(R.id.det4_13);
		edtDet9 = (EditText) findViewById(R.id.det4_20);
		edtDet10 = (EditText) findViewById(R.id.det4_21);
		edtDet11 = (EditText) findViewById(R.id.det4_22);
		edtDet12 = (EditText) findViewById(R.id.det4_23);
		edtDet13 = (EditText) findViewById(R.id.det4_30);
		edtDet14 = (EditText) findViewById(R.id.det4_31);
		edtDet15 = (EditText) findViewById(R.id.det4_32);
		edtDet16 = (EditText) findViewById(R.id.det4_33);
		txtRes = (TextView) findViewById(R.id.txtResDet3);
		btnCalcDet4 = (Button) findViewById(R.id.btnCalcDet4);
		btnCalcDet4.setOnClickListener(this);
	}

	@Override
	public void onClick(View v) {
		if (v.getId() == R.id.btnCalcDet4) {
			if (edtDet1.getText().toString().equals("")
					|| edtDet2.getText().toString().equals("")
					|| edtDet3.getText().toString().equals("")
					|| edtDet4.getText().toString().equals("")
					|| edtDet5.getText().toString().equals("")
					|| edtDet6.getText().toString().equals("")
					|| edtDet7.getText().toString().equals("")
					|| edtDet8.getText().toString().equals("")
					|| edtDet9.getText().toString().equals("")
					|| edtDet10.getText().toString().equals("")
					|| edtDet11.getText().toString().equals("")
					|| edtDet12.getText().toString().equals("")
					|| edtDet13.getText().toString().equals("")
					|| edtDet14.getText().toString().equals("")
					|| edtDet15.getText().toString().equals("")
					|| edtDet16.getText().toString().equals("")) {
				Toast.makeText(this, "Digite todos os valores da matriz!",
						Toast.LENGTH_SHORT).show();
			} else {
				double[][] matriz = new double[4][4];
				matriz[0][0] = Double.parseDouble(edtDet1.getText().toString());
				matriz[0][1] = Double.parseDouble(edtDet2.getText().toString());
				matriz[0][2] = Double.parseDouble(edtDet3.getText().toString());
				matriz[0][3] = Double.parseDouble(edtDet4.getText().toString());
				matriz[1][0] = Double.parseDouble(edtDet5.getText().toString());
				matriz[1][1] = Double.parseDouble(edtDet6.getText().toString());
				matriz[1][2] = Double.parseDouble(edtDet7.getText().toString());
				matriz[1][3] = Double.parseDouble(edtDet8.getText().toString());
				matriz[2][0] = Double.parseDouble(edtDet9.getText().toString());
				matriz[2][1] = Double.parseDouble(edtDet10.getText().toString());
				matriz[2][2] = Double.parseDouble(edtDet11.getText().toString());
				matriz[2][3] = Double.parseDouble(edtDet12.getText().toString());
				matriz[3][0] = Double.parseDouble(edtDet13.getText().toString());
				matriz[3][1] = Double.parseDouble(edtDet14.getText().toString());
				matriz[3][2] = Double.parseDouble(edtDet15.getText().toString());
				matriz[3][3] = Double.parseDouble(edtDet16.getText().toString());

				Calculos calculos = new Calculos();
				res = calculos.det4(matriz);
				txtRes.setText(String.valueOf(res));
			}
		}
	}
}

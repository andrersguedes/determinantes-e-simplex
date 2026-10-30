package br.edu.fatecgarca.determinantes;

import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.app.Activity;
import android.content.Intent;

public class MainActivity extends Activity implements OnClickListener {

	Button btnDet2, btnDet3, btnDet4;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);

		btnDet2 = (Button) findViewById(R.id.btnDet2);
		btnDet3 = (Button) findViewById(R.id.btnDet3);
		btnDet4 = (Button) findViewById(R.id.btnDet4);

		btnDet2.setOnClickListener(this);
		btnDet3.setOnClickListener(this);
		btnDet4.setOnClickListener(this);
	}

	@Override
	public void onClick(View v) {
		Intent intent;
		switch (v.getId()) {
		case R.id.btnDet2:
			intent = new Intent(this, Det2.class);
			intent.putExtra("nome", btnDet2.getText().toString());
			startActivity(intent);
			break;
		case R.id.btnDet3:
			intent = new Intent(this, Det3.class);
			intent.putExtra("nome", btnDet3.getText().toString());
			startActivity(intent);
			break;
		case R.id.btnDet4:
			intent = new Intent(this, Det4.class);
			intent.putExtra("nome", btnDet4.getText().toString());
			startActivity(intent);
			break;
		}
	}

}

package br.edu.fatecgarca.determinantessimplex;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;

import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {

    Button btnDet2, btnDet3, btnDet4;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        btnDet2 = findViewById(R.id.btnDet2);
        btnDet3 = findViewById(R.id.btnDet3);
        btnDet4 = findViewById(R.id.btnDet4);

        Intent intent = new Intent(this, Det2.class);

        btnDet2.setOnClickListener(view -> {
            intent.putExtra("nome", btnDet2.getText().toString());
            startActivity(intent);
        });
        btnDet3.setOnClickListener(view -> {
            intent.putExtra("nome", btnDet3.getText().toString());
            startActivity(intent);
        });
        btnDet4.setOnClickListener(view -> {
            intent.putExtra("nome", btnDet4.getText().toString());
            startActivity(intent);
        });
    }

}

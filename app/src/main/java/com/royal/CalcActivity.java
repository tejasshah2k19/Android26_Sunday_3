package com.royal;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class CalcActivity extends AppCompatActivity {

    //declare
    EditText edtN1, edtN2;
    Button btnAdd,btnSub,btnMul;
    TextView tvResult;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_calc);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });
    //binding

        edtN1 = findViewById(R.id.edtCalcN1);
        edtN2 = findViewById(R.id.edtCalcN2);

        btnAdd = findViewById(R.id.btnCalcAdd);
        btnSub = findViewById(R.id.btnCalcSub);
        btnMul = findViewById(R.id.btnCalcMul);

        tvResult = findViewById(R.id.tvCalcResult);


    //logic---click
    btnAdd.setOnClickListener(new View.OnClickListener() {
        @Override
        public void onClick(View view) {
            //read n1 n2
            String strN1 = edtN1.getText().toString();
            String strN2 = edtN2.getText().toString();

            //parseInt
            int n1 = Integer.parseInt(strN1);
            int n2 = Integer.parseInt(strN2);

            int ans = n1+n2;

            tvResult.setText("Addition => "+ans);

        }
    });

    btnSub.setOnClickListener(new View.OnClickListener() {
        @Override
        public void onClick(View view) {
//read n1 n2
            String strN1 = edtN1.getText().toString();
            String strN2 = edtN2.getText().toString();

            //parseInt
            int n1 = Integer.parseInt(strN1);
            int n2 = Integer.parseInt(strN2);

            int ans = n1-n2;

            tvResult.setText("Subtraction => "+ans);

        }
    });

    btnMul.setOnClickListener(new View.OnClickListener() {
        @Override
        public void onClick(View view) {
            //read n1 n2
            String strN1 = edtN1.getText().toString();
            String strN2 = edtN2.getText().toString();

            //parseInt
            int n1 = Integer.parseInt(strN1);
            int n2 = Integer.parseInt(strN2);

            int ans = n1*n2;

            tvResult.setText("Multiplication => "+ans);

        }
    });
    }
}
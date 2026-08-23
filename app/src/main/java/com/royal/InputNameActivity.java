package com.royal;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class InputNameActivity extends AppCompatActivity {

    //1 declare
    EditText edtFirstName;
    Button btnUpper,btnReverse;
    TextView tvResult;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_input_name);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });

        //2 binding
        edtFirstName = findViewById(R.id.edtInputNameFirstname);//R
        btnUpper = findViewById(R.id.btnInputNameUpper);
        btnReverse = findViewById(R.id.btnInputNameReverse);
        tvResult = findViewById(R.id.tvInputNameResult);


        //3
            //logic -> click
        btnUpper.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                //logic -> click
                Log.i("InputNameActivity","on click Button Upper");

                //read name
                String firstName = edtFirstName.getText().toString();

                //convert uppercase
                firstName = firstName.toUpperCase();

                //text view -> set
                tvResult.setText(firstName);

            }
        });


        btnReverse.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                //read
                String firstName = edtFirstName.getText().toString();
                //reverse

                //
                tvResult.setText(firstName);
            }
        });


    }

}
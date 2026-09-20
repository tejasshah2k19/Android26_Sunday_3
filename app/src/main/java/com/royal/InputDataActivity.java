package com.royal;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import java.util.HashSet;
import java.util.Set;

public class InputDataActivity extends AppCompatActivity {


    TextView tv;
    EditText edtFirstName;
    Button btnSubmit;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_input_data);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });

        tv = findViewById(R.id.tvInputDataList);
        edtFirstName = findViewById(R.id.edtInputDataFirstname);
        btnSubmit = findViewById(R.id.btnInputDataSubmit);

        tv.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                //
                Intent intent = new Intent(getApplicationContext(), ListDataActivity.class);
                startActivity(intent);
            }
        });

        btnSubmit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String firstName = edtFirstName.getText().toString();

                SharedPreferences sharedPreferences = getSharedPreferences("sunday3",MODE_PRIVATE);
                SharedPreferences.Editor editor  = sharedPreferences.edit();
//                editor.putString("firstName",firstName);//key value

                edtFirstName.setText("");

                Set<String> names =  sharedPreferences.getStringSet("listOfName",null);
                if(names == null){
                    names = new HashSet<>();
                    names.add(firstName);
                }else{
                    names.add(firstName);
                }

                editor.putStringSet("listOfName",names);
                editor.apply();


                Toast.makeText(getApplicationContext(),"Data Submited",Toast.LENGTH_LONG).show();

            }
        });

    }
}
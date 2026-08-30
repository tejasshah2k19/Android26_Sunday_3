package com.royal;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.TextView;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class SignupActivity extends AppCompatActivity {

    EditText edtFirstName,edtEmail,edtPassword;
    RadioButton rbMale,rbFemale;
    Button btnSubmit;
    TextView tvExistingUser;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_signup);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });


        edtFirstName = findViewById(R.id.edtSignupFirstName);
        edtEmail  = findViewById(R.id.edtSignupEmail);
        edtPassword =findViewById(R.id.edtSignupPassword);
        rbMale = findViewById(R.id.rbSignupGenderMale);
        rbFemale = findViewById(R.id.rbSignupGenderFemale);


        btnSubmit = findViewById(R.id.btnSignupSubmit);
        tvExistingUser = findViewById(R.id.tvSignupExistingUser);


        btnSubmit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                //read
                String firstName = edtFirstName.getText().toString();
                String email =edtEmail.getText().toString();
                String password = edtPassword.getText().toString();
                String gender = "";

                if(rbMale.isChecked()){
                    gender="male";
                }
                if(rbFemale.isChecked()){
                    gender="female";
                }

                //validation
                boolean isError = false;

                if(firstName.isBlank()){
                    isError = true;
                    edtFirstName.setError("Please Enter FirstName");
                }
                if(email.isBlank()){
                    isError=true;
                    edtEmail.setError("Please Enter Email");
                }

                if(password.isBlank()){
                    isError= true;
                    edtPassword.setError("Please Enter Password");
                }

                if(gender.isBlank()){
                    isError=true;
                    rbMale.setError("");
                    rbFemale.setError("");
                }


                if(isError){
                    Toast.makeText(getApplicationContext(), "Please fix the error(s)", Toast.LENGTH_LONG).show();

                }else {
                    //db insertion

                    //toast
                    Toast.makeText(getApplicationContext(), "Signup Success", Toast.LENGTH_LONG).show();

                    //redirect to login
                    Intent intent = new Intent(getApplicationContext(), LoginActivity.class);

                    intent.putExtra("email",email);//data set

                    startActivity(intent);
                }
            }
        });

        tvExistingUser.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                //redirect to login
                Intent intent= new Intent(getApplicationContext(), LoginActivity.class);
                startActivity(intent);
            }
        });
    }
}
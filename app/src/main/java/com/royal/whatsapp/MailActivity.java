package com.royal.whatsapp;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.ImageButton;
import android.widget.ListView;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import com.royal.R;

public class MailActivity extends AppCompatActivity {
    ListView listMail;
    ImageButton imgBtnCall,imgBtnUser;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_mail);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });


        listMail = findViewById(R.id.lvMailEmail);

        imgBtnCall = findViewById(R.id.imgBtnMailCall);
        imgBtnUser = findViewById(R.id.imgBtnMailUser);

        String mails [] = {"7654322345@gmail.com","9632587412@gmail.com","9638529639@gmail.com","8527419635@gmail.com"};
        ArrayAdapter<String> adapter = new ArrayAdapter<>(this, android.R.layout.simple_list_item_1,mails);
        listMail.setAdapter(adapter);

        imgBtnCall.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent  = new Intent(getApplicationContext(),CallActivity.class);
                startActivity(intent);
            }
        });


        imgBtnUser.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent  = new Intent(getApplicationContext(),UserActivity.class);
                startActivity(intent);
            }
        });
    }
}
package com.royal;

import android.content.SharedPreferences;
import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.TextView;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class ListDataActivity extends AppCompatActivity {

    TextView tvFirstName;
    ListView listViewNames;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_list_data);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });

        tvFirstName = findViewById(R.id.tvListDataFirstname);
        listViewNames = findViewById(R.id.listViewListDataNameList);

        SharedPreferences sharedPreferences = getSharedPreferences("sunday3",MODE_PRIVATE);
        String firstName = sharedPreferences.getString("firstName","");
        tvFirstName.setText(firstName);

        String names[] = {"Bhavya","Sujal","Arik","Vidhit"};
        ArrayAdapter<String> adapter = new ArrayAdapter<>(this, android.R.layout.simple_list_item_1,names);

        listViewNames.setAdapter(adapter);


    }
}
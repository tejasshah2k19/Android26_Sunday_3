package com.royal.diamondgame;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageButton;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import com.royal.R;

public class GamePlayActivity extends AppCompatActivity {
    //declare
    ImageButton btn1,btn2,btn3;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_game_play);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });

        //bind
        btn1 = findViewById(R.id.imgBtnGamePlayB1);
        btn2 = findViewById(R.id.imgBtnGamePlayB2);
        btn3 = findViewById(R.id.imgBtnGamePlayB3);

        //click
        btn1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                int random = (int)(Math.random()*100);//098.56259845 * 100
                if(random%2 == 0 ){
                    //diamond
                    btn1.setBackgroundResource(R.drawable.diamond_512);
                }else{
                    //bomb
                    btn1.setBackgroundResource(R.drawable.blast);
                    Intent intent = new Intent(getApplicationContext(), GameMenuActivity.class);
                    startActivity(intent);
                }

            }
        });



    }
}
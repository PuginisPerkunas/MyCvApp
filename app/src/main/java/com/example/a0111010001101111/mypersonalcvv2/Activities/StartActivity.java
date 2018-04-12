package com.example.a0111010001101111.mypersonalcvv2.Activities;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.example.a0111010001101111.mypersonalcvv2.R;

public class StartActivity extends AppCompatActivity {

    private Button ltBtn, enBtn, ruBtn;
    Intent intentForActions;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_start);

        init();
        setListener();
    }

    private void init(){
        ltBtn = (Button) findViewById(R.id.lt_btn);
        enBtn = (Button) findViewById(R.id.en_btn);
        ruBtn = (Button) findViewById(R.id.ru_btn);
        intentForActions = new Intent(StartActivity.this,MainActivity.class);
    }

    private void setListener(){
        ltBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                intentForActions.putExtra("lan","lt");
                startActivity(intentForActions);
                finish();
            }
        });

        enBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                intentForActions.putExtra("lan","en");
                startActivity(intentForActions);
                finish();
            }
        });

        ruBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                intentForActions.putExtra("lan","ru");
                startActivity(intentForActions);
                finish();
            }
        });
    }
}

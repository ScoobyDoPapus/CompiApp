package com.example.cp.myapplication;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity implements View.OnClickListener{

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Button button=findViewById(R.id.button);
        Button button2=findViewById(R.id.buttonD);
        button.setOnClickListener(this);
        button2.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.button:
                openActivityCamara();
                break;

            case R.id.buttonD:
                openActivityDisplay();
                break;

        }
    }
    public void openActivityDisplay(){
        Intent intent=new Intent(this,DisplayBraile.class);
        intent.putExtra("StringServer","Esperando Contenido del Server");
        startActivity(intent);
    }
    public void openActivityCamara(){
        Intent intent=new Intent(this,CamaraActivity.class);
        startActivity(intent);
    }
}

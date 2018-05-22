package com.example.cp.myapplication;

import android.os.StrictMode;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import java.io.IOException;

public class DisplayBraile extends AppCompatActivity implements View.OnClickListener{
    String numero=null;
    TextView textView;
    ClienteSocket cli= null;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_display_braile);

        if(getIntent().hasExtra("StringServer")) {
            this.numero = getIntent().getStringExtra("StringServer");
        }
        TextView textView=findViewById(R.id.textViewNumero);
        if(numero!=null) {
            textView.setText(numero);
        }
        StrictMode.setThreadPolicy(new StrictMode.ThreadPolicy.Builder()
                .permitNetwork().build());
        Button button=findViewById(R.id.buttonEnviarServer);
        button.setOnClickListener(this);
        try {
            cli = new ClienteSocket("192.168.1.127",textView);
            cli.execute();

        } catch (IOException e) {
            e.printStackTrace();
        }

    }

    @Override
    public void onClick(View v) {

        try {
            numero.replaceAll("((\\r\\n|\\n\\r|\\r|\\n))", " ");
            for(int i=0;i<numero.length();i++){
                System.err.println(numero.charAt(i));
            }
            System.err.println(numero);

            cli.send(numero);

        } catch (IOException e) {
            e.printStackTrace();
        }

    }
}

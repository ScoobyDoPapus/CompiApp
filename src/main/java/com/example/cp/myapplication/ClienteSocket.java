package com.example.cp.myapplication;

import android.os.AsyncTask;
import android.widget.TextView;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;

public class ClienteSocket extends AsyncTask<Void,Void,String>{
    String resultado="";
    int port=8084;
    Socket sc;
    String serverIp="";
    TextView text1;
    private PrintWriter out;
    public ClienteSocket(String serverIp, TextView t) throws IOException {
        this.serverIp=serverIp;
        this.text1=t;
        System.err.println("Nuevo Cli Socke");
        sc = new Socket(this.serverIp, port);
    }



    @Override
    protected String doInBackground(Void... voids) {

        try {

          //  InetAddress serverAddr = InetAddress.getByName(serverIp);
            System.err.println("sokc Listo");
            out = new PrintWriter(sc.getOutputStream(), true);
            BufferedReader in = new BufferedReader(new InputStreamReader(sc.getInputStream()));
           // out.println("azul");
            String read;
            String contenido="";
            while ((read=in.readLine())!= null){
                contenido+=read;
       //         System.err.println("recive"+contenido);
            }
            return contenido;
        } catch (IOException e) {
            e.printStackTrace();
        }finally {
            if(sc!=null){

            }
        }
        return "";
    }

        @Override
    protected void onPostExecute(String s) {
        text1.setText(s);
    }


    public void send(String enviar) throws IOException {


        enviar=enviar+"\n";
        out.write(enviar);
        out.flush();
      //  out.close();

    }
}

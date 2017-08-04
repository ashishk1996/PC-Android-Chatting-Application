package com.ashish.kumar.dummychat;

import android.Manifest;
import android.content.Intent;
import android.os.AsyncTask;
import android.support.v4.app.ActivityCompat;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Gravity;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;
import android.widget.Toast;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.Socket;

abstract class var {
    static String userInput = "";
    static String Server = "";
    static String host = "";

}

public class MainActivity extends AppCompatActivity {
    //  static String userInput="";


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.main);


    }

    public void execute(View view) {
        EditText et = (EditText) findViewById(R.id.userInput);
        var.userInput = et.getText().toString();
        try {

            View parent = findViewById(R.id.parent);
            TextView tv = new TextView(this);
            tv.setText(var.userInput);
            //  ViewGroup.LayoutParams lp=new ViewGroup.LayoutParams();


            LinearLayout.LayoutParams params = new LinearLayout.LayoutParams(LinearLayout.LayoutParams.WRAP_CONTENT, LinearLayout.LayoutParams.MATCH_PARENT);
            // params.weight = 1.0f;
            params.gravity = Gravity.RIGHT;
            tv.setLayoutParams(params);
            ((LinearLayout) parent).addView(tv);
        } catch (Exception e) {
            System.out.println(e);
        }
        String message = "sent";
        try{
        asynctaskconnect conn = new asynctaskconnect();

            message = conn.execute().get();
            // message=var.Server;
            // while(message!="-1")
            //String message = "";

            //message=var.Server;
          //  conn.cancel(true);
           // asynctaskreceive conn2 = new asynctaskreceive();
            //message = conn2.execute().get();
           // conn2.execute();
           // message=var.Server;
        } catch (Exception e) {
            System.out.println(e);
        }
        try {


            if(!(message.equals("null"))) {
                View parent = findViewById(R.id.parent);
                TextView tv = new TextView(this);
                tv.setText(message);
                tv.setLayoutParams(new RelativeLayout.LayoutParams(ViewGroup.LayoutParams.MATCH_PARENT, RelativeLayout.LayoutParams.WRAP_CONTENT));
                ((LinearLayout) parent).addView(tv);
                // message=conn.execute().get();
            }
        } catch (Exception e) {
            System.out.println(e);
        }


    }
}


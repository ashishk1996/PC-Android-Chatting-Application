package com.ashish.kumar.dummychat;

import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.EditText;

public class ipaddress extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.ipaddress);



    }
    public void submit(View view)
    {
        EditText et=(EditText)findViewById(R.id.ip);
        var.host=et.getText().toString();
        Intent intent=new Intent(ipaddress.this,MainActivity.class);
        startActivity(intent);
    }

}

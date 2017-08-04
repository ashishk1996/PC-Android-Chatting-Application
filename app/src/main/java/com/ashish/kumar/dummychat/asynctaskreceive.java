package com.ashish.kumar.dummychat;

import android.os.AsyncTask;

import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.InetAddress;
import java.net.Socket;

/**
 * Created by Ashish on 17-07-2017.
 */

public class asynctaskreceive extends AsyncTask<Void,Void,String> {
    private static Socket socket;


    @Override
    protected String doInBackground(Void... params) {
        String message="";
        try {


            String host = "192.168.1.2";
            int port = 25000;
            InetAddress address = InetAddress.getByName(host);
            socket = new Socket(address, port);
            InputStream is = socket.getInputStream();
            InputStreamReader isr = new InputStreamReader(is);
            BufferedReader br = new BufferedReader(isr);
            message = br.readLine();
            System.out.println("Message received from the server : " +message);
            var.Server=message;
            socket.close();
            return message;
             

        }catch(Exception e){System.out.println(e);}
        return message;
    }
}

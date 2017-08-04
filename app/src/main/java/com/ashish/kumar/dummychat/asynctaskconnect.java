package com.ashish.kumar.dummychat;

import android.os.AsyncTask;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.DataOutputStream;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.OutputStreamWriter;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;
import java.net.Socket;

import static android.R.id.message;

/**
 * Created by Ashish on 17-07-2017.
 */

public class asynctaskconnect extends AsyncTask<Void,Void,String> {
    private static Socket socket;

    @Override
    protected String doInBackground(Void... params) {
        try
        {


            String host = var.host;
            int port = 25000;
            InetAddress address = InetAddress.getByName(host);
            socket = new Socket(address, port);

            //Send the message to the server
            OutputStream os = socket.getOutputStream();
            OutputStreamWriter osw = new OutputStreamWriter(os);
            BufferedWriter bw = new BufferedWriter(osw);

            String msg = var.userInput;

            String sendMessage = msg + "\n";
            bw.write(sendMessage);
            bw.flush();
            System.out.println("Message sent to the server : "+sendMessage);
           // Thread.sleep(5000);
            //Get the return message from the server
            InputStream is = socket.getInputStream();
            InputStreamReader isr = new InputStreamReader(is);
            BufferedReader br = new BufferedReader(isr);
            String message = br.readLine();
            System.out.println("Message received from the server : " +message);

            socket.close();
            return message;
        }catch(Exception e){System.out.println(e);}
        finally
        {
            //Closing the socket
            try
            {
                socket.close();

            }
            catch(Exception e)
            {
                e.printStackTrace();
            }
        }
        return null;

        }


}

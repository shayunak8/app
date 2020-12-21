package com.example.kidzcashfinal;

import android.os.StrictMode;
import android.util.Log;
import android.widget.TextView;
import java.io.BufferedReader;
import java.io.Console;
import java.io.DataInputStream;
import java.io.EOFException;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.OutputStream;
import java.io.OutputStreamWriter;
import java.net.*;
import java.util.UUID;

import java.net.Socket;

public class Client {
    private Socket socket;
    private OutputStreamWriter osw;
    private BufferedReader dis;

    public Client() {
        try {
            socket = new Socket();
            InetSocketAddress socketAddress = new InetSocketAddress("192.168.50.174", 8001);
            socket.connect(socketAddress, 1000);
            osw = new OutputStreamWriter(socket.getOutputStream());
            dis = new BufferedReader(new InputStreamReader(socket.getInputStream()));
        } catch (IOException e) {
            Log.w("MyDebug", e.toString());
        }
    }

    public boolean Verify(String email, String password) {
        try {
            String str = "v " + email + " " + password;
            osw.write(str, 0, str.length());
            String output = dis.readLine();
            osw.flush();
            return output.equals("True");
        } catch (IOException e) {
            Log.w("MyDebug", e.toString());
        }
        return false;
    }

    public void Add(UUID uuid, String name, String email, String password, String creditCard, String cvv, String date) {
        try {
            String str = "a " + uuid + " " + name + " " + email + " " + password + " " + 0 + " " + creditCard + " " + cvv + " " + date + " ";
            osw.write(str, 0, str.length());
            osw.flush();
        } catch (IOException e) {
            Log.w("MyDebug", e.toString());
        }
    }

    public void Charge(String uuid, String amount) {
        try {
            String str = "c " + uuid + " " + amount;
            osw.write(str, 0, str.length());
            osw.flush();
        } catch (IOException e) {
            Log.w("MyDebug", e.toString());
        }
    }

    public String getName(String uuid) {
        try {
            StrictMode.ThreadPolicy policy = new StrictMode.ThreadPolicy.Builder().permitAll().build();
            StrictMode.setThreadPolicy(policy);
            String str = "u " + "name " + uuid;
            osw.write(str,0, str.length());
            osw.flush();
            int bufferSize = 1024;
            byte[] buffer = new byte[bufferSize];
            int bytesRead = -1;
            bytesRead = socket.getInputStream().read(buffer,0,bufferSize);
            String result = new String(buffer,0,bytesRead);
            return result;
        } catch (IOException e) {
            Log.w("MyDebug", e.toString());
        }
        return "invaild";
    }

}

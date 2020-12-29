package com.example.demo.distributed;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.OutputStreamWriter;
import java.io.PrintStream;
import java.net.Socket;

import org.junit.jupiter.api.Test;

public class ClientSocketTCPIP {

    @Test
    public void socketTest() {

        try {
            Socket socket = new Socket("192.168.51.145", 8888);
            InputStream inputStream = socket.getInputStream();
            OutputStream outputStream = socket.getOutputStream();
            // 从服务器端读取信息
            BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(inputStream));
            BufferedWriter bufferedWriter = new BufferedWriter(new OutputStreamWriter(outputStream));
            bufferedWriter.write("gu shao hua shi ge da shuai bi");
            bufferedWriter.flush();
            String readLine = bufferedReader.readLine();
            System.out.println("clent receive server send message:" + readLine);
        } catch (IOException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
    }

    public static void main(String[] args) {
        try {
            Socket socket = new Socket("192.168.51.145", 8888);
            InputStream inputStream = socket.getInputStream();
            OutputStream outputStream = socket.getOutputStream();
            // 从服务器端读取信息
            BufferedWriter bufferedWriter = new BufferedWriter(new OutputStreamWriter(outputStream));
            bufferedWriter.write("gu shao hua shi ge da shuai bi");
            bufferedWriter.flush();
            BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(inputStream));
            String readLine = bufferedReader.readLine();
            System.out.println("clent receive server send message:" + readLine);
        } catch (IOException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
    }

}

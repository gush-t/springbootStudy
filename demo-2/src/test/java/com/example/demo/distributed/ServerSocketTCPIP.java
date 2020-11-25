package com.example.demo.distributed;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.net.ServerSocket;
import java.net.Socket;

import org.junit.jupiter.api.Test;

public class ServerSocketTCPIP {

	@Test
	public void serverSocketTest() {
		try {
			ServerSocket serverSocket = new ServerSocket(8888);
			Socket accept = serverSocket.accept();
			System.out.println("client:" + accept.getInetAddress().getLocalHost());
			BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(accept.getInputStream()));
			System.out.println("server revice client send message:" + bufferedReader.readLine());

			BufferedWriter bufferedWriter = new BufferedWriter(new OutputStreamWriter(accept.getOutputStream()));
			bufferedWriter.write(" sure");

		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	public static void main(String[] args) {
		try {
			ServerSocket serverSocket = new ServerSocket(8888);
			Socket accept = serverSocket.accept();
			System.out.println("client:" + accept.getInetAddress().getLocalHost());
			BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(accept.getInputStream()));
			System.out.println("server revice client send message:" + bufferedReader.readLine());
			BufferedWriter bufferedWriter = new BufferedWriter(new OutputStreamWriter(accept.getOutputStream()));
			bufferedWriter.write(" sure");
			bufferedWriter.flush();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}

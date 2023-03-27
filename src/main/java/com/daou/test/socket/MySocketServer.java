package com.daou.test.socket;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

public class MySocketServer {

    public static void main(String[] args) {
        try {
            int socketPort = 1234;
            ServerSocket serverSocket = new ServerSocket(socketPort); // 소켓 만들기
            System.out.println("socket : " + socketPort + "으로 서버가 열렸습니다");

            // 소켓 서버가 종료될 때까지 반복
            while(true) {
                Socket socketUser = serverSocket.accept(); // 소켓 서버로 접속 시 socketUser에 접속자 정보 할당
                System.out.println("Client가 접속함 : " + socketUser.getLocalAddress()); // 접속자의 getLocalAddress 가져오기
            }

        } catch (IOException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }

    }

}
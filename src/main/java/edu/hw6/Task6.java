package edu.hw6;

import java.io.IOException;
import java.net.DatagramSocket;
import java.net.InetSocketAddress;
import java.net.ServerSocket;

public class Task6 {
    private Task6() {

    }

    public static String checkPort(String protocol, int port){
        try{
            if ("TCP".equals(protocol)){
                ServerSocket serverSocket = new ServerSocket(port);
                serverSocket.setReuseAddress(true);
                serverSocket.bind(new InetSocketAddress("localhost", port));
                serverSocket.close();
                return protocol + "\t   " + port + "\t  Свободен";
            }
            else if ("UDP".equals(protocol)){
                DatagramSocket datagramSocket = new DatagramSocket(port);
                datagramSocket.close();
                return protocol + "\t" + port + "\tСвободен";
            }
        } catch (IOException e) {
            return protocol + "\t" + port + "\tЗанят";
        }
        return null;
    }
    public static void main(String[] args) {
        String resultTCP = Task6.checkPort("TCP", 8080);
        String resultUDP = Task6.checkPort("UDP", 8080);

        System.out.println(resultTCP);
        System.out.println(resultUDP);
    }
}

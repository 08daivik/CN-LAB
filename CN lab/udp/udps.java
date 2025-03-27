package udp;
import java.net.*;
import java.io.*;

public class udps {
    public static void main(String args[]) throws Exception{
    DatagramSocket serversocket=new DatagramSocket(9876);
    System.out.println("Server ready");
    byte receiveData[]=new byte[1024];
    byte sendData[]=new byte[1024];
    while (true){
        DatagramPacket receivePacket=new DatagramPacket(receiveData,receiveData.length);
        serversocket.receive(receivePacket);
        String sen=new String(receivePacket.getData());
        System.out.println("Recieved data"+sen);
        String cap=sen.toUpperCase();
        InetAddress IP=receivePacket.getAddress();
        int port=receivePacket.getPort();
        sendData=cap.getBytes();
        DatagramPacket sendPacket=new DatagramPacket(sendData,sendData.length,IP,port);
        serversocket.send(sendPacket);
    }
}
}
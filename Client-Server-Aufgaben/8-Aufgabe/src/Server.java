/**
 * Created by stbormir on 14.02.2017.
 */

import java.net.*;
import java.util.Arrays;

public class Server {

    public static void main(String args[]) throws Exception {

        DatagramSocket serverSocket = new DatagramSocket(4242);
        try {

            byte[] receiveData = new byte[1024];
            byte[] sendData = new byte[1024];
            DatagramPacket receivePacket = new DatagramPacket(receiveData, receiveData.length);
            String sentence = "";
            System.out.println("Server gestartet");
            while (!sentence.equals("exit")) {
                Arrays.fill(receiveData, (byte) 0);

                serverSocket.receive(receivePacket);                        //Auf Nachrichten warten

                sentence = new String(receivePacket.getData());

                System.out.println(receivePacket.getAddress()+": RECEIVED: " + sentence );

                String answer = sentence;

                sendData = answer.getBytes();
                String IP = "255.255.255.255";
                InetAddress broadcast = InetAddress.getByName(IP);
                                                //An alle anderen die das Programm verwenden weiterleiten

                DatagramPacket sendPacket = new DatagramPacket(sendData, sendData.length, broadcast, 4545);

                serverSocket.send(sendPacket);
            }
        } catch (Exception e) {

            System.out.println("Fehler Server");
            e.printStackTrace();

        }
    }
}

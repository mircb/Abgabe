/**
 * Created by stbormir on 14.02.2017.
 */

import java.io.*;
import java.net.*;
import java.util.Arrays;

public class Client {

    public static void main(String args[]) throws Exception {


        //Daten des Servers einlesen
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        System.out.println("IP des Servers eingeben, auf dem der UDP-Chat auf Port 4242 und 4545 laüft\n" +                  //IP des Servers wird eingelesen(Default127.0.0.1) oder exit befehl wird ausgeführt
                "(Default 127.0.0.1)Tippe 'exit' to exit");

        String serverAddress = "127.0.0.1";
        String enter = reader.readLine();
        if (enter.equals("exit")) {                                     //Eventuel Programm beenden
            System.out.println("Programm beendet");
            System.exit(0);
        } else if (enter != null) {
            serverAddress = enter;
        }

        DatagramSocket clientSocket = new DatagramSocket();

        InetAddress IPAddress = InetAddress.getByName(serverAddress);

        Thread t1 = new Thread() {                      //Listener Thread, der erhaltene Nachrichten ausgibt

            @Override
            public void run() {

                byte[] receiveData = new byte[1024];
                Arrays.fill(receiveData, (byte) 0);
                System.out.println("Listener gestartet");
                try {
                    DatagramSocket listenerSocket = new DatagramSocket(4545);

                    DatagramPacket receivePacket = new DatagramPacket(receiveData, receiveData.length);

                    while (true) {

                        listenerSocket.receive(receivePacket);
                        String answer = new String(receivePacket.getData());
                            System.out.println("Anderer Benutzer(oder eingene Nachricht):" + answer);

                    }
                } catch (Exception e) {
                    System.out.println("Fehler Listener");
                    e.printStackTrace();
                }
            }
        };
        t1.start();

        System.out.println("Eingabe oder exit:");
        while (!enter.equals("exit")) {

            byte[] sendData = new byte[1024];

            Arrays.fill(sendData, (byte) 0);

                         //Nachricht einlesen und dem Server senden.

            enter = reader.readLine();
            sendData = enter.getBytes();

            DatagramPacket sendPacket = new DatagramPacket(sendData, sendData.length, IPAddress, 4242);
            clientSocket.send(sendPacket);


        }

        System.out.println("Programm beendet");
        clientSocket.close();
        System.exit(0);
    }

}


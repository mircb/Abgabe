/**
 * Created by stbormir on 09.01.2017.
 * KLasse der Server, erzeugt Threads um mehrere Clients gleichzeitig zu bedienen
 */

import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;


public class Server {

    public void start() {

        while (true) {
            try {
                ServerSocket listener = new ServerSocket(4242);
                boolean p = true;

                System.out.println("Server gestartet");
                while (p) {
                    Socket socket = listener.accept();                                                  //Auf Verbindungen wird gewartet
                    System.out.println("verbunden mit:" + socket.getLocalSocketAddress());
                    try {
                        ObjectInputStream in = new ObjectInputStream(socket.getInputStream());

                        Message M = (Message) in.readObject();
                        if (M.getMessage().equals("0")) {

                            double Ant = Math.random()*99*(Math.random())*100;
                            Thread.sleep(1000);
                            System.out.println("Wert:" + Ant);
                            M.setInt1(0);

                            M.setMessage(String.valueOf(Ant));
                        } else {

                            long Ant2 = System.currentTimeMillis();
                            Thread.sleep(1000);
                            System.out.println("Wert:" + Ant2);
                            M.setMessage(String.valueOf(Ant2));
                            M.setInt1(1);
                        }

                        ObjectOutputStream out = new ObjectOutputStream(socket.getOutputStream());
                        out.writeObject(M);


                    } catch (Exception e) {

                        System.out.println("Fehler bei der Übertragung");
                        e.printStackTrace();

                    }

                }
            } catch (Exception e) {

                System.out.println("Fehler Server");
                e.printStackTrace();
                break;

            }
        }
        System.out.println("Server beendet");


    }


}

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
                    ExecutorService executor = Executors.newCachedThreadPool();

                    System.out.println("Server gestartet");
                    while (p) {
                        Socket socket = listener.accept();                                                  //Auf Verbindungen wird gewartet
                        System.out.println("verbunden mit:" + socket.getLocalSocketAddress());
                        executor.execute(new ServerThread(socket, this));


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

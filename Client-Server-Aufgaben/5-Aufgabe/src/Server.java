/**
 * Created by stbormir on 09.01.2017.
 * KLasse der Server, erzeugt Threads um mehrere Clients gleichzeitig zu bedienen
 */

import java.net.ServerSocket;
import java.net.Socket;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;


public class Server {

    ServerSocket serverSocket;
    Socket connection = null;

        public void start() {

            while (true) {
                try {
                    ServerSocket listener = new ServerSocket(4242);
                    ExecutorService executor = Executors.newCachedThreadPool();             //Executor verwaltet Threads

                    boolean p = true;


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

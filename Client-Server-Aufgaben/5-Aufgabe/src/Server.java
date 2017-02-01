/**
 * Created by stbormir on 09.01.2017.
 */
import java.io.*;

import java.net.ServerSocket;
import java.net.Socket;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;



public class Server {



        public static void main(String[] args) throws IOException {
            ServerSocket listener = new ServerSocket(4242);

            boolean p = true;



            try {


                System.out.println("Server gestartet");
                while (p) {
                    Socket socket = listener.accept();                                                  //Auf Verbindungen wird gewartet
                    System.out.println("verbunden mit:" + socket.getLocalSocketAddress());

                    try {


                        ObjectInputStream in = new ObjectInputStream(socket.getInputStream());
                        try {


                            Url a = (Url) in.readObject();
                            Path Link = (Paths.get(a.getMessage()));
                            System.out.println(Link+" Wird heruntergeladen");



                    OutputStream out = socket.getOutputStream();
                            InputStream fileIn = new FileInputStream(Link.toFile());

                            byte[] buffer = new byte[1024];
                            while (fileIn.available() > 0) {
                                out.write(buffer, 0, fileIn.read(buffer));
                            }

                            fileIn.close();
                            out.flush();



                        } catch (Exception e) {

                            System.out.println("Fehler bei der Übertragung");
                            e.printStackTrace();

                        }


                    } finally {
                        socket.close();
                        System.out.println("gedownloadet, gesendet und getrennt");                      //Download fertig, ferbindung getrennt
                    }
                }
            }
            finally {
                listener.close();
                System.out.println("Server beendet");
            }
        }





}

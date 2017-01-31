/**
 * Created by stbormir on 09.01.2017.
 */
import java.io.*;

import java.net.MalformedURLException;
import java.net.ServerSocket;
import java.net.Socket;
import java.net.URL;


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
                            String Link = a.getMessage();
                            System.out.println(Link+" Wird heruntergeladen");

                            WebDownloader wd = new WebDownloader();

                            try {
                                wd.saveTo(new URL(Link),"Server-exit.html");                //Simon lösung

                            } catch (MalformedURLException e) {
                                e.printStackTrace();
                            }




                    OutputStream out = socket.getOutputStream();
                            InputStream fileIn = new FileInputStream("Server-exit.html");

                            byte[] buffer = new byte[1024];
                            while (fileIn.available() > 0) {
                                out.write(buffer, 0, fileIn.read(buffer));
                            }

                            fileIn.close();




                        } catch (Exception e) {

                            System.out.println("Fehler bei der Übertragung");

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

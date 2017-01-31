/**
 * Created by stbormir on 09.01.2017.
 */
import java.io.*;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.Date;
public class Server {

    
        public static void main(String[] args) throws IOException {
            ServerSocket listener = new ServerSocket(4242);
            try {
                System.out.println("Server gestartet");
                while (true) {
                    Socket socket = listener.accept();                                                  //Auf Verbindungen wird gewartet
                    System.out.println("verbunden mit:"+socket.getLocalSocketAddress());

                    try {


                        ObjectInputStream in = new ObjectInputStream(socket.getInputStream());
                        try{
                        Message m = (Message)in.readObject();                                           //Erhaltennes Objekt wird in Message umgewandet
                            System.out.println(m.getInt1()+ m.getMessage()+m.getInt2());
                            OutputStreamWriter out = new OutputStreamWriter(socket.getOutputStream());

                            if(m.getMessage().equals("+")){                                             //Berechnen und Ergebniss senden

                                out.write(m.getInt1()+m.getInt2());
                                System.out.println("="+(m.getInt1()+m.getInt2()));
                            }
                            if(m.getMessage().equals("-")){

                                out.write((m.getInt1()-m.getInt2()));
                                System.out.println("="+(m.getInt1()-m.getInt2()));
                            }
                            if(m.getMessage().equals("*")){

                                out.write((m.getInt1()*m.getInt2()));
                                System.out.println("="+m.getInt1()*m.getInt2());
                            }
                            if(m.getMessage().equals("/")){

                                out.write((m.getInt1()/m.getInt2()));
                                System.out.println("="+m.getInt1()/m.getInt2());
                            }
                            out.flush();

                        }catch (java.lang.ClassNotFoundException e){

                            System.out.println("Fehler bei der Übertragung");

                        }


                    } finally {
                        socket.close();
                        System.out.println("Berechnung abgeschlossen und getrennt");                      //Berechnung fertig, ferbindung getrennt
                    }
                }

            }
            finally {
                listener.close();
                System.out.println("Server beendet");
            }
        }





}

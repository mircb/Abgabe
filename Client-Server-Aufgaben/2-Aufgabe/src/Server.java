/**
 * Created by stbormir on 09.01.2017.
 */
import java.io.*;
import java.lang.reflect.Array;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.ArrayList;
class NoAuth extends Exception
{
    NoAuth()
    {
        super("Nicht Authetifizierter Benutzer!");
    }
}

public class Server {



        public static void main(String[] args) throws IOException {
            ServerSocket listener = new ServerSocket(4242);
            ArrayList<String> Benutzer = new ArrayList<String>();
            boolean p = true;

            Benutzer.add("Hans");                       //Benutzer
            Benutzer.add("Peter");
            Benutzer.add("Walter");
            Benutzer.add("Martha");

            try {
                System.out.println("Server gestartet");
                while (p) {
                    Socket socket = listener.accept();                                                  //Auf Verbindungen wird gewartet
                    System.out.println("verbunden mit:" + socket.getLocalSocketAddress());

                    try {


                        ObjectInputStream in = new ObjectInputStream(socket.getInputStream());
                        OutputStreamWriter out = new OutputStreamWriter(socket.getOutputStream());

                        try {

                            Auth a = (Auth) in.readObject();                            //Beutzername wird empfangen

                            String name = a.getMessage();
                            int i = 0;


                            while (Benutzer.size() > i && Benutzer.get(i) != null) {                    //Benutzer wird kontrolliert

                                if (name.equals(Benutzer.get(i))) {

                                    System.out.println("Verbunden mit:"+Benutzer.get(i));
                                    i = Integer.MAX_VALUE;
                                    out.write(1);
                                    break;
                                }
                                i++;

                            }
                            if (i != Integer.MAX_VALUE) {
                                out.write(0);
                                throw new NoAuth();
                            }
                            out.flush();

                            Message m = (Message) in.readObject();                                           //Erhaltennes Objekt wird in Message umgewandet
                            System.out.println(m.getInt1() + m.getMessage() + m.getInt2());


                            if (m.getMessage().equals("+")) {                                             //Berechnen und Ergebniss senden

                                out.write(m.getInt1() + m.getInt2());
                                System.out.println("=" + (m.getInt1() + m.getInt2()));
                            }
                            if (m.getMessage().equals("-")) {

                                out.write((m.getInt1() - m.getInt2()));
                                System.out.println("=" + (m.getInt1() - m.getInt2()));
                            }
                            if (m.getMessage().equals("*")) {

                                out.write((m.getInt1() * m.getInt2()));
                                System.out.println("=" + m.getInt1() * m.getInt2());
                            }
                            if (m.getMessage().equals("/")) {

                                out.write((m.getInt1() / m.getInt2()));
                                System.out.println("=" + m.getInt1() / m.getInt2());
                            }
                            out.flush();

                        } catch (java.lang.ClassNotFoundException e) {

                            System.out.println("Fehler bei der Übertragung");

                        } catch (NoAuth e) {
                            System.out.println(e.getMessage());
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

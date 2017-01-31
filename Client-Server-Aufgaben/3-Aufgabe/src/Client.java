/**
 * Created by stbormir on 09.01.2017.
 */
import javax.swing.text.html.HTML;
import javax.swing.text.html.HTMLDocument;
import java.io.*;
import java.net.Socket;

public class Client {


        public static void main(String[] args) throws IOException {
            Url M = new Url(); //Objekt wird erzeugt, das gesendet wird

            BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));



                System.out.println("IP des Servers eingeben, auf dem der URL-Download Port 4242 laüft\n" +                  //IP des Servers wird eingelesen(Default127.0.0.1) oder exit befehl wird ausgeführt
                        "(Default 127.0.0.1)Tippe 'exit' to exit");

                String serverAddress = "127.0.0.1";
                String enter= reader.readLine();
                if (enter.equals("exit")) {
                    System.out.println("Programm beendet");
                    System.exit(0);
                }else if(enter!=null){
                serverAddress=enter;
                }
            boolean exit= false;
            while(!exit) {


                System.out.println("Url eingeben mit https:// (oder exit)");                    //Benutzernamen eingeben, um sich zu Authetifizieren.
                enter = reader.readLine();
                if (enter.equals("exit")) {
                    exit = true;
                } else if (enter != null) {

                    M.setMessage(enter);
                    Socket s = new Socket(serverAddress, 4242);                                         //Verbindung wird aufgebaut

                    ObjectOutputStream out = new ObjectOutputStream(s.getOutputStream());
                    out.writeObject(M);
                    out.flush();




                    InputStream in = s.getInputStream();
                    FileOutputStream fileOut = new FileOutputStream("Client-downloadet.html");

                    byte[] buffer = new byte[1024];
                    while (s.isConnected()) {
                        int bytesRead = in.read(buffer);
                        if (bytesRead == -1) break;
                        fileOut.write(buffer, 0, bytesRead);
                    }

                    fileOut.close();
                    exit=true;


                }
            }

            System.out.println("Programm beendet");


        }


}

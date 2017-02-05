/**
 * Created by stbormir on 09.01.2017.
 */

import java.io.*;
import java.net.Socket;

import java.nio.file.Paths;

public class Client {


        public static void main(String[] args) throws IOException {
            Url M = new Url();                                      //Objekt wird erzeugt, das gesendet wird indem der Pfad zum File gespeichert ist


            BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));



                System.out.println("IP des Servers eingeben, auf dem der File-Download Port 4242 laüft\n" +                  //IP des Servers wird eingelesen(Default127.0.0.1) oder exit befehl wird ausgeführt
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


                System.out.println("File mit Pfad eingeben (oder exit)");                    //Pfad eingeben oder exit
                enter = reader.readLine();
                if (enter.equals("exit")) {
                    exit = true;
                } else if (enter != null) {

                    M.setMessage(enter);
                    Socket s = new Socket(serverAddress, 4242);                                         //Verbindung wird aufgebaut und Pfad gesendet

                    ObjectOutputStream out = new ObjectOutputStream(s.getOutputStream());
                    out.writeObject(M);
                    out.flush();

                    String file = Paths.get(M.getMessage()).toString();

                    String extension = "";

                    int i = file.lastIndexOf('.');
                    if (i > 0) {
                        extension = file.substring(i+1);
                    }

                    InputStream in = s.getInputStream();
                    FileOutputStream fileOut = new FileOutputStream("Client-downloadet."+extension);

                    byte[] buffer = new byte[1024];                                 //File wird gespeichert
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

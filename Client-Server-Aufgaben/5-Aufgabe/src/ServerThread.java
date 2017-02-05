import java.io.*;
import java.net.Socket;
import java.nio.file.Path;
import java.nio.file.Paths;

/**
 * Created by Mirco B on 04.02.2017.
 * Thread des Servers
 */

public class ServerThread extends Thread {
    private Socket connection;
    private Server server;
    BufferedReader in =null;
    PrintWriter out;

    public ServerThread(Socket con, Server s) throws IOException {          //Mit Construktor werden Verbindung und Server übergeben

        this.connection = con;
        this.server = s;
        in = new BufferedReader(new InputStreamReader(connection.getInputStream()));
        out = new PrintWriter(connection.getOutputStream(), true);
    }

    @Override
    public void run() {
        try {


            ObjectInputStream in = new ObjectInputStream(connection.getInputStream());
            try {


                Url a = (Url) in.readObject();                                          //Datei wird geöffnet und gesendet
                Path Link = (Paths.get(a.getMessage()));
                System.out.println(Link+" Wird gesendet");

                OutputStream out = connection.getOutputStream();
                InputStream fileIn = new FileInputStream(Link.toFile());

                byte[] buffer = new byte[1024];
                while (fileIn.available() > 0) {
                    out.write(buffer, 0, fileIn.read(buffer));
                }

                fileIn.close();




            } catch (Exception e) {

                System.out.println("Fehler bei der Übertragung");
                e.printStackTrace();

            }


        }catch (Exception e) {

                System.out.println("Fehler Server");

        }finally {
            try{
            connection.close();
            System.out.println(" gesendet und getrennt");

            } catch (Exception e) {

                System.out.println("Fehler Server");
                e.printStackTrace();

            }
        }
    }




    }






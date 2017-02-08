import java.io.*;
import java.net.Socket;
import java.util.Date;

/**
 * Created by Mirco B on 04.02.2017.
 * Thread des Servers
 */

public class ServerThread extends Thread {
    private Socket connection;
    private Server server;

    public ServerThread(Socket con, Server s) throws IOException {          //Mit Construktor werden Verbindung und Server übergeben

        this.connection = con;
        this.server = s;

    }

    @Override
    public void run() {
        try {

            ObjectInputStream in = new ObjectInputStream(connection.getInputStream());

            Message M = (Message) in.readObject();
            if (M.getMessage().equals("0")) {

                double Ant = Math.random()*99*(Math.random())*100;
                System.out.println("Wert:" + Ant);
                M.setInt1(0);

                M.setMessage(String.valueOf(Ant));
            } else {

                long Ant2 = System.currentTimeMillis();
                System.out.println("Wert:" + Ant2);
                M.setMessage(String.valueOf(Ant2));
                M.setInt1(1);
            }

            ObjectOutputStream out = new ObjectOutputStream(connection.getOutputStream());
            out.writeObject(M);


        } catch (Exception e) {

            System.out.println("Fehler bei der Übertragung");
            e.printStackTrace();
        }finally {
            try {
                connection.close();
                System.out.println(" gesendet und getrennt");

            } catch (Exception e) {

                System.out.println("Fehler Server");
                e.printStackTrace();

            }
        }
    }


}






import java.io.IOException;
import java.io.ObjectInputStream;
import java.net.Socket;

/**
 * Created by Borri Mirco on 03.03.2017.
 */
public class ServerThread extends Thread {
    private Socket connection;
    private Server server;
    ObjectInputStream in;

    public ServerThread(Socket con, Server s) throws IOException {          //Thread zum Kommunizieren mit dem Client

        this.connection = con;
        this.server = s;
        ObjectInputStream in = new ObjectInputStream(con.getInputStream());

    }

    @Override
    public void run() {                         //Wartet auf Nachricht und schickt diese an den Server. der Server speichert diese.
        try {
            System.out.println("mit server verbunden");
            Nachricht msg;

            while (true) {

                msg = (Nachricht) in.readObject();


                if (msg.getMessage().equals("reset")) {
                    server.setButtons("reset");

                } else {
                    server.setButtons(msg.getMessage());
                }


            }

        } catch (Exception e) {
            System.out.println("Fehler aufgetreten!!!!");
            e.printStackTrace();
        }


    }


}
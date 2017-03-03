
import java.net.ServerSocket;
import java.net.Socket;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * Created by Borri Mirco on 03.03.2017.
 */
public class Server {                                   //Server Hauptthread

    public static void main(String[] args) {


    Server s = new Server();
        s.start();

    }



        public String getButtons() {

        return buttons;
    }

    public Server() {
        this.start();
    }

    private ServerSocket serverSocket;
    private Socket connection = null;
    private ExecutorService executor;

    public void setButtons(String s) {
        buttons = s;
    }

    private String buttons = "";


    public void start() {

        System.out.println("Server Gestartet");
        executor = Executors.newCachedThreadPool();

        try {
            serverSocket = new ServerSocket(4242);

            for (int i = 0; i < 2; i++) {                 //Wartet auf 2 verbindungen

                connection = serverSocket.accept();
                System.out.println("Client " + connection.getInetAddress().toString() + " mit server verbunden");
                executor.execute(new ServerThread(connection, this));            //Startet neuen Serverthread und übergibt connection
                executor.execute(new writer(this, connection));
            }

        } catch (Exception e) {
            System.out.println("Fehler aufgetreten!!!!");
            executor.shutdownNow();
            e.printStackTrace();
        }
    }

}




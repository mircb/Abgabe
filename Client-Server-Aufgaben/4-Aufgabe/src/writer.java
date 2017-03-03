
import java.io.ObjectOutputStream;
import java.net.Socket;
/**
 * Created by Borri Mirco on 03.03.2017.
 */
public class writer extends Thread{

    private String last ="";
    private Server ser;
    ObjectOutputStream out;
    Socket connection;

    public writer(Server s,Socket c) {              //Thread zum verschiken von Nachrichten an den Client
        ser = s;
        connection = c;
        this.start();


    }

    @Override
    public void run(){                  //Falls sich der gespeicherte Button ändert, wird der neue dem anderen Client gesendet
        try {
            out = new ObjectOutputStream(connection.getOutputStream());

            //out.println("hello");

            Nachricht send = new Nachricht();

            while(true){
                    Thread.sleep(10);
                if(!last.equals(ser.getButtons())) {
                    last = ser.getButtons();
                    send.setMessage(last);
                    out.writeObject(send);
                }
            }


        }catch(Exception e){

        System.out.println("Fehler aufgetreten!!!");
        e.printStackTrace();

    }

    }



}

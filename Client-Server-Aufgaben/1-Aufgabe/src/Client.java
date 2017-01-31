/**
 * Created by stbormir on 09.01.2017.
 */
import java.io.*;
import java.net.Socket;

public class Client {


        public static void main(String[] args) throws IOException {
            Message M = new Message();                                  //Objekt wird erzeugt, das gesendet wird

            BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

            while(true){

                System.out.println("IP des Servers eingeben, auf dem der Calc-serviceauf Port 4242 laüft\n"+			//IP des Servers wird eingelesen(Default127.0.0.1) oder exit befehl wird ausgeführt
			"(Default 127.0.0.1)Tippe 'exit' to exit");												

                String serverAddress = "127.0.0.1";

                String enter= reader.readLine();

                if (enter.equals("exit")) {
                    break;
                }else if(enter!=null){
                    serverAddress=enter;
                }

                int Op1=0;
                int Op2=0;
                String Operantion="+";

                try {
                    System.out.println("Erste Zahl zum berechnen(ganze Zahlen)");
                    Op1 = Integer.parseInt(reader.readLine());

                    System.out.println("Operationszeichen eingeben (+,-,*,/)");

                    Operantion = reader.readLine();


                    System.out.println("Zweite Zahl zum berechnen(ganze Zahlen)");
                    Op2 = Integer.parseInt(reader.readLine());

                }catch(java.lang.NumberFormatException e){                                  //Falls falsch eingegeben wird neu begonnen
                    System.out.println("Falsch eingegeben. Bitte nochmal!");


                }
                M.setInt1(Op1);
                M.setInt2(Op2);
                M.setMessage(Operantion);

                Socket s = new Socket(serverAddress, 4242);                                         //Verbindung wird aufgebaut

                ObjectOutputStream out = new ObjectOutputStream(s.getOutputStream());

                out.writeObject(M);                                                                 //Objekt wird gesendet

                InputStreamReader input = new InputStreamReader(s.getInputStream());

                int answer = input.read();                                                      //Ergebniss wird empfangen und ausgegeben

                System.out.println("= " + answer);

                s.close();
            }

            System.out.println("beendet");

        }


}

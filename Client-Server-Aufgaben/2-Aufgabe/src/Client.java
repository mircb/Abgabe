/**
 * Created by stbormir on 09.01.2017.
 */
import java.io.*;
import java.net.Socket;

public class Client {


        public static void main(String[] args) throws IOException {
            Message M = new Message(); //Objekt wird erzeugt, das gesendet wird

            Auth a = new Auth();
            BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));



                System.out.println("IP des Servers eingeben, auf dem der Calc-service mit Authentifizierung auf Port 4242 laüft\n" +                  //IP des Servers wird eingelesen(Default127.0.0.1) oder exit befehl wird ausgeführt
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
            while(!exit){
                boolean aut = false;
                while(!aut) {
                    System.out.println("Benutzername eingeben (oder exit)");                    //Benutzernamen eingeben, um sich zu Authetifizieren.
                    enter = reader.readLine();
                    if (enter.equals("exit")) {
                        exit = true;
                        break;
                    } else if (enter != null) {

                        a.setMessage(enter);
                        Socket s = new Socket(serverAddress, 4242);                                         //Verbindung wird aufgebaut

                        ObjectOutputStream out = new ObjectOutputStream(s.getOutputStream());
                        InputStreamReader input = new InputStreamReader(s.getInputStream());

                        out.writeObject(a);
                        int answer = input.read();
                        int Op1=0;
                        int Op2=0;
                        String Operantion="+";

                        if (answer == 1) {
                            aut = true;
                            System.out.println("Authentifiziert!");                     //Zahlen und Rechenzeichen werden eingelesen

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

                                out.writeObject(M);           //Objekt wird gesendet
                                out.flush();

                                int erg = input.read();                                                      //Ergebniss wird empfangen und ausgegeben

                                System.out.println("= " + erg);

                                s.close();


                            }else{
                                System.out.println("nicht Authentifiziert! \n");

                            }
                        }

                }

            }
            System.out.println("Programm beendet");


        }


}

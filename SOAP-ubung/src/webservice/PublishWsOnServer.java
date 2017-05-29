package webservice;

import javax.swing.JOptionPane;
import javax.xml.ws.Endpoint;

public class PublishWsOnServer {

	public static void main (String[]args){
		System.out.println("Server gestartet");
		Endpoint endpoint = Endpoint.publish("http://127.0.0.1:8080/services", new MyWebService());

	}
}

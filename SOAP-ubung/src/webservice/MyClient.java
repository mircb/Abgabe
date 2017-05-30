package webservice;

import java.util.Scanner;

import webservice.gen.mywebserviceservice.MINICALC;
import webservice.gen.mywebserviceservice.MyWebServiceService;

public class MyClient {

	public static void main(String[] args){
		//System.out.println("Java mit eigenem Server und useWSImport.bat:\n-------------------");
		System.out.println("Welche Operation?(+ - * / )");
		Scanner scanner = new Scanner(System.in);
		String input = scanner.nextLine();
		
		MINICALC service = new MyWebServiceService().getMINICALCPort();


		System.out.println("Gib die erste Zahl ein:");
		String f1 = scanner.nextLine();
		
		System.out.println("Gib die zweite Zahl ein:");
		String f2 = scanner.nextLine();

		if( input.equals("+")) {

			System.out.println("Das Ergebniss ist: " + service.addition(Float.parseFloat(f1), Float.parseFloat(f2)));
		}
		if( input.equals("-")) {

			System.out.println("Das Ergebniss ist: " + service.subbtraktion(Float.parseFloat(f1), Float.parseFloat(f2)));
		}
		if( input.equals("*")) {

			System.out.println("Das Ergebniss ist: " + service.multiplikation(Float.parseFloat(f1), Float.parseFloat(f2)));
		}
		if( input.equals("/")) {

			System.out.println("Das Ergebniss ist: " + service.division(Float.parseFloat(f1), Float.parseFloat(f2)));
		}
		}
	}



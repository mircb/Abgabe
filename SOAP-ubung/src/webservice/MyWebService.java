package webservice;

import javax.jws.*;
import javax.jws.soap.SOAPBinding;

@WebService(name="MINICALC")
@SOAPBinding(style = SOAPBinding.Style.RPC)

public class MyWebService {

	@WebMethod(operationName="Addition")
	public float Addition (float f1,float f2){
		return f1+f2;
	}

	@WebMethod(operationName="Subbtraktion")
	public float Subbtraktion (float f1,float f2){
		return f1-f2;
	}

	@WebMethod(operationName="Multiplikation")
	public float Multiplikation (float f1,float f2){
		return f1*f2;
	}

	@WebMethod(operationName="Division")
	public float Division (float f1,float f2){
		return f1/f2;
	}
	

}

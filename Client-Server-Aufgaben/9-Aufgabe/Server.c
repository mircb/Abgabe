#include <stdio.h>
#include <sys/socket.h>
#include <netinet/in.h>
#include <string.h>
#include <stdlib.h>
#include <time.h>
#include <sys/socket.h>
#include <netinet/in.h>
#include <arpa/inet.h>

int main(){

  int Socket, newSocket;
char buffer[1024];
  struct sockaddr_in serverAddr;
  struct sockaddr_storage serverStorage;
  socklen_t addr_size;
	

  Socket = socket(PF_INET, SOCK_STREAM, 0);		//alles intialisieren
  

  	serverAddr.sin_family = AF_INET;
 
  	serverAddr.sin_port = htons(4242);
  
  	serverAddr.sin_addr.s_addr = inet_addr("127.0.0.1");
  
  	memset(serverAddr.sin_zero, '\0', sizeof serverAddr.sin_zero);  

	int  i = 1;
  while(i=1){
	  	bind(Socket, (struct sockaddr *) &serverAddr, sizeof(serverAddr));

	  	if(listen(Socket,2)==0)			// auf Verbindungen warten
	    		printf("Warten...\n");
	  	else
	    		printf("Error\n");


	  	addr_size = sizeof serverStorage;
	  newSocket = accept(Socket, (struct sockaddr *) &serverStorage, &addr_size);

		int res =0;
			recv(newSocket, buffer, 10, 0);
	
		
		printf("für Ortschaft berechnen:%s\n",buffer);		//Ausgeben
		srand( (unsigned) time(NULL));
		int gefahr = rand () %5+1;			//Berechnen

		char ant[2] = "";
		ant[0] = (char)gefahr;	
		
		printf("Gefahr:%i\n\n",ant[0]);

	  	send(newSocket,ant,10,0);
	}		

  return 0;
}

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
  int clientSocket, sendS;
  char buffer[2];
  struct sockaddr_in serverAddr;
  socklen_t addr_size;
struct sockaddr_storage Storage;
 char eingabe[10]; 
  
					//alles intialisieren

	clientSocket = socket(PF_INET, SOCK_STREAM, 0);
	  
	serverAddr.sin_family = AF_INET;
	serverAddr.sin_port = htons(4242);

	printf("IP des Servers eingeben auf dem der Lawinen-berechnugs-service auf Port 4242 läuft:\n");    			//Verbinden
		                          
		
	scanf("%s",&eingabe);

	 serverAddr.sin_addr.s_addr = inet_addr(eingabe);

	 memset(serverAddr.sin_zero, '\0', sizeof serverAddr.sin_zero);  

	 addr_size = sizeof serverAddr;
	 connect(clientSocket, (struct sockaddr *) &serverAddr, addr_size);

	printf("\nWelche Ortschaft?\n");     
                                  
	scanf("%s",&eingabe);

	send(clientSocket,eingabe,10,0);		//Senden und antwort erhalten

  	recv(clientSocket, buffer, 2, 0);


  	printf("Gefahr: %i\n",buffer[0]);
   

  return 0;
}

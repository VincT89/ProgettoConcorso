package test;

import java.util.Scanner;

public class Utente {
	
    public static void main(String[] args) {
    	Scanner scanner = new Scanner(System.in);
        final int MAX_PARTECIPANTI = 100;
        String[] partecipanti = new String[MAX_PARTECIPANTI]; // Array per memorizzare i nomi dei partecipanti
        int[] voti = new int[MAX_PARTECIPANTI]; // Array per memorizzare i voti dei partecipanti , parallelo all'array partecipanti in modo che l'indice di un partecipante corrisponda all'indice del suo voto visto che il massimo numero di partecipanti e' 100
        String passwordGestore = "ciao"; // Numero di partecipanti effettivi 
        
        int numeroPartecipanti = 0;
        int numeroVotanti=0;//tiene conto delle persone che votano
        
        //5 partecipanti già inseriti per i test
        numeroPartecipanti=5;
        partecipanti[0] = "Mario Rossi";
        voti[0] = 0;

        partecipanti[1] = "Luigi Bianchi";
        voti[1] = 0;

        partecipanti[2] = "Giovanni Verdi";
        voti[2] = 0;

        partecipanti[3] = "Paolo Neri";
        voti[3] = 0;

        partecipanti[4] = "Luca Russo";
        voti[4] = 0;

        while (true) {
            System.out.println("Seleziona un'opzione:");
            System.out.println("1. Visualizza partecipanti");
            System.out.println("2. Vota");
            System.out.println("3. Accesso gestore");
            System.out.println("---------------------------------------------------------------");

            while (!scanner.hasNextInt()) {
            	System.out.println("---------------------------------------------------------------");
                System.out.println("Per favore, inserisci un numero valido.");
                System.out.println("---------------------------------------------------------------");
                scanner.next(); // Consuma l'input non valido
            }
            int scelta = scanner.nextInt();
            scanner.nextLine(); // Consuma la scelta che rimane in memoria

            switch (scelta) {
            
                case 1: // Visualizza partecipanti
                    if (numeroPartecipanti == 0) {
                    	System.out.println("---------------------------------------------------------------");
                        System.out.println("Non ci sono partecipanti al momento.");
                        System.out.println("---------------------------------------------------------------");
                     
                    } else {
                        for (int i = 0; i < numeroPartecipanti; i++) {
                        	System.out.println("---------------------------------------------------------------");
                            System.out.println((i + 1) + ". " + partecipanti[i]); // Stampa il nome del partecipante  preceduti dal numero del partecipante (ecco perche' i + 1)
                            System.out.println("---------------------------------------------------------------");
                        }
                    }
                    break;
                    
                case 2: // Vota
                	System.out.println("---------------------------------------------------------------");
                    System.out.println("Inserisci il numero del partecipante per votare:");
                    System.out.println("---------------------------------------------------------------");
                    while (!scanner.hasNextInt()) {
                    	System.out.println("---------------------------------------------------------------");
                        System.out.println("Per favore, inserisci un numero valido.");
                        System.out.println("---------------------------------------------------------------");
                        scanner.next(); // Consuma l'input non valido
                    }
                    int indiceVoto = scanner.nextInt() - 1; // Indice del partecipante da votare (parte da 0) e serve per accedere all'array partecipanti e voti per memorizzare il voto
                    scanner.nextLine(); // Consuma l'input 
                    if (indiceVoto >= 0 && indiceVoto < numeroPartecipanti) { // Controllo che l'indice sia valido (compreso tra 0 e numeroPartecipanti - 1 cioe' il numero di partecipanti effettivi)
                        voti[indiceVoto]++; // Incremento il voto del partecipante selezionato
                        numeroVotanti++;
                        System.out.println("---------------------------------------------------------------");
                        System.out.println("Hai votato per " + partecipanti[indiceVoto]);
                        System.out.println("---------------------------------------------------------------");
                    } else {
                    	System.out.println("---------------------------------------------------------------");
                        System.out.println("Partecipante non valido.");
                        System.out.println("---------------------------------------------------------------");
                    }
                    break;
                    
                case 3: // Accesso gestore
                	System.out.println("---------------------------------------------------------------");
                    System.out.println("Inserisci la password del gestore:");
                    System.out.println("---------------------------------------------------------------");
                    while (!scanner.hasNextLine()) {
                    	System.out.println("---------------------------------------------------------------");
                        System.out.println("Per favore, inserisci una password valida.");
                        System.out.println("---------------------------------------------------------------");
                        scanner.next(); // Consuma l'input non valido
                    }
                    String password = scanner.nextLine();
                    if (!password.equals(passwordGestore)) {
                    	System.out.println("---------------------------------------------------------------");
                    	System.out.println("Password errata.");
                    	System.out.println("---------------------------------------------------------------");
                    }
                    else {
                    	System.out.println("---------------------------------------------------------------");
                        System.out.println("Accesso gestore:");
                        System.out.println("1. Aggiungi partecipante");
                        System.out.println("2. Visualizza risultati");
                        System.out.println("3. Visualizza statistiche votazioni");
                        System.out.println("4. Chiudi applicativo");
                        System.out.println("---------------------------------------------------------------");
                        while (!scanner.hasNextInt()) {
                        	System.out.println("---------------------------------------------------------------");
                            System.out.println("Per favore, inserisci un numero valido.");
                            System.out.println("---------------------------------------------------------------");
                            scanner.next(); // Consuma l'input non valido
                        }
                        int sceltaGestore = scanner.nextInt();
                        scanner.nextLine(); // Consuma la scelta rimasta
                        switch(sceltaGestore) {
                        
                        case 1:
                        	if(numeroPartecipanti>=100) {//check per il massimo raggiunto
                        		System.out.println("---------------------------------------------------------------");
                                System.out.println("Non puoi inserire nuovi partecipanti!");
                                System.out.println("---------------------------------------------------------------"); 
                                break;
                        	}
                        	System.out.println("---------------------------------------------------------------");
                            System.out.println("Inserisci nome e cognome del nuovo partecipante:");
                            System.out.println("---------------------------------------------------------------");
                            String nuovoPartecipante=scanner.nextLine();
                            boolean giaPresente = false;//check per evitare nomi ripetuti
                            for(int i = 0; i < partecipanti.length; i++) {
                            	if(nuovoPartecipante.equalsIgnoreCase(partecipanti[i])) {                            		
                                    giaPresente=true;
                                    break;
                                    }
                            }
                            if(giaPresente) {
                            	System.out.println("---------------------------------------------------------------");
                                System.out.println(nuovoPartecipante+" è già nel database!");
                                System.out.println("---------------------------------------------------------------");
                            }else {
                            voti[numeroPartecipanti] = 0;
                            partecipanti[numeroPartecipanti] = nuovoPartecipante;
                            numeroPartecipanti++;
                            String massimoRaggiunto=(numeroPartecipanti == 100 ? "Non puoi aggiungere altri partecipanti." : "");
                            System.out.println("---------------------------------------------------------------");
                            System.out.println("Nuovo partecipante inserito. " + massimoRaggiunto);
                            System.out.println("---------------------------------------------------------------");
                            }
                        	break;
                        	
                        case 2://Visualizzazione risultati
                        	if (numeroPartecipanti == 0) {
                				System.out.println("---------------------------------------------------------------");
                                System.out.println("Non ci sono partecipanti al momento.");
                                System.out.println("---------------------------------------------------------------");
                                break;
                            }
                        	for(int i = 0; i < partecipanti.length; i++) {
                    			if(partecipanti[i] == null) {
                    				break;
                    			}
                    			System.out.println("# " + (int)(i + 1) + "\nNome: "+partecipanti[i] + "\nVoti: " + voti[i]);
                				System.out.println("---------------------------------------------------------------");
                    		}

                        	break;
                        	
                        case 3://statistiche
                        	if (numeroPartecipanti == 0 || numeroVotanti == 0) {
                				System.out.println("---------------------------------------------------------------");
                                System.out.println("Non ci sono abbastanza dati al momento.");
                                System.out.println("---------------------------------------------------------------");
                                break;
                            }                     
                        	int votoMax = -1;
                        	int votoMin = voti[0] + 1;
                        	String vincitoreTemp = "";
                    		String perdenteTemp = "";
                    		for(int i = 0; i < voti.length; i++) {
                    			
                    			if(partecipanti[i] == null) {//quando i partecipanti finiscono il ciclo si blocca
                    				break;
                    			}
                    			//tutti i voti vengono ciclati e confrontati, aggiornando le variabili dei voti più alto e più basso
                    			if(votoMax < voti[i]) {
                    				votoMax = voti[i];
                    				vincitoreTemp = partecipanti[i];
                    			}
                    			else if(votoMax == voti[i]){
                    				votoMax = voti[i];
                    				vincitoreTemp += " e " + partecipanti[i];
                    			}
                    			if(votoMin > voti[i]) {
                    				votoMin = voti[i];
                    				perdenteTemp = partecipanti[i];
                    			}
                    			else if(votoMin == voti[i]){
                    				votoMin = voti[i];
                    				perdenteTemp += " e " + partecipanti[i];
                    			}
                    		}
                    		System.out.println("---------------------------------------------------------------");
                        	System.out.println("Concorrente/i in testa: " + vincitoreTemp + " con " + votoMax + " voti;" );
                        	System.out.println("---------------------------------------------------------------");
                        	System.out.println("Concorrente/i in coda: " + perdenteTemp + " con " + votoMin + " voti;" );
                            System.out.println("---------------------------------------------------------------");
                        	break;
                        	
                        case 4: // Esci               
                        	System.out.println("---------------------------------------------------------------");
                        	System.out.println("Uscita dal programma.");
                        	System.out.println("---------------------------------------------------------------");
                        	scanner.close();
                        	return;
                        	
                        default:
                        	System.out.println("---------------------------------------------------------------");
                        	System.out.println("Scelta non valida.");
                        	System.out.println("---------------------------------------------------------------");
                        	break;
                        }
                    
                    }  
                    	
                    break;
                    
                default:
                	System.out.println("---------------------------------------------------------------");
                	System.out.println("Scelta non valida.");
                	System.out.println("---------------------------------------------------------------");
                	break;
            }
        }
    }
}            
        
    


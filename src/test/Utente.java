package test;

import java.util.Scanner;

public class Utente {
    public static void main(String[] args) {
    	Scanner scanner = new Scanner(System.in);
        final int MAX_PARTECIPANTI = 100;
        String[] partecipanti = new String[MAX_PARTECIPANTI];
        int[] voti = new int[MAX_PARTECIPANTI];
        String passwordGestore = "ciao";
        
        int numeroPartecipanti = 0;

        while (true) {
            System.out.println("Seleziona un'opzione:");
            System.out.println("1. Visualizza partecipanti");
            System.out.println("2. Vota");
            System.out.println("3. Accesso gestore");
            System.out.println("4. Esci");
            System.out.println("---------------------------------------------------------------");

            while (!scanner.hasNextInt()) {
            	System.out.println("---------------------------------------------------------------");
                System.out.println("Per favore, inserisci un numero valido.");
                System.out.println("---------------------------------------------------------------");
                scanner.next(); // Consuma l'input non valido
            }
            int scelta = scanner.nextInt();
            scanner.nextLine(); // Consuma la newline rimanente

            switch (scelta) {
                case 1: // Visualizza partecipanti
                    if (numeroPartecipanti == 0) {
                    	System.out.println("---------------------------------------------------------------");
                        System.out.println("Non ci sono partecipanti al momento.");
                        System.out.println("---------------------------------------------------------------");
                     
                    } else {
                        for (int i = 0; i < numeroPartecipanti; i++) {
                        	System.out.println("---------------------------------------------------------------");
                            System.out.println((i + 1) + ". " + partecipanti[i] + " - Voti: " + voti[i]);
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
                    int indiceVoto = scanner.nextInt() - 1;
                    scanner.nextLine(); // Consuma l'input 
                    if (indiceVoto >= 0 && indiceVoto < numeroPartecipanti) {
                        voti[indiceVoto]++;
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
                    if (password.equals(passwordGestore)) {
                    	System.out.println("---------------------------------------------------------------");
                        System.out.println("Accesso gestore:");
                        System.out.println("1. Aggiungi partecipante");
                        System.out.println("2. Visualizza risultati");
                        System.out.println("3. Visualizza statistiche votazioni");
                        System.out.println("---------------------------------------------------------------");
                        while (!scanner.hasNextInt()) {
                        	System.out.println("---------------------------------------------------------------");
                            System.out.println("Per favore, inserisci un numero valido.");
                            System.out.println("---------------------------------------------------------------");
                            scanner.next(); // Consuma l'input non valido
                        }
                        int sceltaGestore = scanner.nextInt();
                        scanner.nextLine(); // Consuma la newline rimanente
                        
                    
                    } else {
                    	System.out.println("---------------------------------------------------------------");
                    	System.out.println("Password errata.");
                    	System.out.println("---------------------------------------------------------------");
                    }
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
}
}
               
        
    


package example;

import peepingTom.PrinterManager;

/*
 * Classe main utilizada para testes do programa
 */
public class Main {
	public static void main(String[] args) {
        // Instanciating and running the printManager with the requested sizes
        PrinterManager printmanager;
		printmanager = new PrinterManager(20,10,6);
        printmanager.start();
	}
}
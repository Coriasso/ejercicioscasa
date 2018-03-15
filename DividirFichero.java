package com.iesvirgendelcarmen.com;

import java.io.File;

public class DividirFichero {

	public static void main(String[] args) {

		if (args.length != 2) {
			System.out.println("Número de argumentos inválidos");
			System.exit(1); 			
		}
		
		File inFile = new File(args[0]);
		
		if(!inFile.exists()) {
			System.out.println("No existe el fichero");
			System.exit(1); 			

		}
		if (!args[1].matches("[\\d+]")) {
			System.out.println("Número inválido");
			System.exit(1);
		}
		System.out.println("Todo bien, todo correcto");
	}

}

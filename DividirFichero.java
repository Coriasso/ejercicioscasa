package com.iesvirgendelcarmen.ejercicios;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;

public class DividirFichero {

	public static void main(String[] args) {
		//Controlar la entrada de 2 argumentos
		if (args.length != 2) {
			System.out.println("N�mero de argumentos inv�lidos");
			System.exit(1); 			
		}
		//Declaramos todas las variables que vamos a crear
		File inFile = new File(args[0]);
		int NumArchivos = Integer.parseInt(args[1]);
		int tama�oJustoArchivos = 0;
		int tama�oSobraArchivos = 0;

		if(!inFile.exists()) {
			System.out.println("No existe el fichero");
			System.exit(1); 			

		}
		if (!args[1].matches("[\\d+]")) {
			System.out.println("N�mero inv�lido");
			System.exit(1);
		}

		System.out.println("Todo bien, todo correcto, el programa empezar� ahora");

		//Determinar el tama�o de cada parte


		tama�oJustoArchivos = (int) Math.floor(((((double) inFile.length())/Double.parseDouble((args[1])))));

		//Comprueba si la divisi�n es exacta, si no lo es coge el n�mero de bytes sobrantes y los guarda
		if ((int) inFile.length() % Integer.parseInt(args[1]) != 0) {

			tama�oSobraArchivos = (int) inFile.length() % Integer.parseInt(args[1]);
			System.out.printf("Tama�o del archivo a partir: %s%nN�mero de archivos que se van a generar: %d, de tama�o %d y una parte de tama�o %d%n"
					, inFile.length(), NumArchivos, tama�oJustoArchivos,tama�oSobraArchivos);

		}
		else
			System.out.printf("Tama�o del archivo a partir: %s%nN�mero de archivos que se van a generar: %d, de tama�o %d%n", inFile.length(), NumArchivos,tama�oJustoArchivos);	


		try (InputStream in = new FileInputStream(inFile); ){
			//Creamos la salida sin inicializar
			OutputStream out = null;
			int ByteRead = 0;

			//Fragmentaci�n del archivo. El primer for da tantas vueltas como archivos se vayan a crear y el segundo tantas como bytes de tama�o tengan estas nuevas partes
			//Al final, si hay bytes que sobran se escriben tambi�n

			for (int i = 0; i < NumArchivos; i++) {
				out = new FileOutputStream ("archivos/fichero_copia"+(i+1)+".txt"); // Al principio de cada for creamos un nuevo objeto con la ruta de una de las partes nuevas

				for (int j = 0; j < tama�oJustoArchivos; j++) {

					ByteRead = in.read();
					out.write(ByteRead); 	


				}

				out.flush();


				//Comprueba que es la �ltima iteraci�n del for y si hay bytes sobrantes
				if (i == NumArchivos - 1 && tama�oSobraArchivos != 0) {
					out = new FileOutputStream ("archivos/fichero_copia"+(i+2)+".txt");
					for (int j = 0; j < tama�oSobraArchivos; j++) {

						ByteRead = in.read();
						out.write(ByteRead);



					}
					out.flush();
					
				}

				

			}
			
			out.close();
			System.out.println("Archivos copiados sin problemas");


		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}




	}






}
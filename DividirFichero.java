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
			System.out.println("Número de argumentos inválidos");
			System.exit(1); 			
		}
		//Declaramos todas las variables que vamos a crear
		File inFile = new File(args[0]);
		int NumArchivos = Integer.parseInt(args[1]);
		int tamañoJustoArchivos = 0;
		int tamañoSobraArchivos = 0;

		if(!inFile.exists()) {
			System.out.println("No existe el fichero");
			System.exit(1); 			

		}
		if (!args[1].matches("[\\d+]")) {
			System.out.println("Número inválido");
			System.exit(1);
		}

		System.out.println("Todo bien, todo correcto, el programa empezará ahora");

		//Determinar el tamaño de cada parte


		tamañoJustoArchivos = (int) Math.floor(((((double) inFile.length())/Double.parseDouble((args[1])))));

		//Comprueba si la división es exacta, si no lo es coge el número de bytes sobrantes y los guarda
		if ((int) inFile.length() % Integer.parseInt(args[1]) != 0) {

			tamañoSobraArchivos = (int) inFile.length() % Integer.parseInt(args[1]);
			System.out.printf("Tamaño del archivo a partir: %s%nNúmero de archivos que se van a generar: %d, de tamaño %d y una parte de tamaño %d%n"
					, inFile.length(), NumArchivos, tamañoJustoArchivos,tamañoSobraArchivos);

		}
		else
			System.out.printf("Tamaño del archivo a partir: %s%nNúmero de archivos que se van a generar: %d, de tamaño %d%n", inFile.length(), NumArchivos,tamañoJustoArchivos);	


		try (InputStream in = new FileInputStream(inFile); ){
			//Creamos la salida sin inicializar
			OutputStream out = null;
			int ByteRead = 0;

			//Fragmentación del archivo. El primer for da tantas vueltas como archivos se vayan a crear y el segundo tantas como bytes de tamaño tengan estas nuevas partes
			//Al final, si hay bytes que sobran se escriben también

			for (int i = 0; i < NumArchivos; i++) {
				out = new FileOutputStream ("archivos/fichero_copia"+(i+1)+".txt"); // Al principio de cada for creamos un nuevo objeto con la ruta de una de las partes nuevas

				for (int j = 0; j < tamañoJustoArchivos; j++) {

					ByteRead = in.read();
					out.write(ByteRead); 	


				}

				out.flush();


				//Comprueba que es la última iteración del for y si hay bytes sobrantes
				if (i == NumArchivos - 1 && tamañoSobraArchivos != 0) {
					out = new FileOutputStream ("archivos/fichero_copia"+(i+2)+".txt");
					for (int j = 0; j < tamañoSobraArchivos; j++) {

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
package com.iesvirgendelcarmen.ejercicios;

import java.util.Scanner;


public class letraDNI {
	 public static final String NIF_STRING_ASOCIATION = "TRWAGMYFPDXBNJZSQVHLCKE";
	
	 public static void main(String[] args) {
		
		 Scanner sc = new Scanner(System.in);
		 System.out.println("Introduzca 8 números y una letra:");
		 String dni = sc.next();
		// System.out.println(letra(dni));
		 sc.close();
		 comprobarDNI(dni +"");
	}
	
	 public static String letra(int dni) {
		    return String.valueOf(dni) + NIF_STRING_ASOCIATION.charAt(dni % 23);
		  }
	 
	 
	 
	 public static void comprobarDNI(String dni) {
		 
		 String dniSinNumero =dni.substring(0, dni.length()-1);
		 int dniSinNumeroNumero = Integer.parseInt(dniSinNumero);
		 System.out.println(dniSinNumeroNumero);
		char Letra = NIF_STRING_ASOCIATION.charAt(dniSinNumeroNumero  % 23);
		 
		if (Letra == dni.charAt(dni.length()-1))
			System.out.println("DNI correcto");
		else
			System.out.println("DNI incorrecto");
		
		 
		
	 };
	 

}

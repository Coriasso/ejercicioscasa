package com.iesvirgendelcarmen.poo.ejercicios;

import java.util.Scanner;

public class hexanumber {

	private String hexadecimalNumber;

	public hexanumber(String hexadecimalNumber) 
			throws IlegalHexaNumber {
		if(HexaValidator(hexadecimalNumber))
			this.hexadecimalNumber = hexadecimalNumber.toUpperCase();
		else
			throw new IlegalHexaNumber("Número hexadeciman no váĺido");
	}

	public String getHexadecimalNumber() {
		return hexadecimalNumber;
	}

	public void setHexadecimalNumber(String hexadecimalNumber) {
		this.hexadecimalNumber = hexadecimalNumber;
	}
	
	
	
	
	
	
	
	public  long hexaToDecimall() {
		long sum = 0;
		String sb = new StringBuilder(this.hexadecimalNumber).reverse().toString();
		for (int i = 0; i < sb.length(); i++) {
			if (sb.charAt(i) != '0') {
				switch (sb.charAt(i)) {
				case 'A':
					sum +=(Math.pow(16, i)*10);				
					break;
					
				case 'B':
					sum +=(Math.pow(16, i)*11);
					break;
					
				case 'C':
					sum +=(Math.pow(16, i)*12);
					break;

				case 'D':
					sum +=(Math.pow(16, i)*13);
					break;

				case 'E':
					sum +=(Math.pow(16, i)*14);
					break;

				case 'F':
					sum +=(Math.pow(16, i)*15);
					break;


				default:
					sum += (Math.pow(16, i)*(sb.charAt(i)-48));
					break;
				}
				
				
			}
				
			
		}
	
		
		return sum;
	}
	
	
	
	
	
	

	public static boolean HexaValidator(String value) {

		return value.toUpperCase().matches("[0-9ABCDEF]+"); 

	}
	
	
	
	
	
	
	

	public static void main(String[] args) {
		
		
		System.out.println("Introduce un número decimal");
		Scanner sc = new Scanner(System.in); 
		String hexaValue = sc.next();
		sc.close();

		try {
			hexanumber hx = new hexanumber(hexaValue);
			
			System.out.println(hx.getHexadecimalNumber());
			System.out.println(hx.hexaToDecimall());
			
		} catch (IlegalHexaNumber e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	
		
		//System.out.println(HexaValidator(" 1784b ".trim()));
	}


}

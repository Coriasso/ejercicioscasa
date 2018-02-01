package com.iesvirgendelcarmen.ejercicios;

import java.util.ArrayList;

public class Banco {
	
	
	private ArrayList<CuentaBancaria> listaDeCuentas = new ArrayList<>();
	
	
	
	

	
	public ArrayList<CuentaBancaria> meterCuenta(CuentaBancaria cuenta) {
		
		 listaDeCuentas.add(cuenta);
		
		 return listaDeCuentas;
		
	}

	public ArrayList<CuentaBancaria> getListaDeCuentas() {
		return listaDeCuentas;
	}

	@Override
	public String toString() {
		return "Banco [listaDeCuentas=" + listaDeCuentas + "]";
	}
	
 
	
	
	

}

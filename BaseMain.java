package com.iesvirgendelcarmen.ejercicio;

import java.sql.Connection;

public class BaseMain {

	public static void main(String[] args) {
		
		Connection c = Conexion.getInstanceOf();
		Connection d = Conexion.getInstanceOf();
		
		System.out.println(c);
		System.out.println(d);

	}

}

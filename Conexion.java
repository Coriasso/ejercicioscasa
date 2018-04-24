package com.iesvirgendelcarmen.ejercicio;

import java.io.FileReader;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Properties;


import org.sqlite.SQLiteConfig;

public class Conexion {

	private static Connection conexion = null;
	private Statement st;

	private Conexion() {

		String BD = null;
		String DB_URL = null;
		String DRIVER = null;
		Properties p = new Properties();

		try {

			p.load(new FileReader("DB.properties"));
			BD = p.getProperty("BD");
			DB_URL = p.getProperty("DB_URL");
			DRIVER = p.getProperty("DRIVER");

		}
		catch(Exception e) {

			System.out.println("Fallo");
		}


		try {

			Class.forName(DRIVER);

			try {	
				SQLiteConfig config = new SQLiteConfig();
				config.enforceForeignKeys(true);
				conexion = DriverManager.getConnection(DB_URL + BD, config.toProperties());
				st = (Statement) conexion.createStatement();
			}catch(SQLException e) {
				System.out.println("Error SQL");
			}

		} catch (ClassNotFoundException e) {
			
			System.out.println("class not found");
		}
		


	

	}


	public static Connection getInstanceOf() {
		if(conexion == null) {
			new Conexion();
		}

		return conexion;
	}

	public ResultSet busqueda(String nombre) {

		String sqlConsultarUsuario ="Select * FROM usuario WHERE login=";

		return null;
	}

}

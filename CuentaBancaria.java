
import java.util.Date;

public class CuentaBancaria {
	
	

	
	private int saldo = 0;
	
	private double interes = 2.5;
	
	Date date = new Date();
	
	private Date fechaCreacion = date;
	//private LocalDate fechaCreacion = LocalDate.now();
	
	private final String ENTIDAD = "1234";
	
	private final String OFICINA = "5678";
	
	private String numeroCuenta;
	
	private static int numeroTotalDeCuentas = 0;
	
	
	
	//CONSTRUCTORES
	public CuentaBancaria(int saldo, double interes) {

		this.saldo = saldo; 
		this.interes = interes;	
		//String numerosFinalesCuenta = numerosDeLaCuenta();
		numeroCuenta= ENTIDAD + "-" + OFICINA + "-" + primerNumeroControl()+ segundoNumeroDeControl(numerosDeLaCuenta()) + "-" + numerosDeLaCuenta();
		numeroTotalDeCuentas+=1;
		
	}

	public CuentaBancaria() {
		
		String numerosFinalesCuenta = numerosDeLaCuenta();
		numeroCuenta= ENTIDAD + "-" + OFICINA + "-" + primerNumeroControl()+ segundoNumeroDeControl(numerosFinalesCuenta) + "-" + numerosFinalesCuenta;		
		numeroTotalDeCuentas+=1;
	}
	//FIN CONSTRUCTORES
	
	
	
	//GETTERS Y SETTERS	
	public String getNumeroCuenta() {
		return numeroCuenta;
	}

	public void setNumeroCuenta(String numeroCuenta) {
		this.numeroCuenta = numeroCuenta;
	}

	public int getSaldo() {
		return saldo;
	}

	public void setSaldo(int saldo) {
		this.saldo = saldo;
	}

	public double getInteres() {
		return interes;
	}

	public void setInteres(double interes) {
		this.interes = interes;
	}

	public Date getFechaCreacion() {
		return fechaCreacion;
	}

	public void setFechaCreacion(Date fechaCreacion) {
		this.fechaCreacion = fechaCreacion;
	}
	
	public int getNumeroTotalDeCuentas() {
		return numeroTotalDeCuentas;
	}
	
	
	//FIN GETTERS Y SETTERS

	@Override
	public String toString() {
		return "CuentaBancaria [numeroCuenta=" + numeroCuenta + ", saldo=" + saldo +"]";
	}
	
	
	
	
	public String numerosDeLaCuenta() {
		long multiplicador =(long) (Math.pow(10, 10));
		long numero = (long)(Math.random()*multiplicador);
		String numeroCadena = numero + "";
		
		
		return numeroCadena;
		 
	}
	
	
	
	
	
	public String primerNumeroControl() {
	String oficina = OFICINA;
	String entidad = ENTIDAD;
	
	int primerBanco = oficina.charAt(0) * 4;
	int segundoBanco = oficina.charAt(1) * 8;
	int tercerBanco = oficina.charAt(2) * 5;
	int cuartoBanco = oficina.charAt(3) * 10;
	int primerEntidad = entidad.charAt(0) * 9;
	int segundoEntidad = entidad.charAt(1) * 7;
	int tercerEntidad = entidad.charAt(2) * 3; 
	int cuartoEntidad = entidad.charAt(3) * 6;
	
	int sumaTotal = primerBanco + segundoBanco + tercerBanco + cuartoBanco + primerEntidad + segundoEntidad + tercerEntidad + cuartoEntidad;
	
	int aDevolver =  sumaTotal % 11;
	
	aDevolver = 11 - aDevolver;
	
	if (aDevolver !=10)
		return aDevolver + "";
	else
	return 1 + "";		
	}
	
	
	
	
	
	public String segundoNumeroDeControl(String numerosDeLaCuenta) {
		
		int primeraCifra = (numerosDeLaCuenta.charAt(0)) - 48;
		
		primeraCifra = primeraCifra * 1 * 2 * 4 * 8 * 5 * 10  *9 * 7 * 3 * 6;
		
		primeraCifra = primeraCifra % 11;
		
		primeraCifra = 11 - primeraCifra;
			
		if (primeraCifra == 10)
			return 1 + "";
			
		
		
		
		return primeraCifra + ""; 
	}

	/*
	public int depositarDinero(int saldo, int cambio) {
	 if (cambio < 0) {
		 System.out.println("No se puede ingresar una cantidad negativa");
		 return 0;
	 }
		return saldo + cambio;
	}
	
	public int retirarDinero (int saldo, int cambio) {
		 if (cambio < 0) {
			 System.out.println("No se puede ingresar una cantidad negativa");
			 return 0;
		 }
		return saldo - cambio;
	}
	*/
	public int gestionarSaldo (int saldo, int cambio) {
		//Un cambio positivo añade saldo y uno negativo lo retira
		return saldo + cambio;
		
		
	}
	
	
	
}



import java.util.Scanner;

public class TestCuentaBancaria {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
	
	Banco banco = new Banco();
	CuentaBancaria cuenta1 = new CuentaBancaria();
	CuentaBancaria cuenta2 = new CuentaBancaria();
	banco.meterCuenta(cuenta1);
	banco.meterCuenta(cuenta2);
	
	System.out.println("Numero de cuentas= " + cuenta1.getNumeroTotalDeCuentas());
	
	Scanner sc = new Scanner(System.in);
	System.out.println("Introduce un saldo");
	int saldoNuevo = sc.nextInt();
	System.out.println("Introduce un interés");
	double interesNuevo = sc.nextDouble();

	CuentaBancaria cuenta3 = new CuentaBancaria(saldoNuevo, interesNuevo);
	
	
	System.out.println(cuenta1);
	System.out.println(cuenta2);
	System.out.println(cuenta3);
	

	System.out.printf("Introduce un número%nPositivo suma al saldo, negativo lo resta:%n");
	
	cuenta1.setSaldo(cuenta1.gestionarSaldo(cuenta1.getSaldo(), sc.nextInt()));
	System.out.println(cuenta1);
	
	
	sc.close();
	
	
	System.out.println("Numero de cuentas= " +  cuenta1.getNumeroTotalDeCuentas());

	System.out.println(banco);
	
	

	

	
}
	
	
	

}

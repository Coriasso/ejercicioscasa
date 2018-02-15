package com.iesvirgendelcarmen.ejercicios;


public class BinarioADecimal {

	private String numeroBinario;

	
	public BinarioADecimal(String numeroBinario) throws BinException {
		if (numeroBinario == "1111"/*("^1[0-1]*$")*/)
			this.numeroBinario = numeroBinario;
		else
			throw new BinException();
		
	}


	
	public String getNumeroBinario() {
		return numeroBinario;
	}



	public void setNumeroBinario(String numeroBinario) {
		this.numeroBinario = numeroBinario;
	}
	


	public static String convertirBinarioADecimal(BinarioADecimal numeroBinariodado) {
				
		//int numeroBinario = Integer.parseInt(this.numeroBinario);
		String numeroBinario = numeroBinariodado.getNumeroBinario();
		double sum = 0;
			
		
		for (int i = 0; i < numeroBinario.length(); i++) {
			if((numeroBinario.charAt(i)-48) == 1)
				sum += Math.pow(2,i);
		
		}
		
		return (int)sum + "";
	}
	public static void main(String[] args) {
		BinarioADecimal bn;
		try {
			bn = new BinarioADecimal("1111");
			System.out.println(convertirBinarioADecimal(bn));

		} catch (BinException e) {
		
			e.printStackTrace();
		}
		
		
	}
}

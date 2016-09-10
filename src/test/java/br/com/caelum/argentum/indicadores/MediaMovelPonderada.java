package br.com.caelum.argentum.indicadores;


import org.junit.Assert;
import org.junit.Test;

import br.com.caelum.argentum.modelo.Candle;
import br.com.caelum.argentum.modelo.SerieTemporal;

public class MediaMovelPonderada {
	public double calcula(int posicao, SerieTemporal serie){
		double soma = 0.0;
		int peso = 3;
		
		for(int i = posicao; i > posicao -3; i--){
			Candle c = serie.getCandle(i);
			soma +=c.getFechamento()*peso;
			peso--;
		}
		return soma/6;
			
	}
	
	@Test
	public void sequenciaSimplesDeCandles(){
		SerieTemporal serie = GeradorDeSerie.criaSerie(1,2,3,4,5,6);
		MediaMovelPonderada mmp = new MediaMovelPonderada();
		
		//ex: calcula(2): 1*1+2*2+3*3=14. Divide por 6, da 14/6
		Assert.assertEquals(14.0/6, mmp.calcula(2, serie),0.00001);
		Assert.assertEquals(20.0/6, mmp.calcula(3, serie),0.00001);
		Assert.assertEquals(26.0/6, mmp.calcula(4, serie),0.00001);
		Assert.assertEquals(32.0/6, mmp.calcula(5, serie),0.00001);
	}
	

}

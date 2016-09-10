package br.com.caelum.argentum.bean;

import java.util.List;

import br.com.caelum.argentum.grafico.GeradorModeloGrafico;
import br.com.caelum.argentum.modelo.Candle;
import br.com.caelum.argentum.modelo.CandleFactory;
import br.com.caelum.argentum.modelo.Negociacao;
import br.com.caelum.argentum.modelo.SerieTemporal;
import br.com.caelum.argentum.ws.ClienteWebService;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;

import org.primefaces.model.chart.ChartModel;
@ViewScoped
@ManagedBean
public class ArgentumBean {
	private List<Negociacao> negociacoes;
	private ChartModel modeloGrafico;
	
	public ChartModel getModeloGrafico() {
		return modeloGrafico;
	}

	public ArgentumBean(){
		this.negociacoes = new ClienteWebService().getNegociacoes();
		List<Candle> candles = new CandleFactory().constroiCandles(negociacoes);
		SerieTemporal serie = new SerieTemporal(candles);
		GeradorModeloGrafico geradorGrafico = new GeradorModeloGrafico(serie, 2, serie.getUltimaPosicao());
		geradorGrafico.plotaMediaMovelSimples();
		this.modeloGrafico = geradorGrafico.getModelGrafico();
	}
	
	public List<Negociacao> getNegociacoes(){
		return negociacoes;
	}

}

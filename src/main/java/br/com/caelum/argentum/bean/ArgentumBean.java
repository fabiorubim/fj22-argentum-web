package br.com.caelum.argentum.bean;

import java.util.List;

import br.com.caelum.argentum.modelo.Negociacao;
import br.com.caelum.argentum.ws.ClienteWebService;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
@ViewScoped
@ManagedBean
public class ArgentumBean {
	private List<Negociacao> negociacoes;
	
	public ArgentumBean(){
		negociacoes = new ClienteWebService().getNegociacoes();
	}
	
	public List<Negociacao> getNegociacoes(){
		return negociacoes;
	}

}

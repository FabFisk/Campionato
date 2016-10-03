package campionato;

import java.util.*;

public class Campionato {
	
	private String nome;
	Map<String, Squadra> partecipanti = new TreeMap<String, Squadra>();
	Map<String, Giocatore> calciatori = new TreeMap<String, Giocatore>();
	Map<String, Partita> giocate = new TreeMap<String, Partita>();
		
	public Campionato(){}
	public Campionato(String nome){
		this.nome = nome;
	}
		
	public String getNome() {
		return nome;
	}
	public void setNome(String nome) {
		this.nome = nome;
	}
	public void setPartecipanti(Map<String, Squadra> partecipanti) {
		this.partecipanti = partecipanti;
	}
	public Map<String, Squadra> getPartecipanti() {
		return partecipanti;
	}
	public Map<String, Giocatore> getCalciatori() {
		return calciatori;
	}
	public void setCalciatori(Map<String, Giocatore> calciatori) {
		this.calciatori = calciatori;
	}
	public Map<String, Partita> getGiocate() {
		return giocate;
	}
	public void setGiocate(Map<String, Partita> giocate) {
		this.giocate = giocate;
	}
//	public Map<String, Partita> getCalendario() {
//		return calendario;
//	}
//	public void setCalendario(Map<String, Partita> calendario) {
//		this.calendario = calendario;
//	}
	
}

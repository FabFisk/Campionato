package campionato;

import java.util.*;

public class Partita {
	
	private Date data;
	private Squadra casa, ospite;
	private int retiSqCasa, retiSqOspite;
	private char risultato;
	
	public Partita(){}
	public Partita(Squadra casa, Squadra ospite, Date data){
		this.casa = casa;
		this.ospite = ospite;
		this.data = data;
	}
	public Partita(Squadra casa, Squadra ospite, 
			int retiSqCasa, int retiSqOspite, Date data){
		this.casa = casa;
		this.ospite = ospite;
		this.data = data;
		this.retiSqCasa = retiSqCasa;
		this. retiSqOspite = retiSqOspite;		
	}
	
	public Date getData() {
		return data;
	}
	public void setData(Date data) {
		this.data = data;
	}
	public Squadra getCasa() {
		return casa;
	}
	public void setCasa(Squadra casa) {
		this.casa = casa;
	}
	public Squadra getOspite() {
		return ospite;
	}
	public void setOspite(Squadra ospite) {
		this.ospite = ospite;
	}
	public int getRetiSqCasa() {
		return retiSqCasa;
	}
	public void setRetiSqCasa(int retiSqCasa) {
		this.retiSqCasa = retiSqCasa;
	}
	public int getRetiSqOspite() {
		return retiSqOspite;
	}
	public void setRetiSqOspite(int retiSqOspite) {
		this.retiSqOspite = retiSqOspite;
	}
	public char getRisultato() {
		return risultato;
	}
	public void setRisultato(char risultato) {
		this.risultato = risultato;
	}
	
	

}

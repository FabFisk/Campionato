package campionato;

import java.util.*;

public class Squadra {
	
	private String nome;
	private int punti, retiFatte, retiSubite, diffReti;
	Set<Giocatore> rosa = new HashSet<Giocatore>();
	
	public Squadra(){}
	public Squadra(String nome){
		this.nome=nome;
		punti = 0;
		retiFatte = 0;
		retiSubite = 0;
		diffReti = retiFatte - retiSubite;
	}
	
	public String getNome() {
		return nome;
	}
	public void setNome(String nome) {
		this.nome = nome;
	}
	public int getPunti() {
		return punti;
	}
	public void setPunti(int punti) {
		this.punti = punti;
	}
	public int getRetiFatte() {
		return retiFatte;
	}
	public void setRetiFatte(int retiFatte) {
		this.retiFatte = retiFatte;
	}
	public int getRetiSubite() {
		return retiSubite;
	}
	public void setRetiSubite(int retiSubite) {
		this.retiSubite = retiSubite;
	}
	public int getDiffReti() {
		return diffReti;
	}
	public void setDiffReti(int diffReti) {
		this.diffReti = diffReti;
	}
	public Set<Giocatore> getRosa() {
		return rosa;
	}
	public void setRosa(Set<Giocatore> rosa) {
		this.rosa = rosa;
	}
	
	

}

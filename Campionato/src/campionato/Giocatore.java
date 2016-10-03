package campionato;

public class Giocatore {
	
	private String nome, cognome, ruolo, codFisc;
	private int eta, ammonizioni, espulsioni, reti, assist;
	private double stipendio;
	
	public Giocatore(){}
	public Giocatore(String nome, String cognome, String ruolo, String codFisc,
			int eta) {
		super();
		this.nome = nome;
		this.cognome = cognome;
		this.ruolo = ruolo;
		this.codFisc = codFisc;
		this.eta = eta;
		ammonizioni = 0;
		espulsioni = 0;
		reti = 0;
		assist = 0;
		stipendio = 0;
	}
	
	public String getNome() {
		return nome;
	}
	public void setNome(String nome) {
		this.nome = nome;
	}
	public String getCognome() {
		return cognome;
	}
	public void setCognome(String cognome) {
		this.cognome = cognome;
	}
	public String getRuolo() {
		return ruolo;
	}
	public void setRuolo(String ruolo) {
		this.ruolo = ruolo;
	}
	public String getCodFisc() {
		return codFisc;
	}
	public void setCodFisc(String codFisc) {
		this.codFisc = codFisc;
	}
	public int getEta() {
		return eta;
	}
	public void setEta(int eta) {
		this.eta = eta;
	}
	public int getAmmonizioni() {
		return ammonizioni;
	}
	public void setAmmonizioni(int ammonizioni) {
		this.ammonizioni = ammonizioni;
	}
	public int getEspulsioni() {
		return espulsioni;
	}
	public void setEspulsioni(int espulsioni) {
		this.espulsioni = espulsioni;
	}
	public int getReti() {
		return reti;
	}
	public void setReti(int reti) {
		this.reti = reti;
	}
	public int getAssist() {
		return assist;
	}
	public void setAssist(int assist) {
		this.assist = assist;
	}
	public double getStipendio() {
		return stipendio;
	}
	public void setStipendio(double stipendio) {
		this.stipendio = stipendio;
	}
	
	
	
	

}

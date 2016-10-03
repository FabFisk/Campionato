package campionato;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.*;

public class ServizioCampionato {
	
	public Giocatore registraGiocatore(Campionato c, String nome, String cognome, 
			String ruolo, String codFisc, int eta){
		Giocatore g = null;
		if(!esisteGiocatore(c, codFisc)){
			g = new Giocatore(nome, cognome, ruolo, codFisc, eta);
			c.getCalciatori().put(codFisc, g);
		}else{
			g = cercaGiocatore(c, codFisc);
		}		
		return g;
	}
	
	public Squadra registraSquadra(Campionato c, String nome){
		Squadra s = null;
		if(!esisteSquadra(c, nome)){
			s = new Squadra(nome);
			c.getPartecipanti().put(nome, s);
		}else{
			s = cercaSquadra(c, nome);
		}		
		return s;
	}
	
	public boolean assegnaGiocatoreSquadra (Campionato c, Giocatore g, Squadra s){
		boolean token = false;
		if(esisteSquadra(c, s)
				&& esisteGiocatore(c, g)){
			s.getRosa().add(g);
			token  = true;
		}		
		return token;
	}
	
	public Partita registraPartita(Campionato c, Squadra casa, Squadra ospite, 
			int retiCasa, int retiOspite, String data, List<Giocatore> marcatori, 
			List<Giocatore> ammoniti, List<Giocatore> espulsi) throws ParseException{
		Date d = stringToDate(data);
		Partita p = new Partita(casa, ospite, retiCasa, retiOspite, d);
		c.getGiocate().put(casa+"-"+ospite, p);
		aggiornaDatiSquadra(casa, ospite, retiCasa, retiOspite, p);
		aggiornaDatiGiocatore(marcatori, ammoniti, espulsi);
		return p;
	}

	public Giocatore getCapocannoniere(Campionato c){
		Giocatore capocannoniere = null;
		List<Giocatore> giocatori = new ArrayList<Giocatore>();
		giocatori.addAll(c.calciatori.values());
		Collections.sort(giocatori, new GiocatoreComparator());
		capocannoniere = giocatori.get(0);	
		return capocannoniere;
	}
	
	public Squadra getCampione (Campionato c){
		Squadra campione = null;
		List<Squadra> squadre = new ArrayList<Squadra>();
		squadre.addAll(c.partecipanti.values());
		Collections.sort(squadre, new SquadraComparator(c));
		campione = squadre.get(0);		
		return campione;
	}

	public Partita partitaDaGiocare(Campionato c, Squadra casa, Squadra ospite, String data) 
			throws ParseException{
		Date d = stringToDate(data);
		Partita p = new Partita(casa, ospite, d);
		return p;
	}
	
	
	
	
//	public Giocatore getCapocannoniere(Campionato c){
//		Giocatore gio = null;
//		List<Giocatore> temp = new ArrayList<Giocatore>(c.calciatori.values());
//		int var1 = 0;
//		List<Giocatore> temp2 = new ArrayList<Giocatore>(c.calciatori.values());
//		int var2 = 0;
//		for (Map.Entry<String, Giocatore> giocatore : c.calciatori.entrySet()) {
//			if (giocatore.getValue().getReti()>=var1) {
//				if(giocatore.getValue().getReti()== var1){
//					temp.add(giocatore.getValue());					
//				}else{
//					var1 = giocatore.getValue().getReti();
//					temp.clear();
//					temp.add(giocatore.getValue());
//				}							
//			}
//		}
//		if(temp.size()==1){
//			gio = temp.get(0);
//		}
//		else{
//			for (Giocatore g : temp) {
//					if(g.getEspulsioni()>var2){
//						var2=g.getEspulsioni();
//					}
//			}
//			for (Giocatore g : temp) {
//				if (g.getEspulsioni()<=var2) {
//					if(g.getEspulsioni()== var2){
//						temp2.add(g);					
//					}else{
//						var2 = g.getEspulsioni();
//						temp2.clear();
//						temp2.add(g);
//					}							
//				}
//			}
//			var1 = 0;
//			temp.clear();
//			if(temp2.size()==1){
//				gio = temp2.get(0);
//			}
//			else{
//				for (Giocatore g : temp2) {
//						if(g.getAmmonizioni()>var1){
//							var1=g.getAmmonizioni();
//						}
//				}
//				for (Giocatore g : temp) {
//					if (g.getAmmonizioni()<=var1) {
//						if(g.getAmmonizioni()== var1){
//							temp.add(g);					
//						}else{
//							var1 = g.getAmmonizioni();
//							temp.clear();
//							temp.add(g);
//						}							
//					}
//				}
//				gio = temp.get(0);
//			}
//		}
//		return gio;
//	}
	
	//Metodi ausiliari
	
	private void aggiornaDatiGiocatore(List<Giocatore> marcatori,
			List<Giocatore> ammoniti, List<Giocatore> espulsi) {
		for(Giocatore g : marcatori){
			g.setReti(g.getReti()+1);
		}
		for(Giocatore g : ammoniti){
			g.setAmmonizioni(g.getAmmonizioni()+1);
		}
		for(Giocatore g : espulsi){
			g.setEspulsioni(g.getEspulsioni()+1);
		}
	}

	private void aggiornaDatiSquadra(Squadra casa, Squadra ospite,
			int retiCasa, int retiOspite, Partita p) {
		aggiornaGolSquadra(casa, ospite, retiCasa, retiOspite);
		aggiornaPunti(casa, ospite, retiCasa, retiOspite, p);
	}

	private void aggiornaPunti(Squadra casa, Squadra ospite, int retiCasa,
			int retiOspite, Partita p) {
		if(retiCasa>retiOspite){
			p.setRisultato('1');
			casa.setPunti(casa.getPunti()+3);			
		}else if(retiCasa==retiOspite){
			p.setRisultato('X');	
			casa.setPunti(casa.getPunti()+1);
			ospite.setPunti(ospite.getPunti()+1);			
		}else{
			p.setRisultato('2');	
			ospite.setPunti(ospite.getPunti()+3);			
		}
	}

	private void aggiornaGolSquadra(Squadra casa, Squadra ospite, int retiCasa,
			int retiOspite) {
		casa.setRetiFatte(casa.getRetiFatte()+retiCasa);
		casa.setRetiSubite(casa.getRetiSubite()+retiOspite);
		ospite.setRetiFatte(ospite.getRetiFatte()+retiOspite);
		ospite.setRetiSubite(ospite.getRetiSubite()+retiCasa);
		casa.setDiffReti(casa.getRetiFatte()-casa.getRetiSubite());
		ospite.setDiffReti(ospite.getRetiFatte()-ospite.getRetiSubite());
	}
	
	private Date stringToDate(String data) throws ParseException {
		Date date = null;
		SimpleDateFormat sdf = new SimpleDateFormat("dd-M-yyyy");
		date = sdf.parse(data);
		return date;
	}

	private Squadra cercaSquadra(Campionato c, String n) {
		Squadra squa = null;
		if (c.partecipanti.containsKey(n)) {
			squa = c.partecipanti.get(n);
		}	
		return squa;
	}
	private boolean esisteSquadra(Campionato c, String n) {
		boolean token = false;
		if (c.partecipanti.containsKey(n)) {
			token = true;
		}		
		return token;
	}
	private boolean esisteSquadra(Campionato c, Squadra s) {
		boolean token = false;
		if (c.partecipanti.containsValue(s)) {
			token = true;
		}	
		return token;
	}
	
	private Giocatore cercaGiocatore(Campionato c, String codFisc) {
		Giocatore gio = null;		
			if (c.calciatori.containsKey(codFisc)) {
				gio = c.calciatori.get(codFisc);
			}		
		return gio;
	}
	private boolean esisteGiocatore(Campionato c, String codFisc) {
		boolean token = false;
		if (c.calciatori.containsKey(codFisc)) {
			token = true;
		}		
		return token;
	}
	private boolean esisteGiocatore(Campionato c, Giocatore g) {
		boolean token = false;
		if (c.calciatori.containsValue(g)) {
			token = true;
		}	
		return token;
	}

}

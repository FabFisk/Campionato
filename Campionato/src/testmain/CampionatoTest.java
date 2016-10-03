package testmain;
import campionato.*;

import java.text.ParseException;
import java.util.*;

public class CampionatoTest {

	public static void main(String[] args) throws ParseException {
		
		Campionato c = new Campionato("Serie A");
		ServizioCampionato s = new ServizioCampionato();
		
		//liste per registrare partite
		List<Giocatore> marcatori = new ArrayList<Giocatore>();
		List<Giocatore> espulsi = new ArrayList<Giocatore>();
		List<Giocatore> ammoniti = new ArrayList<Giocatore>();
		
		List<Giocatore> marcatori1 = new ArrayList<Giocatore>();
		List<Giocatore> espulsi1 = new ArrayList<Giocatore>();
		List<Giocatore> ammoniti1 = new ArrayList<Giocatore>();
		
		//registrazione giocatori
		Giocatore g1 = s.registraGiocatore(c, "A", "A", "Att", "1", 28);
		Giocatore g2 = s.registraGiocatore(c, "B", "B", "Att", "2", 28);
		Giocatore g3 = s.registraGiocatore(c, "C", "C", "Att", "3", 28);
		Giocatore g4 = s.registraGiocatore(c, "D", "D", "Att", "4", 28);
		Giocatore g5 = s.registraGiocatore(c, "E", "E", "Cent", "5", 28);
		Giocatore g6 = s.registraGiocatore(c, "F", "F", "Cent", "6", 28);
		Giocatore g7 = s.registraGiocatore(c, "G", "G", "Cent", "7", 28);
		Giocatore g8 = s.registraGiocatore(c, "H", "H", "Cent", "8", 28);
		Giocatore g9 = s.registraGiocatore(c, "I", "I", "Dif", "9", 28);
		Giocatore g10 = s.registraGiocatore(c, "L", "L", "Dif", "10", 28);
		Giocatore g11 = s.registraGiocatore(c, "M", "M", "Dif", "11", 28);
		Giocatore g12 = s.registraGiocatore(c, "N", "N", "Dif", "12", 28);
		Giocatore g13 = s.registraGiocatore(c, "O", "O", "Dif", "13", 28);
		Giocatore g14 = s.registraGiocatore(c, "P", "P", "Dif", "14", 28);
		Giocatore g15 = s.registraGiocatore(c, "Q", "Q", "Dif", "15", 28);
		Giocatore g16 = s.registraGiocatore(c, "R", "R", "Dif", "16", 28);
		
		//verifica
		for(Map.Entry<String, Giocatore> m : c.getCalciatori().entrySet()){
			System.out.println(m.getKey()+"\t"+m.getValue().getNome()
					+"\t"+m.getValue().getReti()+"\t"+m.getValue().getAmmonizioni()
					+"\t"+m.getValue().getEspulsioni());
			
		}	
		
		System.out.println();
		
		//registrazione squadre
		Squadra s1 = s.registraSquadra(c, "Juve");
		Squadra s2 = s.registraSquadra(c, "Milan");
		Squadra s3 = s.registraSquadra(c, "Inter");
		Squadra s4 = s.registraSquadra(c, "Torino");
		
		//verifica
		for(Map.Entry<String, Squadra> S : c.getPartecipanti().entrySet()){
			System.out.println(S.getValue().getNome());
		}
		System.out.println();
		
		//assegnazione giocatori
		System.out.println(s.assegnaGiocatoreSquadra(c, g1, s1));
		System.out.println(s.assegnaGiocatoreSquadra(c, g2, s2));
		System.out.println(s.assegnaGiocatoreSquadra(c, g3, s1));
		System.out.println(s.assegnaGiocatoreSquadra(c, g4, s2));
		System.out.println(s.assegnaGiocatoreSquadra(c, g5, s1));
		System.out.println(s.assegnaGiocatoreSquadra(c, g6, s2));
		System.out.println(s.assegnaGiocatoreSquadra(c, g7, s1));
		System.out.println(s.assegnaGiocatoreSquadra(c, g8, s2));
		System.out.println(s.assegnaGiocatoreSquadra(c, g9, s1));
		System.out.println(s.assegnaGiocatoreSquadra(c, g10, s2));
		System.out.println(s.assegnaGiocatoreSquadra(c, g11, s1));
		System.out.println(s.assegnaGiocatoreSquadra(c, g12, s2));
		System.out.println(s.assegnaGiocatoreSquadra(c, g13, s1));
		System.out.println(s.assegnaGiocatoreSquadra(c, g14, s2));
		System.out.println(s.assegnaGiocatoreSquadra(c, g15, s1));
		System.out.println(s.assegnaGiocatoreSquadra(c, g16, s2));	
		
		//verifica
		for(Giocatore g: s1.getRosa()){
			System.out.println(g.getNome());
		}
		System.out.println();
		
		for(Giocatore g: s2.getRosa()){
			System.out.println(g.getNome());
		}
		System.out.println();
		
		//riempimento liste per partite
		marcatori.add(g1);
		marcatori.add(g1);
		marcatori.add(g1);
		marcatori.add(g1);
		marcatori.add(g2);
		
		ammoniti.add(g5);
		ammoniti.add(g6);
		
		espulsi.add(g10);
		
		marcatori1.add(g1);
		
		//registrazione partite
		s.registraPartita(c, s1, s2, 4, 1, "27-09-2016", marcatori, ammoniti, espulsi);
		s.registraPartita(c, s2, s1, 0, 1, "29-05-2017", marcatori1, ammoniti1, espulsi1);
		
		//verifica aggiornamento dati giocatori
		for(Map.Entry<String, Giocatore> m : c.getCalciatori().entrySet()){
			System.out.println(m.getKey()+"\t"+m.getValue().getNome()
					+"\t"+m.getValue().getReti()+"\t"+m.getValue().getAmmonizioni()
					+"\t"+m.getValue().getEspulsioni());
			
		}	
		System.out.println();
		
		//verifica aggiornamento dati squadre
		for(Map.Entry<String, Squadra> S : c.getPartecipanti().entrySet()){
			System.out.println(S.getValue().getNome()+"\t"+S.getValue().getPunti()
					+"\t"+S.getValue().getRetiFatte()+"\t"+S.getValue().getRetiSubite()
					+"\t"+S.getValue().getDiffReti());
		}
		System.out.println();
		
		//determinazione capocannoniere e squadra vincitrice
		Squadra S = s.getCampione(c);
		Giocatore G = s.getCapocannoniere(c);
		
		//verifica
		System.out.println(G.getNome()+" "+G.getCognome());
		System.out.println(S.getNome());
		
		System.out.println();		
	}

}

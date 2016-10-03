package campionato;

import java.util.Comparator;

public class SquadraComparator implements Comparator<Squadra> {
  
	Campionato c;
	
	public SquadraComparator(Campionato c) {
		this.c = c;
	}

	@Override
	public int compare(Squadra o1, Squadra o2) {
		int var = o2.getPunti()-o1.getPunti();
		if(var == 0){
			int var2 = o2.getDiffReti()-o1.getDiffReti();	
			if(var2==0){
				int var3 = scontriDiretti(o1, o2);
				return var3;
			}else{
				return var2;
			}
		}
		return var;
	}

	private int scontriDiretti(Squadra o1, Squadra o2) {
		int p1 = 0;
		int p2 = 0;
		if(c.giocate.containsKey(o1+"-"+o2)
				&& c.giocate.containsKey(o2+"-"+o1)){
			Partita pAndata = c.giocate.get(o1+"-"+o2);
			if(pAndata.getRisultato()=='1'){
				p1 += 3;	
			}else if(pAndata.getRisultato()=='2'){
				p2 += 3;
			}else{
				p1 += 1;
				p2 += 1;
			}
			Partita pRitorno = c.giocate.get(o2+"-"+o1);
			if(pRitorno.getRisultato()=='1'){
				p2 += 3;	
			}else if(pRitorno.getRisultato()=='2'){
				p1 += 3;
			}else{
				p1 += 1;
				p2 += 1;
			}
		}
		int var3 = p2-p1;
		return var3;
	}



}

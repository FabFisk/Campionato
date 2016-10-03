package campionato;

import java.util.Comparator;

public class GiocatoreComparator implements Comparator<Giocatore> {

	@Override
	public int compare(Giocatore o1, Giocatore o2) {
		int var = o2.getReti()-o1.getReti();
		if(var == 0){
			int var2 = o1.getEspulsioni()-o2.getEspulsioni();	
			if(var2==0){
				int var3 = o1.getAmmonizioni()-o2.getAmmonizioni();	
				return var3;				
			}else{
				return var2;
			}
		}
		return var;
	}

}

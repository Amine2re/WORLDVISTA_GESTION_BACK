
package com.worldvistaGestion.services.sup;

import java.time.LocalDate;
import java.time.LocalTime;

import org.springframework.stereotype.Service;

@Service
public class serviceHoraire {
	
public LocalDate today(){
	return  LocalDate.now();
}

public LocalTime heureActuelle() {
	return LocalTime.now();
}

//public static void main(String args[])  {
//	serviceHoraire sh = new serviceHoraire();
//	LocalDate ld = LocalDate.parse(sh.today().toString());
////	long minutes = ChronoUnit.MINUTES.between(sh.heureActuelle(), sh.heureActuelle());
//System.out.println(ld);
//}

}

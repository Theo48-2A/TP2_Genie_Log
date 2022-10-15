import java.text.NumberFormat;
import java.util.*;

public class StatementPrinter {

  public String print(Invoice invoice, Map<String, Play> plays) {
  
    float totalAmount = 0;  // Somme totale du
    int volumeCredits = 0;  // Points de fidélité gagnés
    String tampon = String.format("Statement for %s\n", invoice.customer);  // Un tampon qui va servir à insérer dans le StringBuffer
    StringBuffer result = new StringBuffer(tampon);	//Notre StringBuffer qui a remplacé le String de départ 
   
    NumberFormat frmt = NumberFormat.getCurrencyInstance(Locale.US);

    for (Performance perf : invoice.performances) {	// On parcourt toutes les performances d'un client
      Play play = plays.get(perf.playID);    //On récupère le play correspondant dans le HashMap grace à la clé
      float thisAmount = 0;	// La somme du pour la performance en cours ( dans le for)

      switch (play.type) {	// On effectue un traitement spécifique celon le type de pièce
        case "tragedy":		// Si la pièce est une tragedy
          thisAmount = 400;	// Le cout de la piece est mis à 400
          if (perf.audience > 30) { 	// Si l'audience de la perf a dépassée 30
            thisAmount += 10 * (perf.audience - 30);    // Le cout de la pièce augmente
          }
          break;
        case "comedy":		// Si la pièce est une comedy
          thisAmount = 300;     // Le cout de la piece est mis à 300
          if (perf.audience > 20) {   // Si l'audience de la perf a dépassée 20
            thisAmount += 100 + 5 * (perf.audience - 20);     // Le cout de la pièce augmente
          }
          thisAmount += 3 * perf.audience;	// Le cout de la pièce augmente encore
          break;
          
        // On a retiré default car il n'a plus d'utilité, comme on vérifie le type depuis Play
      }

      // add volume credits
      volumeCredits += Math.max(perf.audience - 30, 0);
      
      // add extra credit for every ten comedy attendees
      if ("comedy".equals(play.type)) volumeCredits += Math.floor(perf.audience / 5);

      // print line for this order
      

      tampon = String.format("  %s: %s (%s seats)\n", play.name, frmt.format(thisAmount), perf.audience);
      result.append(tampon);
      
      totalAmount += thisAmount;
    }
    
    tampon = String.format("Amount owed is %s\n", frmt.format(totalAmount));
    result.append(tampon);


    

    tampon = String.format("You earned %s credits\n", volumeCredits);
    result.append(tampon);
    
    return result.substring(0);
  }

}

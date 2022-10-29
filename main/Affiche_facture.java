import java.util.*;
import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.util.Objects;

public class Affiche_facture{

   
 private String contenu_Facture;     //Le contenu de la facture
   private String nom_client;  		// Nom du client
   private String[][] tableau_pieces_infos;    //Le tableau qui contient chaque pièce avec ses informations [[nom][nb_spectateurs][cout]]
   private String[] tableau_fin_info;         //Le tableau qui contient le cout total ainsi que les points de fidelité gagnés

   public Affiche_facture(String contenu_Facture, String nom_client, String[][] tableau_pieces_infos, String[] tableau_fin_info){
      this.contenu_Facture = Objects.requireNonNull(contenu_Facture);
      this.nom_client = Objects.requireNonNull(nom_client);
      this.tableau_pieces_infos = Objects.requireNonNull(tableau_pieces_infos);
      this.tableau_fin_info = Objects.requireNonNull(tableau_fin_info);

   }


//Obtenir le Contenu de la facture
   public String getContenu_facture(){
      return this.contenu_Facture;
   }
   
   //Obtenir le nom du client
   public String getNomclient(){
      return this.nom_client;
   }
   
   //Obtenir le tableau qui contient les informations des pièces de théâtre
   public String[][] getTableau_pieces_infos(){
      return this.tableau_pieces_infos;
   }

   //Obtenir le tableau qui contient la somme dû par le client ainsi que les points de fidélité qu'il a gagné
   public String[] getTableau_fin_info(){
      return this.tableau_fin_info;
   }
   
   public boolean toText(){
   
     //chemin vers les fichiers txt générés : "../../../fichiers_html_text_generes/Text/CeFichierDeBoss.txt"

     PrintWriter Facture_text = null;
      String Facture = this.getContenu_facture();
        
      try {
         Facture_text = new PrintWriter("fichiers_html_text_generes/Text/" + this.getNomclient() + "_Facture_text.txt");
      } 
      catch (FileNotFoundException e) {
         System.out.println("Erreur lors de la création du fichier: " + e.getMessage());

      }
      Objects.requireNonNull(Facture_text).println(Facture);
      Facture_text.close();
        
      return true;  
   }


   public String toHTML(){
   
   //chemin vers les fichiers html générés : "../../../fichiers_html_text_generes/HTML/CeFichierDeBoss.txt"
     
     
      PrintWriter Facture_HTML = null;
      String Facture = Transform_text_en_html();    //Transformation de la facture text en html
        
      try {
         Facture_HTML = new PrintWriter("fichiers_html_text_generes/HTML/" + this.getNomclient() + "_Facture_HTML.html");
      } 
      catch (FileNotFoundException e) {
         System.out.println("Erreur lors de la création du fichier: " + e.getMessage());

      }
      Objects.requireNonNull(Facture_HTML).println(Facture);
      Facture_HTML.close();
        
      return Facture;   
   }
   
   public String toHTML(){
   
   //chemin vers les fichiers html générés : "../../../fichiers_html_text_generes/HTML/CeFichierDeBoss.txt"
     
     
      PrintWriter Facture_HTML = null;
      String Facture = Transform_text_en_html();    //Transformation de la facture text en html
        
      try {
         Facture_HTML = new PrintWriter("fichiers_html_text_generes/HTML/" + this.getNomclient() + "_Facture_HTML.html");
      } 
      catch (FileNotFoundException e) {
         System.out.println("Erreur lors de la création du fichier: " + e.getMessage());

      }
      Objects.requireNonNull(Facture_HTML).println(Facture);
      Facture_HTML.close();
        
      return Facture;   
   }




   public String Transform_text_en_html(){
   
   //On va insérer petit à petit le code html dans un StringBuffer

      //Balise doctype html
      String tampon = "<!doctype html>\n";  
      StringBuffer html = new StringBuffer(tampon); 
      
      //debut balise html
      tampon = "<html lang=\"fr\">\n";  
      html.append(tampon);
      
      //debut balise head
      tampon = "<head>\n"; 
      html.append(tampon);
      
      //Balise meta charset
      tampon = "  <meta charset=\"utf-8\">\n"; 
      html.append(tampon);
      
      //Balise titre
      tampon = "  <title>Facture</title>\n";  
      html.append(tampon);
      
      
   }


}

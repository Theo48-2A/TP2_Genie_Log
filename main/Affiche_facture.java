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





}

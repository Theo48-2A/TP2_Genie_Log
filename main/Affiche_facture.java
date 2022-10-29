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








}

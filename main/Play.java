public class Play {
  // Les variables static (finales aussi) qui correspondent au type de pièce qu'il est possible d'avoir  
  public static final String comedy = "comedy";
  public static final String tragedy = "tragedy";
  //-----------------------------------------------------------------------------------------------

  public String name;
  public String type;

  public Play(String name, String type) {
    this.name = name;
    this.type = type;
  }
  
  public boolean TestType(String type){  //Fonction qui regarde si le type saisi est correct
     if(type.equals(comedy)){
        return true;
     }
     else if(type.equals(tragedy)){
        return true;
     }
 
     return false;
  }
}

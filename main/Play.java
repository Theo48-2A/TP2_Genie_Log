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
}

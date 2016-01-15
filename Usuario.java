import java.util.ArrayList;

public class Usuario
{
    //nombre del usuario
    private String nombreCompleto;
    //proteinas  ingeridas por el usuario
    private float proteinasIngeridas;
    //carbohidratos ingeridos por el usuario
    private float carbohidratosIngeridos;
    //grasas ingeridas por el usuario
    private float grasasIngeridas;
    //calorias totales ingeridas por el usuario
    private float caloriasIngeridas;
    //guarda el nombre del alimento mas calorico
    private Alimento alimentoMasCalorico;
    //guarda las calorias del alimeto mas calorico
    private float calAlimentoCalorico;
    // Una Arraylist para guardar el orden de comida de alimentos de los alimentos
    private ArrayList<Alimento> alimento;

    /**
    *Constructor de la clase usuario
    */
    public Usuario (String nombreCompleto)
    {
        this.nombreCompleto = nombreCompleto;   
        proteinasIngeridas = 0;
        carbohidratosIngeridos = 0;
        grasasIngeridas = 0;
        caloriasIngeridas = 0;
        alimento = new ArrayList<Alimento>();
    }
    
    /**
    * Metodo utilizado para dar de comer al usuario
    */
    public void comer(Alimento alimentoQueCome, float gramosDelAlimento)
    {
        proteinasIngeridas = proteinasIngeridas + (alimentoQueCome.getProteinas() / 100 * gramosDelAlimento);
        carbohidratosIngeridos = carbohidratosIngeridos + (alimentoQueCome.getCarbohidratos() / 100 * gramosDelAlimento);
        grasasIngeridas = grasasIngeridas + (alimentoQueCome.getGrasas() / 100 * gramosDelAlimento);
        caloriasIngeridas = caloriasIngeridas + (alimentoQueCome.getCalorias() / 100 * gramosDelAlimento);
        
        if (alimentoMasCalorico == null){
            alimentoMasCalorico = alimentoQueCome;
        }
        else{
            calAlimentoCalorico = alimentoMasCalorico.getCalorias();
            if (calAlimentoCalorico == caloriasIngeridas){
                alimentoMasCalorico = alimentoQueCome;
            }
            else if (calAlimentoCalorico < caloriasIngeridas){
                alimentoMasCalorico = alimentoQueCome;
            }
        }
        alimento.add(alimentoQueCome);
    }
    
    /**
    * Metodo que muestra la informacion de lo ingerido por el usuario.
    */
    public void muestraDatos()
    {
        float totalNutrientes = (proteinasIngeridas + grasasIngeridas + carbohidratosIngeridos) / 100;
        String datosProteinas = "Gramos totales de proteinas ingeridos:     " + proteinasIngeridas;
        String datosCarbohidratos = "Gramos totales de carbohidratos ingeridos: " +             carbohidratosIngeridos;
        String datosGrasas = "Gramos totales de grasas ingeridos:        " + grasasIngeridas;
        if (proteinasIngeridas > 0) {
            datosProteinas = datosProteinas + " (" + proteinasIngeridas / totalNutrientes + "%)";
        }
        if (carbohidratosIngeridos > 0) {
            datosCarbohidratos = datosCarbohidratos + " (" + carbohidratosIngeridos / totalNutrientes + "%      )";
        }
        if (grasasIngeridas > 0) {
            datosGrasas = datosGrasas + " (" + grasasIngeridas / totalNutrientes + "%)";
        }
        System.out.println("Nombre:                                    " + nombreCompleto);
        System.out.println(datosProteinas);    
        System.out.println(datosCarbohidratos);
        System.out.println(datosGrasas);
        System.out.println("Calorias totales ingeridas:                " + caloriasIngeridas);  
    }

    /**
     * Method that gets the name of the food
     */
    public String getNombre()
    {
        return nombreCompleto;
    }
     
    /**
     * Method that gets the calories of the food
     */
    public float getCalorias()
    {
        return caloriasIngeridas;
    }
    
    /**
     * Method wich compares the ingested calories between two users
     */
    public void compararCaloriasEntreDosUsuarios(Usuario usuario1)
    {
        String nombreSegundoUsuario = usuario1.getNombre();
        float caloriasSegundoUsuario = usuario1.getCalorias();
        
        if (caloriasIngeridas == caloriasSegundoUsuario){
            System.out.println(nombreCompleto + " y " + nombreSegundoUsuario + " han consumido las mismas calorias." + " ( " + caloriasIngeridas + " ).");
        }
        
        if (caloriasIngeridas > caloriasSegundoUsuario){
            System.out.println(nombreCompleto + " ha consumido más calorias que " + nombreSegundoUsuario + "." + 
            " (" + caloriasIngeridas + " frente a " + caloriasSegundoUsuario + ")");
        }
        
        if(caloriasSegundoUsuario > caloriasIngeridas){
            System.out.println(nombreSegundoUsuario + " ha consumido más calorias que " + nombreCompleto + "." + 
            " (" + caloriasSegundoUsuario + " frente a " + caloriasIngeridas + ")");
        }
    }
    
    /**
     * Method that show the food with the most calories
     */
    public void alimentoMasCalorico()
    {
        if (alimentoMasCalorico != null){
            System.out.println("Alimento más calórico ingerido por este usuario hasta el momento es el/la " + alimentoMasCalorico.getNombre() + " ( " + alimentoMasCalorico.getCalorias() + " calorias.)");
        }
        else{
            System.out.println("No se han consumido alimentos hasta el momento");
        }
    }
    
    /**
     * Metodo que muestra los datos nutricionales del alimento consumido en una posicion determinada
     */
    public void datosNutricionalesAlimento(int numeroDeAlimentos)
    {
        if (numeroDeAlimentos < alimento.size()){
            alimentoQueCome.muestraDatos();
        }
    }
}






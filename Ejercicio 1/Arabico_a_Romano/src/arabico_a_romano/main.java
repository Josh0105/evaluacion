package arabico_a_romano;

/**
 *
 * @author Jonathan Calo
 */
public class main {

    public static void main(String[] args) {
        
        int[] valores_de_prueba = {1,24,57,60,85,154,299,341,387,425,633,823,1024,2048,4096};
        try{
            for(int valor : valores_de_prueba){
                conversor nuevoConversor = new conversor(valor);
                System.out.print("Valor ingresado: " + valor + " Resultado: ");  
                System.out.print(nuevoConversor.getConversion() + "\n");                
            }
        }catch(Exception e){
            System.out.print("Error en datos");
        }
    }
    
}

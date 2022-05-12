package arabico_a_romano;

/**
 *
 * @author Jonathan Calo
 */
public class conversor {
    
    private final String[] romanos = {"M","CM","D","CD","C","XC","L","XL","X","IX","V","IV","I"};
    private final int[] valores = {1000,900,500,400,100,90,50,40,10,9,5,4,1};
    
    private String resultado;
    private int valor;

    public conversor( int Valor) {
        //ASIGNAMOS LOS VALORES INICIALES
        this.resultado = "";
        this.valor = Valor;
    }

    public String getConversion() {
        
        //se agregaron las siguientes validaciones en caso de tener numeros fuera del rango admitido por la tabla
        if(this.valor<=0){
            return "Valor No definido";
        }
        if(this.valor>=5000){
            return "Fuera de rango admitido";
        }
        //INICIO DEL ALGORITMO PROPUESTO
        int i =1;
        while(i<=this.romanos.length){
            if(this.valor>=this.valores[i-1]){
                this.resultado += this.romanos[i-1];
                this.valor -= this.valores[i-1];
            }else{
                i++;
            }          
        }
        return resultado;
    }
}

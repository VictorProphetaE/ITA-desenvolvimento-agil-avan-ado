
import java.util.ArrayList;
import java.util.List;

public class Oraculo {
    
    public List<String> melhoresProdutos(String tipo){
        List<String> lista = new ArrayList<>();
        if(tipo.equals("doce de leite")){
            lista.add("Viçosa");
            lista.add("Boreal");
        }else if(tipo.equals("queijo mineiro")){
            lista.add("Candido Tostes");
            lista.add("Humaita");
        }
               
        return lista;
    }
    
}

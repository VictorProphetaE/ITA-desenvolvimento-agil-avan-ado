import java.util.ArrayList;
import java.util.List;

public class Principal {
	
	public static void main(String[] args) {
		List<produto> lista = new ArrayList<>();
		lista.add(new produto("Tenis",300));
		lista.add(new produto("Camiseta",80));
		lista.add(new produto("Cinto",50));

		Carrinho c = new Carrinho(lista);

		c.darDesconto(20,produto:: caro);
		
		//c.darDesconto(20,p -> p.getNome().contains("a"));

		//c.darDesconto(20,p -> p.getValor()<100);
		
		c.getLista().forEach(System.out::println);
		
		
		
	}
	
}

import java.util.List;

public class Carrinho {

	private List<produto> lista;

	public Carrinho(List<produto> lista) {
		this.lista = lista;
	}
	
	public void darDesconto(int porcentagem, Condicao<produto> cond) {
		for(produto p : lista) {
			if(cond.incluir(p)) {
				p.setValor(p.getValor()*(100-porcentagem)/100);
			}
		}
	}

	public List<produto> getLista() {
		return lista;
	}
	
	
}

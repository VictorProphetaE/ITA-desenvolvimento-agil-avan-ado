
public class Diferenca {

	private String propriedade;
	private Object valornovo;
	private Object valorvelho;
	public Diferenca(String propriedade, Object valornovo, Object valorvelho) {
		super();
		this.propriedade = propriedade;
		this.valornovo = valornovo;
		this.valorvelho = valorvelho;
	}
	@Override
	public String toString() {
		return "Diferenca [propriedade=" + propriedade + ", valornovo=" + valornovo + ", valorvelho=" + valorvelho
				+ "]";
	}
	
	
}

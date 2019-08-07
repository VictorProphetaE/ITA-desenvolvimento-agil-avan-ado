
public class Pessoa {

	private String nome;
	private String sobrenome;
	private int idade;
	private String profissao;
	public Pessoa(String nome, String sobrenome, int idade, String profissao) {
		super();
		this.nome = nome;
		this.sobrenome = sobrenome;
		this.idade = idade;
		this.profissao = profissao;
	}
	public String getNome() {
		return nome;
	}
	public void setNome(String nome) {
		this.nome = nome;
	}
	public String getSobrenome() {
		return sobrenome;
	}
	public void setSobrenome(String sobrenome) {
		this.sobrenome = sobrenome;
	}
	@IgnorarNaComparacao
	public int getIdade() {
		return idade;
	}
	public void setIdade(int idade) {
		this.idade = idade;
	}
	public String getProfissao() {
		return profissao;
	}
	public void setProfissao(String profissao) {
		this.profissao = profissao;
	}
	
	
}

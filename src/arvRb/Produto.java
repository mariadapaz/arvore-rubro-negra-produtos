package arvRb;

public class Produto {
	private String descricao;
	private double valor;
	
	public Produto(String descricao, double valor) {
		this.descricao = descricao;
		this.valor = valor;
	}
	
	public String getDescricao() {
		return descricao;
	}
	
	public double getValor() {
		return valor;
	}
	
	@Override
	public String toString() {
		return String.format("%s: R$%.2f", descricao, valor);
	}
}

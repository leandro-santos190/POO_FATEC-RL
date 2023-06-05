import java.util.GregorianCalendar;

public abstract class Assinante {
	private long cpf; // CPF do assinante
	private String nome; // nome completo do assinante
	private int numero; //  numero do telefone celular do assinante
	protected Chamada[] chamadas; // vetor de referencias a objetos da classe Chamada
	protected int numChamadas; // nï¿½mero de chamadas feitas pelo assinante

	public Assinante(long cpf, String nome, int numero) {
		this.cpf = cpf;
		this.nome = nome;
		this.numero = numero;
		this.chamadas = new Chamada[10];
		this.numChamadas++;
	}
	
	public long getCpf() {
		return this.cpf;
	}
	@Override
    public String toString() {
        return "CPF: " + this.cpf + "\nNome: " + this.nome + "\nNÃºmero: " + this.numero;
    }

	public abstract void fazerChamada(GregorianCalendar data, int duracao);
	public abstract void imprimirFatura(int mes, int ano);


}

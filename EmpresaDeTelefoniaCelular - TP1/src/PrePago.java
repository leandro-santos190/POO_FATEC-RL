
public class PrePago extends Assinante {
	
	//atributos da classe
	private float creditos;
	private int numRecargas;
	//vetor do tipo Classe Recarga e Chamada
	private Recarga[] recargas;
	private Chamada[] chamadas;


//Metodo construtor, inicializando os seus atributos
public PrePago(long cpf, String nome, int numero) {
	super(cpf, nome, numero);// pega os atributos da classe mãe Assinante
	//Inicializa os atributos com valor zero
	this.numRecargas = 0;
	this.creditos = 0f;
	//Como não foi definido um valor para o tamanho dos arrays, definimos os mesmos com tamanho 10.
	this.recargas = new Recarga[10];
	this.chamadas = new Chamada[10];

}

}


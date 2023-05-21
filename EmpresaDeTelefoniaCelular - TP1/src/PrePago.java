import java.util.GregorianCalendar;

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

public void fazerChamada(GregorianCalendar data, int duracao) {

	float custo_ligacao = 1.45f * duracao; //Custo da ligação 1,45 por minuto

	// System.out.println("Tamanho do vetor chamadas = "+chamadas.length);
	// System.out.println("numChamadas = "+numChamadas);

	if (chamadas.length > numChamadas && this.creditos >= custo_ligacao) {

		Chamada chamada = new Chamada(data, duracao); //instanciei um objeto do tipo chamada, passando como argumento, os parametros recebidos no método
		chamadas[numChamadas] = chamada; //adiciono as informações da chamada, no vetor chamadas 
		numChamadas++; //incremento o número de chamadas feita usando plano pré-pago
		this.creditos -= custo_ligacao; //subtraio o custo da ligação do valor de créditos
		System.out.println("Ligação realizada!"); //Saída para indicar que a chamada foi bem sucedidida

	} else {
		System.out.println("Você não possui créditos suficientes para completar esta ligação!");//Saída para indicar que a chamada não foi bem sucedidida

	}

}



}

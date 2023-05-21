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

		Chamada chamada = new Chamada(data, duracao); //instanciei um objeto do tipo Chamada, passando como argumento, os parametros recebidos no método
		chamadas[numChamadas] = chamada; //adiciono as informações da chamada, no vetor chamadas 
		numChamadas++; //incremento o número de chamadas feita usando plano pré-pago
		this.creditos -= custo_ligacao; //subtraio o custo da ligação do valor de créditos
		System.out.println("Ligação realizada!"); //Saída para indicar que a chamada foi bem sucedidida

	} else {
		System.out.println("Você não possui créditos suficientes para completar esta ligação!");//Saída para indicar que a chamada não foi bem sucedidida

	}

}

public void recarregar(GregorianCalendar data, float valor) {

	// System.out.print(recargas.length);
	if (recargas.length <= 10) { //verifico se tem espaço no vetor de recargas
		Recarga recarga = new Recarga(data, valor); //instanciei um objeto do tipo Recarga, passando como argumento, os parametros recebidos no método
		recargas[numRecargas] = recarga; //adiciono as informações da recarga, no vetor recargas
		this.numRecargas++; //incremento o número de recargas feita usando plano pré-pago
		this.creditos += valor; //adiciono o valor da recarga ao valor dos créditos
		System.out.println("\nRecarga realizada!"); //Saída para indicar que a recarga foi bem sucedidida

	} else {
		System.out.println("Você não pode mais fazer recargas... estranho!");//Saída para indicar que a recarga não foi bem sucedidida
	}
}

public void imprimirFatura(int mes) {
	float total_fatura = 0;
	System.out.println("\n---------Assinante------------");
	System.out.println(super.toString());//Chama o metodo construtor da classe mãe Assinante e puxa os dados do Assinante

	Chamada[] c = chamadas; //instanciei um objeto do tipo Chamada e atribui a ele, o vetor de chamadas, para listar todos as chamadas do mês, de um assinante pre-pago
	System.out.println("\n---------Chamadas-------------");
	for (int i = 0; i < c.length; i++) {
		if (c[i] != null) { // Verifica se o elemento não é nulo antes de acessá-lo
			GregorianCalendar data = c[i].getData(); //Chamo metodo getData para retornar a data de cada ligação 
			int dia = data.get(GregorianCalendar.DAY_OF_MONTH); //	Retorna o dia do mês, de uma determinada chamada feita em alguma data qualquer. 
			int mesChamada = data.get(GregorianCalendar.MONTH) + 1; // Retorna o dia do mês, de uma determinada chamada feita em alguma data qualquer / adiciona 1 ao mês porque os meses iniciam em zero e vão ate onze
			int ano = data.get(GregorianCalendar.YEAR);//	Retorna o ano, de uma determinada chamada feita em alguma data qualquer.
			System.out.println("\nData: " + dia + "/" + mesChamada + "/" + ano); //Exibe a data 
			System.out.println("Duração: " + c[i].getDuracao()); //retorna o a duração da chamada, pelo metodo getDuracao de Chamada
			float custo_ligacao = (c[i].getDuracao() * 145) / 100; //calcula o custo de uma ligação, feita em uma data qualquer
			System.out.println("Custo: R$" + custo_ligacao); //exibe o custo da ligação
			total_fatura += custo_ligacao; //Aqui soma os custos de todas as ligações
		}
	}
	System.out.println("\n---------Valor-Total----------");
	System.out.println("\nTotal da Fatura: R$" + total_fatura);//exibe o valor total da fatura
	System.out.println("Total de Recargas: " + this.numRecargas); //exibe o valor total de recargas
	System.out.println("Creditos Disponiveis: " + this.creditos);//exibe o valor total dos creditos
}


}


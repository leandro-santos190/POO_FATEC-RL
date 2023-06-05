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
	super(cpf, nome, numero);// pega os atributos da classe mÃ£e Assinante
	//Inicializa os atributos com valor zero
	this.numRecargas = 0;
	this.creditos = 0f;
	//Como nÃ£o foi definido um valor para o tamanho dos arrays, definimos os mesmos com tamanho 10.
	this.recargas = new Recarga[10];
	this.chamadas = new Chamada[10];

}

@Override
public void fazerChamada(GregorianCalendar data, int duracao) {

	float custo_ligacao = 1.45f * duracao; //Custo da ligaÃ§Ã£o 1,45 por minuto

	// System.out.println("Tamanho do vetor chamadas = "+chamadas.length);
	// System.out.println("numChamadas = "+numChamadas);

	if (chamadas.length > numChamadas && this.creditos >= custo_ligacao) {

		Chamada chamada = new Chamada(data, duracao); //instanciei um objeto do tipo Chamada, passando como argumento, os parametros recebidos no mÃ©todo
		chamadas[numChamadas] = chamada; //adiciono as informaÃ§Ãµes da chamada, no vetor chamadas 
		numChamadas++; //incremento o nÃºmero de chamadas feita usando plano prÃ©-pago
		this.creditos -= custo_ligacao; //subtraio o custo da ligaÃ§Ã£o do valor de crÃ©ditos
		System.out.println("LigaÃ§Ã£o realizada!"); //SaÃ­da para indicar que a chamada foi bem sucedidida

	} else {
		System.out.println("VocÃª nÃ£o possui crÃ©ditos suficientes para completar esta ligaÃ§Ã£o!");//SaÃ­da para indicar que a chamada nÃ£o foi bem sucedidida

	}

}

public void recarregar(GregorianCalendar data, float valor) {

	// System.out.print(recargas.length);
	if (recargas.length <= 10) { //verifico se tem espaÃ§o no vetor de recargas
		Recarga recarga = new Recarga(data, valor); //instanciei um objeto do tipo Recarga, passando como argumento, os parametros recebidos no mÃ©todo
		recargas[numRecargas] = recarga; //adiciono as informaÃ§Ãµes da recarga, no vetor recargas
		this.numRecargas++; //incremento o nÃºmero de recargas feita usando plano prÃ©-pago
		this.creditos += valor; //adiciono o valor da recarga ao valor dos crÃ©ditos
		System.out.println("\nRecarga realizada!"); //SaÃ­da para indicar que a recarga foi bem sucedidida

	} else {
		System.out.println("VocÃª nÃ£o pode mais fazer recargas... estranho!");//SaÃ­da para indicar que a recarga nÃ£o foi bem sucedidida
	}
}

@Override
public void imprimirFatura(int mes, int ano) {
	float total_fatura = 0;
	System.out.println("\n---------Assinante------------");
	System.out.println(super.toString());//Chama o metodo construtor da classe mÃ£e Assinante e puxa os dados do Assinante

	Chamada[] c = chamadas; //instanciei um objeto do tipo Chamada e atribui a ele, o vetor de chamadas, para listar todos as chamadas do mÃªs, de um assinante pre-pago
	System.out.println("\n---------Chamadas-------------");
	for (int i = 0; i < c.length; i++) {
		if (c[i] != null) { // Verifica se o elemento nÃ£o Ã© nulo antes de acessÃ¡-lo
			GregorianCalendar data = c[i].getData(); //Chamo metodo getData para retornar a data de cada ligaÃ§Ã£o 
			int dia = data.get(GregorianCalendar.DAY_OF_MONTH); //	Retorna o dia do mÃªs, de uma determinada chamada feita em alguma data qualquer. 
			int mesChamada = data.get(GregorianCalendar.MONTH) + 1; // Retorna o dia do mÃªs, de uma determinada chamada feita em alguma data qualquer / adiciona 1 ao mÃªs porque os meses iniciam em zero e vÃ£o ate onze
			int anoChamada = data.get(GregorianCalendar.YEAR);//	Retorna o ano, de uma determinada chamada feita em alguma data qualquer.
			if(mesChamada == mes && anoChamada == ano) { //compara o mes e no do argumento do metodo com o mes e ano da chamada
			System.out.println("\nData: " + dia + "/" + mesChamada + "/" + anoChamada); //Exibe a data 
			System.out.println("DuraÃ§Ã£o: " + c[i].getDuracao()); //retorna o a duraÃ§Ã£o da chamada, pelo metodo getDuracao de Chamada
			float custo_ligacao = (c[i].getDuracao() * 145) / 100; //calcula o custo de uma ligaÃ§Ã£o, feita em uma data qualquer
			System.out.println("Custo: R$" + custo_ligacao); //exibe o custo da ligaÃ§Ã£o
			total_fatura += custo_ligacao; //Aqui soma os custos de todas as ligaÃ§Ãµes
			}
		}
	}
	System.out.println("\n---------Valor-Total----------");
	System.out.println("\nTotal da Fatura: R$" + total_fatura);//exibe o valor total da fatura
	System.out.println("Total de Recargas: " + this.numRecargas); //exibe o valor total de recargas
	System.out.println("Creditos Disponiveis: " + this.creditos);//exibe o valor total dos creditos
}


}


import java.util.GregorianCalendar;

public class PosPago extends Assinante {

	private float assinatura;

	public PosPago(long cpf, String nome, int numero, float assinatura) {
		super(cpf, nome, numero);// pega os atributos da classe mÃ£e Assinante
		this.assinatura = assinatura;
	}

	@Override
	public void fazerChamada(GregorianCalendar data, int duracao) {

		// System.out.println("Tamanho do vetor chamadas = "+chamadas.length);
		// System.out.println("numChamadas = "+numChamadas);

		if (chamadas.length > numChamadas && this.assinatura > 0) {
			Chamada chamada = new Chamada(data, duracao); //instanciei um objeto do tipo Chamada, passando como argumento, os parametros recebidos no mÃ©todo
			chamadas[numChamadas] = chamada;//adiciono as informaÃ§Ãµes da chamada, no vetor chamadas 
			numChamadas++;//incremento o nÃºmero de chamadas feita usando plano pÃ³s-pago
			System.out.println("Chamada realizada com sucesso!");//SaÃ­da para indicar que a chamada foi bem sucedidida

		} else {

			System.out.println("NÃ£o foi possÃ­vel realizar a chamada!");//SaÃ­da para indicar que a chamada nÃ£o foi bem sucedidida

		}
	}

	@Override
	public void imprimirFatura(int mes, int ano) {

		float total_fatura = 0;
		System.out.println("\n---------Assinante------------");
		System.out.println(super.toString());//Chama o metodo construtor da classe mÃ£e Assinante e puxa os dados do Assinante

		System.out.println("\n---------Chamadas-------------");

		for (int i = 0; i < chamadas.length; i++) {
			if (chamadas[i] != null) {
				GregorianCalendar data = chamadas[i].getData();//Chamo metodo getData para retornar a data de cada ligaÃ§Ã£o
				int dia = data.get(GregorianCalendar.DAY_OF_MONTH);//	Retorna o dia do mÃªs, de uma determinada chamada feita em alguma data qualquer.
				int mesChamada = data.get(GregorianCalendar.MONTH) + 1; // Retorna o dia do mÃªs, de uma determinada chamada feita em alguma data qualquer / adiciona 1 ao mÃªs porque os meses iniciam em zero e vÃ£o ate onze
				int anoChamada = data.get(GregorianCalendar.YEAR);//	Retorna o ano, de uma determinada chamada feita em alguma data qualquer.
				if(mesChamada == mes && ano == anoChamada) { //compara o mes e ano dos argumentos do metodo com o mes e ano da chamada
				System.out.println("Data: " + dia + "/" + mesChamada + "/" + anoChamada); //Exibe a data
				System.out.println("DuraÃ§Ã£o: " + chamadas[i].getDuracao());//retorna o a duraÃ§Ã£o da chamada, pelo metodo getDuracao de Chamada
				float custo_ligacao = (chamadas[i].getDuracao() * 104) / 100;//calcula o custo de uma ligaÃ§Ã£o, feita em uma data qualquer
				System.out.println("Custo: R$" + custo_ligacao);//exibe o custo da ligaÃ§Ã£o
				total_fatura += custo_ligacao;//Aqui soma os custos de todas as ligaÃ§Ãµes
				}
			}
		}

		System.out.println("\n---------Valor-Total----------");
		System.out.println("\nValor da Assinatura: R$" + this.assinatura);//exibe o valor da assinatura
		System.out.println("Total da Fatura: R$" + (total_fatura + this.assinatura));//exibe o valor total da fatura

	}

}

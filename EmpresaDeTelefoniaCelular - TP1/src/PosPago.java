import java.util.GregorianCalendar;

public class PosPago extends Assinante {

	private float assinatura;

	public PosPago(long cpf, String nome, int numero, float assinatura) {
		super(cpf, nome, numero);// pega os atributos da classe mãe Assinante
		this.assinatura = assinatura;
	}

	public void fazerChamada(GregorianCalendar data, int duracao) {

		// System.out.println("Tamanho do vetor chamadas = "+chamadas.length);
		// System.out.println("numChamadas = "+numChamadas);

		if (chamadas.length > numChamadas && this.assinatura > 0) {
			Chamada chamada = new Chamada(data, duracao); //instanciei um objeto do tipo Chamada, passando como argumento, os parametros recebidos no método
			chamadas[numChamadas] = chamada;//adiciono as informações da chamada, no vetor chamadas 
			numChamadas++;//incremento o número de chamadas feita usando plano pós-pago
			System.out.println("Chamada realizada com sucesso!");//Saída para indicar que a chamada foi bem sucedidida

		} else {

			System.out.println("Não foi possível realizar a chamada!");//Saída para indicar que a chamada não foi bem sucedidida

		}
	}
	
	public void imprimirFatura(int mes) {

		float total_fatura = 0;
		System.out.println("\n---------Assinante------------");
		System.out.println(super.toString());//Chama o metodo construtor da classe mãe Assinante e puxa os dados do Assinante

		System.out.println("\n---------Chamadas-------------");

		for (int i = 0; i < chamadas.length; i++) {
			if (chamadas[i] != null) {
				GregorianCalendar data = chamadas[i].getData();//Chamo metodo getData para retornar a data de cada ligação
				int dia = data.get(GregorianCalendar.DAY_OF_MONTH);//	Retorna o dia do mês, de uma determinada chamada feita em alguma data qualquer.
				int m = data.get(GregorianCalendar.MONTH) + 1; // Retorna o dia do mês, de uma determinada chamada feita em alguma data qualquer / adiciona 1 ao mês porque os meses iniciam em zero e vão ate onze
				int ano = data.get(GregorianCalendar.YEAR);//	Retorna o ano, de uma determinada chamada feita em alguma data qualquer.

				System.out.println("Data: " + dia + "/" + m + "/" + ano); //Exibe a data
				System.out.println("Duração: " + chamadas[i].getDuracao());//retorna o a duração da chamada, pelo metodo getDuracao de Chamada
				float custo_ligacao = (chamadas[i].getDuracao() * 104) / 100;//calcula o custo de uma ligação, feita em uma data qualquer
				System.out.println("Custo: R$" + custo_ligacao);//exibe o custo da ligação
				total_fatura += custo_ligacao;//Aqui soma os custos de todas as ligações
			}
		}

		System.out.println("\n---------Valor-Total----------");
		System.out.println("\nValor da Assinatura: R$" + this.assinatura);//exibe o valor da assinatura
		System.out.println("Total da Fatura: R$" + (total_fatura + this.assinatura));//exibe o valor total da fatura

	}

}

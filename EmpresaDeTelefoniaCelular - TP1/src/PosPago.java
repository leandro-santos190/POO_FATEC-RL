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

	
	

}

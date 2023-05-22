public class Telefonia {

	private int numPrePagos;
	private int numPosPagos;
	private PrePago[] assinantesPrePago;
	private PosPago[] assinantesPosPago;

	// ---------------------------------------------------------------

	public void telefonia() {
		assinantesPosPago = new PosPago[10]; // removemos o numPosPago e será adicionado um valor como o prof
												// determinou, de 10 posições
		assinantesPrePago = new PrePago[10];
		numPrePagos = 0;
		numPosPagos = 0;
		/*
		 * esse método configura as listas de assinantes pré-pagos e pós-pagos com um
		 * tamanho máximo de 10 elementos e inicializa as variáveis de controle
		 */
	}
}
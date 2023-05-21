
public class PosPago extends Assinante {

	private float assinatura;

	public PosPago(long cpf, String nome, int numero, float assinatura) {
		super(cpf, nome, numero);// pega os atributos da classe mãe Assinante
		this.assinatura = assinatura;
	}

	
	
	

}

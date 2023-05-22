import java.text.SimpleDateFormat;
import java.util.GregorianCalendar;

public class Recarga {
	
	private GregorianCalendar  data;
	private float valor;
	
	public Recarga(GregorianCalendar data, float valor) {
		this.data = data;
		this.valor = valor;	
	}
	
	public GregorianCalendar getData() {
		return this.data; 	
	}

			
	public float getValor() {
		return this.valor;
	}
	
	public String toString() {
		SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
		String dataFormatada = sdf.format(data);
		
		return "data" + dataFormatada;	
		
	}
}
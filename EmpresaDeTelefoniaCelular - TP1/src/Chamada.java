import java.util.GregorianCalendar; // Importando a classe  
import java.text.SimpleDateFormat; // Importando classe que formata as datas

public class Chamada { // Inicializando a classe chamada com seus atributos
  private GregorianCalendar data;
  private int duracao;

  public Chamada(GregorianCalendar data, int duracao) { // Iniciando o construtor da classe
    this.data = data;
    this.duracao = duracao;
  }

  public GregorianCalendar getData() { // Metodo que retorna um atributo data
    return this.data;
  }

  public int getDuracao() { // Metodo que retorna um atributo duracao
    return this.duracao;
  }

}
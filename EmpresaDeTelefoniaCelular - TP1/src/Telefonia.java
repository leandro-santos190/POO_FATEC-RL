import java.util.Scanner;
import java.util.GregorianCalendar;
import java.text.ParseException;
import java.text.SimpleDateFormat;

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

        public void cadastrarAssinante() {

            int numb1;
            Scanner scanner = new Scanner(System.in);
            do {
                System.out.println("\nCadastrar Assinante:");
                System.out.println("------------------------------");
                System.out.println("\nEscolha o tipo de assinatura: ");
                System.out.println("1 - Pre-Pago\n2 - Pós-pago");// faz o usuário escolher entre pospago e prepago
                System.out.print(": ");
                int num = scanner.nextInt();
                scanner.nextLine();// dar uma quebra de linha
    
                if (num == 1) {// Aqui ele escolheu PrePago
    
                    if (numPrePagos <= 10) {// Esse If impede que mais de 10 assinaturas sejam criadas.
    
                        // Ele vai pedir os dados para cadastrar o Assinante
                        System.out.print("\nDigite seu CPF: ");
                        long cpf = scanner.nextLong();
                        System.out.print("\nDigite o nome do Assinante: ");
                        String nome = scanner.next();
                        System.out.print("\nDigite o número do Celular: ");
                        int telefone = scanner.nextInt();
                        // logo abaixo, ele está criando um nv objeto "NovoAssinante" e está passando os
                        // parâmetros no método construtor da PrePago;
                        PrePago novoAssinante = new PrePago(cpf, nome, telefone);
                        // Estamos guardando o novoAssinante nessa variável AssinantesPrePago (logo mais
                        // ela será usada)
                        assinantesPrePago[numPrePagos] = novoAssinante;
                        // E finalizando, estamos incrementando 1 no indice desse vetor. Para que o
                        // próximo cliente cadastrado assuma outra posição dentro desse vetor.
                        numPrePagos++;
    
                    } else {
                        System.out.println("\nLimite excedido");// quando passar de 10 manda essa mensagem aqui
                    }
                } else if (num == 2) {
                    if (numPosPagos <= 10) {
                        // Aqui tudo se repete...
                        System.out.print("\nDigite seu CPF: ");
                        long cpf = scanner.nextLong();
                        System.out.print("\nDigite o nome do Assinante: ");
                        String nome = scanner.next();
                        System.out.print("\nDigite o número do Celular: ");
                        int telefone = scanner.nextInt();
                        System.out.print("\nDigite o valor do assinatura: ");// Porém, isso é novo.
                        float assinatura = scanner.nextFloat();
                        PosPago novoAssinante2 = new PosPago(cpf, nome, telefone, assinatura);
                        assinantesPosPago[numPosPagos] = novoAssinante2;
                        numPosPagos++;
    
                    } else {
                        System.out.println("\nLimite excedido");
                    }
                }
    
                System.out.println("\nDeseja realizar um novo cadastro?\n1- Sim\n2- Não");// Aqui estamos dando uma nova
                                                                                            // opção ao user, ele pode
                                                                                            // escolher fazer mais cadastro
                                                                                            // (em outro CPF)
                System.out.print(":");
                numb1 = scanner.nextInt();
                scanner.nextLine();// dar uma quebra de linha
            } while (numb1 == 1);
    
        }
    
        public void listarAssinante() {
            // Basicamente listamos os nossos cadastrados aqui...
            if (numPrePagos > 0) {// olha a variável que usamos como índice do vetor assinantesPrePago aqui
                System.out.println("\nLista de Assinantes Pré-Pagos:");
                System.out.println("------------------------------");
            }
    
            for (int i = 0; i < numPrePagos; i++) {
                System.out.println("\n" + (i + 1) + "-" + assinantesPrePago[i].toString()); // A função do método toString()
                                                                                            // é transformar um objeto em
                                                                                            // uma representação de texto.
            }
    
            if (numPosPagos > 0) {
                System.out.println("\nLista de Assinantes Pós-Pagos:");
                System.out.println("------------------------------");
            }
    
            for (int i = 0; i < numPosPagos; i++) {
                System.out.println("\n" + (i + 1) + "-" + assinantesPosPago[i].toString());
            }
        }
    
        public void fazerChamada() {
            int num;
    
            do {
                Scanner scanner = new Scanner(System.in);
    
                System.out.println("\nFazer Chamada:");
                System.out.println("------------------------------");
                System.out.print("\nDigite seu CPF: ");
                long cpf = scanner.nextLong();
                scanner.nextLine();
    
                // Verificar se é pré-pago ou pós-pago
                Assinante assinantepre = localizarPrePago(cpf);// Aqui vamos criar um objeto do tipo Assinante e vamos
                                                                // passar como parametro no método
                Assinante assinantepos = localizarPosPago(cpf);// localizarpos/pre o cpf que foi digitado;
    
                if (assinantepre != null || assinantepos != null) {// o método localizarPrePago e Pospago retornam null se
                                                                    // não forem encontrados, por isso
                    // fazemos essa comparação...
                    if (assinantepre != null) {
                        System.out.println("\nAssinante Pré encontrado");
                    }
                    if (assinantepos != null) {
                        System.out.println("\nAssinante PósPago encontrado\n");
                    }
                } else {
                    System.out.println("\nAssinante não encontrado, tente novamente.\n");
                    break;
                }
    
                System.out.print("\nInforme a data da chamada no formato: (dd/mm/aaaa): ");
                String dataStr = scanner.nextLine();// solicitamos ao usuário que ele escreva uma data no formado acima;
                SimpleDateFormat format = new SimpleDateFormat("dd/MM/yyyy");// o SimpleDateFormat é usado para escolher um
                                                                                // padrão no formato das datas.
                GregorianCalendar data;// e aqui, criamos um objeto do tipo gregorian
    
                try {
    
                    /*
                     * Em resumo, esse trecho de código converte uma string de data para um objeto
                     * GregorianCalendar, permitindo manipular e trabalhar com a data de forma mais
                     * conveniente usando os recursos oferecidos pela classe GregorianCalendar.
                     */
                    data = new GregorianCalendar();
                    data.setTime(format.parse(dataStr));
                } catch (ParseException e) {
                    System.out.println("\nData inválida.");
                    return;
                }
    
                System.out.print("\nInforme a duração da chamada em minutos: ");
                int duracao = scanner.nextInt();
                scanner.nextLine();
                // Aqui só saiu com apoio do Robson (ChatGPT)
                if (assinantepre instanceof PrePago) {
                    ((PrePago) assinantepre).fazerChamada(data, duracao);
                } else if (assinantepos instanceof PosPago) {
                    ((PosPago) assinantepos).fazerChamada(data, duracao);
    
                }
    
                System.out.println("\nDeseja fazer mais alguma ligação?\n1 - Sim\n2 - Não");
                System.out.print(":");
    
                num = scanner.nextInt();
            } while (num == 1);
    
        }
    
        public void fazerRecarga() {
            int num;
            Scanner scanner = new Scanner(System.in);
    
            do {
                System.out.println("\nFazer Recarga:");
                System.out.println("------------------------------");
                System.out.print("\nDigite seu cpf: ");
                long cpf = scanner.nextLong();
                scanner.nextLine();
    
                PrePago localizPrePago = localizarPrePago(cpf);
                if (localizPrePago != null) {
                    System.out.print("\nDigite o valor da recarga: ");
                    float valor = scanner.nextFloat();
                    scanner.nextLine();
    
                    System.out.print("\nDigite a data (dd/mm/aaaa): ");
                    String dataString = scanner.nextLine();
                    int dia = Integer.parseInt(dataString.substring(0, 2));
                    int mes = Integer.parseInt(dataString.substring(3, 5)) - 1;
                    int ano = Integer.parseInt(dataString.substring(6));
    
                    GregorianCalendar data = new GregorianCalendar(ano, mes, dia);
    
                    localizPrePago.recarregar(data, valor);
                } else {
                    System.out.println("\nCPF nao encontrado!");
                }
    
                System.out.println("\nDeseja fazer mais alguma recarga?\n1 - Sim\n2 - Não");
                System.out.print(":");
                num = scanner.nextInt();
            } while (num == 1);
        }
    
        private PrePago localizarPrePago(long cpf) {
            for (int i = 0; i < numPrePagos; i++) {
                if (assinantesPrePago[i].getCpf() == cpf) {
                    System.out.println(assinantesPrePago[i]);
                    return assinantesPrePago[i];
                }
            }
            return null;
        }
    
        private PosPago localizarPosPago(long cpf) {
            for (int i = 0; i < numPosPagos; i++) {
                if (assinantesPosPago[i].getCpf() == cpf) {
                    System.out.println(assinantesPosPago[i]);
                    return assinantesPosPago[i];
                }
            }
            return null;
        }
    
        public void imprimirFaturas() {
            System.out.println("\nImprimir fatura:");
            System.out.println("------------------------------");
    
            Scanner scanner = new Scanner(System.in);
            System.out.print("\nDigite o mês desejado (1-12): ");
            int mes = scanner.nextInt();
            while (mes < 1 || mes > 12) {
                System.out.print("\nMês inválido. Digite novamente (1-12): ");
                mes = scanner.nextInt();
            }
    
            // Imprime as faturas dos assinantes pré-pagos
            System.out.println("\nFaturas dos assinantes Pré-Pagos:");
            for (int i = 0; i < numPrePagos; i++) {
                assinantesPrePago[i].imprimirFatura(mes);
            }
    
            // Imprime as faturas dos assinantes pós-pagos
            System.out.println("------------------------------");
            System.out.println("\nFaturas dos assinantes Pós-Pagos:");
            for (int i = 0; i < numPosPagos; i++) {
                assinantesPosPago[i].imprimirFatura(mes);
            }
    
        }
    
}

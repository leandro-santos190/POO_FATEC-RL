import java.util.Scanner;
import java.util.Date;
import java.util.GregorianCalendar;
import java.text.ParseException;
import java.text.SimpleDateFormat;

public class Telefonia {
	private Assinante[] assinantes;//new
    private int numAssinantes;//new
	// ---------------------------------------------------------------

	public void telefonia() {//new
		assinantes = new Assinante[10];
		numAssinantes = 0;
	
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
    
                    if (numAssinantes <= 10) {
    
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
                        assinantes[numAssinantes] = novoAssinante;
                        // E finalizando, estamos incrementando 1 no indice desse vetor. Para que o
                        // próximo cliente cadastrado assuma outra posição dentro desse vetor.
                        numAssinantes++;
    
                    } else {
                        System.out.println("\nLimite excedido");// quando passar de 10 manda essa mensagem aqui
                    }
                } else if (num == 2) {
                    if (numAssinantes <= 10) {
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
                        assinantes[numAssinantes] = novoAssinante2;
                        numAssinantes++;
    
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
            
            if (numAssinantes > 0) {
                System.out.println("\nLista de Assinantes Pré-Pagos e Pós-Pagos:");
                System.out.println("------------------------------");
            }
    
            for (int i = 0; i < numAssinantes; i++) {
                System.out.println("\n" + (i + 1) + "-" + assinantes[i].toString()); 
         
            }
        }
     
     public void fazerChamada(Assinante assinante) {
    	    int num;
    	    
    	    Scanner scanner = new Scanner(System.in);

    	    do {
    	        System.out.println("\nFazer Chamada:");
    	        System.out.println("------------------------------");

    	            	        
    
    	        if (assinante!= null) {
    	            //System.out.println("\nAssinante encontrado");

    
    	            if (assinante instanceof PrePago) {
    	                System.out.println("\nAssinante Pré encontrado");
    	                System.out.print("\nInforme a data da chamada no formato (dd/mm/aaaa): ");
    	                String dataStr = scanner.nextLine();
    	                SimpleDateFormat format = new SimpleDateFormat("dd/MM/yyyy");
    	                GregorianCalendar data;

    	                try {
    	                    data = new GregorianCalendar();
    	                    data.setTime(format.parse(dataStr));

    	                } catch (ParseException e) {
    	                    System.out.println("\nData inválida.");
    	                    return;
    	                }

    	                System.out.print("\nInforme a duração da chamada em minutos: ");
    	                int duracao = scanner.nextInt();
    	                scanner.nextLine();
    
    	                ((PrePago) assinante).fazerChamada(data, duracao);
    	                
    
    	            } else if (assinante instanceof PosPago) {
    	                System.out.println("\nAssinante PósPago encontrado");
    	                System.out.print("\nInforme a data da chamada no formato (dd/mm/aaaa): ");
    	                String dataStr = scanner.nextLine();
    	                SimpleDateFormat format = new SimpleDateFormat("dd/MM/yyyy");
    	                GregorianCalendar data;

    	                try {
    	                    data = new GregorianCalendar();
    	                    data.setTime(format.parse(dataStr));

    	                } catch (ParseException e) {
    	                    System.out.println("\nData inválida.");
    	                    return;
    	                }

    	                System.out.print("\nInforme a duração da chamada em minutos: ");
    	                int duracao = scanner.nextInt();
    	                scanner.nextLine();
    
    	                ((PosPago) assinante).fazerChamada(data, duracao);
    	                
    	            } else {
    	                System.out.println("\nAssinante inválido para fazer chamada");
    	                break;
    	            }
    	        } else {
    	            System.out.println("\nAssinante não encontrado ou inválido, tente novamente.\n");
    	            break;
    	        }

    	        System.out.println("\nDeseja fazer mais alguma ligação?\n1 - Sim\n2 - Não");
    	        System.out.print(":");
    	        num = scanner.nextInt();
    	        scanner.nextLine();
    	    } while (num == 1);
    	}


    
     public void fazerRecarga(PrePago prePago) {
    	    int num = 0;
    	    Scanner scanner = new Scanner(System.in);

    	    do {
    	        System.out.println("\nFazer Recarga:");
    	        System.out.println("------------------------------");
    	        
    	        long cpf = prePago.getCpf();

    
    	        if (cpf>0) {
    	            System.out.print("\nDigite o valor da recarga: ");
    	            float valor = scanner.nextFloat();
    	            scanner.nextLine();

    	            System.out.print("\nDigite a data (dd/mm/aaaa): ");
    	            String dataString = scanner.nextLine();
    	            SimpleDateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy");
    	            Date data;
    	            try {
    	                data = dateFormat.parse(dataString);
    	            } catch (ParseException e) {
    	                System.out.println("\nFormato de data inválido!");
    	                continue;
    	            }

    	            GregorianCalendar calendar = new GregorianCalendar();
    	            calendar.setTime(data);

    	            prePago.recarregar(calendar, valor);
    	        } else {
    	            System.out.println("\nCPF não encontrado!");
    	        }

    	        System.out.println("\nDeseja fazer mais alguma recarga?\n1 - Sim\n2 - Não");
    	        System.out.print(":");
    	        num = scanner.nextInt();
    	    } while (num == 1);
    	}


     private Assinante localizarAssinante(long cpf) {
    	    for (int i = 0; i < numAssinantes; i++) {
    	        if (assinantes[i].getCpf() == cpf) {
    	            return assinantes[i];
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

            System.out.print("\nDigite o ano desejado: ");
            int ano = scanner.nextInt();
            while (ano <=0) {
                System.out.print("\nAno inválido. Digite novamente....: ");
                ano = scanner.nextInt();
            }
            
            // Imprime as faturas dos assinantes pré-pagos
            System.out.println("\nFaturas dos Assinantes Pré-Pagos:");
            for (int i = 0; i < numAssinantes; i++) {
                if (assinantes[i] instanceof PrePago) {
                    PrePago prePago = (PrePago) assinantes[i];
                    prePago.imprimirFatura(mes, ano);
                }
            }

            // Imprime as faturas dos assinantes pós-pagos
            System.out.println("------------------------------");
            System.out.println("\nFaturas dos assinantes Pós-Pagos:");
            for (int i = 0; i < numAssinantes; i++) {
                if (assinantes[i] instanceof PosPago) {
                    PosPago posPago = (PosPago) assinantes[i];
                    posPago.imprimirFatura(mes, ano);
                }
            }
        }

     public static void main(String[] args) {

            Telefonia user = new Telefonia();
            int opcao = 0;
            Scanner scanner = new Scanner(System.in);
            user.telefonia();
    
            do {
    
                System.out.println("\n=== MENU ===");
                System.out.println("1 - Cadastrar Assinante");
                System.out.println("2 - Listar Assinantes");
                System.out.println("3 - Fazer Chamada");
                System.out.println("4 - Fazer Recarga");
                System.out.println("5 - Imprimir Faturas");
                System.out.println("6 - Sair");
                System.out.print("Opcao: ");
    
                opcao = scanner.nextInt();
                scanner.nextLine();
    
                switch (opcao) {
                case 1:
                    user.cadastrarAssinante();
                    break;
                case 2:
                    user.listarAssinante();
                    break;
                case 3:
                    System.out.print("\nDigite seu CPF: ");
                    long cpfChamada = scanner.nextLong();
                    scanner.nextLine();
    
                    user.fazerChamada(user.localizarAssinante(cpfChamada));
   
                    break;
                case 4:
                    System.out.print("\nDigite o CPF do Assinante: ");
                    long cpfRecarga = scanner.nextLong();
                    scanner.nextLine();

                    Assinante assinanteRecarga = user.localizarAssinante(cpfRecarga);
                    if (assinanteRecarga != null && assinanteRecarga instanceof PrePago) {
    
                    	user.fazerRecarga((PrePago) assinanteRecarga);
                    	
                    } else {
                        System.out.println("\nAssinante não encontrado ou não é um assinante pré-pago.");
                    }
                    break;

                case 5:
                    user.imprimirFaturas();
                    break;
                case 6:
                    System.out.println("Bye!");
                    break;
                default:
                    System.out.println("Opção inválida. Tente novamente.");
                    break;
                }
    
            } while (opcao != 6);
    
        }
    
    
}


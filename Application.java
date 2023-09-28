import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.InputMismatchException;
import java.util.Map;
import java.util.Scanner;

import src.entities.Conta;
import src.entities.enums.Definicao;
import src.entities.enums.Status;

public class Application {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
        Map<Integer, Conta> mapList = new HashMap<>();
        Double total = 0.0;

        boolean loop = true;
        try {
            while (loop) {
                System.out.println();
                System.out.println("Digite (1) para lançar uma conta");
                System.out.println("Digite (2) para listar as contas registradas");
                System.out.println("Digite (3) para visualizar o total de contas a pagar");
                System.out.println("Digite (4) para visualizar o total de contas a receber");
                System.out.println("Digite (5) para visualizar o total geral de contas");
                System.out.println("Digite (6) para sair da aplicação");
                System.out.print("Escolha uma das opções acima: ");
                String escolha = sc.nextLine();
                System.out.println();
                
                
                switch (escolha){
                    case "1":
                        try {
                            System.out.print("Conta à pagar (0) ou à receber (1) ");
                            int definicao = sc.nextInt();
                            System.out.print("Insira é o valor da conta: ");
                            Double valor = sc.nextDouble();
                            System.out.print("Insira a descrição da conta: ");
                            sc.nextLine();
                            String descricao = sc.nextLine();
                            System.out.print("Insira a data de vencimento da conta (dd/mm/yyyy) ");
                            Date dataDeVencimento = sdf.parse(sc.nextLine());
                            Conta contas = new Conta(Definicao.valueOf(definicao), valor, descricao, dataDeVencimento, Status.PENDENTE);
                            mapList.put(contas.getId(), contas);
                            break;
                        }
                        catch (InputMismatchException e){
                            System.out.println("Erro ao inserir as informações, tente novamente!");
                        }

                    case "2":
                        System.out.println("ID | Definição | Valor | Descrição | Data de Vencimento | Status");
                        for (Integer key : mapList.keySet()){
                            System.out.println(mapList.get(key));
                        }
                        break;
                        
                    case "3":
                        System.out.println("ID | Definição | Valor | Descrição | Data de Vencimento | Status");
                        for(Integer key : mapList.keySet()){
                            if (mapList.get(key).getDefinicao() == Definicao.PAGAR){
                                System.out.println(mapList.get(key));
                            }
                        }
                        break;
                    case "4":
                        System.out.println("ID | Definição | Valor | Descrição | Data de Vencimento | Status");
                        for(Integer key : mapList.keySet()){
                            if (mapList.get(key).getDefinicao() == Definicao.RECEBER){
                                System.out.println(mapList.get(key));
                            }
                        }
                        break;
                    case "5":
                        for(Integer key : mapList.keySet()){
                            total += mapList.get(key).getValor(); 
                        }
                        System.out.printf("O valor total das contas é de R$%.2f%n", total);
                        break;
                    case "6":
                        loop = false;
                        break;
                    default:
                        System.out.println("Opção inválida, digite novamente! ");
                }
            }
        }
        catch (ParseException e){
            System.out.println("Data inválida!");
        }
        catch (IllegalArgumentException e){
            throw new IllegalArgumentException("");
        }
        finally{
            sc.close();
        }
    }
}

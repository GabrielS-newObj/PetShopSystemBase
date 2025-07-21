import java.util.InputMismatchException;
import java.util.Scanner;

public final class AGerenciadorDePetshop {
    public static void main(String[] args) {

        Animal[] temporarilyDataBase = new Animal[1000];

        AEnterAcessDeleteDadosPetShop acessEnter = new AEnterAcessDeleteDadosPetShop();


        Scanner input = new Scanner(System.in);


        double opcMenu;
        boolean verifyVariable;


        while (true){

            System.out.println("\n\n Escolha uma das opções do menu:");

            System.out.println(
            "\n\n =-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-="       +
            "\n\n   [1]    Cadastrar um Pet"                                     +
            "\n   [2]    Acessar um Pet"                                       +
            "\n   [2,1]  Acessar todos Pet's de um tipo"                       +
            "\n   [3]    Deletar um Pet cadastrado"                            +
            "\n   [3,1]  Deletar todos os Pet's de um tipo cadastrado"         +
            "\n   [4]    Sair"                                                 +
            "\n\n =-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-= \n\n\n"
            );


            try {
                opcMenu = input.nextDouble();
            }catch (InputMismatchException ime){
                System.out.println("Entrada Inválida!");
                input.nextLine();
                continue;
            }

            if (opcMenu == 4)
                break;


            else if (opcMenu == 1){

                verifyVariable = false;

                String nome = acessEnter.enterNome();
                String tipo = acessEnter.enterTipo();
                String dono = acessEnter.enterDono();
                short idade = acessEnter.enterIdade();
                String raca = acessEnter.enterRaca();
                double peso = acessEnter.enterPeso();
                String endereco = acessEnter.enterEndereco();


                for (int i = 0; i < temporarilyDataBase.length; i++) {

                    if (temporarilyDataBase[i] == null){
                        verifyVariable = true;

                        if (tipo.equalsIgnoreCase("cachorro")){
                            char porte = acessEnter.enterPorte();
                            temporarilyDataBase[i] = new Cachorro (nome, tipo, dono, idade, raca, peso, endereco, porte);
                            input.nextLine();
                        }
                        else if (tipo.equalsIgnoreCase("gato")){
                            String tipoDePelagem = acessEnter.enterTipoDePelagem();
                            temporarilyDataBase[i] = new Gato (nome, tipo, dono, idade, raca, peso, endereco, tipoDePelagem);
                            input.nextLine();
                        }
                        else if (tipo.equalsIgnoreCase("passaro")){
                            String tipoDeBico = acessEnter.enterTipoDeBico();
                            temporarilyDataBase[i] = new Passaro (nome, tipo, dono, idade, raca, peso, endereco, tipoDeBico);
                            input.nextLine();
                        }
                        else {
                            String habitat = acessEnter.enterHabitat();
                            temporarilyDataBase[i] = new Reptil(nome, tipo, dono, idade, raca, peso, endereco, habitat);
                            input.nextLine();
                        }

                        break;
                    }
                }
                if (!verifyVariable)
                    System.out.println("\n\n Não há mais espaço para cadastros :(");
            }


            else if (opcMenu == 2){

                String nome;
                String dono;


                while (true) {
                    input.nextLine();

                    System.out.println("\n\n Qual o nome do Pet?");
                    nome = input.nextLine();

                    if (nome.isEmpty()) {
                        System.out.println("\n\n --------------------- \n ERRO: nome inválido \n ---------------------");
                        continue;
                    }

                    System.out.println("\n\n Qual o nome do dono cadastrado?");
                    dono = input.nextLine();

                    if (dono.isEmpty()) {
                        System.out.println("\n\n --------------------- \n ERRO: dono inválido \n ---------------------");
                        continue;
                    }
                    break;
                }


                verifyVariable = acessEnter.acessByNomeAndDono(nome,dono, temporarilyDataBase);

                if (!verifyVariable)
                    System.out.println("\n\n Não há Pets com esse nome e dono");
            }


            else if(opcMenu == 2.1){
                input.nextLine();

                verifyVariable = false;

                while (true){

                    System.out.println("\n\n Quer acessar mesmo todos os registros de um tipo? sim (s) ou não (n)");
                    char simNao = input.next().charAt(0);

                    if (simNao != 's' && simNao != 'S' && simNao != 'n' && simNao != 'N') {
                        System.out.println("\n\n ERRO: somente sim/s ou não/n");
                    }
                    else if (simNao == 's' || simNao == 'S'){
                        break;
                    }
                    else {
                        verifyVariable = true;
                        break;
                    }
                }

                if (verifyVariable)
                    System.out.println("\n\n Voltando para o menu então");
                else{
                    String tipo = acessEnter.enterTipo();

                    verifyVariable = acessEnter.acessAllInstancesByClassName(tipo, temporarilyDataBase);

                    if (!verifyVariable)
                        System.out.println("\n\n Não há cadastros desse tipo do Pet");
                }
            }


            else if (opcMenu == 3){
                input.nextLine();

                String nome;
                String dono;


                while (true) {

                    System.out.println("\n\n Qual o nome do Pet?");
                    nome = input.nextLine();

                    if (nome.isEmpty()) {
                        System.out.println("\n\n --------------------- \n ERRO: nome inválido \n ---------------------");
                        continue;
                    }

                    System.out.println("\n\n Qual o nome do dono cadastrado?");
                    dono = input.nextLine();

                    if (dono.isEmpty()) {
                        System.out.println("\n\n --------------------- \n ERRO: dono inválido \n ---------------------");
                        continue;
                    }
                    break;
                }


                verifyVariable = acessEnter.deleteByNomeAndDono(nome, dono, temporarilyDataBase);

                if (!verifyVariable)
                    System.out.println("\n\n Não há Pets com esse nome e dono");
                else System.out.println("\n\n "+nome+" de "+dono+" deletado com sucesso");
            }


            else if (opcMenu == 3.1){
                input.nextLine();

                verifyVariable = false;

                while (true){

                    System.out.println("\n\n Tem certeza que deseja deletar todos os registros de um tipo? sim (s) ou não (n)");
                    char simNao = input.next().charAt(0);

                    if (simNao != 's' && simNao != 'S' && simNao != 'n' && simNao != 'N') {
                        System.out.println("\n\n ERRO: somente sim/s ou não/n");
                    }
                    else if (simNao == 's' || simNao == 'S'){
                        break;
                    }
                    else {
                        verifyVariable = true;
                        break;
                    }
                }

                if (verifyVariable)
                    System.out.println("\n\n Voltando para o menu então");
                else{
                    String tipo = acessEnter.enterTipo();

                    verifyVariable = acessEnter.deleteAllInstancesByClassName(tipo, temporarilyDataBase);

                    if (!verifyVariable)
                        System.out.println("\n\n Não há cadastros desse tipo do Pet");
                    else System.out.println("\n\n Todos pet´s tipo "+tipo+" deletados com sucesso");
                }

            }

            
            else
                System.out.println("\n\n Por favor, digite apenas opções do menu");
        }



        System.out.println("\n\n Volte sempre :) !!");
    }
}

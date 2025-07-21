import java.util.InputMismatchException;
import java.util.Scanner;

public final class AEnterAcessDeleteDadosPetShop {

    Scanner input = new Scanner(System.in);


    boolean acessByNomeAndDono(String nome, String dono, Animal[] animals) {
        boolean verifyVariableTrue = false;

        for (Animal animal : animals) {
            if ((animal != null) && (animal.getNome().equals(nome)) && (animal.getDono().equals(dono))) {
                System.out.println(animal);
                verifyVariableTrue = true;
            }
        }
        return verifyVariableTrue;
    }


    boolean acessAllInstancesByClassName(String nomeClasse, Animal[] animals) {
        boolean verifyVariableTrue = false;
        boolean printTitle = true;

        for (Animal animal : animals) {

            if (animal != null) {

                if ((nomeClasse.equalsIgnoreCase("Cachorro")) && (animal instanceof Cachorro)) {
                    System.out.println(printTitle ? "\n\n ==============   Cachorros cadastrados   ==============" : "");
                    System.out.println(animal);
                    verifyVariableTrue = true;
                }
                else if ((nomeClasse.equalsIgnoreCase("Gato")) && (animal instanceof Gato)) {
                    System.out.println(printTitle ? "\n\n ==============      Gatos cadastrados    ==============" : "");
                    System.out.println(animal);
                    verifyVariableTrue = true;
                }
                else if ((nomeClasse.equalsIgnoreCase("Passaro")) && (animal instanceof Passaro)) {
                    System.out.println(printTitle ? "\n\n ==============     Pássaros cadastrados  ==============" : "");
                    System.out.println(animal);
                    verifyVariableTrue = true;
                }
                else if  (animal instanceof Reptil){
                    System.out.println(printTitle ? "\n\n ==============      Réptils cadastrados  ==============" : "");
                    System.out.println(animal);
                    verifyVariableTrue = true;
                }

                printTitle = false;
            }
        }
        return verifyVariableTrue;
    }


    boolean deleteByNomeAndDono(String nome, String dono, Animal[] animals) {
        boolean verifyVariableTrue = false;

        for (int i = 0; i < animals.length; i++) {
            if ((animals[i] != null) && (animals[i].getNome().equals(nome)) && (animals[i].getDono().equals(dono))) {
                animals[i] = null;
                verifyVariableTrue = true;
            }
        }
        return verifyVariableTrue;
    }


    boolean deleteAllInstancesByClassName(String nomeClasse, Animal[] animals) {
        boolean verifyVariableTrue = false;

        for (int i = 0; i < animals.length; i++) {

            if (animals[i] != null) {

                if ((nomeClasse.equalsIgnoreCase("Cachorro")) && (animals[i] instanceof Cachorro)) {
                    animals[i] = null;
                    verifyVariableTrue = true;
                } else if ((nomeClasse.equalsIgnoreCase("Gato")) && (animals[i] instanceof Gato)) {
                    animals[i] = null;
                    verifyVariableTrue = true;
                } else if ((nomeClasse.equalsIgnoreCase("Passaro")) && (animals[i] instanceof Passaro)) {
                    animals[i] = null;
                    verifyVariableTrue = true;
                } else if (animals[i] instanceof Reptil){
                    animals[i] = null;
                    verifyVariableTrue = true;
                }
            }
        }
        return verifyVariableTrue;
    }


    String enterNome(){

        String nome;

        while (true){

            System.out.println("\n\n Digite o nome do novo Pet: ");
            nome = String.valueOf(input.nextLine());

            if (nome.isEmpty())
                System.out.println("\n\n --------------------- \n ERRO: nome inválido \n ---------------------");
            else
                return nome;
        }
    }


    String enterTipo(){

        String tipo;

        while (true){

            System.out.println("\n\n Digite o tipo: (cachorro, gato, pássaro ou réptil) sem acento");
            tipo = String.valueOf(input.nextLine());


            if (!(tipo.equalsIgnoreCase("cachorro") || tipo.equalsIgnoreCase("gato") || tipo.equalsIgnoreCase("passaro") || tipo.equalsIgnoreCase("reptil")))
                System.out.println("\n\n --------------------------------------------------- \n ERRO: o tipo deve ser um dos indicados e sem acento\n ---------------------------------------------------");
            else
                return tipo;
        }
    }


    String enterDono(){

        String dono;

        while (true){

            System.out.println("\n\n Digite o nome do seu dono:");

            dono = String.valueOf(input.nextLine());

            try{
                double d = Double.parseDouble(dono);
                System.out.println("Somente letra");
                continue;
            }catch (NumberFormatException e1){
                System.out.println("Quase lá...\n\n");
            }

            if (dono.isEmpty())
                System.out.println("\n\n --------------------- \n ERRO: dono inválido \n ---------------------");
            else
                return dono;
        }
    }


    short enterIdade(){

        short idade;

        while (true){

            System.out.println("\n\n Digite a idade do seu Pet: (em anos)");
            try {
                idade = input.nextShort();
            }catch (InputMismatchException ime){
                System.out.println("Deve ser um número");
                input.nextLine();
                continue;
            }

            if (idade < 0)
                System.out.println("\n\n ------------------------------------------------ \n ERRO: idade igual ou maior que 0 é válida somente \n ------------------------------------------------");
            else
                return idade;
        }
    }


    String enterRaca(){

        input = new Scanner(System.in);

        String raca;

        while (true){

            System.out.println("\n\n E qual a raça do seu Pet?");
            raca = String.valueOf(input.nextLine());

            if (raca.isEmpty())
                System.out.println("\n\n --------------------- \n ERRO: raça inválida \n ---------------------");
            else
                return raca;
        }
    }


    double enterPeso(){

        double peso;

        while (true){

            System.out.println("\n\n E qual seu peso? (em Kg)");
            try {
                peso = input.nextDouble();
            }catch (InputMismatchException ime){
                System.out.println("Deve ser um número");
                input.nextLine();
                continue;
            }
            if (peso <= 0)
                System.out.println("\n\n ------------------------------------------------ \n ERRO: o peso deve ser, no mínimo, maior que zero \n ------------------------------------------------");
            else
                return peso;
        }
    }


    String enterEndereco(){
        String endereco;

        input.nextLine();

        String cidade = giveCidade();
        String bairro = giveBairro();
        String numeroCasa = giveNumeroCasa();

        return cidade + " " + bairro + " " + numeroCasa;
    }


    String giveCidade(){

        String cidade;

        while (true){
            System.out.println("\n\n Quase lá! Vamos para o endereço \n Digite a cidade:");
            cidade = String.valueOf(input.nextLine());

            if (cidade.isEmpty())
                System.out.println("\n\n --------------------- \n ERRO: cidade inválida \n ---------------------");
            else
                return cidade;
        }
    }


    String giveBairro(){

        String bairro;

        while (true){
            System.out.println("\n\n Digite o bairro:");
            bairro = String.valueOf(input.nextLine());

            if (bairro.isEmpty())
                System.out.println("\n\n --------------------- \n ERRO: bairro inválido \n ---------------------");
            else
                return bairro;
        }
    }


    String giveNumeroCasa(){

        String numeroCasa;

        while (true){

            System.out.println("\n\n Digite o número da casa: (pode ser letra, para casos especiais)");
            numeroCasa = String.valueOf(input.nextLine());

            if (numeroCasa.isEmpty())
                System.out.println("\n\n --------------------- \n ERRO: número inválido \n ---------------------");
            else
                return numeroCasa;
        }
    }


    char enterPorte(){

        char porte;

        while (true){

            System.out.println("\n\n Digite a letra do porte: \n (P) - pequeno \n (M) - médio \n (G) - grande");
            porte = input.next().charAt(0);

            if (!(porte == 'P' || porte == 'M' || porte == 'G' || porte == 'p' || porte == 'm' || porte == 'g'))
                System.out.println("\n\n ------------------------------- \n ERRO: deve ser apenas uma letra \n -------------------------------");
            else
                return porte;
        }
    }


    String enterTipoDePelagem(){

        String tipoDePelagem;

        while (true){

            System.out.println("\n\n Digite agora a pelagem:");
            tipoDePelagem = String.valueOf(input.nextLine());

            if (tipoDePelagem.isEmpty())
                System.out.println("\n\n ---------------- \n ERRO: está vazia \n ----------------");
            else
                return tipoDePelagem;
        }
    }


    String enterTipoDeBico(){

        String tipoDeBico;

        while (true){

            System.out.println("\n\n Qual o tipo de bico?");
            tipoDeBico = String.valueOf(input.nextLine());

            if (tipoDeBico.isEmpty())
                System.out.println("\n\n ----------------------- \n ERRO: não pode ser nada \n -----------------------");
            else
                return tipoDeBico;
        }
    }


    String enterHabitat(){

        String habitat;

        while (true){

            System.out.println("\n\n Onde seu réptil mora? ");
            habitat = String.valueOf(input.nextLine());

            if (habitat.isEmpty())
                System.out.println("\n\n ----------------------- \n ERRO: está vazio! \n -----------------------");
            else
                return habitat;
        }
    }

}

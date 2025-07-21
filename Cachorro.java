public class Cachorro extends Animal {

    private char porte;


    public Cachorro(String nome, String tipo, String dono, short idade, String raca, double peso, String endereco, char porte) {
        super(nome, tipo, dono, idade, raca, peso, endereco);
        this.porte = porte;
    }


    @Override
    public String toString() {
        return
            super.toString()+
            "\n\n Porte: " + this.porte+
            "\n\n --------------------------------";
    }

}

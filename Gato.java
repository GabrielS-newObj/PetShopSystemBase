public class Gato extends Animal {

    private String tipoDePelagem;


    public Gato(String nome, String tipo, String dono, short idade, String raca, double peso, String endereco, String tipoDePelagem) {
        super(nome, tipo, dono, idade, raca, peso, endereco);
        this.tipoDePelagem = tipoDePelagem;
    }


    @Override
    public String toString() {
        return
            super.toString()+
            "\n\n Tipo de pelagem: " + this.tipoDePelagem+
            "\n\n --------------------------------";
    }
}

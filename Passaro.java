public class Passaro extends Animal {

    private String tipoDeBico;


    public Passaro(String nome, String tipo, String dono, short idade, String raca, double peso, String endereco, String tipoDeBico) {
        super(nome, tipo, dono, idade, raca, peso, endereco);
        this.tipoDeBico = tipoDeBico;
    }


    @Override
    public String toString() {
        return
            super.toString()+
            "\n\n Tipo de bico: " + this.tipoDeBico+
            "\n\n --------------------------------";
    }
}

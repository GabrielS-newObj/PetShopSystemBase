public class Reptil extends Animal {

    private String habitat;


    public Reptil(String nome, String tipo, String dono, short idade, String raca, double peso, String endereco, String habitat) {
        super(nome, tipo, dono, idade, raca, peso, endereco);
        this.habitat = habitat;
    }


    @Override
    public String toString() {
        return
            super.toString()+
            "\n\n Habitat: " + this.habitat+
            "\n\n --------------------------------";
    }
}

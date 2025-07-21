public abstract class Animal {

    private String nome;
    private String tipo;
    private String dono;
    private short idade;
    private String raca;
    private double peso;
    private String endereco;


    protected Animal(String nome, String tipo, String dono, short idade, String raca, double peso, String endereco) {
        this.nome = nome;
        this.tipo = tipo;
        this.dono = dono;
        this.idade = idade;
        this.raca = raca;
        this.peso = peso;
        this.endereco = endereco;
    }


    @Override
    public String toString(){
        return
            "\n\n --------------------------------" +
            "\n\n Nome: " + getNome() +
            "\n\n Tipo: " + getTipo() +
            "\n\n Dono: " + getDono() +
            "\n\n Idade: " + getIdade() +
            "\n\n Raça: " + getRaca() +
            "\n\n Peso: " + getPeso() +
            "\n\n Endereço: " + getEndereco();
    }

    public String getNome() {
        return nome;
    }

    public String getTipo() {
        return tipo;
    }

    public String getDono() {
        return dono;
    }

    public short getIdade() {
        return idade;
    }

    public String getRaca() {
        return raca;
    }

    public double getPeso() {
        return peso;
    }

    public String getEndereco() {
        return endereco;
    }
}

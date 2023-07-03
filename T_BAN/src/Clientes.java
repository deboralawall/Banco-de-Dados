
public class Clientes {
    private long cpf;
    private String nome;
    private String rua;
    private String bairro;
    private int numero;
    private long telefone;

    public Clientes(long cpf, String nome, String rua, String bairro, int numero, long telefone) {
        this.cpf = cpf;
        this.nome = nome;
        this.rua = rua;
        this.bairro = bairro;
        this.numero = numero;
        this.telefone = telefone;
    }
    
    public Clientes(String nome) {
        this.nome = nome;
    }
    
    public long getCpf() {
        return cpf;
    }

    public void setCpf(long cpf) {
        this.cpf = cpf;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getRua() {
        return rua;
    }

    public void setRua(String rua) {
        this.rua = rua;
    }

    public String getBairro() {
        return bairro;
    }

    public void setBairro(String bairro) {
        this.bairro = bairro;
    }

    public int getNumero() {
        return numero;
    }

    public void setNumero(int numero) {
        this.numero = numero;
    }

    public long getTelefone() {
        return telefone;
    }

    public void setTelefone(long telefone) {
        this.telefone = telefone;
    }

	@Override
    public String toString() {
        return "Cliente:\n" + "CPF: " + cpf + ", Nome: " + nome +
                "\nEndereço: rua " + rua + ", bairro " + bairro + ", numero " + numero + "\n";
    }
}

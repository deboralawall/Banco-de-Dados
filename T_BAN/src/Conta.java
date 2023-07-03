public class Conta {
    private int numConta;
    private float saldo;
    private String cpf;
    private Clientes cliente;

    public Conta(int numConta, float saldo, String cpf) {
    	this.numConta = numConta;
        this.saldo = saldo;
        this.cpf = cpf;
    }
    
    public Conta(float saldo, String cpf) {
        this.saldo = saldo;
        this.cpf = cpf;
    }

    public int getNumConta() {
        return numConta;
    }

    public void setNumConta(int numConta) {
        this.numConta = numConta;
    }

    public float getSaldo() {
        return saldo;
    }

    public void setSaldo(float saldo) {
        this.saldo = saldo;
    }

    public String getCpf() {
		return cpf;
	}

	public void setCpf(String cpf) {
		this.cpf = cpf;
	}

	public Clientes getCliente() {
		return cliente;
	}

	public void setCliente(Clientes cliente) {
		this.cliente = cliente;
	}

	public String toString(){
        return "Numero da conta: " + numConta + " saldo: R$"+saldo+"\nCPF do cliente: "+cpf+"\n";
    }
	
	public String toStringComCliente(){
        return "Numero da conta: " + numConta + " saldo: R$"+saldo+"\n" + cliente.toString()+"\n";
    }
}
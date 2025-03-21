import java.util.ArrayList;
import java.util.List;

public class Banco {
    private String nome;
    private String endereco;
    private int telefone;
    private List<Conta> contas;
    private List<Cliente> clientes;

    public Banco(String nome, String endereco, int telefone) {
        this.nome = nome;
        this.endereco = endereco;
        this.telefone = telefone;
        this.contas = new ArrayList<>();
        this.clientes = new ArrayList<>();
    }

    public void criarContaPoupanca(int agencia, double saldo, int numero, Cliente cliente) {
        Conta conta = new ContaPoupanca(agencia, saldo, numero, cliente, this);
        contas.add(conta);
        clientes.add(cliente);
    }

    public void criarContaCorrente(int agencia, double saldo, int numero, Cliente cliente, double limit) {
        Conta conta = new ContaCorrente(agencia, saldo, numero, cliente, this, limit);
        contas.add(conta);
        clientes.add(cliente);
    }

    public String getEndereco() {
        return endereco;
    }

    public void setEndereco(String endereco) {
        this.endereco = endereco;
    }

    public int getTelefone() {
        return telefone;
    }

    public void setTelefone(int telefone) {
        this.telefone = telefone;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }
}

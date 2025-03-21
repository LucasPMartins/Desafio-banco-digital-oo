import org.xml.sax.HandlerBase;

import java.sql.Array;
import java.util.ArrayList;
import java.util.List;

public abstract class Conta {
    protected int agencia;
    protected double saldo;
    protected int numero;
    protected Cliente cliente;
    protected Banco banco;

    private List<String> extrato;

    private static int SEQUENCIAL = 1;

    public Conta(int agencia, double saldo, int numero, Cliente cliente, Banco banco) {
        this.agencia = agencia;
        this.saldo = saldo;
        this.numero = SEQUENCIAL++;
        this.cliente = cliente;
        this.banco = banco;
        extrato = new ArrayList<String>();
    }


    public void mostrarSaldo() {
        System.out.printf("Saldo: R$%.2f\n", getSaldo());
    }

    public void transferir(double valor, Conta conta) {
        if (valor > 0) {
            if (valor > getSaldo()) {
                System.out.println("Saldo insuficiente para a tranferência!");
            } else {
                setSaldo(getSaldo() - valor);
                conta.depositar(valor);
                String msg = "R$" + valor + " transferido para a conta " + conta + " com sucesso!";
                System.out.println(msg);
                addExtrato(msg);
            }
            mostrarSaldo();
        }
    }

    public abstract void sacar(double saque);

    public void depositar(double deposito) {
        setSaldo(getSaldo() + deposito);
        addExtrato("Depósito de R$" + deposito);
    }

    @Override
    public String toString() {
        return "Conta de" + cliente.getNome()
                + "N°" + getNumero()
                + ", Agência: " + getAgencia()
                + " do banco " + getBanco().getNome();
    }

    public void addExtrato(String extrato) {
        if (extrato.length() < 10) {
            this.extrato.add(extrato);
        } else {
            this.extrato = new ArrayList<String>();
            addExtrato(extrato);
        }
    }

    public void mostrarExtrato() {
        System.out.println("Extrato bancário");
        for (String e : extrato) {
            System.out.println(e);
        }
    }

    public int getAgencia() {
        return agencia;
    }

    public void setAgencia(int agencia) {
        this.agencia = agencia;
    }

    public double getSaldo() {
        return saldo;
    }

    public void setSaldo(double saldo) {
        this.saldo = saldo;
    }

    public int getNumero() {
        return numero;
    }

    public void setNumero(int numero) {
        this.numero = numero;
    }

    public void setCliente(Cliente cliente) {
        this.cliente = cliente;
    }

    public Cliente getCliente() {
        return cliente;
    }

    public Banco getBanco() {
        return banco;
    }

    public void setBanco(Banco banco) {
        this.banco = banco;
    }
}

public class ContaCorrente extends Conta {
    private double limit;

    public ContaCorrente(int agencia, double saldo, int numero, Cliente cliente, Banco banco, double limit) {
        super(agencia, saldo, numero, cliente, banco);
        this.limit = limit;
    }

    public double getLimit() {
        return limit;
    }

    public void setLimit(double limit) {
        this.limit = limit;
    }

    @Override
    public void sacar(double saque) {
        if (saque > 0) {
            if (getSaldo() - saque <= limit) {
                setSaldo(getSaldo() - saque);
                System.out.println("Saque realizado com sucesso!");
                addExtrato("Saque de R$" + saque);
            } else {
                System.out.println("Impossível sacar, Limite e/ou saldo insuficiente!");
            }
            this.mostrarSaldo();
        }
    }

}

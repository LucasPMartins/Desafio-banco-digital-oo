public class ContaPoupanca extends Conta {

    public ContaPoupanca(int agencia, double saldo, int numero, Cliente cliente, Banco banco) {
        super(agencia, saldo, numero, cliente, banco);
    }

    @Override
    public void sacar(double saque) {
        if (saque > 0 && getSaldo() > saque) {
            setSaldo(getSaldo() - saque);
            System.out.println("Saque realizado com sucesso!");
        } else {
            System.out.println("Impossível sacar, saldo insuficiente!");
        }
        this.mostrarSaldo();
    }
}

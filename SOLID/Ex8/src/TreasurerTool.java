public class TreasurerTool implements FinanceOperations {

    private int balance = 0;

    @Override
    public void addFunds(int amount, String source) {
        balance += amount;
        System.out.println("Ledger: +" + amount + " (" + source + ")");
    }

    @Override
    public int getBalance() {
        return balance;
    }
}
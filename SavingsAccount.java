public class SavingsAccount extends GeneralAccount {
    private boolean freeWithdrawalUsed;

    public SavingsAccount() {
        this("0000000", "SAMPLE", "SAMPLE", 0);
    }

    public SavingsAccount(String num, String fName, String lName, double amount) {
        super(num, fName, lName, amount);
        interestRate = 0.01;
        freeWithdrawalUsed = false;
    }

    @Override
    public boolean withdrawal(double amount) {
        if (amount > 0) {
            double fee = freeWithdrawalUsed ? 5.00 : 0.00;
            if (balance >= amount + fee) {
                balance -= (amount + fee);
                freeWithdrawalUsed = true;
                return true;
            }
        }
        return false;
    }

    @Override
    public void endOfMonth() {
        balance += minMonthBalance * interestRate;
        minMonthBalance = balance;
        freeWithdrawalUsed = false;
        System.out.println(this);
    }

    @Override
    public boolean billPayment(double amount, GeneralAccount g) {
        return false;
    }

    @Override
    public boolean chequeCashed(int num, double amount) {
        return false;
    }
}

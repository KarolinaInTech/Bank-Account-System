import java.util.List;
import java.util.ArrayList;

public class ChequingAccount extends GeneralAccount {
    private List<Integer> chequesCashed;

    public ChequingAccount() {
        this("0000000", "SAMPLE", "SAMPLE", 0);
    }

    public ChequingAccount(String num, String fName, String lName, double amount) {
        super(num, fName, lName, amount);
        withdrawFee = 3.50;
        billFee = 5.50;
        chequeFee = 3.50;
        chequesCashed = new ArrayList<>();
    }

    @Override
    public boolean billPayment(double amount, GeneralAccount g) {
        if (amount > 0 && balance >= amount + billFee) {
            balance -= (amount + billFee);
            g.deposit(amount);
            return true;
        }
        return false;
    }

    @Override
    public boolean chequeCashed(int num, double amount) {
        if (amount > 0 && balance >= amount + chequeFee) {
            balance -= (amount + chequeFee); // Deduct cheque amount + fee
            chequesCashed.add(num);
            return true;
        }
        return false;
    }

    @Override
    public void endOfMonth() {
        // Print current state of the account
        System.out.println(this);
        // Clear cheques cashed for next month
        chequesCashed.clear();
    }

    @Override
    public String toString() {
        return super.toString() + "Cheques Cashed: " + (chequesCashed.isEmpty() ? "none" : formatChequeList()) + "\n";
    }

    private String formatChequeList() {
        StringBuilder sb = new StringBuilder();
        for (int num : chequesCashed) {
            sb.append(num).append(" ");
        }
        return sb.toString().trim();
    }
}
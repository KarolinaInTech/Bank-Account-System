public class GrandAccount extends ChequingAccount {
    private boolean feesActive;

    public GrandAccount() {
        this("0000000", "SAMPLE", "SAMPLE", 0);
    }

    public GrandAccount(String num, String fName, String lName, double amount) {
        super(num, fName, lName, amount);
        feesActive = amount < 1000;
    }

    @Override
    public boolean withdrawal(double amount) {

        feesActive = minMonthBalance < 1000;

        if (feesActive) {
            withdrawFee = 3.50;
            chequeFee = 3.50;
            billFee = 5.50;
        } else {
            withdrawFee = 0;
            chequeFee = 0;
            billFee = 0;
        }
        return super.withdrawal(amount);
    }

    @Override
    public void endOfMonth() {

        feesActive = minMonthBalance < 1000;

        if (feesActive) {
            withdrawFee = 3.50;
            chequeFee = 3.50;
            billFee = 5.50;
        } else {
            withdrawFee = 0;
            chequeFee = 0;
            billFee = 0;
        }

        minMonthBalance = balance;

        super.endOfMonth();
    }
}

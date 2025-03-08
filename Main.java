public class Main {
    public static void main(String[] args) {
        ChequingAccount chequing = new ChequingAccount("4873053", "Emmy", "White", 5000);
        GrandAccount grand = new GrandAccount("1092649", "Chloe", "Walker", 2500);
        SavingsAccount savings = new SavingsAccount("2435087", "Alex", "Cooper", 1500);

        chequing.deposit(500);
        chequing.withdrawal(200);
        chequing.chequeCashed(12, 50);
        chequing.chequeCashed(8, 30);
        chequing.chequeCashed(14, 75);
        chequing.billPayment(100, grand);
        chequing.endOfMonth();

        grand.withdrawal(600);
        grand.endOfMonth();

        savings.deposit(200);
        savings.withdrawal(100);
        savings.endOfMonth();
    }
}
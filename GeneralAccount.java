/*
 * GeneralAccount.java for Assignment 3 in AUCSC 112
 * by R. Heise
 * 7 February 2016 (modified 1 Oct 2023)
 *
 * Public Methods:
 *    Constructors to make a GeneralAccount
 *    deposit(double) --> boolean
 *        Adds to balance if amount positive (takes out deposit fee)
 *    withdrawal(double) --> boolean
 *        Subtracts from balance if amount positive (takes out withdrawal
 *        fee)
 *    endOfMonth()
 *        Performs month end stuff (interest calc, reset variables,
 *        print report)
 *    billPayment(double amount, GeneralAccount g) --> false
 *        Not activated.
 *    chequeCashed(int num, double amount) --> false
 *        Not activated.
 *    toString() --> String
 *        String report
 *    getAccountNum() --> String
 *        Returns account number
 *    getName() --> String
 *        Returns name (first and last)
 *    getBalance() --> double
 *        Returns current balance
 */

public abstract class GeneralAccount {

    //===========================================
    //DATA

    protected String accountNum;
    protected String firstName;
    protected String lastName;
    protected double balance;
    protected double depFee;      //deposit service fee
    protected double withdrawFee; //withdrawal service fee
    protected double chequeFee;   //cheque cashing service fee
    protected double billFee;     //bill payment service fee
    protected double minMonthBalance;
    protected double interestRate;

    //===========================================
    //METHODS

    /**************************************
     * Constructors
     *    Creates account, sets all fee amounts to 0.
     *
     * @param num the account number, given as a String.
     * @param fName the first name of account holder, given as a String.
     * @param lName the last name of account holder, given as a String.
     * @param amount the initial deposit amount (must be +ve or set to 0)
     */
    public GeneralAccount(String num, String fName, String lName,
                          double amount){
        accountNum = num;
        firstName = fName;
        lastName = lName;
        if (amount < 0)  //only allow +ve amounts, else set to 0
            amount = 0;
        balance = amount;

        depFee = 0;
        withdrawFee = 0;
        chequeFee = 0;
        minMonthBalance = amount;
        interestRate = 0;
    }//Constructor, all arguments

    public GeneralAccount(){
        this("0000000", "SAMPLE", "SAMPLE", 0);
    }//default constructor, no arguments given

    /**************************************
     * deposit
     *    Add amount to balance, assuming amount is positive;
     *    service fee (depFee) may be deducted.
     *
     * @param amount positive double number
     * @return true if transaction successful; false otherwise
     */
    public boolean deposit(double amount){
        if (amount > 0){
            double newBal;
            newBal = balance + amount - depFee;

            if (newBal > 0){
                balance = newBal;
                return true;
            }
            else{
                System.out.println("deposit error: balance not sufficient to"
                        + " cover service fee");            }
        }//outer if
        else{
            System.out.printf("deposit error:  amount (%.2f) should be "
                    + "positive \n", amount);
        }
        return false;
    }//deposit

    /**************************************
     * withdrawal
     *    Subtract amount (and service fee) from balance,
     *    assuming amount is positive and available in the account.
     *
     * @param amount positive double number
     * @return true if transaction successful; false otherwise
     */
    public boolean withdrawal(double amount){
        if (amount > 0){
            double totalW;
            totalW = amount + withdrawFee;

            if (balance >= totalW){
                balance = balance - totalW;

                //might change minBalance
                if (balance < minMonthBalance)
                    minMonthBalance = balance;
                return true;
            }
            else{
                System.out.printf("withdrawal error:  amount and service "
                        + "fee (%.2f) is greater than balance\n", totalW);
                return false;
            }
        }
        else{
            System.out.printf("withdrawal error:  amount (%.2f) should be "
                    + "positive\n", amount);
            return false;
        }
    }//withdrawal

    /**************************************
     * endOfMonth
     *    Adds interest to balance and prints report.  This is the
     *    method to reset the month.
     */
    public void endOfMonth(){
        balance = balance + minMonthBalance * interestRate;
        minMonthBalance = balance;
        System.out.println(this);
    }//endOfMonth

    /**************************************
     * billPayment
     *    Actual kinds of accounts must define this method.
     *
     * @param amount amount of the bill (positive double)
     * @param g account to pay
     * @return true is successful; false otherwise
     */
    public abstract boolean billPayment(double amount, GeneralAccount g);

    /**************************************
     * chequeCashed
     *   Actual kinds of accounts must define this method.
     *
     * @param num = the cheque number (an int)
     * @param amount = amount of the cheque (positive double)
     * @return true if successful; false otherwise
     */
    public abstract boolean chequeCashed(int num, double amount);


    /**************************************
     * toString
     *    Gives String representation of an account.
     *
     * @return the String representation
     */
    @Override
    public String toString(){
        return accountNum + "\r\n" + lastName.toUpperCase() + ", " +
                firstName + "\r\n" +
                "Balance: " + String.format("%.2f", balance) + "\r\n";
    }//toString

    /**************************************
     * getAccountNum
     *      Returns the account number
     * @return the account number
     */
    public String getAccountNum(){
        return accountNum;
    }//getAccountNum

    /**************************************
     * getName
     *      Returns the name of the account holder.
     * @return the name (first space last)
     */
    public String getName(){
        return firstName + " " + lastName;
    }//getName

    /**************************************
     * getBalance
     *      Returns the balance
     *
     * @return the balance in the account
     */
    public double getBalance(){
        return balance;
    }//getBalance
}//GeneralAccount
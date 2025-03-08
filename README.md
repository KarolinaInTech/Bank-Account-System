# Bank-Account-System

A simple bank account system built in Java using object-oriented programming (OOP) principles like inheritance, encapsulation, and method overriding.

**Features**
- Object-oriented design with multiple account types
- Supports deposits, withdrawals, bill payments, and cheque transactions
- Monthly interest calculation for SavingsAccount
- Service fees for transactions (based on account type)
- Ensures account balance never goes negative
- Automated end-of-month processing

**Tech Stack**
Language: Java
OOP Concepts: Inheritance, Encapsulation, Polymorphism
IDE: IntelliJ IDEA 
**Project Structure**

/BankingSystem
│-- /src
│   │-- GeneralAccount.java
│   │-- ChequingAccount.java
│   │-- GrandAccount.java
│   │-- SavingsAccount.java
│   │-- Main.java
│-- /tests
│   │-- ChequingAccountTest.java
│   │-- GrandAccountTest.java
│   │-- SavingsAccountTest.java
│-- README.md

**Installation & Setup**

1) Clone the repository
git clone https://github.com/your-username/your-repo-name.git

2) Navigate to the project folder
cd your-repo-name

3) Compile the Java files
javac src/*.java

4) Run the program
java src.Main

**Usage**
Create a new ChequingAccount, SavingsAccount, or GrandAccount.
Perform transactions like deposits, withdrawals, and bill payments.
Run endOfMonth() to apply interest and reset counters.

**Author**
Karolina Vakula - 

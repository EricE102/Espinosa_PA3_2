package com.jetbrains;


class SavingsAccount{
    //used to store the annual interest rate for all account holders
    public static double annualInterestRate = 0.0;

    //amount the saver currently has on deposit
    private double savingsBalance;

    public SavingsAccount(double balance){
        savingsBalance = balance;
    }

    //used to calculate monthly interest rate
    public void calculateMonthlyInterest(){
        double monthly_Interest;
        monthly_Interest = (savingsBalance * (annualInterestRate/100)) / 12;
        savingsBalance = savingsBalance + monthly_Interest;
    }

    //sets the anual interst rate to a new value
    public static void modifyInterestRate(double change_Rate){
        annualInterestRate = change_Rate;
    }

    //used to print out the balance
    public void print(){
        System.out.printf("$%.2f", savingsBalance);
    }
}



public class Application {

    public static void main(String[] args) {
        SavingsAccount saver1 = new SavingsAccount(2000.00); //initializes saver1 with 2000
        SavingsAccount saver2 = new SavingsAccount(3000.00); //initializes saver2 with 3000
        SavingsAccount.modifyInterestRate(4.0); //set interest rate to 4 percent
        System.out.println("At 4% interest rate: ");
        System.out.println("          Saver1      Saver2");
        int i;
        //for loop to calculate the monthly rate as well as print it out.
        for(i = 1; i<=12; ++i){
            saver1.calculateMonthlyInterest();  //calculate balance for saver1
            saver2.calculateMonthlyInterest();  //calculate balance for saver2
            System.out.print("Month " + i  + ": ");
            saver1.print();
            System.out.print("     ");
            saver2.print();
            System.out.println();
        }

        System.out.println("\nAt 5% interest rate: ");
        SavingsAccount.modifyInterestRate(5.0); //set rate to 5 percent
        saver1.calculateMonthlyInterest();  //calculate balance for saver 1
        saver2.calculateMonthlyInterest();  //calculate balance for saver 2
        //print next months balance
        System.out.println("                                                Saver1      Saver2");
        System.out.print("Next months balance with the 5% interest: ");
        saver1.print();
        System.out.print("      ");
        saver2.print();



    }
}

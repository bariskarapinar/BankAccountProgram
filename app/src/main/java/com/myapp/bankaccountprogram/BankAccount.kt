package com.myapp.bankaccountprogram

import java.util.Locale

// This class represents a simple bank account
class BankAccount(
    var accountHolder: String,
    var balance: Double)
{
    // List to store all transactions
    private val transactionHistory = mutableListOf<String>()

    // Adds money to the account
    fun deposit(amount: Double){
        balance += amount
        transactionHistory.add("Deposited $${String.format(Locale.US, "%.2f", amount)}")
    }

    // Takes money out of the account if there are enough funds
    fun withdraw(amount: Double){
        if(amount <= balance){
            balance -= amount
            transactionHistory.add("Withdrew $${String.format(Locale.US, "%.2f", amount)}")
        }else{
            println("You don't have the funds to withdraw $$amount")
        }
    }

    // Prints all transactions to the console
    fun displayTransactionHistory(){
        println("Transaction history for $accountHolder")
        for(transaction in transactionHistory){
            println(transaction)
        }
    }

    // Returns the list of transactions
    fun getTransactionHistory(): List<String> {
        return transactionHistory
    }
}

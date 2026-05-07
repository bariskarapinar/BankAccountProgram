package com.myapp.bankaccountprogram

// This is the entry point for running the code as a simple Kotlin program
fun main(){

    // Create a new bank account
    val johnsBankAccount = BankAccount("John Doe", 1338.20)

    // Perform some transactions
    johnsBankAccount.deposit(200.0)
    johnsBankAccount.withdraw(1200.00)
    johnsBankAccount.deposit(3000.00)
    johnsBankAccount.deposit(2000.00)
    johnsBankAccount.withdraw(3333.15)

    // Show the results in the console
    johnsBankAccount.displayTransactionHistory()
    println("${johnsBankAccount.accountHolder}'s " +
            "balance is ${johnsBankAccount.balance}")
}
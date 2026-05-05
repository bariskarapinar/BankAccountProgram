package com.myapp.bankaccountprogram

fun main(){

    val johnsBankAccount = BankAccount("John Doe", 1338.20)

    johnsBankAccount.deposit(200.0)
    johnsBankAccount.withdraw(1200.00)
    johnsBankAccount.deposit(3000.00)
    johnsBankAccount.deposit(2000.00)
    johnsBankAccount.withdraw(3333.15)

    johnsBankAccount.displayTransactionHistory()
    println("${johnsBankAccount.accountHolder}'s " +
            "balance is ${johnsBankAccount.balance}")

}
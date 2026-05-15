package com.myapp.bankaccountprogram

import java.util.Locale
import java.text.SimpleDateFormat
import java.util.Date

// Represents the type of transaction
enum class TransactionType {
    DEPOSIT, WITHDRAWAL
}

// Data class to store transaction details
data class Transaction(
    val type: TransactionType,
    val amount: Double,
    val balanceAfter: Double,
    val timestamp: String
)

// This class represents a simple bank account
class BankAccount(
    var accountHolder: String,
    var balance: Double)
{
    // List to store all transaction objects
    private val transactionHistory = mutableListOf<Transaction>()
    private val dateFormat = SimpleDateFormat("HH:mm:ss", Locale.US)

    // Adds money to the account
    fun deposit(amount: Double){
        if (amount > 0) {
            balance += amount
            val transaction = Transaction(
                TransactionType.DEPOSIT,
                amount,
                balance,
                dateFormat.format(Date())
            )
            transactionHistory.add(transaction)
        }
    }

    // Takes money out of the account if there are enough funds
    fun withdraw(amount: Double){
        if (amount > 0 && amount <= balance) {
            balance -= amount
            val transaction = Transaction(
                TransactionType.WITHDRAWAL,
                amount,
                balance,
                dateFormat.format(Date())
            )
            transactionHistory.add(transaction)
        } else if (amount > balance) {
            println("You don't have the funds to withdraw $$amount")
        }
    }

    // Prints all transactions to the console
    fun displayTransactionHistory(){
        println("Transaction history for $accountHolder")
        for(transaction in transactionHistory){
            val typeStr = if (transaction.type == TransactionType.DEPOSIT) "Deposited" else "Withdrew"
            println("${transaction.timestamp}: $typeStr $${String.format(Locale.US, "%.2f", transaction.amount)} (Balance: $${String.format(Locale.US, "%.2f", transaction.balanceAfter)})")
        }
    }

    // Returns the list of transactions
    fun getTransactionHistory(): List<Transaction> {
        return transactionHistory
    }
}

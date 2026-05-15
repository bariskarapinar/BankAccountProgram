package com.myapp.bankaccountprogram

import android.os.Bundle
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import java.util.Locale

// The main screen of the application
class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        // Set the visual layout
        setContentView(R.layout.activity_main)

        // Find the text views in the layout
        val historyTextView = findViewById<TextView>(R.id.historyTextView)
        val balanceTextView = findViewById<TextView>(R.id.balanceTextView)

        // Create a new bank account
        val account = BankAccount("John Doe", 1338.20)

        // Perform some transactions
        account.deposit(200.0)
        account.withdraw(1200.00)
        account.deposit(3000.00)
        account.deposit(2000.00)
        account.withdraw(3333.15)
        account.deposit(50.50) // A small extra deposit

        // Prepare the transaction history text
        val history = account.getTransactionHistory()
        val historyText = StringBuilder()
        for (transaction in history) {
            val typeStr = if (transaction.type == TransactionType.DEPOSIT) "Deposited" else "Withdrew"
            val formattedAmount = String.format(Locale.US, "%.2f", transaction.amount)
            val formattedBalance = String.format(Locale.US, "%.2f", transaction.balanceAfter)
            
            historyText.append("[")
                .append(transaction.timestamp)
                .append("] ")
                .append(typeStr)
                .append(" $")
                .append(formattedAmount)
                .append("\n  Balance: $")
                .append(formattedBalance)
                .append("\n\n")
        }

        // Update the UI with the history and balance
        historyTextView.text = historyText.toString()
        balanceTextView.text = "$${String.format(Locale.US, "%.2f", account.balance)}"
    }
}

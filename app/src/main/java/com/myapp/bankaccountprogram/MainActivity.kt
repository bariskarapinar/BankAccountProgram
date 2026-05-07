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
        val johnsBankAccount = BankAccount("John Doe", 1338.20)

        // Perform some transactions
        johnsBankAccount.deposit(200.0)
        johnsBankAccount.withdraw(1200.00)
        johnsBankAccount.deposit(3000.00)
        johnsBankAccount.deposit(2000.00)
        johnsBankAccount.withdraw(3333.15)

        // Prepare the transaction history text
        val history = johnsBankAccount.getTransactionHistory()
        val historyText = StringBuilder()
        for (transaction in history) {
            historyText.append(transaction).append("\n")
        }

        // Update the UI with the history and balance
        historyTextView.text = historyText.toString()
        balanceTextView.text = "${johnsBankAccount.accountHolder}'s balance is $${String.format(Locale.US, "%.2f", johnsBankAccount.balance)}"
    }
}

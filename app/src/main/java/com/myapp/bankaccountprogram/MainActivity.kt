package com.myapp.bankaccountprogram

import android.os.Bundle
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import java.util.Locale

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val historyTextView = findViewById<TextView>(R.id.historyTextView)
        val balanceTextView = findViewById<TextView>(R.id.balanceTextView)

        val johnsBankAccount = BankAccount("John Doe", 1338.20)

        johnsBankAccount.deposit(200.0)
        johnsBankAccount.withdraw(1200.00)
        johnsBankAccount.deposit(3000.00)
        johnsBankAccount.deposit(2000.00)
        johnsBankAccount.withdraw(3333.15)

        val history = johnsBankAccount.getTransactionHistory()
        val historyText = StringBuilder()
        for (transaction in history) {
            historyText.append(transaction).append("\n")
        }

        historyTextView.text = historyText.toString()
        balanceTextView.text = "${johnsBankAccount.accountHolder}'s balance is $${String.format(Locale.US, "%.2f", johnsBankAccount.balance)}"
    }
}

package com.myapp.bankaccountprogram

import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import java.util.Locale

// The main screen of the application
class MainActivity : AppCompatActivity() {

    private lateinit var balanceTextView: TextView
    private lateinit var historyTextView: TextView
    private lateinit var amountEditText: EditText
    private lateinit var account: BankAccount

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        // Set the visual layout
        setContentView(R.layout.activity_main)

        // Initialize UI components
        balanceTextView = findViewById(R.id.balanceTextView)
        historyTextView = findViewById(R.id.historyTextView)
        amountEditText = findViewById(R.id.amountEditText)
        val depositButton = findViewById<Button>(R.id.depositButton)
        val withdrawButton = findViewById<Button>(R.id.withdrawButton)

        // Create a new bank account with initial balance
        account = BankAccount("John Doe", 1338.20)

        // Perform some initial transactions
        account.deposit(200.0)
        account.withdraw(1200.00)
        account.deposit(3000.0)

        // Set up button click listeners
        depositButton.setOnClickListener {
            handleTransaction(isDeposit = true)
        }

        withdrawButton.setOnClickListener {
            handleTransaction(isDeposit = false)
        }

        // Initial UI update
        updateUI()
    }

    /**
     * Reads the amount from the input field and performs the transaction.
     */
    private fun handleTransaction(isDeposit: Boolean) {
        val amountString = amountEditText.text.toString()
        val amount = amountString.toDoubleOrNull()

        if (amount == null || amount <= 0) {
            Toast.makeText(this, getString(R.string.error_invalid_amount), Toast.LENGTH_SHORT).show()
            return
        }

        if (isDeposit) {
            account.deposit(amount)
        } else {
            if (amount > account.balance) {
                Toast.makeText(this, getString(R.string.error_insufficient_funds), Toast.LENGTH_SHORT).show()
                return
            }
            account.withdraw(amount)
        }

        // Clear input and update the screen
        amountEditText.text.clear()
        updateUI()
    }

    /**
     * Updates the balance and transaction history on the screen.
     */
    private fun updateUI() {
        // Update Balance
        balanceTextView.text = "$${String.format(Locale.US, "%.2f", account.balance)}"

        // Update History
        val history = account.getTransactionHistory()
        val historyText = StringBuilder()
        // Show transactions in reverse order (newest on top)
        for (i in history.indices.reversed()) {
            val transaction = history[i]
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
        historyTextView.text = historyText.toString()
    }
}

# 🏦 Bank Account Program - Kotlin Learning Journey

<p align="center">
  <img src="https://img.shields.io/badge/Kotlin-1.9.10-blue.svg?style=for-the-badge&logo=kotlin" alt="Kotlin">
  <img src="https://img.shields.io/badge/Android-34-green.svg?style=for-the-badge&logo=android" alt="Android">
  <img src="https://img.shields.io/badge/Architecture-MVVM-orange.svg?style=for-the-badge" alt="MVVM">
  <img src="https://img.shields.io/badge/Build-Gradle-blue?style=for-the-badge&logo=gradle" alt="Gradle">
</p>

## 🌟 Overview

Welcome to my **Bank Account Program**! This is a personal educational project developed to master the fundamentals of **Kotlin** and **Android Development**. The core objective was to build a robust, interactive banking simulation while adhering to modern development standards and architectural patterns.

This project serves as a cornerstone of my Android learning path, demonstrating proficiency in state management, UI design, and object-oriented principles in Kotlin.

---

## 🎨 Visual Showcase

> [!TIP]
> This section showcases the interactive UI of the application.

<p align="center">
  <table>
    <tr>
      <td align="center"><b>Main Dashboard</b></td>
      <td align="center"><b>Transaction Success</b></td>
    </tr>
    <tr>
      <td><img src="https://via.placeholder.com/300x600?text=Placeholder:+Main+Screen" width="250" alt="Main Screen Screenshot"></td>
      <td><img src="https://via.placeholder.com/300x600?text=Placeholder:+Success+State" width="250" alt="Success State Screenshot"></td>
    </tr>
    <tr>
      <td align="center"><i>Visualizing current balance and action cards</i></td>
      <td align="center"><i>Real-time history updates</i></td>
    </tr>
  </table>
</p>

---

## 🏗 Architecture & Design

### 📐 MVVM Architecture
The project follows the **Model-View-ViewModel** pattern to ensure a clean separation of concerns, making the code testable and maintainable.

```mermaid
graph TD
    subgraph View ["View (Activity/XML)"]
        UI["MainActivity.kt"]
        Layout["activity_main.xml"]
    end

    subgraph ViewModel ["Logic Layer (Currently in Activity)"]
        VM["Transaction Logic"]
    end

    subgraph Model ["Data Layer"]
        BA["BankAccount.kt"]
        T["Transaction Data Class"]
    end

    UI --> VM
    VM --> BA
    BA --> T
    Layout -.-> UI
```

### 🔄 App Flow
The following diagram illustrates how a user interaction triggers a data update and UI refresh:

```mermaid
sequenceDiagram
    participant User
    participant Activity as MainActivity
    participant Account as BankAccount
    participant History as TransactionHistory

    User->>Activity: Enters Amount & Clicks Deposit
    Activity->>Activity: Validates Input
    Activity->>Account: deposit(amount)
    Account->>Account: Updates Balance
    Account->>History: Adds new Transaction object
    Account-->>Activity: Returns updated state
    Activity->>Activity: updateUI()
    Activity-->>User: Visual feedback (Balance change)
```

---

## 🚀 Key Features

- **✅ Structured Data**: Leverages Kotlin `data class` and `enum class` for clean transaction modeling.
- **✅ Real-time Validation**: Robust checks for numerical input, positive values, and overdraft protection.
- **✅ Detailed Auditing**: Every action is timestamped and recorded with a "Balance After" snapshot.
- **✅ Material 3 Design**: Uses `CardView`, `TextInputLayout`, and `MaterialToolbar` for a professional look.
- **✅ Precision Handling**: Uses `String.format` with `Locale.US` to prevent floating-point display errors.

---

## 📊 MAD Score (Modern Android Development)

I have evaluated this project against the **MAD Score** criteria to track my progress in using modern Android tools.

| Category | Tooling | Proficiency |
| :--- | :--- | :--- |
| **Language** | Kotlin (100%) | ⭐⭐⭐⭐⭐ |
| **Build** | Gradle (KTS) | ⭐⭐⭐⭐ |
| **UI** | Material Design / XML | ⭐⭐⭐⭐ |
| **Architecture** | MVVM Pattern | ⭐⭐⭐ |

---

## 🛠 Tech Stack

- **Language:** [Kotlin](https://kotlinlang.org/)
- **UI:** XML (Material Design)
- **Minimum SDK:** 24
- **Target SDK:** 34
- **Build System:** Gradle Kotlin DSL
- **Architecture:** Model-View-ViewModel (MVVM) concept

---

## 📚 Learning Outcomes

Through this project, I have gained hands-on experience in:
1. **Kotlin Fundamentals**: Enums, Data Classes, String Templates, and List Manipulations.
2. **Android Lifecycle**: Managing state within the `onCreate` phase.
3. **UI/UX**: Designing responsive layouts with `LinearLayout`, `ScrollView`, and `CardView`.
4. **Input Handling**: Bridging the gap between user text input and numerical logic.
5. **Formatting**: Implementing localized currency and time formatting.

---
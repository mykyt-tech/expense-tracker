# Expense Tracker

A simple console-based Java application to track incomes and expenses.  
This project practices **Java File I/O**, **CSV parsing**, **exception handling**, and **OOP design**.

---

## Features

- Add a new transaction:
    - Fields: Date, Description, Amount, Type (`income` or `expense`)
- View all transactions
- Show a summary:
    - Total income
    - Total expenses
    - Net balance (Income - Expenses)
- Automatically load data from a CSV file on startup
- Automatically save data to a CSV file on exit

---

## Installation

Clone the repository and navigate to the project directory:

```bash
git clone https://github.com/mykyt-tech/expense-tracker.git
cd expense-tracker
```

Compile the Java files:
```bash
javac *.java
```

Run the application:
```bash
java TrackerApp
```

## Usage
### Menu Options
1. Add Transaction
    - Enter the task date in YYYY-MM-DD format.
    - Enter a description.
    - Enter the amount (must be positive).
    - Enter the type (income or expense).
2. View Transaction History
    - Displays all transactions with date, description, amount, and type.
3. Show Summary
   - Displays total income, total expenses, and net balance.
4. Exit
    - Saves all transactions automatically to transactions.csv.

## CSV File Format
Transactions are saved in transactions.csv:
```csv
date,description,amount,type
2025-09-23,Salary,1500,income
2025-09-25,Groceries,200,expense
```
- date: YYYY-MM-DD
- type: income or expense

## Validation Rules
- Date must be in YYYY-MM-DD format
- Amount must be positive
- Type must be either income or expense

## Skills Gained
- Java File I/O and CSV handling
- Exception handling and input validation
- Object-oriented programming (classes, methods)
- Managing dynamic data with ArrayList
- Parsing and formatting user input

## Stretch Goals
- [ ] Generate monthly summary reports
- [ ] Automatically create separate CSV files per month
- [ ] Add search and filter functionality by date or description

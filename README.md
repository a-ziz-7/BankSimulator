# Bank Simulation

This is a Java program that I have created to simulate a bank system. It includes various classes to manage accounts, customer information, and transactions. The program allows users to open accounts, check balances, withdraw, and deposit money.

## Table of Contents

- [Overview](#overview)
- [Usage](#usage)
- [Classes](#classes)
- [Custom Exceptions](#custom-exceptions)
- [Demo](#demo)
- [Contributing](#contributing)
- [License](#license)

## Overview

In this project, I have implemented a comprehensive bank simulation system, including the following key components:

- **Currency Class:** A class to represent currency values and perform operations like addition and subtraction.

- **Account Class:** An abstract class with common methods for managing accounts. It serves as a base class for specific account types like Checking, Savings, and CD.

- **Checking, Savings, and CD Classes:** Subclasses of the Account class, each representing a specific type of bank account with its unique features.

- **Customer Class:** A class to manage customer information and their associated accounts.

- **Custom Exceptions:** I've created custom exception classes to handle various scenarios gracefully, such as invalid transactions, overdrawn accounts, and more.

- **Main Program:** The main program provides a user-friendly menu to interact with the system. Users can become customers, open accounts, perform transactions, and check balances.

- 
## Classes

### Currency Class

- `public Currency()`: Initializes the number of cents to 0.
- `public Currency(int cents)`: Initializes the number of cents to the specified value.
- `public int getValue()`: Returns the number of cents in the account.
- `public Currency add(Currency rhs)`: Adds two Currency objects together.
- `public Currency subtract(Currency rhs)`: Subtracts two Currency objects.
- `public String toString()`: Returns a representation for a Currency object, printing the amount of money in dollars.

### Account Class

- `public Account(Currency initialDeposit)`: Creates an account with an initial deposit.
- `public void withdraw(Currency money)`: Withdraws money from the account (to be overridden by subclasses).
- `public void deposit(Currency money)`: Deposits money into the account (to be overridden by subclasses).
- `public Currency getBalance()`: Returns the balance in the account (to be overridden by subclasses).



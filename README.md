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

## Usage

To run the program, you need to compile the Java files and execute the main program. Here are the steps:

1. Compile the Java files:

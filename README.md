# Bank Account Management System

This repository contains a Java project that simulates a simple bank account management system. This project was developed as part of a computer science course. It includes classes for managing bank accounts, transactions, and bank tellers. The simulation demonstrates concurrent transactions being processed by multiple bank tellers.

## Classes

### BankAccount

The `BankAccount` class represents a bank account with an account number and balance. It includes methods for retrieving the account number, balance, and modifying the balance through thread-safe operations.

### BankTeller

The `BankTeller` class simulates a bank teller that processes transactions concurrently. It takes transactions from a shared queue and updates the associated bank account balances accordingly.

## Getting Started

1. Clone this repository to your local machine.
2. Compile the Java classes using your preferred Java compiler or development environment.
3. Run the `Main` class to start the simulation.

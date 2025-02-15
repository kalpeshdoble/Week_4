package org.example;

import org.example.Junit.BankAccount;
import org.junit.jupiter.api.*;

import static org.junit.jupiter.api.Assertions.*;

public class BankAccountTest {
    private BankAccount account;

    @BeforeEach
    void setUp() {
        account = new BankAccount(100.0); // Start with an initial balance of 100
    }

    @Test
    void testDeposit() {
        account.deposit(50.0);
        assertEquals(150.0, account.getBalance(), "Balance should be 150 after depositing 50");
    }

    @Test
    void testWithdraw() {
        account.withdraw(40.0);
        assertEquals(60.0, account.getBalance(), "Balance should be 60 after withdrawing 40");
    }

    @Test
    void testWithdrawFailsForInsufficientFunds() {
        Exception exception = assertThrows(IllegalArgumentException.class, () -> account.withdraw(200.0));
        assertEquals("Insufficient funds", exception.getMessage());
    }

    @Test
    void testDepositFailsForNegativeAmount() {
        Exception exception = assertThrows(IllegalArgumentException.class, () -> account.deposit(-10.0));
        assertEquals("Deposit amount must be positive", exception.getMessage());
    }

    @Test
    void testWithdrawFailsForNegativeAmount() {
        Exception exception = assertThrows(IllegalArgumentException.class, () -> account.withdraw(-20.0));
        assertEquals("Withdrawal amount must be positive", exception.getMessage());
    }
}


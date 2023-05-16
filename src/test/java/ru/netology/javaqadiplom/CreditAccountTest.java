package ru.netology.javaqadiplom;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class CreditAccountTest {

    @Test //++ сложения начального баланса с добавленным/ random значения
    public void testShouldAddToPositiveBalance() {
        CreditAccount account = new CreditAccount(
                1_000,
                5_000,
                15
        );
        account.add(3_000);

        Assertions.assertEquals(4_000, account.getBalance());
    }


    @Test //++ граничные значения/ сложение начльного баланса + 0
    public void testAddNullToPositiveBalance() {
        CreditAccount account = new CreditAccount(
                1,
                5_000,
                15
        );

        account.add(0);

        Assertions.assertEquals(1, account.getBalance());

    }

    @Test //++ граничные значения/ сложение начального баланса + 1
    public void testAddOneToPositiveBalance() {
        CreditAccount account = new CreditAccount(
                5_000,
                15,
                1
        );

        account.add(1);

        Assertions.assertEquals(5_001, account.getBalance());

    }

    @Test //++ граничные значения/ сложение начального баланса 0 + 0
    public void testAddNullToBalanceNull() {
        CreditAccount account = new CreditAccount(
                0,
                500,
                423
        );

        account.add(0);

        Assertions.assertEquals(0, account.getBalance());

    }

    @Test//++ покупка выше кредитного лимита
    public void testPayAboveTheLimit() {
        CreditAccount account = new CreditAccount(0, 5_000, 15);
        account.pay(6_000);
        Assertions.assertEquals(0, account.getBalance());

    }

    @Test//++ покупка на баланс+кредитный лимит
    public void testPayForTheBalanceAndCreditLimit() {
        CreditAccount account = new CreditAccount(1_000, 5_000, 15);
        account.pay(6_000);
        Assertions.assertEquals(-5_000, account.getBalance());

    }

    @Test//++ /граничные значения покупка на баланс+кредитный лимит
    public void testPayForTheBalanceNullAndCreditLimitNull() {
        CreditAccount account = new CreditAccount(0, 0, 1);
        account.pay(1);
        Assertions.assertEquals(0, account.getBalance());
    }

    @Test//++ покупка по балансу с 0 лимитом
    public void testPayForTheBalanceForNullCredit() {
        CreditAccount account = new CreditAccount(1_000, 0, 15);
        account.pay(300);
        Assertions.assertEquals(700, account.getBalance());
    }

    @Test//++ покупка на кредитный лимит при балансе 0
    public void testPayForTheBalanceNullAndCreditLimit() {
        CreditAccount account = new CreditAccount(0, 5_001, 115);
        account.pay(5_000);
        Assertions.assertEquals(-5_000, account.getBalance());
    }

    @Test//++/граничные значения покупка на кредитный лимит маки балансе мак
    public void testPayForTheBalanceMaxAndCreditLimitMax() {
        CreditAccount account = new CreditAccount(5_000, 5_001, 22);
        account.pay(10_001);
        Assertions.assertEquals(-5_001, account.getBalance());
    }

    @Test// ++ считает проценты при отрицательном балансе
    public void testYearChangeNegativeBalance() {
        CreditAccount account = new CreditAccount(-200, 5_000, 15);
        account.yearChange();
        Assertions.assertEquals(-30, account.yearChange());
    }

    @Test//++ не должен считат проценты при положительном балансе
    public void testYearChangePositiveBalance() {
        CreditAccount account = new CreditAccount(200, 5_000, 15);
        account.yearChange();
        Assertions.assertEquals(0, account.yearChange());
    }

    @Test//++/граничные значения не должен считат проценты при положительном балансе
    public void testYearChangeBalanceNull() {
        CreditAccount account = new CreditAccount(0, 5_000, 15);
        account.yearChange();
        Assertions.assertEquals(0, account.yearChange());

    }

    @Test ////++Проверка IllegalArgumentException
    public void testYearChangeRateNull() {
        try {
            CreditAccount account = new CreditAccount(200, 5_000, 0);
            Assertions.fail("IllegalArgumentException not thrown");
        } catch (IllegalArgumentException expected) {

        }
    }

    @Test ////++Проверка IllegalArgumentException
    public void testYearChangeRateNegative() {
        try {
            CreditAccount account = new CreditAccount(0, 0, -1);
            Assertions.fail("IllegalArgumentException not thrown");
        } catch (IllegalArgumentException expected) {


        }
    }


}

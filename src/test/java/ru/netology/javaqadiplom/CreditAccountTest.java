package ru.netology.javaqadiplom;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class CreditAccountTest {

    @Test //баг, нет сложения начального баланса с добавленным
    public void testShouldAddToPositiveBalance() {
        CreditAccount account = new CreditAccount(
                1_000,
                5_000,
                15
        );
        account.add(3_000);

        Assertions.assertEquals(4_000, account.getBalance());
    }

    @Test //пройдено
    public void testAddNullToPositiveBalance() {
        CreditAccount account = new CreditAccount(
                5_000,
                5_000,
                15
        );

        account.add(0);

        Assertions.assertEquals(5_000, account.getBalance());
        // тут все верно
    }


    @Test//По условию кредитный счет может иметь баланс вплоть до отрицательного, но до указанного кредитного лимита.
    //кредитный лимит 5000, операция должна завершится и ничего не поменяв на счёте
    public void testPayAboveTheLimit() {
        CreditAccount account = new CreditAccount(0, 5_000, 15);
        account.pay(6_000);
        Assertions.assertEquals(0, account.getBalance());

    }

    @Test//успешно, покупка на баланс+кредитный лимит
    public void testPayForTheBalanceAndCreditLimit() {
        CreditAccount account = new CreditAccount(1_000, 5_000, 15);
        account.pay(6_000);
        Assertions.assertEquals(-5_000, account.getBalance());

    }

    @Test//успешно, покупка на баланс+кредитный лимит
    public void testPayForTheBalanceAndCredit() {
        CreditAccount account = new CreditAccount(0, 0, 15);
        account.pay(6_000);
        Assertions.assertEquals(0, account.getBalance());
    }

    @Test//успешно, покупка по балансу с 0 лимитом
    public void testPayForTheBalanceForNullCredit() {
        CreditAccount account = new CreditAccount(6_000, 0, 15);
        account.pay(6_000);
        Assertions.assertEquals(0, account.getBalance());
    }

    @Test//успешно, считает проценты при отрицательном балансе
    public void testYearChangeNegativeBalance() {
        CreditAccount account = new CreditAccount(-200, 5_000, 15);
        account.yearChange();
        Assertions.assertEquals(-30, account.yearChange());
    }

    @Test//баг, не должен считат проценты при положительном балансе
    public void testYearChangePositiveBalance() {
        CreditAccount account = new CreditAccount(200, 5_000, 15);
        account.yearChange();
        Assertions.assertEquals(0, account.yearChange());
    }

    @Test//баг, не должен считат проценты при положительном балансе
    public void testYearChangeBalanceNull() {
        CreditAccount account = new CreditAccount(0, 5_000, 15);
        account.yearChange();
        Assertions.assertEquals(0, account.yearChange());

    }

    @Test
    // При 0 и отрицательном rate, должен возвращать IllegalArgumentException(
    // "Накопительная ставка не может быть отрицательной, а у вас: " + rate);
    public void testYearChangeRateNull() {
        try {
            CreditAccount account = new CreditAccount(200, 5_000, 0);
            Assertions.fail("IllegalArgumentException not thrown");
        } catch (IllegalArgumentException expected) {

        }
    }
    @Test // отрицательный баланс считает%
    public void testYearChangeBalanceNegative() {
        CreditAccount account = new CreditAccount(-200, 5_000, 15);
        account.yearChange();
        Assertions.assertEquals(-30, account.yearChange());

    }


}

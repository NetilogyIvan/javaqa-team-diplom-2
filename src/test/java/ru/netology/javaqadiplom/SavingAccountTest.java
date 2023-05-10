package ru.netology.javaqadiplom;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class SavingAccountTest {
//тесты для add (пополнения) баланса:
    //1) add рандомное число с рандомным балансом
    @Test //не складывает начальный баланс и сумму, которую хотим добвить/ по фиксино
    public void shouldAddLessThanMaxBalance() {
        SavingAccount account = new SavingAccount(
                2_000,
                1_000,
                10_000,
                5
        );
        account.add(3_000);

        Assertions.assertEquals(2_000 + 3_000, account.getBalance());
    }
    @Test  // добавляем сумму превышающую максимальный баланс суммарно. По идее отмена операции и ожидаем 2000.
    //2) add рандомное число с рандомным балансом, сумма выше мак баланса - должна быть отмена операции
    public void shouldAddMoreThanMaxBalance() {
        SavingAccount account = new SavingAccount(
                2_000,
                1_000,
                10_000,
                5
        );
        account.add(10_000);

        Assertions.assertEquals(2_000, account.getBalance());
    }
    @Test  // добавляем отрицательное число./ по фиксино
    public void shouldAddNegativeNumberThanMaxBalance() {
        SavingAccount account = new SavingAccount(
                2_000,
                1_000,
                10_000,
                5
        );
        account.add(-10_000);

        Assertions.assertEquals(2_000, account.getBalance());
    }
    @Test  // списываем отрицательное число. тест прошел
    public void shouldPayNegativeNumberThanMaxBalance() {
        SavingAccount account = new SavingAccount(
                2_000,
                1_000,
                10_000,
                5
        );

        account.pay(-10_000);

        Assertions.assertEquals(2_000, account.getBalance());
    }
    @Test  // списываем сумму меньшую, чем наш баланс. ТЕСТ ПРОШЕЛ
    public void shouldPayLessThanInitialBalance() {
        SavingAccount account = new SavingAccount(
                2_000,
                1_000,
                10_000,
                5
        );

        account.pay(1_000);

        Assertions.assertEquals(1_000, account.getBalance());
    }
    @Test  // списываем сумму меньшую, чем наш баланси чтобы остаток был меньше минимального./ по фиксино
    public void shouldPayLessThanInitialBalanceAndLessThenMinBalance() {
        SavingAccount account = new SavingAccount(
                2_000,
                1_000,
                10_000,
                5
        );

        account.pay(1_500);

        Assertions.assertEquals(2_000, account.getBalance());
    }
    @Test  // списываем сумму большую, чем наш баланс. Сумму вычел, актуал получился -1000 / по фиксино
    public void shouldPayMoreThanInitialBalance() {
        SavingAccount account = new SavingAccount(
                2_000,
                1_000,
                10_000,
                5
        );
        account.pay(3_000);

        Assertions.assertEquals(2_000, account.getBalance());
    }
    @Test  // списываем сумму большую, чем наш баланс. Сумму вычел, актуал получился -1000
    public void testYearChange() {
        SavingAccount account = new SavingAccount(
                200,
                1_000,
                10_000,
                15
        );
        int yearChange = account.yearChange();

        Assertions.assertEquals(30, yearChange);
    }
}

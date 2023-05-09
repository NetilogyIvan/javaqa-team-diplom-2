package ru.netology.javaqadiplom;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class SavingAccountTest {

    @Test //не складывает начальный баланс и сумму, которую хотим добвить
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
    @Test  // добавляем сумму превышающую максимальное значение суммарно. По идее отмена операции и ожидаем 2000. ТЕСТ ПРОШЕЛ, но он не показательный
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
    @Test  // добавляем отрицательное число. хз что должнополучиться. проверка на баг. ХЗ КАК, но тест ПРОШЕЛ
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
    @Test  // списываем отрицательное число. хз что должнополучиться. проверка на баг. ХЗ КАК, но тест ПРОШЕЛ
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
    @Test  // списываем сумму меньшую, чем наш баланси чтобы остаток был меньше минимального. Вычел. Получил 500. Но должен был выдать ошибку.
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
    @Test  // списываем сумму большую, чем наш баланс. Сумму вычел, актуал получился -1000
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
                2_000,
                1_000,
                10_000,
                10
        );

        int yearChange = account.yearChange();

        Assertions.assertEquals(200, yearChange);
    }
}

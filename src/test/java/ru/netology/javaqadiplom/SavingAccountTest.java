package ru.netology.javaqadiplom;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class SavingAccountTest {

    @Test // ++сложение произвольного числа
    public void shouldAddLessThanMaxBalance() {
        SavingAccount account = new SavingAccount(
                2_000,
                1_000,
                10_000,
                5
        );
        account.add(3_999);

        Assertions.assertEquals(5_999, account.getBalance());
    }

    @Test //++ граничные значение+ до максимума
    public void shouldAddLessThanMaxBalance2() {
        SavingAccount account = new SavingAccount(
                2_000,
                1_000,
                10_000,
                5
        );
        account.add(8_000);

        Assertions.assertEquals(10_000, account.getBalance());
    }

    @Test // ++граничные значения, на 1 больше макс
    public void shouldAddLessThanMaxBalance3() {
        SavingAccount account = new SavingAccount(
                2_000,
                1_000,
                10_000,
                5
        );
        account.add(8_001);

        Assertions.assertEquals(2_000, account.getBalance());
    }

    @Test // ++граничные значения, на 1 меньше макс
    public void shouldAddLessThanMaxBalance4() {
        SavingAccount account = new SavingAccount(
                2_000,
                1_000,
                10_000,
                5
        );
        account.add(7_999);

        Assertions.assertEquals(9_999, account.getBalance());
    }

    @Test // ++негативное тестироване на прибавление отрицательного числа
    public void shouldAddNegativeLess() {
        SavingAccount account = new SavingAccount(
                2_000,
                1_000,
                10_000,
                5
        );
        account.add(-1);

        Assertions.assertEquals(2_000, account.getBalance());
    }

    @Test // ++негативное тестироване на прибавление отрицательного числа
    public void shouldAddNegativeLessThanMinBalance() {
        SavingAccount account = new SavingAccount(
                2_000,
                1_000,
                10_000,
                5
        );
        account.add(-1000);

        Assertions.assertEquals(2_000, account.getBalance());
    }

    @Test //++ прибавляем произвольное число, которое превышает лимит
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

    @Test // ++ списание произвольной отрицательной суммы
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

    @Test // ++ граничные значения по списанию
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

    @Test //++ граничные значения, на 1 меньше минимума
    public void shouldPayLessThanInitialBalanceAndLessThenMinBalance() {
        SavingAccount account = new SavingAccount(
                2_000,
                1_000,
                10_000,
                5
        );

        account.pay(1_001);

        Assertions.assertEquals(2_000, account.getBalance());
    }

    @Test //++ граничные значения, на 1 больше минимума
    public void shouldPayLessThanInitialBalance2() {
        SavingAccount account = new SavingAccount(
                2_000,
                1_000,
                10_000,
                5
        );

        account.pay(999);

        Assertions.assertEquals(1_001, account.getBalance());
    }

    @Test // ++ негативное тестирование. списание на сумму большую, чем начальный баланс
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

    @Test //++
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

    @Test // ++ начисление процентов при нулевом балансе
    public void testYearChange2() {
        SavingAccount account = new SavingAccount(
                0,
                0,
                10_000,
                15
        );
        int yearChange = account.yearChange();

        Assertions.assertEquals(0, yearChange);
    }

    @Test // ++ начисление процентов при нулевом балансе
    public void testYearChange3() {
        SavingAccount account = new SavingAccount(
                1,
                0,
                10_000,
                15
        );
        int yearChange = account.yearChange();

        Assertions.assertEquals(0, yearChange);
    }
}

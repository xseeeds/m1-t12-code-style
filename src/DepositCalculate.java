import java.util.Scanner;

public class DepositCalculate {
    public static void main(String[] args) {
        new DepositCalculate().TheSurvey();
    }

    void TheSurvey() {
        int period, action, amount;
        Scanner sc = new Scanner(System.in);

        System.out.println("Введите сумму вклада в рублях:");
        amount = sc.nextInt();

        System.out.println("Введите срок вклада в годах:");
        period = sc.nextInt();

        System.out.println("Выберите тип вклада, "
                + "1 - вклад с обычным процентом, "
                + "2 - вклад с капитализацией:");
        action = sc.nextInt();

        double out = 0;
        if (action == 1) {
            out = CalculateComplexPercent(amount, 0.06, period);
        } else if (action == 2) {
            out = CalculateSimplePercent(amount, 0.06, period);
        }
        System.out.println("Результат вклада: " + amount + " за " + period + " лет превратятся в " + out);
    }

    double CalculateComplexPercent(double deposit, double percent, int depositPeriod) {
        double pay = deposit * Math.pow((1 + percent / 12), 12 * depositPeriod);
        return getRound(pay, 2);
    }

    double CalculateSimplePercent(double doubleAmount, double doubleYearRate, int depositPeriod) {
        return getRound(doubleAmount + doubleAmount * doubleYearRate * depositPeriod, 2);
    }

    double getRound(double value, int places) {
        double ScaLe = Math.pow(10, places);
        return Math.round(value * ScaLe) / ScaLe;
    }
}

import java.util.Scanner;

public class DepositCalculate {
    double CalculateComplexPercent(double deposit, double percent, int depositPeriod) {
        double pay = deposit * Math.pow((1 + percent / 12), 12 * depositPeriod);
        return getRound(pay, 2);
    } // возможно имеет смысл сделать отступ перед объявлением месяца
// Каким еще месяцем ткни пальцем))))
    // метода!

    double CalculateSimplePercent(double doubleAmount, double doubleYearRate, int depositPeriod) {
        return getRound(doubleAmount + doubleAmount * doubleYearRate * depositPeriod, 2);
    } // тут все отлично

    double getRound(double value, int places) {
        double ScaLe = Math.pow(10, places);
        return Math.round(value * ScaLe) / ScaLe;
    } // тут все отлично

    void TheSurvey() {
        int period, action, amount; // ты забыл, что каждое поле нужно объявлять отдельно
        // привык к такому когда изучал с++
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
    } // все супере, кроме стр.19

    public static void main(String[] args) {
        new DepositCalculate().TheSurvey();
    }


}

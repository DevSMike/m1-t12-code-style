import java.util.Scanner;

public class DepositCalculator
{
    double calculateComplexPercent(double amount, double yearRate, int depositPeriod) {
        double pay = amount * Math.pow((1 + yearRate / 12), 12 * depositPeriod);
        return round(pay, 2); //Лучше не передавать 2, а сразу присвоить scale 100, но это не точно
    }

    double calculateSimplePercent(double amount, double yearRate, int depositPeriod) {
         return round(amount + amount * yearRate * depositPeriod, 2); //Наверное было бы лучше формулу вынести из передаваемых параметров
    }

    double round(double value, int places) {
        double scale = Math.pow(10, places);
        return Math.round(value * scale) / scale; //Здесь понял, что я ошибся в своём коде
    }

    void getDepositForYears() {
        int period; //Здесь мне кажется проще создать переменные сразу со сканнером
        int action;

        Scanner scanner = new Scanner(System.in);
        System.out.println("Введите сумму вклада в рублях:") ;
        int amount = scanner.nextInt();
        System.out.println("Введите срок вклада в годах:") ;
        period = scanner.nextInt( );
        System.out.println("Выберите тип вклада, 1 - вклад с обычным процентом, 2 - вклад с капитализацией:");
        action = scanner.nextInt();
        double depositForYear = 0;
        if (action == 1) {
            depositForYear = calculateSimplePercent(amount, 0.06, period);
        } else if (action == 2) {
            depositForYear = calculateComplexPercent(amount, 0.06, period);
      } System.out.println("Результат вклада: " + amount + " за " + period + " лет превратятся в " + depositForYear);
    }

    public static void main(String[] args) {
        new DepositCalculator().getDepositForYears(); //Хорошее решение, я не додумался даже
    }
}

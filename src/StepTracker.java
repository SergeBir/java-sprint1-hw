import java.util.Scanner;
public class StepTracker extends Converter {
    int[][] year = new int[12][31];
    Converter converter = new Converter();
    int stepsGoal = 10000;

    //метод сохранения шагов
    void addSteps() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("За какой месяц добавить значение? " +
                "Введите номер от 1 до 12 ");

        int month = scanner.nextInt();
        if (month > 12 || month < 1) {
            System.out.println("Такого месяца не существует! Начните заново");
            return;
        }
        System.out.println("За какой день добавить значение? " +
                "Введите день от 1 до 30 ");
        int day = scanner.nextInt();
        if (day > 30 || day <= 0) {
            System.out.println("Такого дня не существует! Начните заново");
            return;
        }
        System.out.println("Cколько шагов прошли?");
        int stepsCunt = scanner.nextInt();
        if (stepsCunt < 0) {
            System.out.println("Нельзя пройти отрицательное число шагов! Начните заново!");
            return;
        }
        year[month - 1][day-1] = stepsCunt;
    }

    //метод статистики за месяц
    void checkMonth() {
        //в этой части кода выводи количество шагов по дням
        Scanner scanner = new Scanner(System.in);
        System.out.println("За какой месяц проверить данные? ");
        int month = scanner.nextInt();
        if (month > 12 || month <= 0) {
            System.out.println("Такого месяца не существует! Введите заново");
            return;
        }
        int day = 1;
        for (int i = 1; i < year[month-1].length; i++) {
            System.out.print(i + " день: " + +year[month - 1][day-1] + " шагов,");
            day = day + 1;
        }
        System.out.println(" ");

        //в этой части кода узнаем общую сумму шагов за месяц
        int totalCount = 0;
        for (int j = 0; j < year[month-1].length; j++) {
            totalCount = totalCount + year[month - 1][j];
        }
        System.out.println("Общее количество шагов за месяц: " + totalCount);

        //в этой части кода выводим максимальное количество шагов за месяц
        int maxSteps = 0;
        for (int k = 0; k < year[month-1].length; k++) {
            if (maxSteps < year[month - 1][k]) {
                maxSteps = year[month - 1][k];
            }
        }
        System.out.println("Максимальное количество шагов за месяц: " + maxSteps);

        //в этой части кода выводим среднее количество шагов
        System.out.println("Среднее количество шагов за месяц в день: " + totalCount / 30);

        //В этой части кода выводим расстояние в Км
        converter.countKm(totalCount);

        //В этой части кода выводим количество потраченной энергии
        converter.countEnergy(totalCount);

        //в этой части кода проверяется лучшая серия дней
        int stepsGoalCount = 0;
        int stepsGoalCountMax = 0;
        for (int z = 0; z < year[month-1].length; z++) {
            if(year[month-1][z] >= stepsGoal) {
                stepsGoalCount++;
            }
            else {
                if (stepsGoalCount > stepsGoalCountMax) stepsGoalCountMax = stepsGoalCount;
                stepsGoalCount = 0;
            }
        }
        System.out.println("Лучшая серия: " + stepsGoalCountMax + " дней");
    }


        //метод изменения дневной цели пройденных шагов
        void changeGoal () {
            Scanner scanner = new Scanner(System.in);
            System.out.println("Сейчас дневная цель: " + stepsGoal + " шагов");
            System.out.println("Желаете ли изменить?" +
                    " 1(да)/2(нет)");
            int choice = scanner.nextInt();
            if (choice == 1) {
                System.out.println("Новая дневная цель: ");
                int newGoal = scanner.nextInt();
                if (newGoal < 0) {
                    System.out.println("Нельзя пройти отрицательное количество дней! Попробуйте заново ");
                    return;
                }
                stepsGoal = newGoal;
                System.out.println("Цель успешно изменена на: " + stepsGoal + " шагов");
            } else if (choice == 2) {
                System.out.println("Дневная цель осталась прежней");
            }
        }
    }

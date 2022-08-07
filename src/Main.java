
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        StepTracker stepTracker = new StepTracker();

        Scanner scanner = new Scanner(System.in);

        while (true) {
            printMenu();
            int userResponse = scanner.nextInt();

            if (userResponse == 1) {
                stepTracker.addSteps();
            }
            else if (userResponse == 2) {
                stepTracker.checkMonth();
            }
            else if (userResponse == 3) {
                stepTracker.changeGoal();
            }
            else if (userResponse == 0) {
                System.out.println("Программа завершена");
                break;
            } else {
                System.out.println("Такой программы нет");
            }
        }
    }

    //метод главного меню
    private static void printMenu() {

        System.out.println("Что вы хотите сделать?");
        System.out.println("1 - Ввести количество шагов за определённый день");
        System.out.println("2 - Напечатать статистику за определённую дату");
        System.out.println("3 - Изменить цель по количеству шагов в день");
        System.out.println("0 - Выйти из приложения");
    }
}

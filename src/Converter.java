public class Converter{

    //конвертация шагов в километры
    void countKm(int totalCounts ) {
        int km = ((totalCounts * 75)/100000);
        System.out.println("Пройденная дистанция за месяц (в км): " + km);
    }

    //конвертация шагов в калории
    void countEnergy(int totalCounts) {
        int kK = ((totalCounts * 50)/1000);
        System.out.println("Было сожжено за месяц (в кКал): " + kK);
    }
}

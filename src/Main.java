import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        NotebookShop shop = new NotebookShop();
        shop.loadNotebooks(); // Загружаем ноутбуки в магазин
        Scanner scanner = new Scanner(System.in);

        while (true) {
            System.out.println("Введите цифру, соответствующую необходимому критерию:");
            System.out.println("1 - ОЗУ");
            System.out.println("2 - Объем ЖД");
            System.out.println("3 - Операционная система");
            System.out.println("4 - Цвет");
            System.out.println("5 - Цена");
            System.out.println("q - Завершить ввод критериев и отобразить результаты");

            String input = scanner.nextLine();
            if (input.equals("q")) {
                break;
            }

            shop.addChoice(input, scanner);
        }

        shop.filterAndShowNotebooks();
    }
}
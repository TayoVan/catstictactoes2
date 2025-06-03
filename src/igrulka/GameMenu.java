package igrulka;

import java.util.Scanner;

public class GameMenu {
    private Scanner scanner;

    public GameMenu(Scanner scanner) {
        this.scanner = scanner;
    }

    public void showMainMenu() {
        System.out.println("Котики збираються грати! готуємо лапки!");
        System.out.println("\n1.{ Котики хочуть грати }");
        System.out.println("2. { Котики налаштують вашу гру! }");
        System.out.println("3. { Котики розкажуть казочку про гру }");
        System.out.println("4. { Котики сформували статистику }");
        System.out.println("5. { Покидаєте котиків?( }");
        System.out.print(" { Тиць на циферки }: ");
    }

    public int getUserInput() {
        while (!scanner.hasNextInt()) {
            System.out.println("Опаньки, літер у нашій грі нема, зробіть вибір цифрою)");
            scanner.next();
        }
        int choice = scanner.nextInt();
        scanner.nextLine();
        return choice;
    }

    public void showRules() {
        System.out.println("{ \nПравила гри \"Хрестики-нулики\" }:");
        System.out.println("1. { Два гравці по черзі ставлять на вільні клітинки поля свої знаки (один завжди хрестик, другий - нулик). }");
        System.out.println("2. { Першим завжди ходить гравець, що ставить хрестик. }");
        System.out.println("3. { Мета гри - першим вибудувати в ряд по горизонталі, вертикалі або діагоналі три своїх фігури. }");
        System.out.println("4. { Якщо все поле заповнене, а ніхто не виграв, оголошується нічия.} ");
        System.out.println("Натисніть Enter щоб повернутися в меню.");
        scanner.nextLine();
    }

    public void showSettingsMenu() {
        System.out.println("{ \nНалаштування }");
        System.out.println("1. { Котики змінять розмір поля }");
        System.out.println("2. { Змінити ім'я котика X }");
        System.out.println("3. { Змінити ім'я котика O }");
        System.out.println("0. { Повернути котика до меню }");
        System.out.print("{ Tиць на циферки }: ");
    }

    public void showFieldSizeOptions() {
        System.out.println(" { Оберіть розмір поля }:");
        System.out.println("1. { 3x3 }");
        System.out.println("2. { 5x5 }");
        System.out.println("3. { 7x7 }");
        System.out.println("4. { 9x9 }");
        System.out.print(" { Ваш вибір }: ");
    }

    public String getPlayerNameInput(String prompt) {
        System.out.print(prompt);
        return scanner.nextLine();
    }

    public void pressEnterToContinue() {
        System.out.println("Тисніть Enter щоб повернутися в меню.");
        scanner.nextLine();
    }
}
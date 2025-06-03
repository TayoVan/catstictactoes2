package igrulka;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        GameConfigManager configManager = new GameConfigManager();
        GameStatsManager statsManager = new GameStatsManager();
        GameMenu menu = new GameMenu(scanner);

        GameSettings settings = configManager.loadConfig();

        TicTacToeGame game = new TicTacToeGame(scanner, settings, statsManager, configManager, menu);

        while (true) {
            menu.showMainMenu();
            int choice = menu.getUserInput();

            switch (choice) {
                case 1:
                    game.startGame();
                    break;
                case 2:
                    game.configureGameSettings();
                    break;
                case 3:
                    menu.showRules();
                    break;
                case 4:
                    statsManager.showStats();
                    menu.pressEnterToContinue();
                    break;
                case 5:
                    System.out.println("Вихід.");
                    scanner.close();
                    return;
                default:
                    System.out.println("Опаньки, літер у нашій грі нема, зробіть вибір цифрою)");
            }
        }
    }
}
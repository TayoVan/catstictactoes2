package igrulka;

import java.time.LocalDateTime;
import java.util.Scanner;

public class TicTacToeGame {
    private GameSettings settings;
    private GameBoard board;
    private char currentPlayer;
    private Scanner scanner;
    private GameStatsManager statsManager;
    private GameConfigManager configManager;
    private GameMenu menu;

    public TicTacToeGame(Scanner scanner, GameSettings settings, GameStatsManager statsManager, GameConfigManager configManager, GameMenu menu) {
        this.scanner = scanner;
        this.settings = settings;
        this.statsManager = statsManager;
        this.configManager = configManager;
        this.menu = menu;
    }

    public void startGame() {
        board = new GameBoard(settings.getFieldSize());
        currentPlayer = 'X';
        String currentPlayerName;

        while (true) {
            board.printBoard();
            currentPlayerName = (currentPlayer == 'X') ? settings.getPlayerXName() : settings.getPlayerOName();
            System.out.println("Котик " + currentPlayerName + " (" + currentPlayer + "), ваш хід. Введіть рядок і стовпець (1-" + settings.getFieldSize() + "): ");
            int row = menu.getUserInput() - 1;
            int col = menu.getUserInput() - 1;

            if (row < 0 || row >= settings.getFieldSize() || col < 0 || col >= settings.getFieldSize() || board.isCellOccupied(row, col)) {
                System.out.println("Неправильний хід, спробуйте ще раз.");
                continue;
            }

            board.placeMark(row, col, currentPlayer);

            if (board.checkWin(row, col, currentPlayer)) {
                board.printBoard();
                System.out.println("Котик " + currentPlayerName + " (" + currentPlayer + ") виграв!");
                statsManager.saveStat(new GameStats(LocalDateTime.now(), settings.getFieldSize(), currentPlayerName, currentPlayer));
                break;
            }

            if (board.isFull()) {
                board.printBoard();
                System.out.println("Опаньки, схоже нічия! Ви повертаєтеся на головне меню");
                statsManager.saveStat(new GameStats(LocalDateTime.now(), settings.getFieldSize(), "Нічия"));
                break;
            }

            currentPlayer = (currentPlayer == 'X') ? 'O' : 'X';
        }
    }

    public void configureGameSettings() {
        while (true) {
            menu.showSettingsMenu();
            int settingsChoice = menu.getUserInput();

            switch (settingsChoice) {
                case 1:
                    selectFieldSize();
                    break;
                case 2:
                    settings.setPlayerXName(menu.getPlayerNameInput("Введіть нове ім'я для котика X: "));
                    configManager.saveConfig(settings);
                    break;
                case 3:
                    settings.setPlayerOName(menu.getPlayerNameInput("Введіть нове ім'я для котика O: "));
                    configManager.saveConfig(settings);
                    break;
                case 0:
                    return;
                default:
                    System.out.println("Опаньки, такого пункту немає.");
            }
        }
    }

    private void selectFieldSize() {
        menu.showFieldSizeOptions();
        int fieldChoice = menu.getUserInput();
        switch (fieldChoice) {
            case 1:
                settings.setFieldSize(3);
                break;
            case 2:
                settings.setFieldSize(5);
                break;
            case 3:
                settings.setFieldSize(7);
                break;
            case 4:
                settings.setFieldSize(9);
                break;
            default:
                System.out.println("Опаньки, такого розміру немає. Встановлено стандартний розмір 3x3.");
                settings.setFieldSize(3);
        }
        configManager.saveConfig(settings);
    }
}
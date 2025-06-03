package igrulka;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class GameStats {
    private LocalDateTime dateTime;
    private int fieldSize;
    private String winnerName;
    private char winnerSymbol;

    public GameStats(LocalDateTime dateTime, int fieldSize, String winnerName, char winnerSymbol) {
        this.dateTime = dateTime;
        this.fieldSize = fieldSize;
        this.winnerName = winnerName;
        this.winnerSymbol = winnerSymbol;
    }

    public GameStats(LocalDateTime dateTime, int fieldSize, String result) {
        this(dateTime, fieldSize, result, ' ');
    }

    public String toString() {
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");
        String dateTimeString = dateTime.format(formatter);
        if (winnerName.equals("Нічия")) {
            return "Дата та час: " + dateTimeString + ", Розмір поля: " + fieldSize + "x" + fieldSize + ", Результат: " + winnerName;
        } else {
            return "Дата та час: " + dateTimeString + ", Розмір поля: " + fieldSize + "x" + fieldSize + ", Переможець: " + winnerName + " (" + winnerSymbol + ")";
        }
    }
}
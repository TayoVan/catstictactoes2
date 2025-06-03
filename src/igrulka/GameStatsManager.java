package igrulka;

import java.io.*;
import java.time.LocalDateTime;

public class GameStatsManager {
    private static final String STATS_FILE = "catsstats.txt";

    public void saveStat(GameStats stats) {
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(STATS_FILE, true))) {
            writer.write(stats.toString());
            writer.newLine();
        } catch (IOException e) {
            System.out.println("Помилочка при збереженні статистики.");
        }
    }

    public void showStats() {
        System.out.println("{ \nСтатистика ігор котиків } :");
        try (BufferedReader reader = new BufferedReader(new FileReader(STATS_FILE))) {
            String line;
            boolean hasStats = false;
            while ((line = reader.readLine()) != null) {
                System.out.println(line);
                hasStats = true;
            }
            if (!hasStats) {
                System.out.println("Статистика ігор котиків відсутня.");
            }
        } catch (IOException e) {
            System.out.println("Помилочка при читанні файлу статистики котиків.");
        }
    }
}
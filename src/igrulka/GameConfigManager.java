package igrulka;

import java.io.*;

public class GameConfigManager {
    private static final String CONFIG_FILE = "catsconfig.txt";

    public GameSettings loadConfig() {
        int fieldSize = 3;
        String playerXName = "Гравець X";
        String playerOName = "Гравець O";

        try (BufferedReader reader = new BufferedReader(new FileReader(CONFIG_FILE))) {
            String line;
            while ((line = reader.readLine()) != null) {
                if (line.startsWith("fieldSize=")) {
                    fieldSize = Integer.parseInt(line.substring("fieldSize=".length()));
                } else if (line.startsWith("playerXName=")) {
                    playerXName = line.substring("playerXName=".length());
                } else if (line.startsWith("playerOName=")) {
                    playerOName = line.substring("playerOName=".length());
                }
            }
        } catch (IOException e) {

            System.out.println("Помилка завантаження конфігурації. Використано стандартні налаштування.");
        }
        return new GameSettings(fieldSize, playerXName, playerOName);
    }

    public void saveConfig(GameSettings settings) {
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(CONFIG_FILE))) {
            writer.write("fieldSize=" + settings.getFieldSize());
            writer.newLine();
            writer.write("playerXName=" + settings.getPlayerXName());
            writer.newLine();
            writer.write("playerOName=" + settings.getPlayerOName());
            writer.newLine();
        } catch (IOException e) {
            System.out.println("Помилочка при збереженні конфігурації.");
        }
    }
}
package igrulka;

public class GameSettings {
    private int fieldSize;
    private String playerXName;
    private String playerOName;

    public GameSettings(int fieldSize, String playerXName, String playerOName) {
        this.fieldSize = fieldSize;
        this.playerXName = playerXName;
        this.playerOName = playerOName;
    }

    public int getFieldSize() {
        return fieldSize;
    }

    public void setFieldSize(int fieldSize) {
        this.fieldSize = fieldSize;
    }

    public String getPlayerXName() {
        return playerXName;
    }

    public void setPlayerXName(String playerXName) {
        this.playerXName = playerXName;
    }

    public String getPlayerOName() {
        return playerOName;
    }

    public void setPlayerOName(String playerOName) {
        this.playerOName = playerOName;
    }
}
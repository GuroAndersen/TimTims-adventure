package timtim.app.model.sound;

public enum SoundEffect {
    CHEST("mixkit-casino-bling-achievement-2067.wav"),
    HIT("mixkit-small-hit-in-a-game-2072.wav"),
    GAMEOVER("mixkit-player-losing-or-failing-2042.wav");

    private String fileName;

    SoundEffect(String fileName) {
        this.fileName = fileName;
    }

    public String getFileName() {
        return fileName;
    }
}

package pl.monopoly.logic;

public class SettingsState {
    private static final SettingsState settingsState = new SettingsState();
    private int playersNumber = 4;
    private boolean checkedBackground = false;

    private SettingsState() {}

    public static SettingsState getInstance() {
        return settingsState;
    }

    //get/set
    public int getPlayersNumber() {
        return playersNumber;
    }

    public boolean isCheckedBackground() {
        return checkedBackground;
    }

    public void setPlayersNumber(int playersNumber) {
        this.playersNumber = playersNumber;
    }

    public void setCheckedBackground(boolean checkedBackground) {
        this.checkedBackground = checkedBackground;
    }
}

package pl.monopoly.view;

public enum Sound {
    DRAW_CLICK("drawClick"), BUTTON_CLICK("soundClickDefault"), MUSIC("music");

    private static final String AF = "src\\main\\resources\\sounds\\";
    private static final String FILE_TYPE = ".wav";
    private String name;

    Sound(String name) {
        this.name = name;
    }

    public String getFullPath() {
        return AF+name+FILE_TYPE;
    }
}

package utilis;

public enum WindowsProperties {
    WIDTH(600),
    HEIGHT(800);

    private int value;

    WindowsProperties(int value) {
        this.value = value;
    }

    public int getValue() {
        return value;
    }
}

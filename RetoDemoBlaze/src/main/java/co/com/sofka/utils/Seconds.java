package co.com.sofka.utils;

public enum Seconds {
    TEN_SECONDS(10),
    TWENTY_SECONDS(20);

    private final int value;

    Seconds(int value) {
        this.value = value;
    }

    public int getValue() {
        return value;
    }
}

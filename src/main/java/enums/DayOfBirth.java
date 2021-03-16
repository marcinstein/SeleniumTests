package enums;

public enum DayOfBirth {

    ONE("1"),
    TWO("2"),
    THREE("3"),
    FIFTEEN("15"),
    SIXTEEN("16"),
    TWENTY("20"),
    THIRTY("30");

    private String value;

    DayOfBirth(String value) {
        this.value = value;
    }

    public String getValue() {
        return value;
    }
}

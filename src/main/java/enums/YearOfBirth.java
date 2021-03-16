package enums;

public enum YearOfBirth {

    YEAR2021("2021"),
    YEAR2001("2001"),
    YEAR1981("1981");

    private String value;

    YearOfBirth(String value) {
        this.value = value;
    }

    public String getValue() {
        return value;
    }
}

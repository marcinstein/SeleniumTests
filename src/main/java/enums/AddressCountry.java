package enums;

public enum AddressCountry {

    UNITED_STATES("United States"),
    NOT_DEFINED("-");
    private String value;

    AddressCountry(String value) {
        this.value = value;
    }

    public String getValue() {
        return value;
    }
}

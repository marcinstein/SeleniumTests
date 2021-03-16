package enums;

public enum AddressState {

    ALABAMA("Alabama"),
    ALASKA("Alaska"),
    TEXAS("Texas");

    private String value;

    AddressState(String value) {
        this.value = value;
    }

    public String getValue() {
        return value;
    }
}

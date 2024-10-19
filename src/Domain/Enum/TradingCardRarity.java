package Domain.Enum;

public enum TradingCardRarity {
    COMMON("COMMON"),
    RARE("RARE"),
    ULTRA_RARE("ULTRA_RARE");

    private final String value;

    TradingCardRarity(String value) {
        this.value = value;
    }

    public String getValue() {
        return value;
    }
}

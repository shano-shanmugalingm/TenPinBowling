package au.com.senthur.bowling.dto;

/**
 * Enum to represent the Type of Hits per Roll.
 * */
public enum KnockDownType {

    STRIKE("X", 2),
    SPARE("/", 1),
    MISS("-", 0),
    PARTIAL("", 0);

    private final String indicator;
    private final int accumulationThreshold;

    KnockDownType(String indicator, int accumulationThreshold) {
        this.indicator = indicator;
        this.accumulationThreshold = accumulationThreshold;
    }

    public String getIndicator() {
        return indicator;
    }

    public int getAccumulationThreshold() {
        return accumulationThreshold;
    }

    public static KnockDownType findByIndicator(String indicator) {
        for (KnockDownType knockDownType : values()) {
            if (knockDownType.getIndicator().equals(indicator)) {
                return knockDownType;
            }
        }

        return KnockDownType.PARTIAL;
    }
}

package lotto.model;

public enum ProfitResult {
    GAIN("이득"),
    LOSS("손해");

    private static final double PROFIT_STANDARD = 1;
    private final String title;

    ProfitResult(String title) {
        this.title = title;
    }

    public String getTitle() {
        return title;
    }

    public static ProfitResult of(double profitRate) {
        return profitRate > PROFIT_STANDARD ? GAIN : LOSS;
    }
}

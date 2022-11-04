package study.lotto.domain.order;

public enum OrderType {
    MANUAL, AUTO;

    public boolean isManual() {
        return this == OrderType.MANUAL;
    }

    public boolean isAuto() {
        return this == OrderType.AUTO;
    }
}

package lotto.model.domain;

public enum BonusBallMatch {

    MUST_MATCH(1),
    DOES_NOT_MATTER(-1),
    NOT_MATCH(0);

    private final int bonusCount;

    BonusBallMatch(int bonusCount) {
        this.bonusCount = bonusCount;
    }

    public int getBonusCount() {
        return bonusCount;
    }
}

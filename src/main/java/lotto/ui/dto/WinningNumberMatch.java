package lotto.ui.dto;

import lotto.domain.lotto.Matches;

public enum WinningNumberMatch {
    BLANK(Matches.BLANK, "꽝", false),
    THREE(Matches.THREE, "3개 일치", true),
    FOUR(Matches.FOUR, "4개 일치", true),
    FIVE(Matches.FIVE, "5개 일치", true),
    SIX(Matches.SIX, "6개 일치", true),
    ;

    private final Matches matches;
    private final String label;
    private final boolean displayed;

    WinningNumberMatch(final Matches matches, final String label, final boolean displayed) {
        this.matches = matches;
        this.label = label;
        this.displayed = displayed;
    }

    public static WinningNumberMatch valueOf(Matches matches) {
        return valueOf(matches.name());
    }

    public String toStringWithCount(final long count) {
        return this.label + " (" + this.matches.getUnitPrize() + "원)- " + count + "개";
    }

    public boolean isDisplayed() {
        return this.displayed;
    }
}

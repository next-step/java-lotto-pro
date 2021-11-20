package lotto.application;

import java.util.stream.Collectors;
import lotto.domain.Playslip;
import lotto.domain.Playslips;

public class PlayslipsResponse {

    private static final String NEWLINE = "\n";

    private final Playslips playslips;
    private final int numberOfManuals;

    public PlayslipsResponse(final Playslips playslips, final int numberOfManuals) {
        this.playslips = playslips;
        this.numberOfManuals = numberOfManuals;
    }

    public Playslips getPlayslips() {
        return playslips;
    }

    public String asString() {
        final String numbers = this.playslips.getPlayslips()
            .stream()
            .map(Playslip::asString)
            .collect(Collectors.joining(NEWLINE));
        return "수동으로 "
            + numberOfManuals
            + "장, 자동으로 "
            + (playslips.size() - numberOfManuals)
            + " 개를 구매했습니다."
            + NEWLINE + numbers + NEWLINE;
    }
}

package lotto.application;

import java.util.stream.Collectors;
import lotto.domain.Playslip;
import lotto.domain.Playslips;

public class PlayslipsResponse {

    private static final String NEWLINE = "\n";

    private final Playslips playslips;

    public PlayslipsResponse(final Playslips playslips) {
        this.playslips = playslips;
    }

    public Playslips getPlayslips() {
        return playslips;
    }

    public String asString() {
        final String numbers = this.playslips.getPlayslips()
            .stream()
            .map(Playslip::asString)
            .collect(Collectors.joining(NEWLINE));
        return this.playslips.size() + "개를 구매했습니다." + NEWLINE + numbers + NEWLINE;
    }
}

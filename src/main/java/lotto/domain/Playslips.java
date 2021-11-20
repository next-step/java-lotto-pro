package lotto.domain;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Playslips {

    private final List<Playslip> playslips;

    public Playslips(final List<Playslip> playslips) {
        this.playslips = new ArrayList<>(playslips);
    }

    public Result checkResult(final WinningNumbers winningNumbers) {
        final List<Prize> resultPrizes = new ArrayList<>();
        for (Playslip playslip : playslips) {
            final Prize resultPrize = playslip.checkResult(winningNumbers);
            resultPrizes.add(resultPrize);
        }
        return new Result(Collections.unmodifiableList(resultPrizes));
    }

    public List<Playslip> getPlayslips() {
        return Collections.unmodifiableList(playslips);
    }

    public int size() {
        return playslips.size();
    }
}

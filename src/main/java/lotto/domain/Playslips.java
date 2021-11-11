package lotto.domain;

import java.util.ArrayList;
import java.util.List;

public class Playslips {

    private static final int MATCH_THREE = 3;
    private static final int MATCH_FOUR = 4;
    private static final int MATCH_FIVE = 5;
    private static final int MATCH_SIX = 6;

    private final List<Playslip> playslips;

    public Playslips(List<Playslip> playslips) {
        this.playslips = new ArrayList<>(playslips);
    }

    public int size() {
        return playslips.size();
    }

    public Result checkResult(PickedNumbers winningNumbers) {
        int numberOfPlayslipsMatchedThreeNumbers = 0;
        int numberOfPlayslipsMatchedFourNumbers = 0;
        int numberOfPlayslipsMatchedFiveNumbers = 0;
        int numberOfPlayslipsMatchedSixNumbers = 0;
        for (int i = 0; i < playslips.size(); i++) {
            numberOfPlayslipsMatchedThreeNumbers += contains(winningNumbers, MATCH_THREE, i);
            numberOfPlayslipsMatchedFourNumbers += contains(winningNumbers, MATCH_FOUR, i);
            numberOfPlayslipsMatchedFiveNumbers += contains(winningNumbers, MATCH_FIVE, i);
            numberOfPlayslipsMatchedSixNumbers += contains(winningNumbers, MATCH_SIX, i);
        }
        return new Result(
            playslips.size(),
            numberOfPlayslipsMatchedThreeNumbers,
            numberOfPlayslipsMatchedFourNumbers,
            numberOfPlayslipsMatchedFiveNumbers,
            numberOfPlayslipsMatchedSixNumbers
        );
    }

    private int contains(PickedNumbers winningNumbers, int x, int i) {
        final Playslip ithPlayslip = playslips.get(i);
        return ithPlayslip.contains(winningNumbers, x) ? 1 : 0;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        for (Playslip p : playslips) {
            sb.append(p.toString());
            sb.append("\n");
        }
        return sb.toString();
    }
}

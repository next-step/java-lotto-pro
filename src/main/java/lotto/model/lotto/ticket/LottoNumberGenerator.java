package lotto.model.lotto.ticket;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

/**
 * 1 이상 45 이하의 번호 중에서 무작위 번호를 하나 선택하는 객체이다.
 */
public class LottoNumberGenerator {
    private static final int candidateListSize = 45;
    private final List<Integer> lottoNumberCandidates;

    public LottoNumberGenerator() {
        lottoNumberCandidates = new ArrayList<>(candidateListSize);
        for (int i = 1; i <= 45; ++i) {
            lottoNumberCandidates.add(i);
        }
    }

    public int generate() {
        final Random random = new Random();
        final int randomIndex = random.ints(0, 45).findFirst().getAsInt();
        return lottoNumberCandidates.get(randomIndex);
    }
}

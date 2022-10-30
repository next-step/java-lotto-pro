package lotto.model.lotto.ticket;

import java.util.List;
import java.util.Random;

public class LottoNumberGenerator {
    private final List<Integer> lottoNumberCandidates;

    public LottoNumberGenerator(List<Integer> lottoNumberCandidates) {
        this.lottoNumberCandidates = lottoNumberCandidates;
    }

    public int generate() {
        final Random random = new Random();
        final int randomIndex = random.nextInt(lottoNumberCandidates.size());
        return lottoNumberCandidates.remove(randomIndex);
    }
}

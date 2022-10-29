package lotto.model.lotto.ticket;

import java.util.List;
import java.util.Random;
import java.util.stream.Collectors;

/**
 * 1 이상 45 이하의 번호 중에서 무작위 번호를 하나 선택하는 객체이다.
 */
public class LottoNumberGenerator {
    private final List<Integer> lottoNumberCandidates;

    public LottoNumberGenerator(List<Integer> lottoNumberCandidates) {
        this.lottoNumberCandidates = lottoNumberCandidates.stream().sorted().collect(Collectors.toList());
    }

    public int generate() {
        final Random random = new Random();
        final int randomIndex = random.ints(0, lottoNumberCandidates.size()).findFirst().getAsInt();
        return lottoNumberCandidates.get(randomIndex);
    }
}

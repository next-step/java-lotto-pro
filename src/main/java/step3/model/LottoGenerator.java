package step3.model;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class LottoGenerator {
    private static final int MIN_LOTTO_NUM = 1;
    private static final int MAX_LOTTO_NUM = 45;
    private static final int PICK_LOTTO_MIN_NUM = 0;
    private static final int PICK_LOTTO_MAX_NUM = 6;

    private final List<LottoNumber> lottoCandidateNumbers = new ArrayList<>();

    public LottoGenerator() {
        initLottoCandidateNumbers();
    }

    private void initLottoCandidateNumbers() {
        for (int i = MIN_LOTTO_NUM; i <= MAX_LOTTO_NUM; i++) {
            this.lottoCandidateNumbers.add(new LottoNumber(i));
        }
    }

    public LottoResult createLottoResult() {
        Collections.shuffle(this.lottoCandidateNumbers);
        return new LottoResult(
                new ArrayList<>(this.lottoCandidateNumbers.subList(PICK_LOTTO_MIN_NUM, PICK_LOTTO_MAX_NUM))
        );
    }
}

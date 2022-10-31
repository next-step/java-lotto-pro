package step4.model;

import step4.constant.LottoConstant;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class LottoGenerator {

    private final List<LottoNumber> lottoCandidateNumbers = new ArrayList<>();

    public LottoGenerator() {
        initLottoCandidateNumbers();
    }

    private void initLottoCandidateNumbers() {
        for (int i = LottoConstant.LOTTO_MIN_NUM; i <= LottoConstant.LOTTO_MAX_NUM; i++) {
            this.lottoCandidateNumbers.add(new LottoNumber(i));
        }
    }

    public LottoResult createLottoResult() {
        Collections.shuffle(this.lottoCandidateNumbers);
        return new LottoResult(
                new ArrayList<>(this.lottoCandidateNumbers.subList(0, LottoConstant.PICK_LOTTO_MAX_NUM))
        );
    }
}

package step4.model;

import step4.constant.LottoConstant;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class LottoGenerator {

    private static final List<LottoNumber> lottoCandidateNumbers;

    static {
        lottoCandidateNumbers = IntStream.rangeClosed(LottoConstant.LOTTO_MIN_NUM, LottoConstant.LOTTO_MAX_NUM)
                .mapToObj(LottoNumber::new).collect(Collectors.toList());
    }

    public LottoResult createLottoResult() {
        Collections.shuffle(lottoCandidateNumbers);
        return new LottoResult(
                new ArrayList<>(lottoCandidateNumbers.subList(0, LottoConstant.PICK_LOTTO_MAX_NUM))
        );
    }
}

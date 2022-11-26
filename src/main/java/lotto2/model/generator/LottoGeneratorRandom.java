package lotto2.model.generator;

import lotto2.model.Lotto;
import lotto2.model.constant.LottoConstant;
import lotto2.model.LottoNumber;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class LottoGeneratorRandom {
    public static final List<LottoNumber> fullCandidateList;

    static {
        fullCandidateList = Collections.unmodifiableList(
                IntStream.rangeClosed(LottoConstant.LOTTO_MINIMUM_NUMBER, LottoConstant.LOTTO_MAXIMUM_NUMBER)
                        .mapToObj(LottoNumber::new)
                        .collect(Collectors.toList())
        );
    }

    public static Lotto generate() {
        final List<LottoNumber> listToShuffle = new ArrayList<>(fullCandidateList);
        Collections.shuffle(listToShuffle);
        return new Lotto(new ArrayList<>(listToShuffle.subList(0, LottoConstant.COUNT_OF_NUMBER_IN_LOTTO)));
    }
}

package lotto2.model;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class LottoGenerator {
    public static final int LOTTO_MINIMUM_NUMBER = 1;
    public static final int LOTTO_MAXIMUM_NUMBER = 45;
    public static final int COUNT_OF_NUMBER_IN_LOTTO = 6;
    public static final List<LottoNumber> fullCandidateList;

    static {
        fullCandidateList = Collections.unmodifiableList(
                IntStream.rangeClosed(LOTTO_MINIMUM_NUMBER, LOTTO_MAXIMUM_NUMBER)
                        .mapToObj(LottoNumber::new)
                        .collect(Collectors.toList())
        );
    }

    public static List<LottoNumber> generate() {
        final List<LottoNumber> listToShuffle = new ArrayList<>(fullCandidateList);
        Collections.shuffle(listToShuffle);
        return new ArrayList<>(listToShuffle.subList(0, COUNT_OF_NUMBER_IN_LOTTO));
    }
}

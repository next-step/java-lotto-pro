package lotto.domain;

import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

import static lotto.domain.LottoNumber.LOTTO_MAX_NUMBER;
import static lotto.domain.LottoNumber.LOTTO_MIN_NUMBER;

public class LottoFactory {
    private static final String INPUT_LOTTO_ERROR = "잘못된 로또 번호를 입력하였습니다.";
    private static final List<LottoNumber> LOTTO_NUMBERS = IntStream.rangeClosed(LOTTO_MIN_NUMBER, LOTTO_MAX_NUMBER)
            .mapToObj(LottoNumber::from)
            .collect(Collectors.toList());
    private static final int LOTTO_NUMBERS_COUNT = 6;

    private LottoFactory() {
    }

    public static Lottos generateLottos(Money money, List<String> inputManualLottoNumbers) {
        List<Lotto> lottos = new ArrayList<>();
        for (String s : inputManualLottoNumbers) {
            lottos.add(LottoFactory.manualGenerator(s));
        }
        for (int i=0; i<money.getAutoCount(); i++) {
            lottos.add(LottoFactory.autoGenerator());
        }
        return new Lottos(lottos);
    }

    public static Lotto autoGenerator() {
        Collections.shuffle(LOTTO_NUMBERS);
        return new Lotto(
                LOTTO_NUMBERS.stream()
                .limit(LOTTO_NUMBERS_COUNT)
                .sorted()
                .collect(Collectors.toList())
        );
    }

    public static Lotto manualGenerator(String input) {
        String[] inputArr = input.replace(" ", "").split(",");
        vaildCount(inputArr);
        List<LottoNumber> list = new ArrayList<>();
        for (String s : inputArr) {
            list.add(new LottoNumber(s));
        }
        Collections.sort(list);
        return new Lotto(list);
    }

    private static void vaildCount(String[] input) {
        Set<String> set = new HashSet<>();
        Collections.addAll(set, input);
        if (set.size() != LOTTO_NUMBERS_COUNT) {
            throw new IllegalArgumentException(INPUT_LOTTO_ERROR);
        }
    }
}

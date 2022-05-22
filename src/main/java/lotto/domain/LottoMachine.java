package lotto.domain;

import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class LottoMachine {
    private final static int LOTTO_NUMBER_SIZE_VALUE = 6;
    private final static int LOTTO_NUMBER_MIN_VALUE = 1;
    private final static int LOTTO_NUMBER_MAX_VALUE = 45;

    private final static List<Integer> LOTTO_NUMBERS = IntStream.rangeClosed(LOTTO_NUMBER_MIN_VALUE, LOTTO_NUMBER_MAX_VALUE)
            .boxed()
            .collect(Collectors.toList());

    private static void shuffleNumbers() {
        Collections.shuffle(LOTTO_NUMBERS);
    }

    private static List<Integer> divideNumberList() {
        return LOTTO_NUMBERS.subList(0, LOTTO_NUMBER_SIZE_VALUE);
    }

    private static Set<Integer> issueAutoNumber() {
        shuffleNumbers();
        return new HashSet<>(divideNumberList());
    }

    public static List<Lotto> issueAutoLottos(int purchaseCount) {
        List<Lotto> lottos = new ArrayList<>();
        for (int i = 0; i < purchaseCount; i++)
            lottos.add(new Lotto(issueAutoNumber()));

        return lottos;
    }

    public static Lottos issueLottos(List<Lotto> manualLottos, int purchaseCount) {
        List<Lotto> issueLottos = manualLottos;
        List<Lotto> autoIssueLottos = issueAutoLottos(purchaseCount);
        manualLottos.addAll(autoIssueLottos);

        return new Lottos(issueLottos);
    }
}

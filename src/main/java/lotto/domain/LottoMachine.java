package lotto.domain;

import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import java.util.stream.Stream;

public class LottoMachine {
    private final static int LOTTO_NUMBER_SIZE_VALUE = 6;
    private final static int LOTTO_NUMBER_MIN_VALUE = 1;
    private final static int LOTTO_NUMBER_MAX_VALUE = 45;

    private final static List<Integer> LOTTO_NUMBERS = IntStream.rangeClosed(LOTTO_NUMBER_MIN_VALUE, LOTTO_NUMBER_MAX_VALUE)
            .boxed()
            .collect(Collectors.toList());

    public static Lottos issueLottos(List<Lotto> manualLottos, int purchaseCount) {
        int autoIssueCount = purchaseCount - manualLottos.size();
        List<Lotto> autoIssueLottos = issueAutoLottos(autoIssueCount);

        List<Lotto> issueLottos = Stream.of(manualLottos, autoIssueLottos)
                .flatMap(Collection::stream)
                .collect(Collectors.toList());

        return new Lottos(issueLottos);
    }

    public static List<Lotto> issueAutoLottos(int autoIssueCount) {
        List<Lotto> lottos = new ArrayList<>();
        for (int i = 0; i < autoIssueCount; i++)
            lottos.add(new Lotto(issueAutoNumber()));

        return lottos;
    }

    private static Set<Integer> issueAutoNumber() {
        shuffleNumbers();
        return new HashSet<>(divideNumberList());
    }

    private static void shuffleNumbers() {
        Collections.shuffle(LOTTO_NUMBERS);
    }

    private static List<Integer> divideNumberList() {
        return LOTTO_NUMBERS.subList(0, LOTTO_NUMBER_SIZE_VALUE);
    }
}

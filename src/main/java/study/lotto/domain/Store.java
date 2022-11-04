package study.lotto.domain;

import static java.util.stream.Collectors.toList;

import study.lotto.domain.number.LottoGenerator;
import study.lotto.domain.order.Order;
import study.lotto.domain.order.OrderType;
import study.splitter.Splitter;
import study.util.NumberUtil;

import java.util.*;
import java.util.stream.IntStream;
import java.util.stream.Stream;

public class Store {

    public static final int LOTTO_PRICE = 1000;

    private static final int LOTTO_MIN_NUM = 1;
    private static final int LOTTO_MAX_NUM = 45;

    private static final int LOTTO_STAT_IDX = 0;
    private static final int LOTTO_END_IDX = 6;

    private static final List<Integer> rangeOfLottoNumbers = getRangeOfLottoNumbers();

    private static List<Integer> getRangeOfLottoNumbers() {
        return IntStream.rangeClosed(LOTTO_MIN_NUM, LOTTO_MAX_NUM)
                .boxed()
                .collect(toList());
    }

    public static Lottos buyLottos(Order order) {
        List<Lotto> lottosByManual = order.orderManually();
        List<Lotto> lottosByAuto = order.orderAutomatically();

        return new Lottos(Stream.of(lottosByAuto, lottosByManual)
                .flatMap(Collection::stream)
                .collect(toList()));
    }

    public static Lotto buyLottoManually(String lotto) {
        return convertToLotto(Splitter.split(lotto));
    }

    private static Lotto convertToLotto(String[] lottoSplit) {
        return LottoGenerator.generate(Arrays.stream(lottoSplit)
                .mapToInt((str) -> NumberUtil.convertToPositiveIntNotContainsZero(str.trim()))
                .boxed()
                .collect(toList()), OrderType.MANUAL);
    }

    public static List<Lotto> buyLottosAutomatically(int quantity) {
        List<Lotto> allNumbers = new ArrayList<>();

        IntStream.range(NumberUtil.INIT_ZERO, quantity).forEach((i) -> {
            allNumbers.add(createLottoByAuto());
        });

        return allNumbers;
    }

    private static Lotto createLottoByAuto() {
        Collections.shuffle(rangeOfLottoNumbers);

        return LottoGenerator.generate(
                rangeOfLottoNumbers.subList(LOTTO_STAT_IDX, LOTTO_END_IDX), OrderType.AUTO);
    }
}

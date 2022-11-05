package lotto.domain;

import static java.util.stream.Collectors.toList;

import java.util.List;
import java.util.stream.IntStream;

public class LottoMachine {

    private static final int MINIMUM_MONEY = 0;

    private final int price;
    private final CreateLottoNumberPolicy createLottoNumberPolicy;

    public LottoMachine(int price, CreateLottoNumberPolicy createLottoNumberPolicy) {
        this.price = price;
        this.createLottoNumberPolicy = createLottoNumberPolicy;
    }

    public Lottos issue(int money, Lottos manualLottos) {
        int leftMoney = money - (price * manualLottos.size());
        if (leftMoney < MINIMUM_MONEY) {
            throw new IllegalArgumentException("금액이 부족합니다.");
        }

        int count = leftMoney / price;
        return new Lottos(createLottos(count)).combine(manualLottos);
    }

    private List<Lotto> createLottos(int count) {
        return IntStream.range(0, count)
            .mapToObj(__ -> createLottoNumberPolicy.create())
            .map(Lotto::auto)
            .collect(toList());
    }
}

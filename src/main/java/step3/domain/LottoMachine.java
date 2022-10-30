package step3.domain;

import static java.util.stream.Collectors.toList;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.IntStream;

public class LottoMachine {

    private final int price;
    private final CreateLottoNumberPolicy createLottoNumberPolicy;

    public LottoMachine(int price, CreateLottoNumberPolicy createLottoNumberPolicy) {
        this.price = price;
        this.createLottoNumberPolicy = createLottoNumberPolicy;
    }

    public Lottos issue(int money) {
        if (money < price) {
            return new Lottos(new ArrayList<>());
        }

        int count = money / price;
        return new Lottos(createLottos(count));
    }

    private List<Lotto> createLottos(int count) {
        return IntStream.range(0, count)
            .mapToObj(__ -> createLottoNumberPolicy.create())
            .map(Lotto::new)
            .collect(toList());
    }
}

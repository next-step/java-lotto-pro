package lotto.domain;

import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class AutoLottos {

    private static final int BASE_NUMBER = 0;

    private final List<Lotto> autoLottos;

    public AutoLottos(int count, Numbers numbers) {
        this.autoLottos = IntStream.range(BASE_NUMBER, count)
                .mapToObj(number -> new Lotto(numbers))
                .collect(Collectors.toList());
    }

    public List<Lotto> getAutoLottos() {
        return Collections.unmodifiableList(autoLottos);
    }
}

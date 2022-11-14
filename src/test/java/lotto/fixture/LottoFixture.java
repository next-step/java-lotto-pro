package lotto.fixture;

import lotto.domain.Lotto;
import org.junit.jupiter.params.provider.Arguments;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;
import java.util.stream.Stream;

public class LottoFixture {
    public static Lotto lotto() {
        return new Lotto(Arrays.asList(1, 2, 3, 4, 5, 6));
    }

    public static Lotto size() {
        return new Lotto(Arrays.asList(1, 2, 3, 4, 5));
    }

    public static Lotto duplicate() {
        return new Lotto(Arrays.asList(1, 2, 3, 4, 5, 5));
    }

    public static Lotto overSize() {
        return new Lotto(Arrays.asList(1, 2, 3, 4, 5, 6, 7));
    }

    public static Lotto type() {
        return new Lotto(Arrays.asList(1, 2, 3, 4, 5, Integer.parseInt("x")));
    }

    public static Lotto constructor() {
        return new Lotto(Arrays.asList(1, 2, 3, 4, 5, 6));
    }


    public static Stream<Arguments> lottoSize() {
        List<Arguments> listOfArguments = new LinkedList<>();
        listOfArguments.add(Arguments.of(Arrays.asList(1, 2, 3, 4, 5, 6, 7)));
        listOfArguments.add(Arguments.of(Arrays.asList(1, 2, 3, 4, 5)));
        return listOfArguments.stream();
    }
}

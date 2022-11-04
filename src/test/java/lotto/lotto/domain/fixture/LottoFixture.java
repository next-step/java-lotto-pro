package lotto.lotto.domain.fixture;

import lotto.lotto.domain.Lotto;

import java.util.Arrays;
import java.util.List;

public class LottoFixture {
    public static Lotto 로또번호123456() {
        return new Lotto(Arrays.asList(1, 2, 3, 4, 5, 6));
    }

    public static Lotto 로또번호123457() {
        return new Lotto(Arrays.asList(1, 2, 3, 4, 5, 7));
    }

    public static List<Lotto> lottos() {
        return Arrays.asList(로또번호123456(), 로또번호124569(), 로또번호1456910(), 로또번호45691011());
    }

    public static List<Lotto> 로또123456() {
        return Arrays.asList(로또번호123456());
    }

    private static Lotto 로또번호45691011() {
        return new Lotto(Arrays.asList(4, 5, 6, 9, 10, 11));
    }

    private static Lotto 로또번호1456910() {
        return new Lotto(Arrays.asList(1, 4, 5, 6, 9, 10));
    }

    private static Lotto 로또번호124569() {
        return new Lotto(Arrays.asList(1, 2, 4, 5, 6, 9));
    }
}

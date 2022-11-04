package lotto;

import com.sun.tools.javac.util.List;

public class LottosFixture {
    public static Lottos 로또번호123456() {
        return new Lottos(List.of(1, 2, 3, 4, 5, 6));
    }

    public static Lottos 로또번호123457() {
        return new Lottos(List.of(1, 2, 3, 4, 5, 7));
    }
}

package lotto;

public class LottosFixture {
    public static Lottos 로또번호123456() {
        Lottos lottos = new Lottos();
        lottos.add(new Lotto(1));
        lottos.add(new Lotto(2));
        lottos.add(new Lotto(3));
        lottos.add(new Lotto(4));
        lottos.add(new Lotto(5));
        lottos.add(new Lotto(6));
        return lottos;
    }

    public static Lottos 로또번호123457() {
        Lottos lottos = new Lottos();
        lottos.add(new Lotto(1));
        lottos.add(new Lotto(2));
        lottos.add(new Lotto(3));
        lottos.add(new Lotto(4));
        lottos.add(new Lotto(5));
        lottos.add(new Lotto(7));
        return lottos;
    }
}

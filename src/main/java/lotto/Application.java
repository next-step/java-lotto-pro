package lotto;

import lotto.model.Lottos;

public class Application {
    public static void main(String[] args) {
        Lottos lottos = Lottos.generateAuto(4);
        lottos.print();
    }
}

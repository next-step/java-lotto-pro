package lotto;

import lotto.model.Lotto;

import java.util.List;

public class Application {
    public static void main(String[] args) {
        List<Integer> list = NumberUtils.generateRandomNumbers(6, 1, 45);
        Lotto lotto = Lotto.generate(list);
        System.out.println(lotto);
    }
}

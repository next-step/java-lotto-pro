package lotto.winning.domain;

import lotto.winning.domain.WinningMoneyCalculator;

import java.util.ArrayList;
import java.util.List;

public class WinningMoneyCalculatorFixture {
    public static WinningMoneyCalculator 일치갯수3() {
        return new WinningMoneyCalculator(3, 1);
    }

    public static WinningMoneyCalculator 일치갯수4() {
        return new WinningMoneyCalculator(4, 1);
    }

    public static WinningMoneyCalculator 일치갯수5() {
        return new WinningMoneyCalculator(5, 1);
    }

    public static WinningMoneyCalculator 일치갯수6() {
        return new WinningMoneyCalculator(6, 1);
    }

    public static List<WinningMoneyCalculator> list() {
        List<WinningMoneyCalculator> list = new ArrayList<>();
        list.add(일치갯수3());
        list.add(일치갯수4());
        list.add(일치갯수5());
        list.add(일치갯수6());
        return list;
    }
}

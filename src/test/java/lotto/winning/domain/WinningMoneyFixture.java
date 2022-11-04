package lotto.winning.domain;

import java.util.ArrayList;
import java.util.List;

public class WinningMoneyFixture {
    public static WinningMoney 일치갯수3() {
        return new WinningMoney(3, 1);
    }

    public static WinningMoney 일치갯수4() {
        return new WinningMoney(4, 1);
    }

    public static WinningMoney 일치갯수5() {
        return new WinningMoney(5, 1);
    }

    public static WinningMoney 일치갯수6() {
        return new WinningMoney(6, 1);
    }

    public static List<WinningMoney> list() {
        List<WinningMoney> list = new ArrayList<>();
        list.add(일치갯수3());
        list.add(일치갯수4());
        list.add(일치갯수5());
        list.add(일치갯수6());
        return list;
    }
}

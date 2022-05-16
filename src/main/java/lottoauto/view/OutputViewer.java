package lottoauto.view;

import lottoauto.util.YieldCalculator;
import lottoauto.wrapper.Price;

import java.util.Map;

public class OutputViewer {
    private static final String FOURTH_STR = "3개 일치(5000원)-";
    private static final String THIRD_STR = "4개 일치(50000원)-";
    private static final String SECOND_STR = "5개 일치(1500000원)-";
    private static final String FIRST_STR = "6개 일치(2000000000원)-";
    private static final int FOURTH = 3;
    private static final int THIRD = 4;
    private static final int SECOND = 5;
    private static final int FIRST = 6;
    public OutputViewer(Map<Integer, Integer> winNumbers, Price price) {
        System.out.println(FIRST_STR+" "+winNumbers.get(FIRST));
        System.out.println(SECOND_STR+" "+winNumbers.get(SECOND));
        System.out.println(THIRD_STR+" "+winNumbers.get(THIRD));
        System.out.println(FOURTH_STR+" "+winNumbers.get(THIRD));
        System.out.println("총 수익률은 "+ YieldCalculator.getYield(price.getPrice(), FIRST, SECOND, THIRD, FOURTH) +"입니다.");
    }
}

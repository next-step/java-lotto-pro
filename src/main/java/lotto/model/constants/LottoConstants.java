package lotto.model.constants;

import java.util.ArrayList;
import java.util.List;
import lotto.model.domain.WinCriteria;
import lotto.model.domain.WinCriterion;

public class LottoConstants {

    public static final int LOTTO_NUMBER_COUNT = 6;
    public static final int LOTTO_NUMBER_MIN = 1;
    public static final int LOTTO_NUMBER_MAX = 45;
    public static final String WIN_LOTTO_DELIMITER = "[ ]*,[ ]*";

    public static final List<Integer> LOTTO_NUMBER_POOL = new ArrayList<Integer>() {
        {
            for (int i = LOTTO_NUMBER_MIN; i < LOTTO_NUMBER_MAX; i++) {
                add(i);
            }
        }
    };

    public static final long LOTTO_UNIT_PRICE = 1000;
    public static final String LOTTO_PRINT_START = "[";
    public static final String LOTTO_PRINT_END = "]";
    public static final String LOTTO_PRINT_DELIMITER = ", ";

    public static final WinCriteria LOTTO_WIN_CRITERIA = new WinCriteria() {
        {
            addWinCriterion(new WinCriterion(1, 6, 2000000000));
            addWinCriterion(new WinCriterion(2, 5, 1500000));
            addWinCriterion(new WinCriterion(3, 4, 50000));
            addWinCriterion(new WinCriterion(4, 3, 5000));
        }
    };
}

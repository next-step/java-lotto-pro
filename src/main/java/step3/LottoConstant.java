package step3;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class LottoConstant {

    public static String LOTTO_DELIMITER = ",";
    public static int LOTTO_ELEMENTS_SIZE = 6;
    public static int LOTTO_PRICE = 1000;
    public static int LOTTO_MIN = 1;
    public static int LOTTO_MAX = 46;
    public static List<Integer> LOTTO_VALID_ELEMENTS = IntStream.rangeClosed(LOTTO_MIN, LOTTO_MAX).boxed().collect(Collectors.toList());
    public static int LOTTO_SIX_NUMBER_REWARD = 2000000000;
    public static int SIX_NUMBER_MATCH = 6;
    public static int LOTTO_FIVE_NUMBER_REWARD = 1500000;
    public static int FIVE_NUMBER_MATCH = 5;
    public static int LOTTO_FOUR_NUMBER_REWARD = 50000;
    public static int FOUR_NUMBER_MATCH = 4;
    public static int LOTTO_THREE_NUMBER_REWARD = 5000;
    public static int THREE_NUMBER_MATCH = 3;
    public static String OVERVIEW_FORMAT = "%s개 일치 (%s)- %s개";
    public static String REWARDRATE_FORMAT = "총 수익률은 %.2f입니다.(기준이 1이기 때문에 결과적으로 %s라는 의미임)";
    public static String LOTTOS_INFO_FORMAT = "%s개를 구매했습니다.";
}

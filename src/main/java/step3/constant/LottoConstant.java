package step3.constant;

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
    public static String OVERVIEW_FORMAT = "%s개 일치 (%s원)- %s개";
    public static String REWARDRATE_FORMAT = "총 수익률은 %.2f입니다.(기준이 1이기 때문에 결과적으로 %s라는 의미임)";
    public static String LOTTOS_INFO_FORMAT = "%s개를 구매했습니다.";
}

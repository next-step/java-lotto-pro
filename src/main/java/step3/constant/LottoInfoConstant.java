package step3.constant;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class LottoInfoConstant {

    public static String LOTTO_DELIMITER = ",";
    public static int LOTTO_ELEMENTS_SIZE = 6;
    public static int LOTTO_PRICE = 1_000;
    public static int LOTTO_MIN = 1;
    public static int LOTTO_MAX = 46;
    public static List<Integer> LOTTO_VALID_ELEMENTS = IntStream.rangeClosed(LOTTO_MIN, LOTTO_MAX).boxed().collect(Collectors.toList());

}

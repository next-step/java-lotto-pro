package step3.lotto.utils;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

/**
 * @author : choi-ys
 * @date : 2022/05/17 1:58 오후
 */
public class LottoNumberUtils {

    private static final int LOTTO_NUMBER_START_RANGE = 1;
    private static final int LOTTO_NUMBER_END_RANGE = 45;
    private static final int LOTTO_NUMBER_COUNT = 6;
    private static final int[] lottoRangeNumbers = initLottoRangeNumbers();

    private static int[] initLottoRangeNumbers() {
        final int[] numbers = new int[LOTTO_NUMBER_END_RANGE];

        for (int i = 0; i < LOTTO_NUMBER_END_RANGE; i++) {
            numbers[i] = i + 1;
        }
        return numbers;
    }

    public static List<Integer> generateLottoNumbers() {
        List<Integer> list = intArrayToList(lottoRangeNumbers);
        return subList(shuffle(list));
    }

    private static List<Integer> intArrayToList(int[] numbers) {
        return Arrays.stream(numbers)
            .boxed()
            .collect(Collectors.toList());
    }

    private static List<Integer> shuffle(List<Integer> numbers) {
        List<Integer> copyNumbers = new ArrayList<>(numbers);
        Collections.shuffle(copyNumbers);
        return copyNumbers;
    }

    private static List<Integer> subList(List<Integer> numbers) {
        return numbers.subList(LOTTO_NUMBER_START_RANGE, LOTTO_NUMBER_COUNT + 1);
    }
}

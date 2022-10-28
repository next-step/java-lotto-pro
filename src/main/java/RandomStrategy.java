import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class RandomStrategy implements NumberStrategy {

    // TODO 다른방향으로 수정
    private static final List<Integer> lottoNumberArrange
            = Arrays.asList(1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12, 13, 14, 15, 16, 17, 18, 19, 20, 21, 22, 23, 24, 25, 26, 27, 28, 29, 30, 31, 32, 33, 34, 35, 36, 37, 38, 39, 40, 41, 42, 43, 44, 45);

    @Override
    public List<Integer> shuffle() {
        Collections.shuffle(lottoNumberArrange);
        return lottoNumberArrange.subList(0, 6);
    }
}

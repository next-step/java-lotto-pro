import java.util.Collections;
import java.util.List;
import java.util.Objects;

public class LottoNumber {

    List<Integer> number;

    public LottoNumber(NumberStrategy numberStrategy) {
        List<Integer> shuffle = numberStrategy.shuffle();
        Collections.sort(shuffle);
        this.number = shuffle;
    }

    @Override
    public String toString() {
        return "" + number + "";
    }
}

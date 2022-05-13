package camp.nextstep.edu.step3;

import java.math.BigDecimal;
import java.nio.file.Path;
import java.util.Arrays;
import java.util.List;
import java.util.Objects;
import java.util.function.DoublePredicate;
import java.util.function.IntPredicate;
import java.util.function.LongPredicate;
import java.util.stream.DoubleStream;
import java.util.stream.IntStream;
import java.util.stream.LongStream;

public class LottoPaper {
    private final List<Lotto> lottoList;

    public LottoPaper(Lotto... lottoArray) {
        validation(lottoArray);
        this.lottoList = Arrays.asList(lottoArray);
    }

    private void validation(Lotto[] lottoArray) {
        if (Objects.isNull(lottoArray) || lottoArray.length < 1 ) {
            throw new IllegalArgumentException("invalid input");
        }
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        LottoPaper that = (LottoPaper) o;
        return Objects.equals(lottoList, that.lottoList);
    }

    @Override
    public int hashCode() {
        return Objects.hash(lottoList);
    }
}

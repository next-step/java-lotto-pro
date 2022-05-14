import java.util.Arrays;
import java.util.Iterator;
import java.util.List;
import java.util.stream.Stream;

public class LottoNumbers implements Iterable<LottoNumber> {
    public static final int SIZE = 6;
    private final List<LottoNumber> lottoNumbers;

    public LottoNumbers(LottoNumber... lottoNumbers) {
        check(lottoNumbers);
        this.lottoNumbers = Arrays.asList(lottoNumbers);
    }

    private void check(LottoNumber... lottoNumbers) {
        if (lottoNumbers.length != SIZE) {
            throw new RuntimeException();
        }

        if (hasDuplicate(lottoNumbers)) {
            throw new RuntimeException();
        }
    }

    private boolean hasDuplicate(LottoNumber... lottoNumbers) {
        return lottoNumbers.length != Stream.of(lottoNumbers).distinct().count();
    }

    public boolean contains(LottoNumber lottoNumber) {
        return this.lottoNumbers.contains(lottoNumber);
    }

    @Override
    public Iterator<LottoNumber> iterator() {
        return this.lottoNumbers.iterator();
    }
}

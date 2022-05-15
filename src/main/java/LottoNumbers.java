import java.util.Arrays;
import java.util.Iterator;
import java.util.List;
import java.util.stream.Collectors;

public class LottoNumbers implements Iterable<LottoNumber> {
    public static final int SIZE = 6;
    private final List<LottoNumber> lottoNumbers;

    public LottoNumbers(LottoNumber... lottoNumbers) {
        check(Arrays.asList(lottoNumbers));
        this.lottoNumbers = Arrays.asList(lottoNumbers);
    }

    public LottoNumbers(List<LottoNumber> lottoNumbers) {
        check(lottoNumbers);
        this.lottoNumbers = lottoNumbers;
    }

    private void check(List<LottoNumber> lottoNumbers) {
        if (lottoNumbers.size() != SIZE) {
            throw new RuntimeException();
        }

        if (hasDuplicate(lottoNumbers)) {
            throw new RuntimeException();
        }
    }

    private boolean hasDuplicate(List<LottoNumber> lottoNumbers) {
        return lottoNumbers.size() != lottoNumbers.stream().distinct().count();
    }

    public boolean contains(LottoNumber lottoNumber) {
        return this.lottoNumbers.contains(lottoNumber);
    }

    @Override
    public Iterator<LottoNumber> iterator() {
        return this.lottoNumbers.iterator();
    }

    @Override
    public String toString() {
        return "[" +
                this.lottoNumbers.stream()
                        .map(LottoNumber::toString)
                        .collect(Collectors.joining(", ")) +
                "]";
    }
}

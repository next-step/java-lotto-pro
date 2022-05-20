import java.util.Arrays;
import java.util.Iterator;
import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;

public class LottoNumbers implements Iterable<LottoNumber> {
    public static final int SIZE = 6;
    private final List<LottoNumber> lottoNumbers;

    public LottoNumbers(String lottoNumbers, String separator) {
        this(Arrays.stream(lottoNumbers.split(separator))
                .map(splitLottoNumber -> new LottoNumber(Integer.parseInt(splitLottoNumber)))
                .collect(Collectors.toList()));
    }

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
            throw new IllegalArgumentException("로또 번호의 수는 총 6자리여야 합니다. ");
        }

        if (hasDuplicate(lottoNumbers)) {
            throw new IllegalArgumentException("로또 번호의 수는 중복될 수 없습니다.");
        }
    }

    private boolean hasDuplicate(List<LottoNumber> lottoNumbers) {
        return lottoNumbers.size() != lottoNumbers.stream().distinct().count();
    }

    public boolean contains(LottoNumber lottoNumber) {
        return this.lottoNumbers.contains(lottoNumber);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (!(o instanceof LottoNumbers)) {
            return false;
        }
        LottoNumbers that = (LottoNumbers) o;
        return this.lottoNumbers.size() == that.lottoNumbers.size() && this.lottoNumbers.containsAll(that.lottoNumbers);
    }

    @Override
    public int hashCode() {
        return Objects.hash(lottoNumbers);
    }

    @Override
    public Iterator<LottoNumber> iterator() {
        return this.lottoNumbers.iterator();
    }

    @Override
    public String toString() {
        return "[" + this.lottoNumbers.stream().map(LottoNumber::toString).collect(Collectors.joining(", ")) + "]";
    }
}

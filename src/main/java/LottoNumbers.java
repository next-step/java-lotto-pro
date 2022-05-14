import java.util.Arrays;
import java.util.List;

public class LottoNumbers {
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
    }

    public boolean contains(LottoNumber lottoNumber) {
        return lottoNumbers.contains(lottoNumber);
    }
}

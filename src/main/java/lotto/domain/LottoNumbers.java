package lotto.domain;

import java.util.*;
import java.util.stream.Collectors;

public class LottoNumbers {

    private static final int LOTTO_SIZE = 6;
    private static final String NUMBER_SPLIT_REGEX = ",";
    private static final List<LottoNumber> GENERATE_LOTTO_NUMBERS = new ArrayList<>();
    private final List<LottoNumber> lottoNumbers;

    static {
        for (int i = LottoNumber.LOTTO_MIN_NUMBER; i <= LottoNumber.LOTTO_MAX_NUMBER; i++) {
            GENERATE_LOTTO_NUMBERS.add(LottoNumber.of(i));
        }
    }

    private LottoNumbers(List<LottoNumber> lottoNumbers) {
        validateLottoSize(lottoNumbers);
        this.lottoNumbers = lottoNumbers;
    }

    public static LottoNumbers generate() {
        Collections.shuffle(GENERATE_LOTTO_NUMBERS);
        return new LottoNumbers(GENERATE_LOTTO_NUMBERS.stream().limit(LOTTO_SIZE).collect(Collectors.toList()));
    }

    public static LottoNumbers generate(String numbers) {
        return new LottoNumbers(from(numbers));
    }

    public static LottoNumbers generate(List<Integer> numbers) {
        return new LottoNumbers(from(numbers));
    }

    private static List<LottoNumber> from(String numbers) {
        return Arrays.stream(numbers.split(NUMBER_SPLIT_REGEX))
                .map(LottoNumber::of)
                .collect(Collectors.toList());
    }

    private static List<LottoNumber> from(List<Integer> numbers) {
        return numbers.stream().map(LottoNumber::of).collect(Collectors.toList());
    }

    private void validateLottoSize(List<LottoNumber> lottoNumbers) {
        if (new HashSet<>(lottoNumbers).size() != LOTTO_SIZE) {
            throw new IllegalArgumentException(String.format("로또 번호는 %d개가 필요합니다.", LOTTO_SIZE));
        }
    }

    public int match(LottoNumbers target) {
        return (int) lottoNumbers.stream().filter(target::contains).count();
    }

    private boolean contains(LottoNumber lottoNumber) {
        return lottoNumbers.contains(lottoNumber);
    }


    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof LottoNumbers)) return false;
        LottoNumbers that = (LottoNumbers) o;
        return Objects.equals(lottoNumbers, that.lottoNumbers);
    }

    @Override
    public int hashCode() {
        return Objects.hash(lottoNumbers);
    }

    @Override
    public String toString() {
        return "LottoNumbers{" +
                "lottoNumbers=" + lottoNumbers +
                '}';
    }
}

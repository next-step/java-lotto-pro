package lotto_auto.model;

import java.util.*;

import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class LottoNumbers {
    List<LottoNumber> lottoNumberList;

    public static final int VALID_SIZE = 6;
    public static final String LOTTO_DELIMITER = ", ";

    public static final String NOT_MATCHED_NUMBER_SIZE = "[ERROR] 로또 번호는 6개의 숫자가 필요합니다.";
    public static final String EXIST_DUPLICATE_VALUE = "[ERROR] 로또 번호는 중복 숫자가 존재할 수 없습니다.";

    public LottoNumbers() {
        this.lottoNumberList = generateRandomLottoNumbers();
    }

    public LottoNumbers(String stringNumbers) {
        this.lottoNumberList = Arrays.stream(stringNumbers.split(LOTTO_DELIMITER))
                .map(LottoNumber::new)
                .collect(Collectors.toList());
        checkNumbersSize();
        checkDuplicateNumber();
    }

    private void checkNumbersSize() {
        if (!(lottoNumberList.size() == VALID_SIZE)) {
            throw new IllegalArgumentException(NOT_MATCHED_NUMBER_SIZE);
        }
    }

    private void checkDuplicateNumber() {
        Set<LottoNumber> lottoNumbersSet = new HashSet<>();
        boolean isUnique = this.lottoNumberList.stream().allMatch(lottoNumbersSet::add);

        if (!isUnique) {
            throw new IllegalArgumentException(EXIST_DUPLICATE_VALUE);
        }
    }

    public List<LottoNumber> getLottoNumberList() {
        return lottoNumberList;
    }

    public int countSameLottoNumber(LottoNumbers numbers) {
        return (int) this.lottoNumberList
                .stream()
                .filter(lottoNumber -> numbers.getLottoNumberList().contains(lottoNumber)).count();
    }

    private List<Integer> getRandomNumberList() {
        List<Integer> numbers = IntStream
                .range(LottoNumber.MIN_NUMBER, LottoNumber.MAX_NUMBER + 1)
                .boxed()
                .collect(Collectors.toList());
        Collections.shuffle(numbers);
        return numbers.subList(0, LottoNumbers.VALID_SIZE);
    }

    private List<LottoNumber> generateRandomLottoNumbers() {
        return getRandomNumberList()
                .stream()
                .map(LottoNumber::new)
                .collect(Collectors.toList());
    }

}

package lotto.domain;

import java.util.*;

public class Lotto {

    private static final int LOTTO_LENGTH = 6;
    private static final String SPACE = " ";
    private static final String BLANK = "";
    private static final String SQUARE_BRACKET_LEFT = "[";
    private static final String SQUARE_BRACKET_RIGHT = "]";
    private static final String PATTERN = "^[0-9,]*$";
    private static final String DELIMITER = ",";
    private static final String INVALID_LENGTH_MESSAGE = "로또 당첨 번호는 6자리여야 합니다.";
    private static final String INVALID_DELIMITER_MESSAGE = "로또 당첨 번호는 ,(콤마)로 구분되어야 합니다.";
    private static final String DUPLICATE_NUMBER_MESSAGE = "로또 당첨 번호는 중복되지 않은 값이어야 합니다.";
    private List<LottoNumber> lotto;

    public Lotto() {
        this.lotto = new AutoLottoGenerator().getShuffledNum();
    }

    public Lotto(String input) {
        String[] nums = validateInput(input);
        setLottoNum(nums);
    }

    private String[] validateInput(String input) {

        String[] nums = validateDelimiter(input);

        validateLottoLength(nums.length);

        validateNonDuplicate(nums);

        return nums;
    }

    private String[] validateDelimiter(String input) {
        input = input.replace(SPACE, BLANK);

        if (!input.matches(PATTERN)) {
            throw new IllegalArgumentException(INVALID_DELIMITER_MESSAGE);
        }

        return input.split(DELIMITER);
    }

    private void validateLottoLength(int length) {
        if (length != LOTTO_LENGTH ) {
            throw new IllegalArgumentException(INVALID_LENGTH_MESSAGE);
        }
    }

    private void validateNonDuplicate(String[] nums) {
        Set<String> set = new HashSet<>(Arrays.asList(nums));
        if (set.size() != LOTTO_LENGTH) {
            throw new IllegalArgumentException(DUPLICATE_NUMBER_MESSAGE);
        }
    }

    private void setLottoNum(String[] nums) {
        lotto = new ArrayList<>();
        Arrays.stream(nums).forEach(num -> lotto.add(new LottoNumber(num)));
    }

    public List<LottoNumber> getLotto() {
        return Collections.unmodifiableList(lotto);
    }

    public boolean isContained(LottoNumber number) {
        return lotto.contains(number);
    }

    public int countMatchNum(Lotto winLotto) {
        return (int) lotto.stream().filter(winLotto::isContained).count();
    }

    @Override
    public String toString() {
        StringBuilder reportLotto = new StringBuilder();
        reportLotto.append(SQUARE_BRACKET_LEFT);

        for (LottoNumber lottoNumber : lotto) {
            reportLotto.append(lottoNumber.toString() + DELIMITER + SPACE);
        }

        reportLotto = reportLotto.delete(reportLotto.length()-2, reportLotto.length());

        return reportLotto.append(SQUARE_BRACKET_RIGHT).toString();
    }
}

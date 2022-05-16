package lotto.lotto;

import lotto.util.StringUtils;
import java.util.regex.Pattern;

public class CommaSplittingLottoGenerator implements LottoGenerator {

    private static final String INVALID_MESSAGE = "LottoGenerator 생성 실패했습니다. (입력값: %s)";
    private final String value;
    private final Pattern pattern = Pattern.compile(",");

    public CommaSplittingLottoGenerator(String value) {
        if (StringUtils.isEmpty(value)) {
            throw new FailureCreatingLottoGeneratorException(String.format(INVALID_MESSAGE, value));
        }
        this.value = value;
    }

    @Override
    public Lotto generate() {
        final String[] maybeNumbers = pattern.split(value);
        return Lotto.of(maybeNumbers);
    }
}

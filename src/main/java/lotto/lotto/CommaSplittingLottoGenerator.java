package lotto.lotto;

import java.util.regex.Pattern;

class CommaSplittingLottoGenerator implements LottoGenerator {

    private final String value;
    private final Pattern pattern = Pattern.compile(",");

    CommaSplittingLottoGenerator(String value) {
        if (value == null || value.isEmpty()) {
            throw new FailureCreatingLottoGeneratorException(value);
        }
        this.value = value;
    }

    @Override
    public Lotto generate() {
        final String[] maybeNumbers = pattern.split(value);
        return Lotto.of(maybeNumbers);
    }
}

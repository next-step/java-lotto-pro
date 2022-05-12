package lotto.lotto;

import java.util.regex.Pattern;

class StringSplittingLottoGenerator implements LottoGenerator {

    private final String value;
    private final Pattern pattern;

    StringSplittingLottoGenerator(String value, String delimiter) {
        if (value == null || value.isEmpty()) {
            throw new FailureCreatingLottoGeneratorException(value, delimiter);
        }
        if (delimiter == null || delimiter.isEmpty()) {
            throw new FailureCreatingLottoGeneratorException(value, delimiter);
        }
        this.value = value;
        this.pattern = Pattern.compile(String.format("[%s]", delimiter));
    }

    @Override
    public Lotto generate() {
        final String[] maybeNumbers = pattern.split(value);
        return Lotto.of(maybeNumbers);
    }
}

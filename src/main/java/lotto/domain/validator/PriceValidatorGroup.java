package lotto.domain.validator;

import java.util.Arrays;
import java.util.List;
import lotto.domain.validator.impl.PriceLessThanValidator;
import lotto.domain.validator.impl.PriceUnitMatchedValidator;

public class PriceValidatorGroup {

    private final List<PriceValidator> validators;

    private PriceValidatorGroup() {
        this.validators = Arrays.asList(
            new PriceLessThanValidator(),
            new PriceUnitMatchedValidator()
        );
    }

    private static class LazyHolder {

        private static PriceValidatorGroup instance = new PriceValidatorGroup();
    }

    public static PriceValidatorGroup getInstance() {
        return LazyHolder.instance;
    }

    public void validate(int price) {
        this.validators.forEach(validator -> validator.validate(price));
    }
}

package lotto.domain.lottonumber.purchase.factory.validation;

import java.util.Arrays;
import java.util.List;

public class DefaultPurchaseValidator implements PurchaseValidator {

    private List<PurchaseValidator> validators;

    public DefaultPurchaseValidator() {
        validators = Arrays.asList(new NumberValidator(), new MinCostValidator(), new RemainderValidator());
    }

    @Override
    public void validate(String purchase) {
        for (PurchaseValidator validator : validators) {
            validator.validate(purchase);
        }
    }
}

package lotto.domain;

import lotto.domain.validator.NumberValidator;
import lotto.domain.validator.impl.NumberFormatValidator;

import java.util.ArrayList;
import java.util.List;

public class Quantity {

    private final int quantity;
    private static final NumberValidator numberValidator = new NumberFormatValidator();

    public Quantity(String quantity) {
        numberValidator.validate(quantity);
        this.quantity = Integer.parseInt(quantity);
    }

    public int getQuantity() {
        return quantity;
    }
}

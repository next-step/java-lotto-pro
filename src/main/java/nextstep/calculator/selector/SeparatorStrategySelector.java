package nextstep.calculator.selector;

import nextstep.calculator.domain.BaseSeparator;
import nextstep.calculator.domain.CustomSeparator;
import nextstep.calculator.domain.SeparatorStrategy;
import org.apache.commons.lang3.StringUtils;


public class SeparatorStrategySelector {

    private String inputText;

    public SeparatorStrategySelector(String inputText) {
        this.inputText = inputText;
    }

    public SeparatorStrategy selectSeparatorStrategy() {
        if (isContainsCustomSeparator()) {
            return new CustomSeparator();
        }

        return new BaseSeparator();
    }

    private Boolean isContainsCustomSeparator() {
        return StringUtils.contains(this.inputText, CustomSeparator.PREFIX)
                && StringUtils.contains(this.inputText, CustomSeparator.POSTFIX);
    }
}

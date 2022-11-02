package step3.enums;

public enum Rule {

    TOTAL_START_NUMBER(1),
    TOTAL_END_NUMBER(45),
    LOTTO_START_NUMBER(0),
    LOTTO_END_NUMBER(6);

    private int range;

    Rule(int range) {
        this.range = range;
    }

    public int getRange() {
        return range;
    }

    public static boolean isRuleApplied(int lottoNumber) {
        return Rule.TOTAL_START_NUMBER.getRange() <= lottoNumber
                && lottoNumber <= Rule.TOTAL_END_NUMBER.getRange();
    }

}

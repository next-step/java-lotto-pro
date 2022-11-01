package step3.model.value;

public class Rule {



    private Rule() {
        throw new AssertionError();
    }
    public static final int MAX_LOTTO_NUM = 45;
    public static final int MIN_LOTTO_NUM = 1;

    public static final int AUTO_GENERATE_START_NUM = 0;

    public static final int AUTO_GENERATE_END_NUM = 6;
    public static final int LOTTO_NUMBER_LENGTH = 6;
    public static final int TICKET_PRICE = 1_000;
    public static final int BONUS_COUNT_NUMBER = 5;
    public static final String DELIMITER = ",";

}

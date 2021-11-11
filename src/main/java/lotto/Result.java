package lotto;

public class Result {

    public static final Price FIRST_PRIZE = new Price(2_000_000_000L);
    public static final Price SECOND_PRIZE = new Price(1_500_000L);
    public static final Price THIRD_PRIZE = new Price(50_000L);
    public static final Price FOURTH_PRIZE = new Price(5_000L);

    private final int numberOfPayslips;
    private final int matchedThreeNumbers;
    private final int matchedFourNumbers;
    private final int matchedFiveNumbers;
    private final int matchedSixNumbers;

    public Result(
        final int numberOfPayslips,
        final int matchedThreeNumbers,
        final int matchedFourNumbers,
        final int matchedFiveNumbers,
        final int matchedSixNumbers
    ) {
        this.numberOfPayslips = numberOfPayslips;
        this.matchedThreeNumbers = matchedThreeNumbers;
        this.matchedFourNumbers = matchedFourNumbers;
        this.matchedFiveNumbers = matchedFiveNumbers;
        this.matchedSixNumbers = matchedSixNumbers;
    }

    public int getMatchedThreeNumbers() {
        return matchedThreeNumbers;
    }

    public int getMatchedFourNumbers() {
        return matchedFourNumbers;
    }

    public int getMatchedFiveNumbers() {
        return matchedFiveNumbers;
    }

    public int getMatchedSixNumbers() {
        return matchedSixNumbers;
    }

    public double calculateReturnOnInvestment() {
        final long totalPrize = calculateTotalPrize().getValue();
        final long investedAmount = new Price(numberOfPayslips).getValue();
        double roi;
        try {
            roi = (double) totalPrize / investedAmount;
        } catch (Exception ex) {
            throw new IllegalStateException();
        }
        return roi;
    }

    private Price calculateTotalPrize() {
        return calculateFirstPrize()
            .add(calculateSecondPrize())
            .add(calculateThirdPrize())
            .add(calculateFourthPrize());
    }

    private Price calculateFirstPrize() {
        return FIRST_PRIZE.multiply(getMatchedSixNumbers());
    }

    private Price calculateSecondPrize() {
        return SECOND_PRIZE.multiply(getMatchedFiveNumbers());
    }

    private Price calculateThirdPrize() {
        return THIRD_PRIZE.multiply(getMatchedFourNumbers());
    }

    private Price calculateFourthPrize() {
        return FOURTH_PRIZE.multiply(getMatchedThreeNumbers());
    }
}

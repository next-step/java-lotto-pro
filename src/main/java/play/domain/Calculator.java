package play.domain;

public class Calculator {
    public static final int LOTTO_PRICE = 1000;
    private static final String NUMBER_REGEX = "[0-9]+";
    //private final Lottos lottos;

    public Calculator() {
        //this.lottos = buyLotto(inputMoney);
    }

//    public Lottos getLottos() {
//        return this.lottos;
//    }

    public Lottos buyLotto(String inputMoney) {
        validInputMoney(inputMoney);

        int lottoAmount = calculateLottoAmount(inputMoney);

        //Lottos lottos = new Lottos(lottoAmount);
        return new Lottos(lottoAmount);

        //return lottos;
    }

    private int calculateLottoAmount(String input) {
        int purchasePrice = Integer.parseInt(input);

        int lottoAmount = purchasePrice / LOTTO_PRICE;

        return lottoAmount;
    }

    private void validInputMoney(String inputMoney) {
        validNullOrEmpty(inputMoney);
        validNumber(inputMoney);
    }

    private static void validNumber(String input) {
        if (isNumber(input)) {
            throw new IllegalArgumentException("금액은 숫자로 입력해주세요");
        }
    }

    private static boolean isNumber(String input) {
        return !input.matches(NUMBER_REGEX);
    }

    private void validNullOrEmpty(String input) {
        if (isNullOrEmpty(input)) {
            throw new IllegalArgumentException("금액을 입력해주세요");
        }
    }

    private boolean isNullOrEmpty(String input) {
        return input == null || input.isEmpty();
    }
}

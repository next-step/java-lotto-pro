package lotto.model;

public class Coin {
    private final int deposit;

    public Coin(String money) {
        invalidMoneyCheck(money);
        deposit = Integer.parseInt(money);
    }

    public double getDeposit() {
        return deposit;
    }

    public int buyLottoTicket(int lottoPrice) {
        return deposit / lottoPrice;
    }

    private void invalidMoneyCheck(String money) {
        try {
            Integer.parseInt(money);
        } catch (Exception e) {
            throw new IllegalArgumentException("유효하지 않은 값입니다.");
        }
    }
}

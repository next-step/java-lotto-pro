package lotto.model;

public class LottoNo {
    private final int lottoNo;

    public LottoNo(int no) {
        this.lottoNo = checkLottoNumber(no);
    }

    public int value() {
        return lottoNo;
    }

    private int checkLottoNumber(int no) {
        if (no > 45 || no < 1 ) {
            throw new IllegalArgumentException("로또 번호는 1 ~ 45의 숫자만 가능합니다.");
        }
        return no;
    }
}

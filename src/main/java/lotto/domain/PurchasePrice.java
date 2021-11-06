package lotto.domain;

import lotto.common.Constants;
import lotto.common.CustomEmptyException;
import lotto.common.StringUtil;
import lotto.ui.ResultView;

import java.util.Objects;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
/**
 *  피드백 내용 : 1) 생성자의 내용이 중복되므로 함수로 체크하도록 변경하자
 *             2) 불필요한 형변환(parseInt)을 줄이자. 정상일 경우 변환값을 변환 실패시 예외를 리턴하자.
 *             3) toString() 메소드는 객체의 상태정보를 가지는 메소드이므로 오버라이딩하는 것은 지양하자.(협업 시 잘못 사용될 수 있음)
 *               => https://lelecoder.com/42 참고자료
 * */
/**
 * packageName : lotto.domain
 * fileName : PurchasePrice
 * author : haedoang
 * date : 2021-11-05
 * description : 구입 금액 클래스
 */
public class PurchasePrice {
    public static final int LOTTO_PRICE = 1000;

    private final int purchaseQuantity;

    public PurchasePrice(int price) {
        this.purchaseQuantity = this.calculateQuantity(validate(price));
    }

    public PurchasePrice(String strPrice) {
        if(StringUtil.isStringEmpty(strPrice)) throw new CustomEmptyException();
        this.purchaseQuantity = this.calculateQuantity(validate(StringUtil.parseNumber(strPrice.trim())));
    }

    public int validate(int price) {
        if (price < LOTTO_PRICE) throw new IllegalArgumentException("로또를 구입할 금액이 부족합니다.");
        return price;
    }

    public int calculateQuantity(int price) {
        return price / LOTTO_PRICE;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        PurchasePrice that = (PurchasePrice) o;
        return purchaseQuantity == that.purchaseQuantity;
    }

    @Override
    public int hashCode() {
        return Objects.hash(purchaseQuantity);
    }

    public void print() {
        ResultView.print(this.purchaseQuantity + Constants.MSG_OUTPUT_PURCHASE_RESULT_SUFFIX);
    }

    public Lottos buyLottery() {
        return new Lottos(IntStream.range(0, purchaseQuantity).mapToObj(i -> LottoMaker.createLotto()).collect(Collectors.toList()));
    }
}

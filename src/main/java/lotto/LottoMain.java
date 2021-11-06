package lotto;

/**
 *
 * */
import lotto.service.LottoService;

/**
 * packageName : lotto
 * fileName : LottoMain
 * author : haedoang
 * date : 2021-11-05
 * description : 로또 메인 클래스 생성
 */
public class LottoMain {
    public static void main(String[] args) {
        LottoService lottoService = new LottoService();
        lottoService.start();
    }
}

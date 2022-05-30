package lotto.domain;

import java.util.ArrayList;
import java.util.List;

public class Lotto {
    public static final int LOTTO_PRICE = 1000;
    public static final int LOTTO_NO_START_NUMBER = 1;
    public static final int LOTTO_NO_END_NUMBER = 45;
    public static final int LOTTO_NO_SIZE = 6;

    private List<LottoNo> lottoNumbers = new ArrayList<>();

    public Lotto() {
    }

    public Lotto(String[] splitWinningLotto) {
        if (splitWinningLotto == null || splitWinningLotto.length != LOTTO_NO_SIZE) {
            String exceptionMessage = String.format("로또는 %d개의 숫자입니다.", LOTTO_NO_SIZE);
            throw new IllegalArgumentException(exceptionMessage);
        }
        for (String s : splitWinningLotto) {
            LottoNo lottoNo = LottoNo.createLotto(s.trim());
            addLottoNumber(lottoNo);
        }
    }

    public Lotto(List<Integer> lottoNos) {
        for (Integer lottoNo : lottoNos) {
            addLottoNumber(new LottoNo(lottoNo));
        }
    }

    public List<LottoNo> getLottoNumbers() {
        return lottoNumbers;
    }

    public int calculateMatchCount(Lotto checkLotto) {
        int countMatch = 0;

        for (LottoNo lottoNo : checkLotto.getLottoNumbers()) {
            countMatch = containsLottoNo(lottoNo) ? countMatch + 1 : countMatch;
        }
        return countMatch;
    }

    public void addLottoNumber(LottoNo lottoNo) {
        if (lottoNumbers.contains(lottoNo)) {
            throw new IllegalArgumentException("이미 존재하는 번호는 중복 될 수 없습니다.");
        }
        lottoNumbers.add(lottoNo);
    }

    public boolean containsLottoNo(LottoNo bonusNumber) {
        return lottoNumbers.contains(bonusNumber);
    }
}
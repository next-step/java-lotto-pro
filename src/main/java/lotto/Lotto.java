package lotto;

import java.util.ArrayList;
import java.util.List;

public class Lotto {
    private List<Integer> lottoNumbers = new ArrayList<>();
<<<<<<< HEAD

    public Lotto(List<Integer> lottoNumbers) {
        this.lottoNumbers = lottoNumbers;
    }
=======
>>>>>>> 119371d (refactor : Rank enum으로 변경)

    public Lotto() {
    }

    public Lotto(List<Integer> lottoNumbers) {
        this.lottoNumbers = lottoNumbers;
    }

    public Lotto(String[] splitWinningLottoString) {
        if (splitWinningLottoString == null || splitWinningLottoString.length != 6) {
            throw new IllegalArgumentException("로또는 6개의 숫자입니다.");
        }
        for (String s : splitWinningLottoString) {
            addLottoNumber(s.trim());
        }
    }

    public List<Integer> getLottoNumbers() {
        return lottoNumbers;
    }

    public int checkMatchCount(Lotto checkLotto) {
        int countMatch = 0;
        for (Integer lotto : checkLotto.getLottoNumbers()) {
            countMatch = lottoNumbers.contains(lotto) ? countMatch + 1 : countMatch;
        }
        return countMatch;
    }

<<<<<<< HEAD
    public static int validateBonus(Lotto winningLotto, String bonusBall) {
        int bonusNumber;
        try {
            bonusNumber = Integer.parseInt(bonusBall);
        } catch (NumberFormatException numberFormatException) {
            throw new IllegalArgumentException("보너스볼은 숫자입니다.");
        }
        if (bonusNumber < 1 || bonusNumber > 45) {
            throw new IllegalArgumentException("보너스는 1~45 사이입니다.");
        }
        if (winningLotto.checkBonusMatch(bonusNumber)) {
            throw new IllegalArgumentException("보너스는 당첨 숫자와 달라야합니다.");
        }
        return bonusNumber;
    }

=======
>>>>>>> 119371d (refactor : Rank enum으로 변경)
    public void addLottoNumber(String lottoNumber) {
        int number;
        try {
            number = Integer.parseInt(lottoNumber);
        } catch (NumberFormatException numberFormatException) {
            throw new IllegalArgumentException("당첨번호는 숫자입니다.");
        }
        if (number < 0 || number > 45) {
            throw new IllegalArgumentException("당첨번호은 1~45 사이 숫자입니다.");
        }
        lottoNumbers.add(number);
    }

    public boolean checkBonusMatch(int bonusNumber) {
        return lottoNumbers.contains(bonusNumber);
    }

    public int checkMatchCount(Lotto checkLotto) {
        int countMatch = 0;
        for (Integer lotto : checkLotto.getLottoNumbers()) {
            countMatch = lottoNumbers.contains(lotto) ? countMatch + 1 : countMatch;
        }
        return countMatch;
    }
}
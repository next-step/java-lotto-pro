package lotto.model;

import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.stream.Collectors;

import static org.assertj.core.api.Assertions.assertThat;

public class WinningLottoNumberTest {
  @Test
  void 당첨_로또_번호_및_보너스_번호_입력하여_생성() {
    int[] lottoNumberArray = {1, 2, 3, 4, 5, 6};
    LottoNumbers lottoNumber = getLottoNumber(lottoNumberArray);
    LottoNumber bonusNumber = new LottoNumber(7);
    WinningLottoNumbers winningLottoNumber = new WinningLottoNumbers(lottoNumber, bonusNumber);

    assertThat(winningLottoNumber.getWinningLottoNumbers()).isEqualTo(lottoNumber);
    assertThat(winningLottoNumber.getBonusNumber()).isEqualTo(bonusNumber);
  }

  private LottoNumbers getLottoNumber(int[] lottoNumberArray) {
    return new LottoNumbers(Arrays
      .stream(lottoNumberArray)
      .mapToObj(LottoNumber::new)
      .collect(Collectors.toList()));
  }

  @Test
  void 당첨_번호와_로또_번호를_비교하여_등수를_반환() {
    int[] lottoNumberArray = {1, 2, 3, 4, 5, 6};
    LottoNumbers lottoNumbers = getLottoNumber(lottoNumberArray);
    LottoNumber bonusNumber = new LottoNumber(7);
    WinningLottoNumbers winningLottoNumbers = new WinningLottoNumbers(lottoNumbers, bonusNumber);

    int[] compareNumberArray = {1, 2, 3, 4, 20, 21};
    LottoNumbers compareLottoNumbers = getLottoNumber(compareNumberArray);


    LottoRank lottoRank = winningLottoNumbers.getRankCompareTo(compareLottoNumbers);

    assertThat(lottoRank).isEqualTo(LottoRank.FOURTH);
  }

}
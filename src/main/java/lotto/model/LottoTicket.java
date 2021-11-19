package lotto.model;

import java.util.List;

public class LottoTicket {
  private static final int ADD_COUNT = 1;

  private final List<LottoNumbers> lottoNumbers;

  public LottoTicket(List<LottoNumbers> lottoNumbers) {
    this.lottoNumbers = lottoNumbers;
  }

  public List<LottoNumbers> getLottoNumbers() {
    return lottoNumbers;
  }

  public WinningResult match(WinningLottoNumbers winningLottoNumbers) {
    WinningResult winningResult = WinningResult.init();

    for (LottoNumbers lottoNumber : lottoNumbers) {
      winningResult.addResult(winningLottoNumbers.getRankCompareTo(lottoNumber), ADD_COUNT);
    }

    return winningResult;
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();

    for (LottoNumbers lottoNumber : lottoNumbers) {
      sb.append(lottoNumber);
      sb.append("\n");
    }

    return sb.toString();
  }

}
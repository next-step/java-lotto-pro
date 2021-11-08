package lotto.domain.lotto;

public class LottoGenerator {
  public static Lottos autoGenerate(Integer generatingCount) {
    return Lottos.generate(generatingCount);
  }  
}

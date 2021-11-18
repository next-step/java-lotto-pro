package lotto.model;

import lotto.generator.AutoLottoGenerator;
import lotto.generator.LottoGenerator;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

public class LottoTicketTest {
  @Test
  void 로또_갯수_만큼_로또를_발급한다(){
    LottoGenerator lottoGenerator = new AutoLottoGenerator();
    LottoQuantity lottoQuantity = new LottoQuantity(4);
    List<LottoNumbers> lottoNumbersList = lottoQuantity.makeLottoNumbersAsQuantity(lottoGenerator);
    LottoTicket lottoTicket = new LottoTicket(lottoNumbersList);

    assertThat(lottoTicket.getLottoNumbers().size()).isEqualTo(4);
  }


}

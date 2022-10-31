package study.step3;

import domain.*;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

class WinLottoTest {
    private List<LottoNumber> lottoNumbers;
    private Lotto lotto;
    @BeforeEach
    public void inputLottoSetup(){
        lottoNumbers = new ArrayList<>();
        lottoNumbers.add(new LottoNumber(1));
        lottoNumbers.add(new LottoNumber(45));
        lottoNumbers.add(new LottoNumber(3));
        lottoNumbers.add(new LottoNumber(4));
        lottoNumbers.add(new LottoNumber(18));
        lottoNumbers.add(new LottoNumber(20));

        lotto = new Lotto(lottoNumbers);
    }
    @Test
    @DisplayName("로또번호 3개 맞춘 카운트 검증")
    public void 맞춘개수_3개_검증(){
        String given = "1,10,3,4,7,19";

        Lotto winLottoList = new Lotto(lottoNumbers);
        WinLotto winLotto = new WinLotto(given,  new WinReport());

        List<Lotto> lottoList = new ArrayList<>();
        lottoList.add(lotto);

        WinReport winReport = winLotto.findWinner(lottoList);
        assertThat(winReport.getLottoResult(3)).isEqualTo(1);

    }
    @Test
    @DisplayName("로또번호 4개 맞춘 카운트 검증")
    public void 맞춘개수_4개_검증(){
        String given = "1,45,3,4,17,19";
        Lotto winLottoList = new Lotto(lottoNumbers);
        WinLotto winLotto = new WinLotto(given,  new WinReport());

        List<Lotto> lottoList = new ArrayList<>();
        lottoList.add(lotto);

        WinReport winReport = winLotto.findWinner(lottoList);
        assertThat(winReport.getLottoResult(4)).isEqualTo(1);
    }
    @Test
    @DisplayName("로또번호 5개 맞춘 카운트 검증")
    public void 맞춘개수_5개_검증(){
        String given = "1,45,3,4,18,19";

        Lotto winLottoList = new Lotto(lottoNumbers);
        WinLotto winLotto = new WinLotto(given,  new WinReport());

        List<Lotto> lottoList = new ArrayList<>();
        lottoList.add(lotto);

        WinReport winReport = winLotto.findWinner(lottoList);
        assertThat(winReport.getLottoResult(5)).isEqualTo(1);
    }
    @Test
    @DisplayName("로또번호 6개 맞춘 카운트 검증")
    public void 맞춘개수_6개_검증(){
        String given = "1,45,3,4,18,20";

        Lotto winLottoList = new Lotto(lottoNumbers);
        WinLotto winLotto = new WinLotto(given,  new WinReport());

        List<Lotto> lottoList = new ArrayList<>();
        lottoList.add(lotto);

        WinReport winReport = winLotto.findWinner(lottoList);
        assertThat(winReport.getLottoResult(6)).isEqualTo(1);
    }
}
package lotto.presentaion;


import static org.mockito.Mockito.mockStatic;
import static org.mockito.Mockito.when;

import java.io.ByteArrayOutputStream;
import java.io.InputStream;
import java.io.PrintStream;
import java.util.ArrayList;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestInstance;
import org.mockito.MockedStatic;

import lotto.domain.lotto.Lotto;
import lotto.domain.lotto.LottoNumber;
import lotto.domain.lotto.Lottos;
import lotto.infrastructure.datashared.UiSharedData;
import lotto.presentation.ReportWinStatistics;
import lotto.presentation.Screen;

@TestInstance(TestInstance.Lifecycle.PER_CLASS)
public class ReportWinStatisticsTest {
  private static final ByteArrayOutputStream outContent = new ByteArrayOutputStream();
  private static final PrintStream originalOut = System.out;
  private static final InputStream originalIn = System.in;

  private static MockedStatic<UiSharedData> uiSharedData;

  @BeforeAll
  public static void beforeClass() {
    uiSharedData = mockStatic(UiSharedData.class);
  }

  @AfterAll
  public static void afterClass() {
    uiSharedData.close();
  }

  @BeforeEach
  public void setUpStreams() {
    System.setOut(new PrintStream(outContent));
  }

  @AfterEach
  public void restoreStreams() {
    System.setOut(originalOut);
    System.setIn(originalIn);
    System.out.println(outContent.toString().trim());
  }

  @DisplayName("구입한 로또의 당첨 통계정보를 출력_5개 번호 일치, 보너스 번호 불일치")
  @Test
  void print_reportWinStatisticsTest_fiveMatch() {
    // given
    Lottos buyLottos = Lottos.valueOf(Lotto.valueOf("1", "3", "4", "11", "13", "14"),
                                        Lotto.valueOf("11", "13", "14", "21", "23", "24"),
                                        Lotto.valueOf("1", "3", "4", "31", "33", "44"));
    Lotto latestWinLotto = Lotto.valueOf("1", "3", "4", "31", "33", "34");
    LottoNumber bonusNumber = LottoNumber.valueOf("42");

    when(UiSharedData.getBuyLottos()).thenReturn(buyLottos);
    when(UiSharedData.getLatestWinLotto()).thenReturn(latestWinLotto);
    when(UiSharedData.getBonusNumber()).thenReturn(bonusNumber);

    Screen reportWinStatistics = new ReportWinStatistics();

    // when
    reportWinStatistics.render();

    // then
    List<String> printText = new ArrayList<>();
    printText.add("3개 일치 (5000원)- 1개");
    printText.add("4개 일치 (50000원)- 0개");
    printText.add("5개 일치 (1500000원)- 1개");
    printText.add("5개 일치, 보너스 볼 일치 (30000000원)- 0개");
    printText.add("6개 일치 (2000000000원)- 0개");
    printText.add("총 수익률은 501.67");

    assertThat(outContent.toString().trim()).contains(printText);
  }

  @DisplayName("구입한 로또의 당첨 통계정보를 출력_5개 번호 일치, 보너스 번호 일치")
  @Test
  void print_reportWinStatisticsTest_fiveAndBonusMatch() {
    // given
    Lottos buyLottos = Lottos.valueOf(Lotto.valueOf("1", "3", "4", "11", "13", "14"),
                                        Lotto.valueOf("11", "13", "14", "21", "23", "24"),
                                        Lotto.valueOf("1", "3", "4", "31", "33", "44"));
    Lotto latestWinLotto = Lotto.valueOf("1", "3", "4", "31", "33", "34");
    LottoNumber bonusNumber = LottoNumber.valueOf("44");

    when(UiSharedData.getBuyLottos()).thenReturn(buyLottos);
    when(UiSharedData.getLatestWinLotto()).thenReturn(latestWinLotto);
    when(UiSharedData.getBonusNumber()).thenReturn(bonusNumber);

    Screen reportWinStatistics = new ReportWinStatistics();

    // when
    reportWinStatistics.render();

    // then
    List<String> printText = new ArrayList<>();
    printText.add("3개 일치 (5000원)- 1개");
    printText.add("4개 일치 (50000원)- 0개");
    printText.add("5개 일치 (1500000원)- 0개");
    printText.add("5개 일치, 보너스 볼 일치 (30000000원)- 1개");
    printText.add("6개 일치 (2000000000원)- 0개");
    printText.add("총 수익률은 10001.67");

    assertThat(outContent.toString().trim()).contains(printText);
  }
}

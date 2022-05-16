package lotto;

import lotto.lotto.Lotto;
import lotto.lotto.LottoNumber;
import lotto.lotto.WinningLotto;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtensionContext;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.ArgumentsProvider;
import org.junit.jupiter.params.provider.ArgumentsSource;
import java.util.Arrays;
import java.util.EnumMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Stream;
import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

@DisplayName("LottoAnalyzer 클래스 테스트")
class LottoAnalyzerTest {

    private final WinningLotto winningLotto = WinningLotto.of("1, 2, 3, 4, 5, 6");
    private final LottoNumber bonusLottoNumber = LottoNumber.of(45);

    @DisplayName("lotto가 null이기 떄문에 생성 실패")
    @Test
    void failureCreate() {
        assertThatThrownBy(() -> {
            new LottoAnalyzer(null, null);
        })
        .isInstanceOf(NullPointerException.class);
    }

    @DisplayName("다양한 Lotto 리스트를 전달하여 결과 반환")
    @ParameterizedTest
    @ArgumentsSource(AnalyzeArgumentsProvider.class)
    void analyzeWhenVariousLottoes(List<Lotto> lottoes, Map<LottoPrize, Integer> expectedMap) {
        final LottoAnalyzer lottoAnalyzer = new LottoAnalyzer(winningLotto, bonusLottoNumber);
        final WinningResult winningResult = lottoAnalyzer.analyze(lottoes);
        for (LottoPrize lottoPrize : LottoPrize.values()) {
            final Integer actual = winningResult.find(lottoPrize);
            final Integer expected = expectedMap.getOrDefault(lottoPrize, 0);
            assertThat(actual).isEqualTo(expected);
        }
    }

    static class AnalyzeArgumentsProvider implements ArgumentsProvider {
        @Override
        public Stream<? extends Arguments> provideArguments(ExtensionContext context) {
            return Stream.of(
                    Arguments.of(Arrays.asList(Lotto.of(1, 2, 3, 4, 5, 6)),
                                 new EnumMap<LottoPrize, Integer>(LottoPrize.class) {{
                                     put(LottoPrize.SIX_MATCH, 1);
                                 }}),
                    Arguments.of(Arrays.asList(Lotto.of(1, 2, 3, 4, 5, 45)),
                                 new EnumMap<LottoPrize, Integer>(LottoPrize.class) {{
                                     put(LottoPrize.FIVE_MATCH_WITH_BONUS, 1);
                                 }}),
                    Arguments.of(Arrays.asList(Lotto.of(1, 2, 3, 4, 5, 7)),
                                 new EnumMap<LottoPrize, Integer>(LottoPrize.class) {{
                                     put(LottoPrize.FIVE_MATCH, 1);
                                 }}),
                    Arguments.of(Arrays.asList(Lotto.of(1, 2, 3, 4, 7, 8)),
                                 new EnumMap<LottoPrize, Integer>(LottoPrize.class) {{
                                     put(LottoPrize.FOUR_MATCH, 1);
                                 }}),
                    Arguments.of(Arrays.asList(Lotto.of(1, 2, 3, 7, 8, 9)),
                                 new EnumMap<LottoPrize, Integer>(LottoPrize.class) {{
                                     put(LottoPrize.THREE_MATCH, 1);
                                 }}),
                    Arguments.of(Arrays.asList(Lotto.of(1, 2, 7, 8, 9, 10)),
                                 new EnumMap<LottoPrize, Integer>(LottoPrize.class) {{
                                     put(LottoPrize.MISS, 1);
                                 }}),
                    Arguments.of(Arrays.asList(Lotto.of(1, 7, 8, 9, 10, 11)),
                                 new EnumMap<LottoPrize, Integer>(LottoPrize.class) {{
                                     put(LottoPrize.MISS, 1);
                                 }}),
                    Arguments.of(Arrays.asList(Lotto.of(7, 8, 9, 10, 11, 12)),
                                 new EnumMap<LottoPrize, Integer>(LottoPrize.class) {{
                                     put(LottoPrize.MISS, 1);
                                 }})
            );
        }
    }
}

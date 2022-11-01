package lotto.domain;

import static java.util.stream.Collectors.*;
import static org.assertj.core.api.Assertions.*;

import java.util.Arrays;
import java.util.Collections;
import java.util.Set;
import java.util.stream.Stream;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;
import org.junit.jupiter.params.provider.ValueSource;

import lotto.util.LottoUtil;

class LottoTest {
    @ParameterizedTest
    @ValueSource(ints = {3000, 5000, 13200})
    void 돈을_입력받고_구한갯수만큼_로또를구매한다(int money) {
        assertThat(new Lotto(money, Collections.emptyList()).getLottoNumbersList()).hasSize(
            new LottoMoney(money).count());
    }

    @Test
    void 입력받은_돈중_일부는_수동구매_일부는_자동구매한다() {
        LottoNumbers manualLotto1 = LottoUtil.toLottoNumber("1,2,3,4,5,6");
        LottoNumbers manualLotto2 = LottoUtil.toLottoNumber("7,8,9,10,11,12");
        Lotto lotto = new Lotto(3000, Arrays.asList(manualLotto1, manualLotto2));
        assertThat(lotto.getLottoNumbersList()).hasSize(3);
        assertThat(lotto.getLottoNumbersList()).contains(manualLotto1);
        assertThat(lotto.getLottoNumbersList()).contains(manualLotto2);
        boolean hasAutoPurchase = lotto.getLottoNumbersList().stream()
            .filter(lottoNumbers -> lottoNumbers != manualLotto1)
            .anyMatch(lottoNumbers -> lottoNumbers != manualLotto2);
        assertThat(hasAutoPurchase).isTrue();
    }

    @Test
    void 보너스번호가_당첨번호와_같으면_예외를_던진다() {
        Lotto lotto = new Lotto(
            Collections.singletonList(new LottoNumbers(toLottoNumberSet(new int[] {1, 2, 3, 4, 5, 6}))));
        assertThatThrownBy(() -> lotto.computeResult(new LottoNumbers(toLottoNumberSet(new int[] {1, 2, 3, 4, 5, 6})),
            new LottoNumber(1)))
            .isInstanceOf(IllegalArgumentException.class);
    }

    @ParameterizedTest
    @MethodSource("로또번호_및_당첨번호")
    void 당첨번호를_입력받아_당첨결과를_얻는다(Set<LottoNumber> lottoNumbers, Set<LottoNumber> winningNumbers, Rank rank,
        LottoNumber bonusNumber) {
        Lotto lotto = new Lotto(Collections.singletonList(new LottoNumbers(lottoNumbers)));
        LottoResult result = lotto.computeResult(new LottoNumbers(winningNumbers),
            bonusNumber);
        assertThat(result.getCount(rank)).isEqualTo(1);
    }

    public static Stream<Arguments> 로또번호_및_당첨번호() {
        return Stream.of(
            Arguments.of(//0개일치
                toLottoNumberSet(new int[] {1, 2, 3, 4, 5, 6}), toLottoNumberSet(new int[] {7, 8, 9, 10, 11, 12}),
                Rank.MISS, new LottoNumber(45)),
            Arguments.of(//1개일치
                toLottoNumberSet(new int[] {1, 2, 3, 4, 5, 6}), toLottoNumberSet(new int[] {1, 7, 8, 9, 10, 11}),
                Rank.MISS, new LottoNumber(45)),
            Arguments.of(//2개일치
                toLottoNumberSet(new int[] {1, 2, 3, 4, 5, 6}), toLottoNumberSet(new int[] {1, 2, 7, 8, 9, 10}),
                Rank.MISS, new LottoNumber(45)),
            Arguments.of(//3개일치
                toLottoNumberSet(new int[] {1, 2, 3, 4, 5, 6}), toLottoNumberSet(new int[] {1, 2, 3, 7, 8, 9}),
                Rank.FIFTH, new LottoNumber(45)),
            Arguments.of(//4개일치
                toLottoNumberSet(new int[] {1, 2, 3, 4, 5, 6}), toLottoNumberSet(new int[] {1, 2, 3, 4, 7, 8}),
                Rank.FOURTH, new LottoNumber(45)),
            Arguments.of(//5개일치 3등
                toLottoNumberSet(new int[] {1, 2, 3, 4, 5, 6}), toLottoNumberSet(new int[] {1, 2, 3, 4, 5, 7}),
                Rank.THIRD, new LottoNumber(45)),
            Arguments.of(//5개일치 2등
                toLottoNumberSet(new int[] {1, 2, 3, 4, 5, 6}), toLottoNumberSet(new int[] {1, 2, 3, 4, 5, 7}),
                Rank.SECOND, new LottoNumber(6)),
            Arguments.of(//6개일치
                toLottoNumberSet(new int[] {1, 2, 3, 4, 5, 6}), toLottoNumberSet(new int[] {1, 2, 3, 4, 5, 6}),
                Rank.FIRST, new LottoNumber(45))
        );
    }

    private static Set<LottoNumber> toLottoNumberSet(int[] ints) {
        return Arrays.stream(ints).boxed().map(LottoNumber::new).collect(toSet());
    }

}
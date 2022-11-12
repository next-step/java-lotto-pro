package step5.model;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.params.provider.ValueSource;

import java.util.List;
import java.util.stream.Collectors;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

class LottoNoTest {

    @ValueSource(ints = {1, 45, 29})
    @ParameterizedTest
    @DisplayName("로또 번호 생성")
    void givenLottoNo_whenConstruct_thenLottoNo(int no) {
        //when
        LottoNo lottoNo = new LottoNo(no);

        assertThat(lottoNo).isNotNull();
    }

    @ValueSource(ints = {-1, 46, 201})
    @ParameterizedTest
    @DisplayName("로또 번호 숫자 범위가 아닐 때 에러")
    void givenLottoNo_whenConstruct_thenThrow(int no) {
        //when then
        assertThatThrownBy(() -> new LottoNo(no))
                .isInstanceOf(RuntimeException.class)
                .hasMessageContaining("로또범위의 숫자");
    }

    @ValueSource(ints = {1, 45, 29})
    @ParameterizedTest
    @DisplayName("로또 번호 HashCode 리턴")
    void givenLottoNo_whenHashCode_thenHashCode(int no) {
        //when
        LottoNo lottoNo = new LottoNo(no);

        //then
        assertThat(lottoNo.hashCode()).isEqualTo(no);
    }

    @ValueSource(ints = {1, 45, 29})
    @ParameterizedTest
    @DisplayName("로또 번호와 다른 로또 번호 객체 비교시 내부 값이 같으면 TRUE 리턴")
    void givenLottoNo_whenEquals_thenTrue(int no) {
        //when
        LottoNo lottoNo = new LottoNo(no);

        //then
        assertThat(lottoNo.equals(new LottoNo(no))).isTrue();
    }

    @ValueSource(ints = {1, 45, 29})
    @ParameterizedTest
    @DisplayName("로또 번호 문자로 반환")
    void givenLottoNo_whenToString_thenString(int no) {
        //when
        LottoNo lottoNo = new LottoNo(no);

        //then
        assertThat(lottoNo).hasToString(String.valueOf(no));
    }

    @CsvSource(value = {"31,1", "45,23", "29,12"}, delimiterString = ",")
    @ParameterizedTest
    @DisplayName("로또 번호 리스트가 정렬시 compareTo 호출로 순서 정렬")
    void givenLottoNo_whenToString_thenCompareTo(int firstNo, int secondNo) {
        //when
        LottoNo firstLottoNo = new LottoNo(firstNo);
        LottoNo secondLottoNo = new LottoNo(secondNo);
        List<LottoNo> orderingLottoNos = List.of(firstLottoNo, secondLottoNo).stream()
                .sorted()
                .collect(Collectors.toList());

        //then
        assertThat(orderingLottoNos).element(0).isEqualTo(secondLottoNo);
        assertThat(orderingLottoNos).element(1).isEqualTo(firstLottoNo);
    }
}

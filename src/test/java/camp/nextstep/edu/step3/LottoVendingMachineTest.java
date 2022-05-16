package camp.nextstep.edu.step3;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import static camp.nextstep.edu.step3.LottoTest.createLottoNumberList;
import static org.assertj.core.api.AssertionsForClassTypes.*;
import static org.mockito.Mockito.spy;
import static org.mockito.Mockito.when;

public class LottoVendingMachineTest {

    private LottoVendingMachine vendingMachine;

    @BeforeEach
    void setUp() {
        vendingMachine = new LottoVendingMachine(new LottoGenerator());
    }

    @DisplayName("1000원 단위로 Lotto 를 발급하고 LottoPaper 를 반환한다.")
    @Test
    void issuedTest() {
        LottoPaper paper = vendingMachine.issued(new LottoMoney(14000));
        assertThat(paper.numberOfPurchases()).isEqualTo(14);
    }

    @DisplayName("로또 구매할 금액과 수동으로 적은 로또 list를 인자값으로 넣으면 발급한다.")
    @Test
    void issuedWithManualLottoTest() {
        Lotto manualLotto = new Lotto(createLottoNumberList(new int[]{1, 2, 3, 4, 5, 6}));
        List<Lotto> lottoList = Collections.singletonList(manualLotto);
        LottoPaper paper = vendingMachine.issued(new LottoMoney(14000), lottoList);
        assertThat(paper.isContain(manualLotto)).isTrue();
    }

    @DisplayName("수동 로또가 비어있어나 없을경우에는 자동으로 발급된다.")
    @Test
    void 발급시수동로또가비어있거나없을경우() {
        assertThat(vendingMachine.issued(new LottoMoney(14000), null).numberOfPurchases()).isEqualTo(14);
        assertThat(vendingMachine.issued(new LottoMoney(14000), Collections.emptyList()).numberOfPurchases()).isEqualTo(14);
    }

    @DisplayName("로또 머신은 발급된 로또 정보를 발급할수 있어야 한다.")
    @ParameterizedTest
    @MethodSource("provideIssuedHistory")
    void printIssuedLottoInformation(List<Lotto> manualLotto,IssuedHistory issuedHistory ) {
        List<Lotto> autoLotto = Collections.singletonList(new Lotto(createLottoNumberList(new int[]{1, 2, 3, 4, 5, 6})));
        LottoGenerator spyLottoGenerator = createMockLottoGenerator(autoLotto.get(0));
        LottoVendingMachine lottoVendingMachine = new LottoVendingMachine(spyLottoGenerator);
        lottoVendingMachine.issued(new LottoMoney(3000), manualLotto);
        Optional<IssuedHistory> isIssuedHistory = lottoVendingMachine.printIssuedLotto();
        assertThat(isIssuedHistory.isPresent()).isTrue();
        assertThat(isIssuedHistory.get()).isEqualTo(issuedHistory);
    }

    @DisplayName("로또머신은 발급된 기록이 없을때 빈 객체를 반환한다.")
    @Test
    void invalidPrintIssuedLottoInformation() {
        assertThat(vendingMachine.printIssuedLotto()).isEqualTo(Optional.empty());
    }

    private static Stream<Arguments> provideIssuedHistory() {
        return Stream.of(
                Arguments.of(
                        createManualLotto(Arrays.asList(new int[]{7, 8, 9, 10, 11, 12}, new int[]{1, 2, 3, 4, 5, 7})),
                        createIssuedHistory(
                                Collections.singletonList(new Lotto(createLottoNumberList(new int[]{1, 2, 3, 4, 5, 6}))),
                                createManualLotto(Arrays.asList(new int[]{7, 8, 9, 10, 11, 12}, new int[]{1, 2, 3, 4, 5, 7}))
                        )

                ),

                Arguments.of(
                        createManualLotto(Arrays.asList(new int[]{7, 8, 9, 10, 11, 12}, new int[]{1, 2, 3, 4, 5, 7}, new int[] {1,2,3,4,5,6})),
                        createIssuedHistory(
                                 Collections.emptyList(),
                                createManualLotto(Arrays.asList(new int[]{7, 8, 9, 10, 11, 12}, new int[]{1, 2, 3, 4, 5, 7}, new int[] {1,2,3,4,5,6}))
                        )

                )
        );
    }

    private static IssuedHistory createIssuedHistory(List<Lotto> autoLotto, List<Lotto> manualLotto) {
        List<IssuedInformation> expectedIssuedInformation = new ArrayList<>();
        if (Objects.nonNull(autoLotto) && !autoLotto.isEmpty()) {
            expectedIssuedInformation.add(new IssuedInformation(IssuedMode.Auto, autoLotto));
        }
        if (Objects.nonNull(manualLotto) && !manualLotto.isEmpty()) {
            expectedIssuedInformation.add(new IssuedInformation(IssuedMode.Manual, manualLotto));
        }
        return new IssuedHistory(expectedIssuedInformation);
    }

    private LottoGenerator createMockLottoGenerator(Lotto lotto) {
        LottoGenerator spyLottoGenerator = spy(new LottoGenerator());
        when(spyLottoGenerator.auto()).thenReturn(lotto);
        return spyLottoGenerator;
    }

    private static List<Lotto> createManualLotto(List<int[]> dataList) {
        return dataList.stream().map(LottoTest::createLottoNumberList).map(Lotto::new).collect(Collectors.toList());
    }
}

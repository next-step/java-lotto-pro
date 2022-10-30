//import java.util.ArrayList;
//import java.util.Collections;
//import java.util.List;
//
//public class Lottos {
//
//    List<Integer> lottoRange;
//    List<LottoNumber> selectLotto;
//    private static final int START_LOTTO_NUMBER = 1;
//    private static final int END_LOTTO_NUMBER = 45;
//
//    public void ready(int count) {
////        lottoRange = new ArrayList<>();
////        selectLotto = new ArrayList<>();
////        readyLottoNumber();
////
////        for (int i = 0; i < count; i++) {
////            List<Integer> target = selectLotto();
////            System.out.println("-------------------");
////            System.out.println(target);
////            new LottoNumber(target);
////
////            System.out.println("==-=-=-=-=-=");
////            System.out.println(r.number);
////
////            selectLotto.add(new LottoNumber(target));
////
//////            System.out.println("=========== TERST 2");
////            for (LottoNumber lotto : selectLotto) {
////                System.out.println(lotto.number);
////            }
////
////        }
////
////        System.out.println("===========");
////        for (LottoNumber lotto : selectLotto) {
////            System.out.println(lotto.number);
////        }
////    }
////
////    private List<Integer> selectLotto() {
////        Collections.shuffle(lottoRange);
////        return lottoRange.subList(0, 6);
////    }
////
////    private void readyLottoNumber() {
////        for (int i = START_LOTTO_NUMBER; i <= END_LOTTO_NUMBER; i++) {
////            lottoRange.add(i);
////        }
////    }
////}

#3단계 - 로또(자동)

## 도메인 설계
### LottoNumber
- [x] 정수 하나를 가진다.
- [x] 1 ~ 45 중의 숫자인지 체크

### LottoNumbers
- [x] LottoNumber가 6개 인지 체크
- [x] 6개 LottoNumber 중에 중복이 있는지 체크
- [x] LottoNumbers에 입력한 LottoNumber 하나가 존재 하는지 확인
- [x] LottoNumbers 끼리 몇개의 숫자가 일치 하는 지 확인

### NumberGenerateStrategy
- [x] 전략 패턴을 사용하여 LottoNumbers 외부에서 숫자 리스트를 주입 하기 위해 사용
- [ ] 구현체 RandomNumberGenerateStrategy 

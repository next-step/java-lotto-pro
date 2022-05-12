# 설계
## 입력값 = expression
## expression = custom delimiter part + numbers part
- //로 시작하면 custom delimiter part가 있는 걸로 판단할 수 있다.

## Delimiter를 생성하는 역할
- 디폴트 Delimiter는 ",|:" 로 한다.

## 숫자를 계산하는 역할 
- 양수만 계산 가능(음수를 받은 경우 RuntimeException을 던진다.)

---

# 기능목록
- [X] 빈 문자열 또는 null 값을 입력할 경우 0을 반환
- [ ] Delimiter 추가
  - expression에서 Delimiter 부분과 숫자 입력부분을 나누기 
- [ ] 숫자 계산 기능 추가
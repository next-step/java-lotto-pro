step2 : 문자열 덧셈 계산기

---

- 기능 
  - 문자열을 String 배열로 변환
    - null/공백 입력시 0 이 들어있는 String 배열로 반환
    - 숫자 하나만 들어왔을때 해당 숫자가 들어가있는 String 배열로 변환 
    - ;나 :를 Delimiter로 가지고 있을때, 해당 Delimiter로 Split
    - //와 \n로 둘러쌓인 Delimiter가 있으면 해당 Delimiter로 Split
  - Split된 배열의 값 검증 
    - 각 문자열은 숫자로 변환이 가능한가?
    - 각 문자열은 양수인가?
  - 출력기능
    - Split된 배열의 총 합 반환
**Recursion 재귀**
-재귀는 컴퓨터 과학에서 자신을 정의할 때 자기 자신을 재참조하는 방식을 뜻하며, 프로그래밍에 적용한 재귀 호출(Recursive call)의 형태로 많이 사용된다.
<hr>

**재귀의 구조**
- 순환적 특성
- 중단 조건 - 지속적으로 호출되면 Stackoverflow가 발생된다.

<hr>

> **점화식 관점**
![image](https://user-images.githubusercontent.com/90611410/142831292-583b99bb-312c-4818-9337-e0360026bf8c.png) 점화식을 보면, 5+6+7+8+9+10 즉, 
![image](https://user-images.githubusercontent.com/90611410/142831516-a99b7a33-c030-4256-89e2-702e27f063cf.png) 로 정의할 수 있다. 정의를 통해 코드를 작성한다면 아래와 같다.

```
static int sum = 0;
    public static String re(int data, int end){
        sum += data;
        if(data == end){
            return Integer.toString(data);
        } else{
            return (data + "+" + re(data-1, end));
        }
    }
    public static void main(String[] args) {
        System.out.println(re(10,5) + " = " +sum);
    }
```
<br><br>

>  **분할 관점**
 -반복적인 동일한 규칙으로 큰 문제를 작은 문제로 쪼갤 수 있는 것은 재귀적인 분할 방식으로 접근할 수 있다.
> 
> 배열의 접근방식으로, (앞의 인덱스 + 마지막 인덱스) / 2 인 중앙값을 이용하여 좌, 우로 쪼갠다. 지속적으로 쪼개다 보면 최종적으로 값이 1개인 배열이 된다.
```
void split(int startIndex, int endIndex){
    if(startIndex == endIndex){
        System.out.println(startIndex);
        return;
    }
     int middleIndex = (startIndex + endIndex) / 2;
    split(startIndex, middleIndex); //좌
    split(middleIndex+1, endIndex); //우
}
```
<br><br>

>  **백트래킹 관점**
-탐색 관점에서 스택의 특징을 이용하여 이전 분기로 돌아가(Savepoint) 탐색한다.


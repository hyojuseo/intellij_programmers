package recursion;

public class Split {
    //배열의 인덱스 출력
    public static void split(int startIndex,int endIndex){
        if(startIndex == endIndex){
            System.out.print(startIndex + " ");
            return;
        }
        int middleIndex = (startIndex + endIndex )/2;
        split(startIndex,middleIndex);
        split(middleIndex+1,endIndex);
    }

    //인덱스의 합 메소드
    public static int split2(int startIndex, int endIndex){
        if(startIndex == endIndex){
            return startIndex;
        }
        int middleIndex = (startIndex + endIndex) / 2;
        return split2(startIndex,middleIndex) + split2(middleIndex+1,endIndex);
    }

    //배열의 값 합 메소드
    public static int sum(int[] arr, int startIndex, int endIndex){
        if(startIndex == endIndex){
            return arr[startIndex];
        }
        int middleIndex =(startIndex + endIndex) /2;
        return sum(arr, startIndex, middleIndex) + sum(arr, middleIndex+1, endIndex);
    }

    public static void main(String[] args) {

        split(0, 7);
        System.out.println("\n-----------");

        System.out.printf("인덱스의 합 : %d\n", split2(0, 7));
        System.out.println("-----------");

        int[] arr = {4, 2, 5, 1, 5, 3, 1, 2};
        System.out.printf("배열의 합 : %d", sum(arr, 0, arr.length - 1));

    }
}

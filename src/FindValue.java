public class FindValue {
    public static void main(String[] args) {
        String[] arr = new String[500000];
        System.out.println("데이터 삽입 시작");

        for(int i=0; i<arr.length; i++){
            arr[i] = (i+1)+"";
        }

        for(int i=0; i<arr.length; i++){
            int x = (int)(Math.random() * arr.length);
            int y = (int)(Math.random() * arr.length);

            String tmp = arr[x];
            arr[x] = arr[y];
            arr[y] = tmp;
        }
        System.out.println("데이터 섞기 완료");

        try{
            Thread.sleep(3000);
        }catch (InterruptedException e){
            e.printStackTrace();
        }

        System.out.println("검색 시작");
        long startTime = System.currentTimeMillis();

        //find data
        String findValue = "482923";

        //find data index
        int index = -1;

        for(int i=0; i<arr.length; i++){
            if(arr[i].equals(findValue)){
                index = i;
                break;
            }
        }

        long endTime = System.currentTimeMillis();
        long time = endTime-startTime;
        System.out.printf("index : %d, value : %s, 검색시간 :%d ms"
                , index, findValue, time);
    }
}

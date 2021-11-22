package toy;

public class RecursionToy {
    static int sum = 0;

    public static String re(int data){
        sum += data;
        if(data == 1){
            return Integer.toString(data);
        } else{
            return (data + "+" + re(data-1));
        }
    }
    public static void main(String[] args) {
        System.out.println(re(10) + " = " +sum);
    }
}

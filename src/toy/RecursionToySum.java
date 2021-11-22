package toy;

//end까지의 합
public class RecursionToySum {
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
}

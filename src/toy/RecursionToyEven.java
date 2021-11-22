package toy;

public class RecursionToyEven {
    public static void even(int i){
        if(i<1){
            return;
        } else if(i%2==0){
            System.out.print(i + " ");
        }
        even(i-1);
    }
    public static void main(String[] args) {
        even(10);
    }
}

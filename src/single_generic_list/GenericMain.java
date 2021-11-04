package single_generic_list;

public class GenericMain {
    //코드의 안정성을 높일 수 있다.
    public static void main(String[] args) {
        GenericSinglyLinkedList<String> list = new GenericSinglyLinkedList<String>();
        list.addLast("A");
        list.addLast("B");
        list.addLast("C");
        list.addLast("D");
        //incompatible type (호환되지 않는 타입)
        //list.addLast(1);
        System.out.println(list);
    }
}

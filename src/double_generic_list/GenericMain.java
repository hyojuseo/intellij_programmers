package double_generic_list;

import java.util.ArrayList;
import java.util.List;

public class GenericMain<E>  {
    public static void main(String[] args) {
        List<String> list = new GenericDoublyLinkedList<>();
        list.add("a");
        list.add("b");
        list.add("c");
        list.add("d");
        list.add("e");
        System.out.println(list);

        list.remove("c");
        System.out.println(list);

        List<String> tempList = new ArrayList<>();
        tempList.add("z");
        tempList.add("x");
        tempList.add("y");
        list.addAll(tempList);

        System.out.println(list);

        list.clear();
        System.out.println(list);

    }

}

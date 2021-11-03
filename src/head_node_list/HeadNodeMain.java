package head_node_list;

public class HeadNodeMain {
    public static void main(String[] args) {
        HeadNodeSinglyLinkedList headNodeList = new HeadNodeSinglyLinkedList();
        headNodeList.addLast("B");
        System.out.println(headNodeList);

        headNodeList.addFirst("A");
        System.out.println(headNodeList);

        headNodeList.addLast("E");
        System.out.println(headNodeList);

        headNodeList.add(1, "C");
        System.out.println(headNodeList);

        headNodeList.add(2, "D");
        System.out.println(headNodeList);

        headNodeList.removeLast();
        System.out.println(headNodeList);

        headNodeList.remove(1);
        System.out.println(headNodeList);

        headNodeList.removeFirst();
        System.out.println(headNodeList);

        System.out.printf("노드의 개수:%d\n", headNodeList.size());

        System.out.printf("1번 인덱스의 값:%s", headNodeList.getData(1));

    }
}

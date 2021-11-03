package head_node_list;
public class HeadNodeSinglyLinkedList {
    Node head = new Node();
    int size = 0;

    //노드 탐색
    private Node findNode(int searchIndex) {
        if (-1 > searchIndex || size <= searchIndex) {
            throw new ArrayIndexOutOfBoundsException();
        }

        //head 노드는 0이 아닌 -1 index부터 시작한다.
        int nodeIndex = -1;
        Node pointer = head;

        while (nodeIndex != searchIndex) {
            ++nodeIndex;
            pointer = pointer.next;
        }
        return pointer;
    }

    //노드 삽입
    public void add(int index, Object data) {
        Node node = new Node();
        node.data = data;

        Node foundNode = findNode(index - 1);
        node.next = foundNode.next;
        foundNode.next = node;
        ++size;
    }

    //노드 삭제
    public void remove(int index) {
        Node prevNode = findNode(index - 1);
        prevNode.next = prevNode.next.next;
        --size;
    }

    public Object getData(int searchIndex) {
        return findNode(searchIndex).data;
    }

    public boolean isEmpty() {
        return 0 == size;
    }

    public void addLast(Object data) {
        add(size, data);
    }

    public void addFirst(Object data) {
        add(0, data);
    }

    public void removeLast() {
        remove(size - 1);
    }

    public void removeFirst() {
        remove(0);
    }

    public int size() {
        return size;
    }

    @Override
    public String toString() {
        StringBuilder stringBuilder = new StringBuilder();
        Node pointer = head.next;
        stringBuilder.append("head").append(" -> ");
        while (null != pointer) {
            stringBuilder.append(pointer.data).append(" -> ");
            pointer = pointer.next;
        }
        stringBuilder.append("null");
        return stringBuilder.toString();
    }
}

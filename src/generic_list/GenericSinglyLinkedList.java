package generic_list;

public class GenericSinglyLinkedList<T> {
    GenericNode<T> head;
    int size = 0;

    private GenericNode<T> findNode(int searchIndex) {
        if (0 > searchIndex || size <= searchIndex) {
            throw new ArrayIndexOutOfBoundsException();
        }
        int nodeIndex = 0;

        GenericNode<T> pointer = head;
        while (nodeIndex != searchIndex) {
            ++nodeIndex;
            pointer = pointer.next;
        }
        return pointer;
    }

    public void add(int index, T data) {
        GenericNode<T> node = new GenericNode();
        node.data = data;

        if (0 == index) {
            node.next = head;
            head = node;
        } else {
            GenericNode<T> foundNode = findNode(index - 1);
            node.next = foundNode.next;
            foundNode.next = node;
        }
    }

    public void remove(int index) {
        if (0 == index && null != head) {
            head = head.next;
        } else {
            GenericNode<T> prevNode = findNode(index - 1);
            prevNode.next = prevNode.next.next;
        }
        --size;
    }

    public T getData(int searchIndex) {
        return findNode(searchIndex).data;
    }

    public boolean isEmpty() {
        return size == 0;
    }

    public int size() {
        return size;
    }

    //마지막 노드 추가
    public void addLast(T data) {
        add(size, data);
    }

    //첫번째 노드 추가
    public void addFirst(T data) {
        add(0, data);
    }

    //마지막 노드 삭제
    public void removeLast() {
        remove(size - 1);
    }

    //첫번째 노드 삭제
    public void removeFirst() {
        remove(0);
    }

    @Override
    public String toString() {
        StringBuilder stringBuilder = new StringBuilder();
        GenericNode<T> pointer = head;
        stringBuilder.append("head").append("->");

        while (null != pointer) {
            stringBuilder.append(pointer.data).append("->");
            pointer = pointer.next;
        }
        stringBuilder.append("null");
        return stringBuilder.toString();
    }

}

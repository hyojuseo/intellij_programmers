public class SinglyLinkedList{
    Node head = null;
    int size = 0;

    //1. 특정노드를 찾는다.
    Node findNode(int searchIndex){
        //정상적인 값이 아닐땐 예외처리
        if(0 > searchIndex || size <= searchIndex)
            throw new ArrayIndexOutOfBoundsException();
        int nodeIndex = 0;

        Node pointer = head;
        //검색하려는 인덱스를 찾을때까지 pointer를 다음으로 옮긴다.
        //nodeIndex도 다음으로 증가시킨다.
        while(nodeIndex != searchIndex){
            pointer = pointer.next;
            ++nodeIndex;
        }
        return pointer;
    }

    //2. 특정 index에 Node를 삽입한다.
    public void add(int index, Object data){
        Node newNode = new Node();
        newNode.data = data;

        //맨앞에 노드를 삽입하는 경우
        if(0 == index){
            newNode.next = head;
            head = newNode;
        } else{
            //노드를 중간에 삽입하는 경우
            Node foundNode = findNode(index - 1);
            newNode.next = foundNode.next;
            foundNode.next = newNode;
        }
        ++size;
    }

    //3. 특정 index에 Node를 삭제한다.
    public void remove(int index){
        if(0 == index && null != head){
            head = head.next;
        } else {
            Node prevNode = findNode(index -1);
            //삭제한 노드의 다음노드 참조값을 삭제한 노드의 이전 pointer로 해둬야 된다.
            prevNode.next = prevNode.next.next;
        }
        --size;
    }

    //값을 찾으려는 메서드
    public Object getData(int searchIndex){
        return findNode(searchIndex).data;
    }

    //노드가 비어있는지 확인하는 메서드
    public boolean isEmpty(){
        return 0 == size;
    }

    //마지막에 노드를 추가하는 메서드
    public void addLast(Object data){
        add(size,data);
    }

    //첫번째에 노드를 추가하는 메서드
    public void addFirst(Object data){
        add(0,data);
    }

    public void removeLast(){   //배열와 인덱스 세는 것이 같다
        remove(size-1);
    }

    public void removeFirst(){
        remove(0);
    }

    public int size(){
        return size;
    }

    @Override
    public String toString(){
        StringBuilder stringBuilder = new StringBuilder();
        Node pointer = head;
        stringBuilder.append("head").append("->");
        while(null != pointer){
            stringBuilder.append(pointer.data).append("->");
            pointer = pointer.next;
        }
        stringBuilder.append("null");
        return stringBuilder.toString();
    }
}
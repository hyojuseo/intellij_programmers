package double_list;

public class DoublyLinkedList {
    Node head = null;
    Node tail = null;
    int size = 0;

    //index 찾기
    //중간보다 작으면 head로, 중간보다 크거나 같으면 tail로 찾는다.
    private Node findNode(int searchIndex){
        if(0 > searchIndex || size <= searchIndex){
            throw new ArrayIndexOutOfBoundsException();
        }

        int nodeIndex;
        Node pointer;

        if(size / 2 > searchIndex){
            nodeIndex = 0;
            pointer = head;
            while(nodeIndex != searchIndex){
                ++nodeIndex;
                pointer = pointer.right;
            }
        } else {    //중간index보다 큰경우
            nodeIndex = size-1;
            pointer = tail;
            while(nodeIndex != searchIndex){
                --nodeIndex;
                pointer = pointer.left;
            }
        }
        return pointer;
    }


    //삽입
    //최초, 맨앞, 맨뒤, 중간을 고려
    public void add(int index, Object data){
        Node node = new Node();
        node.data = data;

        if(0==index || size == index){  //index가 0이거나 size가 0 이라면 최초, 맨앞, 맨뒤삽입경우임
            if(null == this.head && null == this.tail){ //최초일때. head와 tail은 null을 가리키고 있다.
                this.head = node;
                this.tail = node;
            } else if(0 == index){  //맨앞 삽입인 경우
                node.right = this.head; //head가 가리키고 있는 참조값을 새 노드 right변수에 저장한다
                this.head.left = node;
                this.head = node;
            } else {    //맨 뒤 삽입인 경우
                node.left = this.tail;
                this.tail.right = node;
                this.tail = node;
            }
        } else {    //중간 삽입인 경우
            Node foundNode = findNode(index);   //삽입할노드위치. 노드A
            Node leftNode = foundNode.left; //노드A의 left변수 참조값은 원래 노드A의 왼쪽 노드임.
            node.right =foundNode;  //새 노드의 right변수에 노드A의 참조값을 저장한다
            foundNode.left = node;
            //새 노드의 left변수에 삽입위치의 왼쪽노드 참조값인 leftNode를 저장한다.
            node.left = leftNode;
            leftNode.right = node;  //삽입노드의 왼쪽 노드의 right변수를 삽입노드 참조값으로 저장한다.
        }
        ++size;
    }


    //제거
    //노드가 한개 일때의 삭제, 맨앞, 맨뒤, 중간삭제를 고려
    public void remove(int index){
        //삭제하려는 노드찾기
        Node removeNode = findNode(index);
        Node leftNode = removeNode.left;
        Node rightNode = removeNode.right;
        if(null != leftNode){   //왼쪽 노드가 존재하는 경우
            leftNode.right = rightNode;
        }
        if(null != rightNode){   //오른쪽 노드가 존재하는 경우
            rightNode.left = leftNode;
        }
        if(0 == index){ //맨앞 노드삭제
            this.head = rightNode;
        }
        if((size-1) == index){    //맨뒤 노드삭제
            this.tail = leftNode;
        }
        removeNode.left = null;
        removeNode.right = null;
        removeNode.data = null;

        --size;
    }


    //검색한 index data 가져오기\
    public Object getData(int searchIndex){
        return findNode(searchIndex).data;
    }
    //노드가 비어있는지 확인하는 메서드
    public boolean isEmpty(){
        return 0 == size;
    }
    //노드의 개수를 반환하는 메서드
    public int size(){
        return size;
    }
    //마지막 노드로 추가하는 메서드
    public void addLast(Object data){
        add(size, data);
    }
    //첫번째 노드로 추가하는 메서드
    public void addFirst(Object data){
        add(0, data);
    }
    //마지막 노드를 삭제하는 메서드
    public void removeLast(){
        remove(size-1);
    }
    //첫번째 노드 삭제하는 메서드
    public void removeFirst(){
        remove(0);
    }

    @Override
    public String toString(){
        StringBuilder stringBuilder = new StringBuilder();
        Node pointer = head;
        stringBuilder.append("head").append("->");
        while(null != pointer){
            stringBuilder.append(pointer.data).append("->");
            pointer = pointer.right;
        }
        stringBuilder.append("null ");

        if(null != tail){
            stringBuilder.append(", tail(").append(tail.data).append("),");
        }
        pointer = tail;
        stringBuilder.append("tail").append("->");
        while(null != pointer){
            stringBuilder.append(pointer.data).append("->");
            pointer = pointer.left;
        }

        stringBuilder.append("null");
        if(null != head){
            stringBuilder.append(", head(").append(head.data).append(")");
        }
        return stringBuilder.toString();
    }



}

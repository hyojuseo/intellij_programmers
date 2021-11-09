package list_stack;

public class ListStack {
    private Node head;

    public boolean isEmpty(){
        return null == head;
    }
    public void push(Object data){
        Node node = new Node();
        node.data = data;
        if(!isEmpty()){
            node.next = head;
        }
        head = node;
    }

    public Object pop(){
        if(isEmpty()){
            throw new RuntimeException("stack is empty");
        }
        Node removeNode = head; //항상 삭제할 노드는 head가 가리키는 노드이다.
        Object tempData = removeNode.data;  //삭제할 노드의 데이터를 임시저장
        head = removeNode.next; //head노드는 삭제할 다음 노드를 가리킨다.

        removeNode.data = null;
        removeNode.next = null;
        return tempData;
    }

    public Object peek(){
        if(isEmpty()){
           return null;
        }
        return head.data;
    }

    @Override
    public String toString(){
        StringBuilder stringBuilder = new StringBuilder();
        if(isEmpty()){
            return "Empty Stack";
        }
        stringBuilder.append("top").append(" | ");
        Node pointer = head;
        while(null != pointer){
            stringBuilder.append(pointer.data).append(" | ");
            pointer = pointer.next;
        }
        stringBuilder.append("bottom");
        return stringBuilder.toString();
    }
}

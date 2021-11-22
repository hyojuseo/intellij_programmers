package queue;

public class ListQueue {
    private Node front;
    private Node rear;

    //Queue가 비어있으면 true
    public boolean isEmpty(){
        return null == front;
    }

    //노드를 추가할 때
    public void add(Object data){
        Node newNode = new Node();
        newNode.data = data;
        //비어있으면 rear와 front가 새 노드를 가리킨다
        if(isEmpty()){
            front = rear = newNode;
        } else{
            rear.next = newNode;
            rear = newNode;
        }
    }

    //노드를 제거할 때
    public Object poll(){
        //제거할 데이터가 있는지 확인을 위해 Queue가 비어있는지 확인
        if(isEmpty()){
            return null;
        }
        Node removeNode = front;
        //삭제할 노드의 데이터를 임시저장한다.
        Object tempData = removeNode.data;
        //삭제할 노드의 참조값을 front에 저장한다.
        front = removeNode.next;

        //제거할 노드가 마지막 노드일 때
        if(removeNode == rear){
            rear = null;
        }
        return tempData;
    }

    //맨 위의 데이터를 확인한다.
    public Object peek(){
        //Queue가 비어있으면 null을 반환
        if(isEmpty()){
            return null;
        }
        //그렇지 않으면 front의 데이터 반환
         return front.data;
    }

    public String toString(){
        StringBuilder builder = new StringBuilder();
        Node cursor = front;
        builder.append("앞").append("->");
        //Queue가 비어있지 않다면
        while(null != cursor){
            builder.append(cursor.data).append("->");
            cursor = cursor.next;
        }
        builder.append("뒤");
        return builder.toString();
    }
}

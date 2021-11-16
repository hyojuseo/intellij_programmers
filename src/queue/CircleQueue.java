package queue;

public class CircleQueue {
    private final Object[] queue;
    private int front = 0;
    private int rear = 0;

    public CircleQueue(int size) {
        this.queue = new Object[size];
    }

    //추가할때는 queue가 꽉 찼는지확인
    public void add(Object data){
        if(front == rear && null != queue[rear]){
            throw new RuntimeException("Queue is Full");
        }
        queue[rear] = data;
        ++rear;
        rear = rear% queue.length;
    }

    //꺼낼때는 queue가 빈 상태인지 확인
    public Object poll() {
        //front == rear && front가 null이면 queue 빈 것
        if(front == rear && queue[front] == null){
            return null;
        }
        Object data = queue[front];
        queue[front] = null;
        ++front;
        front = front % queue.length;
        return data;
    }

    public Object peek(){
        return queue[front];
    }

    @Override
    public String toString(){
        int tempFront = front;
        int tempRear = rear;
        StringBuilder builder = new StringBuilder();
        builder.append("앞").append("->");

        //front와 rear가 동일한 경우 꽉차있거나 비어있는 경우이다.
        if(tempFront == tempRear && queue[tempFront] != null){
            builder.append(queue[tempFront]).append("->");
            ++tempFront;
            tempFront = tempFront % queue.length;
        }
        while(tempFront != tempRear){
            builder.append(queue[tempFront]).append("->");
            ++tempFront;
            tempFront = tempFront % queue.length;
        }
        builder.append("뒤");
        return builder.toString();
    }
}

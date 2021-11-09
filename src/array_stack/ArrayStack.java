package stack;

public class ArrayStack {
    private int top = -1;
    private final Object[] stack;

    public ArrayStack(int stackSize){
        this.stack = new Object[stackSize];
    }

    //1. 데이터가 존재하는지 확인한다.
    //존재하지 않으면 true 존재하면 false
    public boolean isEmpty(){
        return -1 == top;
    }

    //2. stack이 꽉 찼는지 확인한다.
    //꽉찼으면 true 꽉 안찼으면 false
    public boolean isFull(){
        return stack.length -1 == top;
    }

    //3. 데이터를 넣는다.
    public void push(Object data){
        if(isFull()){
            throw new RuntimeException("stack is full");
        }
        stack[++top] = data;
    }

    //4. 데이터를 꺼낸다.
    public Object pop(){
        if(isEmpty()){
            throw new RuntimeException("stack is empty");
        }
        Object tempData = stack[top];
        stack[top--] = null;
        return tempData;
    }

    //5. 맨 위의 데이터가 무엇인지 확인한다.
    public Object peek(){
        if(isEmpty()){  //데이터가 존재하지않으면
            return null;
        }
        return stack[top];
    }

    @Override
    public String toString(){
        StringBuilder builder = new StringBuilder();
        if(isEmpty()){
            return "Empty Stack";
        }
        builder.append("bottom").append(" | ");
        for(int i=0; i<=top; i++){
            builder.append(stack[i]).append(" | ");
        }
        builder.append("top");
        return builder.toString();
    }
}

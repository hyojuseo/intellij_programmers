package double_generic_list;

import java.util.*;

public class GenericDoublyLinkedList<E> implements List<E> {
    private GenericNode<E> head = null;
    private GenericNode<E> tail = null;
    private int size = 0;

    private GenericNode<E> findNode(int searchIndex) {
        if (0 > searchIndex || size <= searchIndex) {
            throw new ArrayIndexOutOfBoundsException();
        }
        int nodeIndex;
        GenericNode<E> pointer;

        if (size / 2 > searchIndex) {
            nodeIndex = 0;
            pointer = head;
            while (nodeIndex != searchIndex) {
                ++nodeIndex;
                pointer = pointer.right;
            }
        } else {
            nodeIndex = size - 1;
            pointer = tail;
            while (nodeIndex != searchIndex) {
                --nodeIndex;
                pointer = pointer.left;
            }
        }
        return pointer;
    }


    //최초, 맨앞, 맨뒤 ,중간삽입 고려
    @Override
    public void add(int index, E data) {
        GenericNode<E> node = new GenericNode<>();
        node.data = data;

        if (0 == index || size == index) {    //최초
            if (null == head && null == tail) {
                this.head = node;
                this.tail = node;
            } else if (0 == index) {    //맨앞
                node.right = this.head;
                this.head.left = node;
                this.head = node;
            } else {
                node.left = this.tail;
                this.tail.right = node;
                this.tail = node;
            }
        } else {
            GenericNode<E> foundNode = findNode(index);
            GenericNode<E> leftNode = foundNode.left;

            node.right = foundNode;
            foundNode.left = node;
            node.left = leftNode;
            leftNode.right = node;
        }
        ++size;
    }


    //노드를 삭제하고 삭제된 노드의 data값을 반환한다.
    private E removeNode(GenericNode<E> removeNode){
        GenericNode<E> leftNode = removeNode.left;
        GenericNode<E> rightNode = removeNode.right;
        E data = removeNode.data;

        if(null != leftNode){   //좌측노드가 존재하는 경우
            leftNode.right = rightNode;
        }
        if(null != rightNode){//우측노드가 존재하는 경우
            rightNode.left = leftNode;
        }
        if(null == leftNode){   //맨앞 노드 삭제 시
            this.head = rightNode;
        }
        if(null == rightNode){
            this.tail = leftNode;
        }
        removeNode.left = null;
        removeNode.right = null;
        removeNode.data = null;

        --size;
        return data;
    }


    @Override
    public E remove(int index){
        GenericNode<E> removeNode = findNode(index);
        return removeNode(removeNode);
    }

    public E removeFirst(){
        return remove(0);
    }
    public E removeLast(){
        return remove(size-1);
    }
    public void addFirst(E data){
        add(0,data);
    }
    public void addLast(E data){
        add(size,data);
    }

    @Override
    public boolean isEmpty(){
        return 0==size;
    }

    @Override
    public boolean contains(Object data){
        return indexOf(data) != -1;
    }

    @Override
    public boolean add(E data){
        try{
            add(size,data);
            return true;
        } catch(ArrayIndexOutOfBoundsException e){
            return false;
        }
    }

    //데이터를 찾아 존재하면 삭제한다. 성공 true, 실패 false
    @Override
    public boolean remove(Object data){
        GenericNode<E> pointer = head;
        while(null != pointer){
            if(null == data && null == pointer.data){
                removeNode(pointer);
                return true;
            } else if(null != data && data.equals(pointer.data)){
                removeNode(pointer);
                return true;
            }
            pointer = pointer.right;
        }
        return false;
    }


    //맨뒤에서부터 데이터를 순차적으로 삽입한다
    @Override
    public boolean addAll(Collection collection){
        return addAll(size,collection);
    }

    //index를 기준으로 index이후로부터의 노드를 삽입한다.
    @Override
    public boolean addAll(int index, Collection collection){
        if(0 > index || size <index){
            throw new ArrayIndexOutOfBoundsException();
        }
        Object[] array = collection.toArray();
        if(0 == array.length) return false;
        for(Object data : array){
            @SuppressWarnings("unchecked") E tempData = (E) data;
            add(index, tempData);
            ++index;
        }
        return true;
    }

    //모든 노드의 링크를 끊는다.
    @Override
    public void clear(){
        GenericNode<E> pointer = head;
        while(null !=pointer){
            GenericNode<E> rightNode = pointer.right;
            pointer.data = null;
            pointer.right = null;
            pointer.left = null;
            pointer = rightNode;
        }
        head = tail = null;
        size = 0;
    }

    //index에 해당하는 노드의 데이터를 반환한다.
    @Override
    public E get(int index){
        return findNode(index).data;
    }

    //index에 해당하는 기존 노드의 데이터를 변경한다.
    @Override
    public E set(int index, E data){
        GenericNode<E> foundNode = findNode(index);
        foundNode.data = data;
        return data;
    }

    //교집합 구하기(원본 훼손)
    @Override
    public boolean retainAll(Collection collection){
        if(null == collection){
            throw new NullPointerException();
        }
        boolean modified = false;
        GenericNode<E> pointer = head;
        while( null != pointer){
            GenericNode<E> tempRightNode = pointer.right;
            if(!collection.contains(pointer.data)){
                this.removeNode(pointer);
                modified = true;
            }
            pointer = tempRightNode;
        }
        return modified;
    }

    //여집합 구하기(원본 훼손)
    @Override
    public boolean removeAll(Collection collection){
        if(null == collection){
            throw new NullPointerException();
        }
        boolean modified = false;
        GenericNode<E> pointer = head;
        while(null!=pointer){
            GenericNode<E> tempRightNode = pointer.right;
            if(collection.contains(pointer.data)){
                this.removeNode(pointer);
                modified = true;
            }
            pointer = tempRightNode;
        }
        return modified;
    }

    //노드에 collection이 포함하는 데이터를 모두 가지고 있는지 확인한다.
    @Override
    public boolean containsAll(Collection collection){
        for(Object data : collection){
            if(!contains(data)){
                return false;
            }
        }
        return true;
    }

    //fromIndex부터 toIndex 까지 데이터를 가진 list 반환
    @Override
    public List<E> subList(int fromIndex, int toIndex){
        if(fromIndex > toIndex || size < fromIndex || size <=toIndex){
            throw new ArrayIndexOutOfBoundsException();
        }
        int index = fromIndex;
        List<E> list = new ArrayList<>(size);
        GenericNode<E> pointer = findNode(fromIndex);

        while(null != pointer && index -1 != toIndex){
            list.add(pointer.data);
            pointer = pointer.right;
            ++index;
        }
        return list;
    }

    //노드의 데이터를 배열로 반환
    @Override
    public Object[] toArray(){
        Object[] result = new Object[size];
        int index = 0;
        GenericNode<E> pointer =head;
        while(null != pointer){
            result[index++] = pointer.data;
            pointer =pointer.right;
        }
        return result;
    }

    @SuppressWarnings("unchecked")
    @Override
    public <T> T[] toArray(T[] array){
        if(array.length < size){
            array = (T[]) java.lang.reflect.Array.newInstance(
                    array.getClass().getComponentType(),size);
        }
        int i=0;
        Object[] result = array;
        for(GenericNode<E> x = head; x!=null; x=x.right){
            result[i++] = x.data;
        }
        if(array.length > size){
            array[size] = null;
        }
        return array;
    }


    //노드의 개수를 반환하는 메서드드
    @Override
    public int size(){
        return size;
    }

    //앞에서부터 검색
    @Override
    public int indexOf(Object data){
        int index = 0;
        GenericNode<E> pointer = head;
        while(null != pointer){
            //찾는 데이터도 null이고 노드에 저장된 데이터도 null인경우
            if(null == data && null == pointer.data){
                return index;
            } else if (null != data && data.equals(pointer.data)){
                return index;
            }
            pointer = pointer.right;
            ++index;
        }
        return -1;
    }

    //뒤에서부터 검색
    @Override
    public int lastIndexOf(Object data){
        int index = size -1;
        GenericNode<E> pointer = tail;
        while(null != pointer){
            if(null == data && null == pointer.data){
                return index;
            } else if(null != data && data.equals(pointer.data)){
                return index;
            }
            pointer = pointer.left;
            --index;
        }
        return -1;
    }

    @Override
    public Iterator<E> iterator(){
        throw new RuntimeException("DoublyLinkedList에서 미구현입니다.");
    }
    @Override
    public ListIterator<E> listIterator(){
        throw new RuntimeException("DoublyLinkedList에서 미구현입니다.");
    }
    @Override
    public ListIterator<E> listIterator(int index){
        throw new RuntimeException("DoublyLinkedList에서 미구현입니다.");
    }

    @Override
    public String toString(){
        StringBuilder stringBuilder = new StringBuilder();
        GenericNode<E> pointer = head;
        stringBuilder.append("head").append("->");

        while (null != pointer) {
            stringBuilder.append(pointer.data).append(" -> ");
            pointer = pointer.right;
        }
        stringBuilder.append("null ");
        if (null != tail) {
            stringBuilder.append(", tail(").append(tail.data).append("), ");
        }
        pointer = tail;
        stringBuilder.append("tail").append(" -> ");
        while (null != pointer) {
            stringBuilder.append(pointer.data).append(" -> ");
            pointer = pointer.left;
        }
        stringBuilder.append("null");
        if (null != head) {
            stringBuilder.append(", head(").append(head.data).append(")");
        }
        return stringBuilder.toString();
    }


}

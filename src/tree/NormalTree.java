package tree;

import java.util.LinkedList;
import java.util.Queue;

public class NormalTree {
    private Node root;

    public void add(int key){
        Node newNode = new Node();
        newNode.key = key;

        //root노드가 비어 있을때
        if(null == root){
            root = newNode;
        } else {
            Queue<Node> queue = new LinkedList<>();
            queue.offer(root);
            while(!queue.isEmpty()){
                Node x = queue.poll();
                //좌측추가
                if(null != x.left){ //좌측노드가 있다면 queue에 추가
                    queue.offer(x.left);
                } else {
                    x.left = newNode;
                    break;
                }
                //우측추가
                if(null != x.right){    //우측노드가 있다면 queue에 추가
                    queue.offer(x.right);
                } else {
                    x.right = new Node();
                    break;
                }
            }
        }
    }
    //위에서 아래, 좌측에서 우측으로 순회
    public void levelOrder(){
        if(null == root){
            return;
        }
        Queue<Node> queue = new LinkedList<>();
        queue.offer(root);
        while(!queue.isEmpty()){
            Node parentNode = queue.poll();

            System.out.printf("%d ", parentNode.key);

            if(null != parentNode.left){
                queue.offer(parentNode.left);
            }
            if(null != parentNode.right){
                queue.offer(parentNode.right);
            }
        }
        System.out.println("");
    }

    private void printHelper(Node x, String indent, boolean last){
        if( x != null){
            System.out.print(indent);
            if(last){
                System.out.print("R----");
                indent += "   ";
            } else {
                System.out.print("L----");
                indent += "|  ";
            }

            System.out.println(x.key);
            printHelper(x.left, indent, false);
            printHelper(x.right, indent, true);
        }
    }

    public void printTree(){
        printHelper(this.root, "", true);
    }
}

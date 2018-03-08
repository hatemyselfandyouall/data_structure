package trees;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.LinkedList;

/**
 * Created by YS-GZD-1495 on 2018/3/6.
 */
public class AVLTree   {
    private Node root;

    class Node{
        int val;
        Node leftChild;
        Node rightChild;
        int height;
        int right;
        Node(int val,Node leftChild,Node rightChild,int height,int right){
            this.val=val;
            this.leftChild=leftChild;
            this.rightChild=rightChild;
            this.height=height;
            this.right=right;
        }
        @Override
        public String toString() {
            return val+"";
        }

    }

    public  void init(int[] numbers){
        if (numbers==null||numbers.length==0){
            return;
        }else {
            root=new Node(numbers[0],null,null,0,0);
        }
        for (int i=1;i<numbers.length;i++){
            add(numbers[i]);
        }
    }


    public void  add(int number){
        if (root==null){
            root=new Node(number,null,null,0,0);
            return;
        }
        Node target=root;
        int height=0;
        int right=0;
        while (target!=null){
            height++;
            if (number==target.val){
                break;
            }
            if (number>target.val){
                right++;
                if (target.rightChild==null){
                    target.rightChild=new Node(number,null,null,height,right);
//                    checkHeight(target.rightChild,1);
                    break;
                }else {
                    if (number>target.val){
                        target=target.rightChild;
                    }else {
                        target=target.leftChild;
                    }
                }
            }else {
                right--;
                if (target.leftChild==null){
                    target.leftChild=new Node(number,null,null,height,right);
//                    checkHeight(target.rightChild,2);
                    break;
                }else {
                    if (number>target.val){
                        target=target.rightChild;
                    }else {
                        target=target.leftChild;
                    }
                }
            }
        }
    }

    private void checkHeight(Node node,int side){
        int rightHeight,leftHeight;
        Node target=root;
        if (side==1){
            rightHeight=node.height;
            leftHeight=0;
            while (target!=null){
                leftHeight++;
                if (target.leftChild==null){

                }
                target=target.leftChild;
            }
        }else {
            leftHeight=node.height;
        }
    }





    public ArrayDeque<Node> levelOrderTraversal() {
        if (root == null) {
            System.out.println("empty tree");
            return null;
        }
        ArrayDeque<Node> queue = new ArrayDeque<>();
        ArrayDeque<Node> result = new ArrayDeque<>();
        queue.add(root);
        while (queue.isEmpty() == false) {
            Node node = queue.remove();
            result.push(node);
            if (node.leftChild != null) {
                queue.add(node.leftChild);
            }
            if (node.rightChild != null) {
                queue.add(node.rightChild);
            }
        }
        return result;
    }


    @Override
    public String toString() {
        ArrayDeque<Node> elements=levelOrderTraversal();
        if (elements==null){
            return null;
        }
        int height=elements.getFirst().height;
        String[] lines=new String[height+1];
        int[] rightCounts=new int[height+1];
//        StringBuilder sb=new StringBuilder();
        while (!elements.isEmpty()){
            Node temp=elements.pollLast();
            if (lines[temp.height]==null){
                lines[temp.height]=getInterval(height+temp.right)+ temp.val;
                rightCounts[temp.height]=temp.right;
            }
            else {
                lines[temp.height]=lines[temp.height]+getInterval(temp.right-rightCounts[temp.height])+ temp.val;
            }
        }
        String result="";
        for (String string:lines){
            result+=string+"\r\n";
        }
        return result;
    }

    String getInterval(int number){
        if (number<=0){
            return "";
        }else {
            StringBuilder sb=new StringBuilder();
            for (int i=1;i<=number;i++){
                sb.append("     ");
            }
            return sb.toString();
        }
    }


    public static void main(String[] args) {
        AVLTree avlTree=new AVLTree();
        avlTree.init(new int[]{1,7,6,8,12,55,9});
        System.out.println(avlTree);
    }

}

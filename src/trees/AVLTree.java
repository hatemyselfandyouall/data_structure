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

    public void leftChange(Node node){
        if (node==null||node.leftChild==null){
            return;
        }
        Node left=node.leftChild;
        left.leftChild=node;
        node.leftChild=left.rightChild;
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
                lines[temp.height]=getInterval(height,temp.height,temp.right)+ temp.val;
                rightCounts[temp.height]=temp.right;
            }
            else {
                lines[temp.height]=lines[temp.height]+getInterval(height,temp.height,temp.right-rightCounts[temp.height])+ temp.val;
            }
        }
        String result="";
        for (String string:lines){
            result+=string+"\r\n";
        }
        return result;
    }

    String getInterval(int totakHeight,int height,int right){
        int oughtWidth=0;
        int i=1;
        for (;i<=totakHeight;i=i<<1){
            oughtWidth+=i;
        }
        oughtWidth*=2;
        System.out.println(oughtWidth+""+i);
        return "";
    }


    public static void main(String[] args) {
        AVLTree avlTree=new AVLTree();
        avlTree.init(new int[]{10,12,11,13,7,5,9,4,6,8,3});
        System.out.println(avlTree);
    }

}

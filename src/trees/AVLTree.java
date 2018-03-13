//package trees;
//
//import java.util.*;
//import java.util.stream.Collector;
//import java.util.stream.Collectors;
//
///**
// * Created by YS-GZD-1495 on 2018/3/6.
// */
//public class AVLTree   {
//    private Node root;
//
//    class Node{
//        int val;
//        Node leftChild;
//        Node rightChild;
//        int height;
//        int right;
//        Node(int val,Node leftChild,Node rightChild,int height,int right){
//            this.val=val;
//            this.leftChild=leftChild;
//            this.rightChild=rightChild;
//            this.height=height;
//            this.right=right;
//        }
//        @Override
//        public String toString() {
//            return val+"";
//        }
//
//    }
//
//    public  void init(int[] numbers){
//        if (numbers==null||numbers.length==0){
//            return;
//        }else {
//            root=new Node(numbers[0],null,null,0,0);
//        }
//        for (int i=1;i<numbers.length;i++){
//            add(numbers[i]);
//        }
//    }
//
//
//    public void  add(int number){
//        if (root==null){
//            root=new Node(number,null,null,0,0);
//            return;
//        }
//        Node target=root;
//        int height=0;
//        int right=0;
//        while (target!=null){
//            height++;
//            if (number==target.val){
//                break;
//            }
//            if (number>target.val){
//                right++;
//                if (target.rightChild==null){
//                    target.rightChild=new Node(number,null,null,height,right);
////                    checkHeight(target.rightChild,1);
//                    break;
//                }else {
//                    if (number>target.val){
//                        target=target.rightChild;
//                    }else {
//                        target=target.leftChild;
//                    }
//                }
//            }else {
//                right--;
//                if (target.leftChild==null){
//                    target.leftChild=new Node(number,null,null,height,right);
////                    checkHeight(target.rightChild,2);
//                    break;
//                }else {
//                    if (number>target.val){
//                        target=target.rightChild;
//                    }else {
//                        target=target.leftChild;
//                    }
//                }
//            }
//        }
//    }
//
//    public void leftChange(Node node){
//        if (node==null||node.leftChild==null){
//            return;
//        }
//        Node left=node.leftChild;
//        left.leftChild=node;
//        node.leftChild=left.rightChild;
//    }
//    private int checkHeight(Node node){
//       if (node==null){
//           return 0;
//       }
//       return 1+Math.max(checkHeight(node.leftChild),checkHeight(node.rightChild));
//    }
//
//
//
//
//
//    public ArrayDeque<Node> levelOrderTraversal() {
//        if (root == null) {
//            System.out.println("empty tree");
//            return null;
//        }
//        ArrayDeque<Node> queue = new ArrayDeque<>();
//        ArrayDeque<Node> result = new ArrayDeque<>();
//        queue.add(root);
//        while (queue.isEmpty() == false) {
//            Node node = queue.remove();
//            result.push(node);
//            if (node.leftChild != null) {
//                queue.add(node.leftChild);
//            }
//            if (node.rightChild != null) {
//                queue.add(node.rightChild);
//            }
//        }
//        return result;
//    }
//
//
//    @Override
//    public String toString() {
//        ArrayDeque<Node> elements=levelOrderTraversal();
//        if (elements==null){
//            return null;
//        }
//        int height=elements.getFirst().height;
//        Map<Integer,List<Node>> elementsMap=elements.stream().collect(Collectors.groupingBy(node -> node.height));
//        String result="";
//        Iterator<Integer> iterator=elementsMap.keySet().iterator();
//        while (iterator.hasNext()){
//            result+=getInterval(height,elementsMap.get(iterator.next()));
//        }
//        return result;
//    }
//
//    String getInterval(int totakHeight,List<Node> node){
//        int currentHeight=node.get(0).height;
//        int oughtWidth=0;
//        int i=1;
//        for (;i<=currentHeight;i++){
//            oughtWidth+=1<<i;
//        }
//        System.out.println(oughtWidth);
//        String[] result=new String[oughtWidth];
//        int[] points =new int[];
////        for (int i=0;i<){
////
////        }
//        for (Node temp:node){
//
//        }
//        return "";
//    }
//
//
//
//    public static void main(String[] args) {
//        AVLTree avlTree=new AVLTree();
//        avlTree.init(new int[]{10,12,11,13,7,5,9,4,6,8,3});
//        System.out.println(avlTree);
//    }
//
//}

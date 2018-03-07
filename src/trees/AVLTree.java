package trees;

/**
 * Created by YS-GZD-1495 on 2018/3/6.
 */
public class AVLTree extends TwoForkLookupTree {
    private Node root;

    class Node{
        int val;
        Node leftChild;
        Node rightChild;
        int height;
        Node(int val,Node leftChild,Node rightChild,int height){
            this.val=val;
            this.leftChild=leftChild;
            this.rightChild=rightChild;
            this.height=height;
        }
        @Override
        public String toString() {
            return val+"";
        }

    }


    @Override
    public void  add(int number){
        if (root==null){
            root=new Node(number,null,null,0);
            return;
        }
        Node target=root;
        int height=0;
        while (target!=null){
            if (number==target.val){
                break;
            }
            if (number>target.val){
                if (target.rightChild==null){
                    target.rightChild=new Node(number,null,null,height);
                    checkHeight(target.rightChild,1);
                    break;
                }else {
                    if (number>target.val){
                        target=target.rightChild;
                    }else {
                        target=target.leftChild;
                    }
                }
            }else {
                if (target.leftChild==null){
                    target.leftChild=new Node(number,null,null,height);
                    checkHeight(target.rightChild,2);
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


    public static void main(String[] args) {
        AVLTree avlTree=new AVLTree();
        avlTree.init(new int[]{1,7,6,8,12,55,9});
        avlTree.lterator();
    }

}

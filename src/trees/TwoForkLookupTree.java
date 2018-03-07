package trees;

/**
 * Created by YS-GZD-1495 on 2018/3/5.
 */
public class TwoForkLookupTree {

    private Node root;

    class Node{
        int val;
        Node leftChild;
        Node rightChild;
        Node(int val,Node leftChild,Node rightChild){
            this.val=val;
            this.leftChild=leftChild;
            this.rightChild=rightChild;
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
            root=new Node(numbers[0],null,null);
        }
        for (int i=1;i<numbers.length;i++){
            add(numbers[i]);
        }
    }

    public void  add(int number){
        if (root==null){
            root=new Node(number,null,null);
            return;
        }
        Node target=root;
        while (target!=null){
            if (number==target.val){
                break;
            }
            if (number>target.val){
                if (target.rightChild==null){
                    target.rightChild=new Node(number,null,null);
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
                    target.leftChild=new Node(number,null,null);
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

    /**
     * 遍历
     */
    public void lterator(){
        if (root==null){
            System.out.println("empty");
            return;
        }
        lterator(root);
    }

    private void lterator(Node node){
        if (node.leftChild!=null) {
            lterator(node.leftChild);
        }
        System.out.println(node);
        if (node.rightChild!=null) {
            lterator(node.rightChild);
        }
    }




    public static void main(String[] args) {
        TwoForkLookupTree twoForkLookupTree=new TwoForkLookupTree();
        twoForkLookupTree.init(new int[]{1,7,6,8,12,55,9});
        twoForkLookupTree.lterator();
    }
}

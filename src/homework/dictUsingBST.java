package homework;

public class dictUsingBST {
    // This is BST Node
    class Node{
        // declared required varaiables
        private String key;
        private Node left,right;
        public Node(String element){
            key=element;
            left=null;
            right=null;
        }
        // using getter and setter
        public void setRightChild(Node n){
            right=n;
        }
        public void setLeftChild(Node n){
            left=n;
        }
        public Node getLeftChild(){
            return left;
        }
        public  Node getRightChild(){
            return right;
        }
        public String toString(){
            return key;
        }
    }
    // declaring root
    Node root;
    // constructor making root as null
    dictUsingBST(){
        root = null;
    }
    // this function add key to BST tree
    void add(String key){
        root = addKey(root,key);
    }
    // this function traverse and add key
    Node addKey(Node root,String key){
        // if root is null new Node is created and making it root by returning it
        if(root == null){
            root=new Node(key);
            return root;
        }
        //x.compareTo(y) is 0 when x==y
        // is positive when x>y
        // is neagative when x<y
        // if key is less than root key then traverse through left
        if(key.compareTo(root.toString())<0){
            root.setLeftChild(addKey(root.left,key));
        }
        // if key is greater than root key then traverse through right
        else if(key.compareTo(root.toString())>0){
            root.setRightChild(addKey(root.right,key));
        }
        return root;
    }
    // this function print elements in tree in inorder fashion i.e sorted way i.e lexicographic order
    public static void printTree(Node root){
        if(root!=null){
            printTree(root.getLeftChild());
            System.out.println(root.toString());
            printTree(root.getRightChild());
        }
    }
    // search the given in value in tree and returns true if present else false
    public static boolean search(Node root,String value){
        while(root!=null){
            if(value.compareTo(root.toString())<0)
                root=root.getLeftChild();
            else if(value.compareTo(root.toString())>0)
                root=root.getRightChild();
            else
                return true;
        }
        return false;
    }
    public static void main(String[] args) {
        dictUsingBST tree = new dictUsingBST();
        tree.add("Yash");
        tree.add("aravindh");
        tree.add("ashok");
        tree.add("abhi");
        printTree(tree.root);
        System.out.println("Finding abhi in tree:"+tree.search(tree.root,"abhi"));
        System.out.println("Finding charan in tree "+tree.search(tree.root,"charan"));

    }
}

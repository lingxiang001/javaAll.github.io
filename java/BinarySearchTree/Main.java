package BinarySearchTree;

public class Main {

    public static void main(String[] args) {
        TreeNode node1=new TreeNode("1","a");
        TreeNode node2=new TreeNode("2","b");
        BinarySearchTreeImpl<String,String> tree=new BinarySearchTreeImpl<String,String>();
        tree.insert("1", "a");
        tree.insert("2", "b");
        tree.insert("0", "c");
       // System.out.println("5".hashCode());
        tree.insert("5", "wc");
        tree.insert("4", "f");
        tree.insert("9", "h");
        
        tree.insert("7", "c");
        System.out.println(tree.getSize());
       tree.inorder(tree.root);
       tree.remove("5");
       System.out.println("***********");
       tree.inorder(tree.root);
       /* System.out.println(tree.getSize());
        tree.remove("1");
        System.out.println(tree.getSize());*/
       /* Maper<String,String> map=new Maper<String,String>();
        map.put("2","b");
        map.put("3", "c");
        map.put("3", "a");
       int size= map.getSize();
       System.out.println(size);
       String val=map.getValue("3");
       System.out.println(val);
       map.remove("2");
       size= map.getSize();
       System.out.println(size);
       System.out.println(map.getValue("2"));
*/
    }

}

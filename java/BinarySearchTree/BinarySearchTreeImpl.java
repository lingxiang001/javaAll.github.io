package BinarySearchTree;

public class BinarySearchTreeImpl<K,V> implements BinarySearchTree<K, V> {
   TreeNode root=null;//   根节点
   private int size=0;//节点数
    @Override
    public void insert(K k, V v) {
        TreeNode newNode=new TreeNode(k,v);
        TreeNode parent;
        
            if(null == root){
                parent=null;
                root=newNode;
                root.parent=parent;
                size++;
              
            }else{
                TreeNode currentNode=root;
                parent=currentNode;
                while(true){
                if(newNode.getKey().hashCode()<=currentNode.getKey().hashCode()){
                 
//                    currentNode=currentNode.getChildL();
                    if(null == currentNode.getChildL()){
//                        currentNode=newNode;
                        size++;
                        newNode.isLeftNode=true;
                        newNode.parent=currentNode;
                        currentNode.setChildL(newNode);
                        System.out.println("success");
                        break;
                    }
                    currentNode = currentNode.getChildL();
                    continue;
                }else{
                   
//                    currentNode=currentNode.getChildL();
                    if(null == currentNode.getChildR()){
                        size++;
                        newNode.isLeftNode=false;
                        newNode.parent=currentNode;
                        currentNode.setChildR(newNode);
                        System.out.println("success");
                        break;
                    }
                    currentNode = currentNode.getChildR();
                    continue;
                }
            }
        }
        
        
    }

    @Override
    public void inorder(TreeNode root) {
        if(root != null){
            inorder(root.getChildL());
            System.out.println(root);
            inorder(root.getChildR());
        }
       
    }

    @Override
    public V lookupValue(K key) {
       return (V) lookupNode(key).getValue();
    }
    private TreeNode lookupNode(K key){
        TreeNode current =root;
       /* if(current.getKey().hashCode()==key.hashCode()){
             return current;
        }*/
      //  System.out.println(key.hashCode());
        while(current !=null && current.getKey().hashCode() != key.hashCode()){
           
            if(key.hashCode()<current.getKey().hashCode()){
                current=current.getChildL();
            }else{
                current=current.getChildR();
            }
            
        }
        return current;
    }

    @Override
    public K min() {
        TreeNode current=root;
        while(null != current.getChildL()){
            current=current.getChildL();
        }
        return (K) current.getKey();
    }

    @Override
    public K max() {
        TreeNode current=root;
        while(null != current.getChildR()){
            current=current.getChildR();
        }
        return (K) current.getKey();
    }

    @Override
    public void remove(K key) {
        removeNode(lookupNode(key)); 
        size--;
    }
    private void removeNode(TreeNode<K,V> node){
        if(null != node){
            //该节点没有叶子节点
            if(node.getChildL() == null && node.getChildR() == null){
                if(node.isLeftNode){
                    node.parent.setChildL(null);
                }else{
                    //根节点
                    if(node.parent == null){
                        root=null;
                    }else{
                        node.parent.setChildR(null);
                    }
                }
                node=null;
                //左子树为空
            }else if(node.getChildL() == null){
                if(node.isLeftNode){
                    node.parent.setChildL(node.getChildR());
                    node.getChildR().isLeftNode=true;
                    node.getChildR().parent=node.parent;
                }else{
                    if(node.parent != null){
                        node.parent.setChildR(node.getChildR());
                        node.getChildR().parent=node.parent;
                    }else{
                        root=node.getChildR();
                    }
                }
                node=null;
                //右子树为空
            }else if(node.getChildR() == null){
                if(node.isLeftNode){
                    node.parent.setChildL(node.getChildL());
                    node.getChildL().isLeftNode=true;
                    node.getChildL().parent=node.parent;
                }else{
                    if(node.parent !=null){
                        node.parent.setChildR(node.getChildL());
                        node.getChildL().isLeftNode=false;
                        node.getChildL().parent=node.parent;
                    }else{
                        root=node.getChildL();
                    }
                }
                node=null;
                //都不为空
            }else{
                TreeNode minNode=minNode(node.getChildR());
                node.setKey((K)minNode.getKey());
                removeNode(minNode);
            }
            
        }
    }
    private TreeNode <K,V> minNode(TreeNode p) {
        while (p.getChildL() != null) {
            p = p.getChildL();
        }
        return p;
    }

    @Override
    public K successor(K x) {
        
        return null;
    }

    @Override
    public K predecessor(K x) {
       
        return null;
    }

    @Override
    public int getSize() {
        return size;
        
    }

}

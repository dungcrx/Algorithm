package datastructure;

/**
 * Created by phandung on 5/23/17.
 */
public class BinarySearchTree<T extends Comparable<T> > implements Tree<T> {

    private TreeNode<T> root;
    @Override
    public void insert(T data) {

        if(root == null){
            root = new TreeNode<>(data);
        } else {
            insertNode(data,root);
        }
    }


    private void insertNode(T newData , TreeNode<T> root) {
        if(newData.compareTo(root.getData()) < 0){
            if(root.getLeftChild() != null){
                insertNode(newData, root.getLeftChild());
            } else{
                root.setLeftChild(new TreeNode<T>(newData));
            }
        } else {
            if(root.getRightChild() != null){
                insertNode(newData,root.getRightChild());
            } else{
                root.setRightChild(new TreeNode<>(newData));
            }
        }

    }

    @Override
    public void delete(T data) {

        if (root != null)
            root = delete(root, data);
    }
    private TreeNode<T> getPredecessor(TreeNode<T> node) {

        if( node.getRightChild() != null )
            return getPredecessor(node.getRightChild());

        System.out.println("Predecessor is: "+node);
        return node;
    }


    private TreeNode<T> delete(TreeNode<T> node, T data) {


        if( node == null ) return node;

        if( data.compareTo(node.getData()) < 0 ) {
            node.setLeftChild( delete(node.getLeftChild(), data) );
        } else if ( data.compareTo(node.getData()) > 0 ) {
            node.setRightChild( delete(node.getRightChild(), data) );
        } else {

            // we have found the node we want to remove !!!
            if( node.getLeftChild() == null && node.getRightChild() == null ) {
                System.out.println("Removing a leaf node...");
                return null;
            }

            if( node.getLeftChild() == null ) {
                System.out.println("Removing the right child...");
                TreeNode<T> tempNode = node.getRightChild();
                node = null;
                return tempNode;
            } else if( node.getRightChild() == null ) {
                System.out.println("Removing the left child...");
                TreeNode<T> tempNode = node.getLeftChild();
                node = null;
                return tempNode;
            }

            // this is the node with two children case !!!
            System.out.println("Removing item with two children...");
            TreeNode<T> tempNode = getPredecessor(node.getLeftChild());

            node.setData(tempNode.getData());
            node.setLeftChild( delete(node.getLeftChild(), tempNode.getData()) );

        }

        return node;
    }

    @Override
    public void traversal() {
        if(this.root == null){
            System.out.println(" Tree is empty ");
        } else {
            traversalNode(this.root);
        }


    }

    private void traversalNode(TreeNode<T> node) {
        if(node.getLeftChild() != null){
            traversalNode(node.getLeftChild());
        }
        System.out.print(node.getData() + " -->");
        if(node.getRightChild() != null ){
            traversalNode(node.getRightChild());
        }
    }

    @Override
    public T getMax() {
        if(this.root == null){ return null;}
        return getMaxNode(this.root);
    }

    private T getMaxNode(TreeNode<T> root) {
        if(root.getRightChild() == null){
            return root.getData();
        }
        return getMaxNode(root.getRightChild());
    }

    @Override
    public T getMin() {
        if(this.root == null){ return null;}

        return getMinNode(this.root);
    }

    private T getMinNode(TreeNode<T> root) {
        if(root.getLeftChild() == null){
            return root.getData();
        }
        return getMinNode(root.getLeftChild());
    }
}

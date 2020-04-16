package BinaryTree;
import java.math.BigInteger;

public class BinaryTree {
    public BinaryTree(String value, BigInteger key) {
        root = new TreeNode(value, key);
    }


    public BinaryTree() {
        root = null;
    }


    public void Add(String value, BigInteger key) {
        //BinaryTree is empty;
        if(root == null) {
            root = new TreeNode(value, key);
            return;
        }
        TreeNode current;
        current = FindPlace(key, root);
        // can not find place to insert;
        if(current == null) {
            return;
        }
        // if find place to insert;
        TreeNode newNode = new TreeNode(value, key);
        if(current.key.compareTo(key) < 0) {
            current.rightChild = newNode;
        } else {
            current.leftChild = newNode;
        }
    }


    public void PrintTree() {
        Print(root);
    }


    public void PrintSortTree() {
        PrintSort(root);
    }

    public void Find(final BigInteger key) {
        TreeNode current = FindNode(key, root);
        if(current != null) {
            current.Print();
        }
    }

    public  void Delete(final BigInteger key) {
        root = DeleteRecursive(key,root);
        /*
        wrong answer:
        TreeNode current = Find(key,root);
        if(current == null) {
            return null;
        }
        //first case;
        if(current.leftChild == null) {
            current = current.rightChild;
            //System.out.println(current.value);
            //System.out.println(current.key);
            return  current;
        } else if(current.rightChild == null) {
            return  current = current.leftChild;
        }
        //second case;
        TreeNode nodeTo = FindMinimum(current.rightChild);
        Delete(nodeTo.key);
        current.value = nodeTo.value;
        current.key = nodeTo.key;
        return current;
        */
    }


    // public BinaryTree ReadFromFile(maybe file) {

    // }

    // public BinaryTree WriteFromFile(maybe file) {

    // }

    //private section;
    private TreeNode root;

    private  TreeNode FindNode(final BigInteger key, TreeNode node) {
        if((node != null) && (node.key.compareTo(key) == 0)) {
            return  node;
        } else if ((node != null) && (node.key.compareTo(key) < 0)) {
            node = FindNode(key, node.rightChild);
        } else if ((node != null) && (node.key.compareTo(key) > 0)) {
            node = FindNode(key, node.leftChild);
        }
        return node;
    }

    private void Print(TreeNode node) {
        if(node != null) {
            System.out.println("key: " + node.key + ";value: " + node.value);
            Print(node.leftChild);
            Print(node.rightChild);
        }
    }

    private void PrintSort(TreeNode node) {
        if(node != null) {
            PrintSort(node.leftChild);
            System.out.println("key: " + node.key + ";value: " + node.value);
            PrintSort(node.rightChild);
        }
    }

    private  TreeNode DeleteRecursive(BigInteger key, TreeNode node) {
        if(node == null) {
            return null;
        }
        if(node.key.compareTo(key) == 0) {
            if(node.leftChild == null) {
                return  node.rightChild;
            } else if(node.rightChild == null) {
                return  node.leftChild;
            }
            TreeNode nodeTo = FindMinimum(node.rightChild);
            DeleteRecursive(nodeTo.key,root);
            node.value = nodeTo.value;
            node.key = nodeTo.key;
            return node;
        }
        if(node.key.compareTo(key) < 0) {
            node.rightChild = DeleteRecursive(key, node.rightChild);
            return  node;
        }
        node.leftChild = DeleteRecursive(key, node.leftChild);
        return node;
    }

    private TreeNode FindMinimum(TreeNode node) {
        while (node.leftChild != null) {
            node = node.leftChild;
        }
        return node;
    }

    private TreeNode FindPlace(BigInteger key,TreeNode node) {
        if((node != null) && (node.key.compareTo(key) == 0)) {
            return  null;
        } else if ((node.rightChild != null) && (node.key.compareTo(key) < 0)) {
            node = FindPlace(key,node.rightChild);
        } else if ((node.leftChild != null) && (node.key.compareTo(key) > 0)) {
            node = FindPlace(key,node.leftChild);
        }
        return  node;
    }

    private static class TreeNode {
        private TreeNode leftChild;
        private TreeNode rightChild;
        private String value;
        private BigInteger key;

        public TreeNode(String value, BigInteger key) {
            leftChild = null;
            rightChild = null;
            this.value = value;
            this.key = key;
        }

        public void Print() {
            System.out.println("key: " + key + ";value: " + value);
        }
    }
}

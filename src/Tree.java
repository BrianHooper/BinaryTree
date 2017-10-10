public class Tree<E extends Comparable<E>> {
    private Node<E> root;
    private int size = 0;

    public int size() {
        return size;
    }

    public boolean insert(E e) {
        if(root == null) {
            root = new Node(e);
            size++;
            return true;
        }
        else return insert(root, e);
    }

    private boolean insert(Node node, E value) {
        if(node.value.compareTo(value) > 0) {
            if(node.left == null) {
                node.left = new Node(value);
                size++;
                return true;
            }
            else return insert(node.left, value);

        } else if(node.value.compareTo(value) < 0) {
            if(node.right == null) {
                node.right = new Node(value);
                size++;
                return true;
            }
            else return insert(node.right, value);
        } else {
            return false;
        }
    }

    public void print() {
        System.out.println("Size: " + size() + "\n" + root);
    }

    public boolean delete(E value) {
        // Don't do anything if the tree is empty
        if(root == null) return false;

        // Find the node to be deleted
        Node current = root;
        Node parent = root;
        boolean isLeftChild = true;

        while(current.value.compareTo(value) != 0) {
            parent = current;
            if(current.value.compareTo(value) > 0) {
                isLeftChild = true;
                current = current.left;
            } else {
                isLeftChild = false;
                current = current.right;
            }

            // If the node is not found, don't delete anything
            if(current == null) return false;
        }

        // Attempt to delete the node
        // Case 0: node has no children
        if(current.left == null && current.right == null) {
            // Check if the node to be deleted is the root
            if(current == root) root = null;

            // Set the parents left or right field to null
            else if(isLeftChild) parent.left = null;
            else parent.right = null;
        }

        // Case 1: node has one right child
        else if(current.left == null && current.right != null) {
            // Check if the node to be deleted is the root
            if(current == root) root = current.right;

            // Set the parents left or right field to point to
            // the child of the current node
            else if(isLeftChild) parent.left = current.right;
            else parent.right = current.right;
        }

        // Case 2: node has one left child
        else if(current.left != null && current.right == null) {
            // Check if the node to be deleted is the root
            if(current == root) root = current.left;

            // Set the parents left or right field to point to
            // the child of the current node
            else if(isLeftChild) parent.left = current.left;
            else parent.right = current.left;
        }

        // Case 3: node has two children
        else {
            // Find the inorder successor
            Node successor = current.right;
            Node successorParent = current;

            while(successor.left != null) {
                successorParent = successor;
                successor = successor.left;
            }

            // If the successor is the right child node of the current node
            if(successorParent == current) {
                // Set the left child of the successor to point to the left child
                // of the current node, and set the parent of the current node
                // to point to the successor
                successor.left = current.left;
                parent.right = successor;
            } else {
                // Set the left child of the successors parent to point
                // to the successors right child
                if(successor.right != null) {
                    successorParent.left = successor.right;
                } else {
                    successorParent.left = null;
                }

                // Set the right child of the successor to point to the right child
                // of the current node
                successor.right = current.right;

                // Set the correct child of the parent node to point to the successor
                if(parent.right != null && parent.right == current) {
                    parent.right = successor;
                } else {
                    parent.left = successor;
                }


                // Set the left child of the successor to point to the
                // left child of the current node
                successor.left = current.left;
            }



        }

        size--;
        return true;

    }

}

public class Node<E extends Comparable<E>> implements Comparable<E>{
    public E value;
    public Node left, right;

    public Node(E n) {
        value = n;
    }

    /*
     * Recursively builds a StringBuilder containing a representation of
     * the binary tree in a human-readable format
     */
    public StringBuilder toString(StringBuilder prefix, boolean isTail, StringBuilder sb) {
        if(right!=null) {
            right.toString(new StringBuilder().append(prefix).append(isTail ? "│   " : "    "), false, sb);
        }
        sb.append(prefix).append(isTail ? "└── " : "┌── ").append(value).append("\n");
        if(left!=null) {
            left.toString(new StringBuilder().append(prefix).append(isTail ? "    " : "│   "), true, sb);
        }
        return sb;
    }

    /*
     * Calls overloaded toString method to build a StringBuilder object
     */
    @Override
    public String toString() {
        return this.toString(new StringBuilder(), true, new StringBuilder()).toString();
    }

    @Override
    public int compareTo(E e) {
        return e.compareTo(this.value);
    }
}
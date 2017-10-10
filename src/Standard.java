public class Standard {


    public static void main(String[] args) {
        Standard stan = new Standard();
        stan.run();
    }

    public void run() {
        Tree<String> tree = new Tree<String>();
        tree.insert("Hello");
        tree.insert("Abacadabra");
        tree.insert("Zoolander");
        tree.insert("Aardvark");
        tree.insert("Bulldozer");
        tree.insert("Bark");
        tree.insert("Canyon");

        tree.print();

        tree.delete("Abacadabra");

        tree.print();
    }


}

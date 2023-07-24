package cs321.btree;

import java.io.IOException;
import java.io.PrintWriter;

public interface BTreeInterface {

    /**
     * @return Returns the number of keys in the BTree.
     */
    long getSize();

    /**
     * @return The degree of the BTree.
     */
    int getDegree();


    /**
     * @return Returns the number of nodes in the BTree.
     */
    int getNumberOfNodes();


    /**
     * @return The height of the BTree
     */
    int getHeight();


    /**
     * Deletes a key from the BTree. Not Implemented.
     *
     * @param key the key to be deleted
     */
    void delete(long key);


    /**
     *
     * Insert a given sequence in the B-Tree. If the sequence already exists in the B-Tree,
     * the frequency count is incremented. Otherwise a new node is inserted
     * following the B-Tree insertion algorithm.
     *
     * @param obj
     *            A TreeObject representing a DNA string
     *
     */
    void insert(TreeObject obj) throws IOException;

    /**
     * Print out all objects in the given BTree in an inorder traversal to a file.
     *
     * @param out PrintWriter object representing output
     */
    void dumpToFile(PrintWriter out) throws IOException;


    /**
     * Searches for a sequence in the given BTree.
     *
     * @param key
     *            The key value to search for.
     */
    TreeObject search(long key) throws IOException;

}

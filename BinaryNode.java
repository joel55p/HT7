/*Como tal el proposito es tener una clase de tipo arbol de busqueda binario */
public class BinaryNode<E> {  /*Clase  de tipo BST  */
    E data;
    BinaryNode<E> left, right;  /*(Weiss, M. A. (2013). Data Structures and Algorithm Analysis in Java (3rd ed.). Pearson.) */

    public BinaryNode(E data) { /*Se ubica en pagina 135-136 del pdf */
        this.data = data;
        this.left = this.right = null;
    }
}

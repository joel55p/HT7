/*Como tal el proposito es la implementacion de un arbol binario de busqueda */

public class BinarySearchTree<E extends Comparable<E>> {
    private BinaryNode<E> root;

    public void insert(E data) {
        root = insertRec(root, data); /*Como tal es la raiz  */
    }

    private BinaryNode<E> insertRec(BinaryNode<E> root, E data) { /*(Weiss, M. A. (2013). Data Structures and Algorithm Analysis in Java (3rd ed.). Pearson.) */
        if (root == null) {
            return new BinaryNode<>(data);   /*se encuentra en la pagina  140 del pdf, figura  4.22 "Insertion into a binary search tree" */
        }
        if (data.compareTo(root.data) < 0) { /*Como tal mira si data es menor que dato en la raiz  */
            root.left = insertRec(root.left, data); /*entonces se va a subarbol izquierdo */
        } else if (data.compareTo(root.data) > 0) { /*de lo contrario se va a la derecha  */
            root.right = insertRec(root.right, data);
        }
        return root;
    }

    public E search(E data) { /*Como tal es la busqueda de un dato en el arbol */
        return searchRec(root, data); /*literal retorna el metodo searchRec */
    }

    private E searchRec(BinaryNode<E> root, E data) { /*ChatGPT(2025) */
        if (root == null || root.data.equals(data)) { /*segun se investigo el "?" es operado ternario */
            return root != null ? root.data : null; /*si root es diferente de null entonces retorna root.data de lo contrario null */
        }
        if (data.compareTo(root.data) < 0) {
            return searchRec(root.left, data); /*si el valor actual es menor que el pasado */
        }
        return searchRec(root.right, data); /*si no pues da el derechos */
    }
}

import static org.junit.Assert.*;
import org.junit.Before;
import org.junit.Test;

/**
 * Pruebas unitarias para la clase BinaryTree utilizando JUnit 4 en VS Code.
 */
public class BinaryTreeTest {
    private BinaryTree<Integer, String> tree;

    /**
     * Configuración inicial antes de cada prueba.
     */
    @Before
    public void setUp() {
        tree = new BinaryTree<>();
    }

    /**
     * Prueba para verificar la inserción de elementos en el árbol.
     */
    @Test
    public void testAdd() {
        tree.add(50, "Producto A");
        tree.add(30, "Producto B");
        tree.add(70, "Producto C");

        // Verificar que los valores fueron insertados correctamente
        assertEquals("Producto A", tree.get(50));
        assertEquals("Producto B", tree.get(30));
        assertEquals("Producto C", tree.get(70));
    }

    /**
     * Prueba para verificar la búsqueda de elementos en el árbol.
     */
    @Test
    public void testGet() {
        tree.add(100, "Producto X");
        tree.add(200, "Producto Y");
        tree.add(150, "Producto Z");

        // Verificar búsqueda de claves existentes
        assertEquals("Producto X", tree.get(100));
        assertEquals("Producto Y", tree.get(200));
        assertEquals("Producto Z", tree.get(150));

        // Verificar que buscar un elemento inexistente devuelve null
        assertNull(tree.get(999));
    }
}

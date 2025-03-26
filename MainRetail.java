import java.io.*;
import java.util.*;

public class MainRetail{
    public static void main(String[] args){
        BinaryTree<String, Producto> arbolSKU = new BinaryTree<>();
        BinaryTree<String, Producto> arbolNombre = new BinaryTree<>();
        int finalizar = 0;
        String archivo = "inventario.csv";
        Scanner input = new Scanner(System.in);
        try (BufferedReader br = new BufferedReader(new FileReader(archivo))) {
            String linea;
            br.readLine(); 

            while ((linea = br.readLine()) != null) {
                String[] partes = linea.split(",");

                String SKU = partes[0];
                String name = partes[1];
                String description = partes[2];
                Producto producto = new Producto(SKU, name, description);
                String[] dividirTallas = partes[3].split("|");
                for(String str : dividirTallas){
                    String[] TallaYCantidad = str.split(":");
                    producto.editSizesAndAmounts(TallaYCantidad[0], TallaYCantidad[1]);
                }

                // Insertar en ambos BST (uno ordenado por SKU, otro por nombre)
                arbolSKU.add(SKU, producto);
                arbolNombre.add(name, producto);
            }

            System.out.println("Carga del archivo CSV completada.");
        } catch (IOException e) {
            System.err.println("Error al leer el archivo: " + e.getMessage());
        }
        while(finalizar == 0){
            System.out.println("Bienvenido a su inventario con arboles");
            System.out.println("1. Agregar producto");
            System.out.println("2. Editar descripción");
            System.out.println("3. Editar talla de un producto");
            System.out.println("4. Editar cantidad de una talla de un producto");
            System.out.println("5. Salir");
            System.out.println("Ingrese la opción de lo que desea realizar: ");
            String opcion = input.nextLine();
        }
        
    }
}
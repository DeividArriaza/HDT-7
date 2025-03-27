/*
 * David Eduardo López Arriaza 24730
 * Hoja de Trabajo 7
 * 26/03/2025
 */
import java.io.*;
import java.util.*;

/*
 * Clase para el manejo de una tienda deportiva, se permite la carga de un archivo csv y/o colocar manualmente los productos
 */
public class MainRetail{
    public static void main(String[] args){
        BinaryTree<Integer, Producto> arbolSKU = new BinaryTree<>();
        BinaryTree<String, Producto> arbolNombre = new BinaryTree<>();
        int finalizar = 0;
        String archivo = "inventario.csv";
        int SKU;
        Producto producto;
        String name;
        String description;
        String elegir;
        Scanner input = new Scanner(System.in);
        /*
         * Lectura del archivo CSV
         */
        try (BufferedReader br = new BufferedReader(new FileReader(archivo))) {
            String linea;
            br.readLine(); 

            while ((linea = br.readLine()) != null) {
                String[] partes = linea.split(",");
                SKU = Integer.parseInt(partes[0]); 

                name = partes[1];
                description = partes[2];
                producto = new Producto(SKU, name, description);
                String[] dividirTallas = partes[3].split("\\|"); 
                for(String str : dividirTallas){
                    String[] TallaYCantidad = str.split("\\:");
                    producto.editSizesAndAmounts(TallaYCantidad[0], TallaYCantidad[1]);
                }

                arbolSKU.add(SKU, producto);
                arbolNombre.add(name, producto);
            }

            System.out.println("Carga del archivo CSV completada.");
        } catch (IOException e) {
            System.err.println("Error al leer el archivo: " + e.getMessage());
        }
        /*
         * Menú para el encargado de la tienda
         */
        while(finalizar == 0){
            System.out.println("Bienvenido a su inventario con arboles");
            System.out.println("1. Agregar producto");
            System.out.println("2. Editar descripción");
            System.out.println("3. Editar talla y cantidad de un producto");
            System.out.println("4. Mostrar todos los productos ordenados por SKU y Nombre");
            System.out.println("5. Salir");
            System.out.println("Ingrese la opción de lo que desea realizar: ");
            String opcion = input.nextLine();
            switch (opcion) {
                /*
                 * Agregar un nuevo producto al inventario
                 */
                case "1":
                    System.out.println("Ingrese el código SKU del producto que desea agregar: ");
                    SKU = input.nextInt();
                    System.out.println("Ingrese el nombre del producto que desea agregar: ");
                    name = input.nextLine();
                    name = input.nextLine();
                    System.out.println("Ingrese la descripción de su producto: ");
                    description = input.nextLine();
                    System.out.println("Ingrese la talla disponible: ");
                    String talla = input.nextLine();
                    System.out.println("Ingrese la cantidad disponible para esta talla: ");
                    String cantidad = input.nextLine();
                    producto = new Producto(SKU, name, description);
                    producto.editSizesAndAmounts(talla, cantidad);

                    arbolSKU.add(SKU, producto);
                    arbolNombre.add(name, producto);
                    break;
                /*
                 * Editar la descripcón de un producto buscando por su SKU o nombre
                 */
                case "2":
                    System.out.println("Desea buscar por 1. SKU | 2. Nombre (Ingrese el número de la opción): ");
                    elegir = input.nextLine();
                    if(elegir.equals("1")){
                        System.out.println("Ingrese el SKU del producto: ");
                        SKU = input.nextInt();
                        System.out.println("Inrese la nueva descripción: ");
                        input.nextLine();
                        description = input.nextLine();
                        arbolSKU.get(SKU).setDescription(description);
                        System.out.println("Descripción cambiada con éxito. ");

                    }
                    else if(elegir.equals("2")){
                        System.out.println("Ingrese el nombre del producto: ");
                        name = input.nextLine();
                        System.out.println("Inrese la nueva descripción: ");
                        description = input.nextLine();
                        arbolNombre.get(name).setDescription(description);
                        System.out.println("Descripción cambiada con éxito. ");

                    }
                    else{
                        System.out.println("Opción no válida");
                    }
                    break;
                /*
                 * Editar la talla y cantidad de un producto, buscandolo por su nombre o SKU
                */
                case "3":
                    System.out.println("Desea buscar por 1. SKU | 2. Nombre (Ingrese el número de la opción): ");
                    elegir = input.nextLine();
                    if(elegir.equals("1")){
                        System.out.println("Ingrese el SKU del producto: ");
                        SKU = input.nextInt();
                        System.out.println("Ingrese la talla a editar: ");
                        input.nextLine();
                        talla = input.nextLine();
                        System.out.println("Elija el número de lo siguiente: 1. Eliminar talla (ya no habrán más tallas a futuro) | 2. Editar cantidad disponible");
                        elegir = input.nextLine();
                        if(elegir.equals("1")){
                            arbolSKU.get(SKU).removeSize(talla);
                            System.out.println("Eliminado con exito");
                        }
                        else if(elegir.equals("2")){
                            System.out.println("Ingrese la cantidad disponible para esta talla: ");
                            cantidad = input.nextLine();
                            arbolSKU.get(SKU).editSizesAndAmounts(talla, cantidad);
                            System.out.println("Talla y cantidad cambiadas con éxito");
                        }

                    }
                    else if(elegir.equals("2")){
                        System.out.println("Ingrese el nombre del producto: ");
                        name = input.nextLine();
                        System.out.println("Ingrese la talla a editar: ");
                        talla = input.nextLine();
                        System.out.println("Elija el número de lo siguiente: 1. Eliminar talla (ya no habrán más tallas a futuro) | 2. Editar cantidad disponible");
                        elegir = input.nextLine();
                        if(elegir.equals("1")){
                            arbolNombre.get(name).removeSize(talla);
                            System.out.println("Eliminado con exito");
                        }
                        else if(elegir.equals("2")){
                            System.out.println("Ingrese la cantidad disponible para esta talla: ");
                            cantidad = input.nextLine();
                            arbolNombre.get(name).editSizesAndAmounts(talla, cantidad);
                            System.out.println("Talla y cantidad cambiadas con éxito");
                        }

                    }
                    else{
                        System.out.println("Opción no válida");
                    }
                    break; 
                
                /*
                 * Mostrar todos los productos de la tienda ordenados por SKU o nombre. 
                 */
                case "4":
                    System.out.println("Productos ordenados por SKU: ");
                    arbolSKU.inOrder();
                    System.out.println();
                    System.out.println("Productos ordenados por nombre: ");
                    arbolNombre.inOrder();
                    break; 
                case "5": 
                    finalizar = 1;
                    break; 
            }

            System.out.println();
        }
        
    }
}
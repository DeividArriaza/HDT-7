import java.util.HashMap;
import java.util.Map;

public class Producto{
    private int SKU;
    private String name;
    private String description;
    private Map<String, String> sizesAndAmounts;

    public Producto(int SKU, String name, String description){
        this.SKU = SKU;
        this.name = name;
        this.description = description;
        sizesAndAmounts = new HashMap<String, String>();
    }


    public int getSKU(){
        return SKU;
    }

    public String getName(){
        return name;
    }

    public void setDescription(String description){
        this.description = description;
    }

    public String getDescription(){
        return description;
    }

    public String getSizeAndAmount(String sizeAvailable){
        return sizesAndAmounts.get(sizeAvailable);
    }
    public void editSizesAndAmounts(String sizeAvailable, String amount){
        sizesAndAmounts.put(sizeAvailable, amount);
    }

    public void removeSize(String size){
        sizesAndAmounts.remove(size);
    }

    public String toString(){
        return "SKU: "  +  SKU + " | " + "Nombre: " + name +  " | " + "descripción: "  + description +  " | " + "tallas: " + sizesAndAmounts.keySet() + " | " +  "cantidades: " + sizesAndAmounts.values() +"\n"; 
    }
}
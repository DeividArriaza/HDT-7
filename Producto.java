import java.util.Map;

public class Producto{
    private String SKU;
    private String name;
    private String description;
    private Map<String, String> sizesAndAmounts;

    public Producto(String SKU, String name, String description){
        this.SKU = SKU;
        this.name = name;
        this.description = description;
    }


    public String getSKU(){
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

    public void editSizesAndAmounts(String sizeAvailable, String amount){
        sizesAndAmounts.put(sizeAvailable, amount);
    }

    public void removeSize(String size){
        sizesAndAmounts.remove(size);
    }

}
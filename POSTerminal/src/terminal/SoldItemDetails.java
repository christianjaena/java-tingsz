package terminal;

public class SoldItemDetails {
    private int item_id;
    private String name;
    private String description;
    private int qty;
    private float price;

    public SoldItemDetails(int item_id, String name, String description, int qty, float price) {
        this.item_id = item_id;
        this.name = name;
        this.description = description;
        this.qty = qty;
        this.price = price;
    }

    public int getItem_id() {
        return item_id;
    }

    public void setItem_id(int item_id) {
        this.item_id = item_id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public int getQty() {
        return qty;
    }

    public void setQty(int qty) {
        this.qty = qty;
    }

    public float getPrice() {
        return price;
    }

    public void setPrice(float price) {
        this.price = price;
    }

    @Override
    public String toString() {
        return name; //To change body of generated methods, choose Tools | Templates.
    }

    
    
}

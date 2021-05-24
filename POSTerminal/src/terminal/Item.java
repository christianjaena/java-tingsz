
package terminal;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;


public class Item {
    private int id;
    private String name;
    private String description;
    private float price;
    private int qtyStock;

    public Item(int id, String name, String description, float price, int qtyStock) {
        this.id = id;
        this.name = name;
        this.description = description;
        this.price = price;
        this.qtyStock = qtyStock;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
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

    public float getPrice() {
        return price;
    }

    public void setPrice(float price) {
        this.price = price;
    }

    public int getQtyStock() {
        return qtyStock;
    }

    public void setQtyStock(int qtyStock) {
        this.qtyStock = qtyStock;
    }

    @Override
    public String toString() {
        return name;//To change body of generated methods, choose Tools | Templates.
    }
    
    public static Item getItemById(int itemId) throws Exception {
        PreparedStatement ps = DB.getConnection().prepareStatement("SELECT id, name, description, price, qty_stock FROM items WHERE id = ?");
        ps.setInt(1, itemId);
        ResultSet rs = ps.executeQuery();
        if(rs.first()) {
            return new Item(
                    rs.getInt("id"), rs.getString("name"), rs.getString("description"),
                    rs.getFloat("price"), rs.getInt("qty_stock")
                    
            );
        }else{
                throw new Exception ("Item number not found");
        }
        
    }
}

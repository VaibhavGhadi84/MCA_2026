import java.util.ArrayList;
import java.util.List;

public class Inventory {
    private List<Stock> managedStock;
    private List<Product> products;

    public Inventory() {
        this.managedStock = new ArrayList<>();
        this.products = new ArrayList<>();
    }

    public void manageStock(Stock stock) {
        managedStock.add(stock);
    }
}
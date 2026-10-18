import java.util.ArrayList;
import java.util.List;

public class Warehouse {
    private String location;
    private List<Stock> storedStock;

    public Warehouse(String location) {
        this.location = location;
        this.storedStock = new ArrayList<>();
    }

    public void storeStock(Stock stock) {
        storedStock.add(stock);
    }
}
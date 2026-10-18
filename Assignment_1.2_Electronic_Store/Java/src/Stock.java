import java.util.List;

public class Stock {
    private List<String> stockList;

    public Stock(List<String> stockList) {
        this.stockList = stockList;
    }

    public List<String> getStockList() { return stockList; }
}
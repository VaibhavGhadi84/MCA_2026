public class Supplier {
    private String id;
    private String name;
    private String phoneNo;

    public Supplier(String id, String name, String phoneNo) {
        this.id = id;
        this.name = name;
        this.phoneNo = phoneNo;
    }

    public void supplyStock(Stock stock) {
        System.out.println(this.name + " is supplying stock: " + stock.getStockList());
    }

    public String getId() { return id; }
    public String getName() { return name; }
    public String getPhoneNo() { return phoneNo; }
}
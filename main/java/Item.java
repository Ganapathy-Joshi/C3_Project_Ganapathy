import java.util.ArrayList;

public class Item {
    private String name;
    private int price;

    private ArrayList<Item> items = new ArrayList<Item>(); 


    public Item(){};

    public Item(String name, int price) {
        this.name = name;
        this.price = price;
    }

    public String getName() {
        return name;
    }

    public int getPrice() {
        return price;
    }

    @Override
    public String toString(){
        return  name + ":"
                + price
                + "\n"
                ;
    }

public void addItems(Item item)
    {
        items.add(item);
    }

    public ArrayList<Item> getItems() {
        return items;
    }

    public double getSelectedItemsTotalCost()
    {
        double totalCost = 0;
        for(Item item : items)
        {
            totalCost += item.price;
        }
        return totalCost;
    }
    
   


}

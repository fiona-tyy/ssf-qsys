package tfip.ssf.practicepurchaseorderserver.model;

public class Item {
    private String name;
    private Float unitCost;

    public Item(){}
    
    public Item(String name, Float unitCost) {
        this.name = name;
        this.unitCost = unitCost;
    }
    
    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }
    public Float getUnitCost() {
        return unitCost;
    }
    public void setUnitCost(Float unitCost) {
        this.unitCost = unitCost;
    }

    
}

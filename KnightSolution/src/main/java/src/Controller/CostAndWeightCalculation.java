package src.Controller;

public class CostAndWeightCalculation {
    private Knight knight;
    private int totalPrice;
    private double totalWeight;

    public int getTotalPrice() {
        return totalPrice;
    }

    public double getTotalWeight() {
        return totalWeight;
    }

    public CostAndWeightCalculation(Knight knight){
        this.knight = knight;
    }

    public void count(){
        if(knight.getArmor() != null){
            this.totalPrice += knight.getArmor().getPrice();
            this.totalWeight += knight.getArmor().getWeight();
        }if(knight.getHelmet() != null){
            this.totalPrice += knight.getHelmet().getPrice();
            this.totalWeight += knight.getHelmet().getWeight();
        }if(knight.getSword() != null){
            this.totalPrice += knight.getSword().getPrice();
            this.totalWeight += knight.getSword().getWeight();
        }if(knight.getShield() != null){
            this.totalPrice += knight.getShield().getPrice();
            this.totalWeight += knight.getShield().getWeight();
        }if(knight.getHeavysword() != null){
            this.totalPrice += knight.getHeavysword().getPrice();
            this.totalWeight += knight.getHeavysword().getWeight();
        }

    }
}

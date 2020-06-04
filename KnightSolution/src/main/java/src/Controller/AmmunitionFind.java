package src.Controller;

import src.Model.Ammunition;

import java.util.Map;
import java.util.TreeMap;

public class AmmunitionFind {
    private Knight knight;
    private int minPrice;
    private int maxPrice;
    private Map<Integer, Ammunition> foundAmmu;

    public AmmunitionFind(Knight knight){
        this.knight = knight;
    }

    public int getMinPrice() {
        return minPrice;
    }

    public void setMinPrice(int minPrice) {
        this.minPrice = minPrice;
    }

    public int getMaxPrice() {
        return maxPrice;
    }

    public void setMaxPrice(int maxPrice) {
        this.maxPrice = maxPrice;
    }

    public Map<Integer, Ammunition> getFoundAmmu() {
        return foundAmmu;
    }

    public void setFoundAmmu(Map<Integer, Ammunition> foundAmmu) {
        this.foundAmmu = foundAmmu;
    }

    public Map<Integer, Ammunition> findAmmuByCost(){
        foundAmmu = new TreeMap<>();
        if(knight.getArmor() != null
                && knight.getArmor().getPrice() > minPrice
                && knight.getArmor().getPrice() < maxPrice){
            foundAmmu.put(knight.getArmor().getPrice(), knight.getArmor());
        }if(knight.getHelmet() != null
                && knight.getHelmet().getPrice() > minPrice
                && knight.getHelmet().getPrice() < maxPrice){
            foundAmmu.put(knight.getHelmet().getPrice(), knight.getHelmet());
        }if(knight.getSword() != null
                && knight.getSword().getPrice() > minPrice
                && knight.getSword().getPrice() < maxPrice){
            foundAmmu.put(knight.getSword().getPrice(), knight.getSword());
        }if(knight.getShield() != null
                && knight.getShield().getPrice() > minPrice
                && knight.getShield().getPrice() < maxPrice){
            foundAmmu.put(knight.getShield().getPrice(), knight.getShield());
        }if(knight.getHeavysword() != null
                && knight.getHeavysword().getPrice() > minPrice
                && knight.getHeavysword().getPrice() < maxPrice){
            foundAmmu.put(knight.getHeavysword().getPrice(), knight.getHeavysword());
        }
        setFoundAmmu(foundAmmu);
        return foundAmmu;
    }
}

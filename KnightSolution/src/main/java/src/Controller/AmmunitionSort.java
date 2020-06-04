package src.Controller;

import src.Model.Ammunition;

import java.util.*;
import java.util.stream.Collectors;

public class AmmunitionSort {
//    private HashMap<Ammunition, Double> map = new HashMap<>();
//
//    public HashMap<Ammunition, Double> getMap() {
//        return map;
//    }
//
//    public void setMap(HashMap<Ammunition, Double> map) {
//        this.map = map;
//    }
//
//    public HashMap MapAdd(){
//        map.put(Ammunition.LIGHT, Ammunition.LIGHT.getWeight());
//        map.put(Ammunition.MIDDLE, Ammunition.MIDDLE.getWeight());
//        map.put(Ammunition.HEAVY, Ammunition.HEAVY.getWeight());
//        map.put(Ammunition.WOOD, Ammunition.WOOD.getWeight());
//        map.put(Ammunition.SILVER, Ammunition.SILVER.getWeight());
//        map.put(Ammunition.STEEL, Ammunition.STEEL.getWeight());
//        map.put(Ammunition.FALSHION, Ammunition.FALSHION.getWeight());
//        map.put(Ammunition.PALASH, Ammunition.PALASH.getWeight());
//        map.put(Ammunition.KAROLING, Ammunition.KAROLING.getWeight());
//        map.put(Ammunition.TARCH, Ammunition.TARCH.getWeight());
//        map.put(Ammunition.GOPLON, Ammunition.GOPLON.getWeight());
//        map.put(Ammunition.PAVEZA, Ammunition.PAVEZA.getWeight());
//        map.put(Ammunition.CLAYMORE, Ammunition.CLAYMORE.getWeight());
//        map.put(Ammunition.BASTARD, Ammunition.BASTARD.getWeight());
//        map.put(Ammunition.BORSHVERT, Ammunition.BORSHVERT.getWeight());
//        return map;
//    }
//
//
//    public HashMap<Ammunition, Double> mapSort(){
//        MapAdd();
//        map.entrySet()
//                .stream()
//                .sorted(Map.Entry.<Ammunition, Double>comparingByValue())
//                .forEach((k,v) -> ;
//        setMap(map);
//        return map;
//    }

    private Knight knight;
    private Map<Double, Ammunition> map;

    public AmmunitionSort(Knight knight) {
        this.knight = knight;
    }

    public Map<Double, Ammunition> getMap() {
        return map;
    }

    public void setMap(Map<Double, Ammunition> map) {
        this.map = map;
    }

    public Map<Double, Ammunition> mapSort() {
        Map<Double, Ammunition> map = new TreeMap<Double, Ammunition>();
        if (knight.getArmor() != null) {
            map.put(knight.getArmor().getWeight(), knight.getArmor());
        }
        if (knight.getHelmet() != null) {
            map.put(knight.getHelmet().getWeight(), knight.getHelmet());
        }
        if (knight.getSword() != null) {
            map.put(knight.getSword().getWeight(), knight.getSword());
        }
        if (knight.getShield() != null) {
            map.put(knight.getShield().getWeight(), knight.getShield());
        }
        if (knight.getHeavysword() != null) {
            map.put(knight.getHeavysword().getWeight(), knight.getHeavysword());
        }
        setMap(map);
        return map;
    }


}

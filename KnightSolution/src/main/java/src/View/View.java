package src.View;

import src.Controller.CostAndWeightCalculation;
import src.Controller.Knight;
import src.Model.Ammunition;

import java.util.Locale;
import java.util.Map;
import java.util.ResourceBundle;

import static src.View.Text_Constants.*;

public class View {

    static String MESSAGE_BUNDLE_NAME = "messages";
    public static final ResourceBundle bundle = ResourceBundle.getBundle(MESSAGE_BUNDLE_NAME, new Locale("ru", "UA"));

    public void viewer(Knight knight, CostAndWeightCalculation calculation,
                       Map<Double, Ammunition> mapSort,
                       Map<Integer, Ammunition> mapFind,
                       Integer maxPrice,
                       Integer minPrice){
        printStringMessage();
        printAmmunition(knight);
        printAmmunitionAbilities(calculation);
        printAmmunitionSort(mapSort);
        printAmmunitionFind(mapFind, maxPrice, minPrice);
    }

    /**
     *
     * @param message
     */

    public void printMessage(String message){
        System.out.println(message);
    }

    /**
     *
     * @param message
     * @return
     */

    public String concatString(String... message){
        StringBuilder concat= new StringBuilder();
        for(String s : message){
            concat = concat.append(s);
        }
        return new String(concat);
    }

    public void printStringMessage(){
        printMessage(concatString(bundle.getString(GREETINGS), bundle.getString(AMMU_SELECTED)));
    }

    public void printAmmunition(Knight knight){
        System.out.println(knight.getArmor() + " - "
        + knight.getHelmet() + " - "
        + knight.getSword() + " - "
        + knight.getShield() + " - "
        + knight.getHeavysword() + "\n\r");
    }

    public void printAmmunitionAbilities(CostAndWeightCalculation calculation){
        printAmmunitionPrice(calculation.getTotalPrice());
        printAmmunitionWeight(calculation.getTotalWeight());
    }

    public void printAmmunitionPrice(int price){
        printMessage(concatString(bundle.getString(KNIGHT_PRICE), price + "" + "\n\r"));
    }

    public void printAmmunitionWeight(double weight){
        printMessage(concatString(bundle.getString(KNIGHT_WEIGHT), weight + ""));
    }

    public void printAmmunitionSort(Map<Double, Ammunition> map){
        printMessage(concatString(bundle.getString(KNIGHT_SORT)));
        for(Map.Entry<Double, Ammunition> temp : map.entrySet()){
            System.out.println(temp.getKey() + " " + temp.getValue());
        }
    }

    public void printAmmunitionFind(Map<Integer, Ammunition> map, int minPrice, int maxPrice){
        System.out.println();
        printMessage(concatString(
                bundle.getString(KNIGHT_FIND), minPrice + " ",
                bundle.getString(AND), maxPrice + " ",
                bundle.getString(AMMU_FOUND)));
        for(Map.Entry<Integer, Ammunition> temp : map.entrySet()) {
            System.out.println(temp.getValue() + " " + temp.getKey());
        }

    }
}

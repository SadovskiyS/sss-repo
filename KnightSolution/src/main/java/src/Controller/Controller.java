package src.Controller;

import src.Model.Ammunition;
import src.Model.Model;
import src.View.View;

import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.util.Set;

public class Controller {

    private Model model;
    private View view;
    private Knight knight;
    private Knight knight2;

    public Controller(Model model, View view) throws IOException {
        this.model = model;
        this.view = view;
    }

    private ArrayList<Ammunition> ammuSelection(){
        ArrayList<Ammunition> ammunitions= new ArrayList<>();
        for(Ammunition a : Ammunition.values()){
            ammunitions.add(a);
        }
        return ammunitions;
    }

    private Knight knightBuilderPalladin (ArrayList<Ammunition> arrayList){
        Ammunition armor = null;
        Ammunition helmet = null;
        Ammunition sword = null;
        Ammunition shield = null;

        for(int i = 0; i < arrayList.size(); i++){
            if(arrayList.get(i).getType().equals("Armor")){
                armor = arrayList.get(i);
            }if(arrayList.get(i).getType().equals("Helmet")){
                helmet = arrayList.get(i);
            }if(arrayList.get(i).getType().equals("Sword")){
                sword = arrayList.get(i);
            }if(arrayList.get(i).getType().equals("Shield")){
                shield = arrayList.get(i);
            }
        }

        Knight knightPalladin = new Knight.Builder()
                .withArmor(armor)
                .withHelmet(helmet)
                .withSword(sword)
                .withShield(shield)
                .build();
        return knightPalladin;
    }

    private Knight knightBuilderBarbarian (ArrayList<Ammunition> arrayList){
        Ammunition armor = null;
        Ammunition helmet = null;
        Ammunition heavysword = null;

        for(int i = 0; i < arrayList.size(); i++){
            if(arrayList.get(i).getType().equals("Armor")){
                armor = arrayList.get(i);
            }if(arrayList.get(i).getType().equals("Helmet")){
                helmet = arrayList.get(i);
            }if(arrayList.get(i).getType().equals("HeavySword")){
                heavysword = arrayList.get(i);
            }
        }

        Knight knightBarbarian = new Knight.Builder()
                .withArmor(armor)
                .withHelmet(helmet)
                .withHeavySword(heavysword)
                .build();
        return knightBarbarian;
    }

//    public void output() {
//
//        sort.MapAdd();
//        sort.mapSort();
//        view.viewer(sort.map.toString());
//
//    }

    public void output(){
        knight = knightBuilderPalladin(ammuSelection());
        CostAndWeightCalculation costWeight= new CostAndWeightCalculation(knight);
        costWeight.count();
        AmmunitionSort sort = new AmmunitionSort(knight);
        //sort.MapAdd();
        sort.mapSort();
        AmmunitionFind findAmmu = new AmmunitionFind(knight);
        findAmmu.setMinPrice(800);
        findAmmu.setMaxPrice(2000);
        findAmmu.findAmmuByCost();
        view.viewer(knight,
                costWeight,
                sort.getMap(),
                findAmmu.getFoundAmmu(),
                findAmmu.getMinPrice(),
                findAmmu.getMaxPrice());
    }


}

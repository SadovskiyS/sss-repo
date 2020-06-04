package src.Model;

public enum Ammunition {
        LIGHT("Armor",5.300,1000),
        MIDDLE("Armor", 8.400,1800),
        HEAVY("Armor", 15.000,3400),
        WOOD("Helmet", 1.200, 230),
        SILVER("Helmet", 1.000, 800),
        STEEL("Helmet", 2.300, 740),
        FALSHION("Sword", 1.200,900),
        PALASH("Sword", 1.100, 980),
        KAROLING("Sword", 1.350, 1000),
        TARCH("Shield", 3.100, 1550),
        PAVEZA("Shield", 5.500, 2300),
        GOPLON("Shield", 4.500, 2000),
        CLAYMORE("HeavySword", 8.300, 2600),
        BASTARD("HeavySword", 9.000, 3230),
        BORSHVERT("HeavySword", 7.900, 3400);

        private String type;
        private double weight;
        private int price;

        Ammunition(String type, double weight, int price){
            this.type = type;
            this.weight = weight;
            this.price = price;
        }

    public String getType() {
        return type;
    }

    public double getWeight() {
        return weight;
    }

    public int getPrice() {
        return price;
    }
}



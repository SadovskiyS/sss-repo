package src.Controller;

import src.Model.Ammunition;

public class Knight {
    private Ammunition armor;
    private Ammunition helmet;
    private Ammunition sword;
    private Ammunition shield;
    private Ammunition heavysword;

    public Ammunition getArmor() {
        return armor;
    }

    public Ammunition getHelmet() {
        return helmet;
    }

    public Ammunition getSword() {
        return sword;
    }

    public Ammunition getShield() {
        return shield;
    }

    public Ammunition getHeavysword() {
        return heavysword;
    }


    public static class Builder{
        private Knight knight;

        public Builder(){
            knight = new Knight();
        }

        public Builder withArmor(Ammunition armor){
            knight.armor = armor;
            return this;
        }
        public Builder withHelmet(Ammunition helmet){
            knight.helmet = helmet;
            return this;
        }
        public Builder withSword(Ammunition sword){
            knight.sword = sword;
            return this;
        }
        public Builder withShield(Ammunition shield){
            knight.shield = shield;
            return this;
        }
        public Builder withHeavySword(Ammunition heavySword){
            knight.heavysword = heavySword;
            return this;
        }

        public Knight build(){
            return knight;
        }
    }
}

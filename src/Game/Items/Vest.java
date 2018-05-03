package Game.Items;

import Game.Entities.Hero;

import java.util.concurrent.ThreadLocalRandom;

import static Game.Items.Names.armorFirstPart;
import static Game.Items.Names.armorSecondPart;

public class Vest extends Armor {
    int HPBonus;

    public Vest() {
        generateRandomEquipable();
    }

    public Vest(String name, int cost, int defence, int HPBonus) {
        setName(name);
        setCost(cost);
        setDefence(defence);
        setHPBonus(HPBonus);

    }

    public void generateRandomEquipable() {
        int firstIndex = ThreadLocalRandom.current().nextInt(0, armorFirstPart.size());
        int secondIndex = ThreadLocalRandom.current().nextInt(0, armorSecondPart.size());
        String result = armorFirstPart.get(firstIndex) + " Vest of " + armorSecondPart.get(secondIndex);
        this.setName(result);
        int stat = firstIndex * 2 + secondIndex * 3 + 2;
        int defence = (int) (firstIndex * 1.5 + secondIndex * 3 + 2);
        this.setDefence(defence);
        this.setHPBonus(stat);
        int cost = stat * 30 + defence * 50;
        this.setCost(cost);
    }

    @Override
    public String toString() {
        return String.format("%s. HP Bonus %d. Defence %d. Cost %d.", getName(), HPBonus, defence, getCost());
    }

    public int getHPBonus() {
        return HPBonus;
    }

    public void setHPBonus(int HPBonus) {
        this.HPBonus = HPBonus;
    }

    @Override
    public void equip(Hero hero) {
        hero.setVest(this);
    }
}

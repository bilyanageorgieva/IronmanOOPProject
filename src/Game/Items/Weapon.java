package Game.Items;

import Game.PlayerType;

import java.util.concurrent.ThreadLocalRandom;

import static Game.Items.Names.weaponFirstPart;
import static Game.Items.Names.weaponSecondPart;
import static Game.Items.Names.weaponThirdPart;

public class Weapon extends Item implements Equipable {
    private PlayerType type;
    private int damage;
    private int levelRequirement;

    public Weapon(String name, int cost, int damage, PlayerType type) {
        super(name, cost);
        this.damage = damage;
        this.type = type;
    }

    public Weapon() {
        generateRandomEquipable();
    }

    public void generateRandomEquipable() {

        int firstIndex = ThreadLocalRandom.current().nextInt(0, weaponFirstPart.size());
        int secondIndex = ThreadLocalRandom.current().nextInt(0, weaponSecondPart.size());
        int thirdIndex = ThreadLocalRandom.current().nextInt(0, weaponThirdPart.size());
        String result = weaponFirstPart.get(firstIndex) + weaponSecondPart.get(secondIndex) + weaponThirdPart.get(thirdIndex);
        setName(result);
        if (secondIndex == 0) {
            setType(PlayerType.WARRIOR);
        } else if (secondIndex == 1) {
            setType(PlayerType.ARCHER);
        } else if (secondIndex == 2) {
            setType(PlayerType.MAGE);
        }
        int damage = firstIndex * 6 + thirdIndex * 4 + 5;
        levelRequirement = (int) ((firstIndex + thirdIndex) / 1.5);
        setDamage(damage);
        int cost = damage * 35;
        setCost(cost);
    }

    @Override
    public String toString() {
        return String.format("%s. Damage %d. Level requirement %d. Cost %d.", getName(), getDamage(), levelRequirement, getCost());
    }

    public PlayerType getType() {
        return type;
    }

    private void setType(PlayerType type) {
        this.type = type;
    }

    public int getDamage() {
        return damage;
    }

    private void setDamage(int damage) {
        this.damage = damage;
    }

    public int getLevelRequirement() {
        return levelRequirement;
    }

    @Override
    public int hashCode() {
        int result = 17;
        result = 31 * result + getCost();
        return result;
    }

    @Override
    public boolean equals(Object obj) {
        if(obj.hashCode()==this.hashCode())
            return true;
        else return false;
    }
}


import java.util.List;

public class Player extends Character {
    private Bag bag;
    private int maxHP = 10;

    public Player(String name, int HP, int ac, List<Weapon> weaponList, Bag bag) {
        super(name, HP, ac, weaponList);
        this.bag = bag;
    }

    public Bag getBag() {
        return bag;
    }

    public void setBag(Bag bag) {
        this.bag = bag;
    }

    public boolean useStim() {
        if (this.HP + 1 > this.maxHP)
            return false;
        this.HP += 1;
        return true;
    }
}
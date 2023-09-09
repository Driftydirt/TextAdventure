
import java.util.List;

public class Character {
    protected String name;
    protected int HP;
    protected int ac;
    protected List<Weapon> weapons;

    public Character(String name, int HP, int ac, List<Weapon> weapons) {
        this.name = name;
        this.HP = HP;
        this.ac = ac;
        this.weapons = weapons;
    }

    public boolean lowerHP(int damage) {
        this.HP = this.HP - damage;
        if (this.HP <= 0) {
            return true;
        }
        return false;
    }

    public int getHP() {
        return this.HP;
    }

    public int getAC() {
        return this.ac;
    }

    public List<Weapon> getWeapons() {
        return this.weapons;
    }

    public Weapon getWeapon(int index) {
        return this.weapons.get(index);
    }

    public String getName() {
        return this.name;
    }

}

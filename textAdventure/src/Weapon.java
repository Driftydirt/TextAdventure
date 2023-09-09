
class Weapon {
    private String name;
    private double accuracy;
    private int dmg;

    public Weapon(String name, double accuracy, int dmg) {
        this.name = name;
        this.accuracy = accuracy;
        this.dmg = dmg;
    }

    public double getAccuracy() {
        return this.accuracy;
    }

    public int getDmg() {
        return this.dmg;
    }

    public String getName() {
        return this.name;
    }
}

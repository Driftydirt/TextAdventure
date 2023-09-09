public class Bag {

    private int stims;

    public Bag(int stims) {
        this.stims = stims;
    }

    public int getStims() {
        return stims;
    }

    public void setStims(int stims) {
        this.stims = stims;
    }

    public boolean takeStim() {
        if (this.stims == 0)
            return false;
        this.stims -= 1;
        return true;
    }

    public void returnStim() {
        this.stims += 1;
    }
}

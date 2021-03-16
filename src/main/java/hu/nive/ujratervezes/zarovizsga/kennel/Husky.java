package hu.nive.ujratervezes.zarovizsga.kennel;

public class Husky extends Dog {

    private int happiness = 0;

    public Husky(String name) {
        super(name);
    }

    @Override
    public String getName() {
        return super.getName();
    }

    @Override
    public int getHappiness() {
        return happiness;
    }

    @Override
    public void feed() {
        happiness += 4;
    }

    @Override
    public void play(int hours) {
        happiness += 3 * hours;
    }

}

package hu.nive.ujratervezes.zarovizsga.kennel;

public class Beagle extends Dog {

    private int happiness = 0;

    public Beagle(String name) {
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
        happiness += 2;
    }

    @Override
    public void play(int hours) {
        happiness += 2 * hours;
    }
}

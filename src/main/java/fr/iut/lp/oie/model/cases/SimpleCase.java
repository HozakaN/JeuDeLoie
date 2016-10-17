package fr.iut.lp.oie.model.cases;

/**
 * Created by gimbert on 2014-09-12.
 */
public class SimpleCase implements Case {

    private final static String SIMPLE_CASE_NAME = "Case simple";

    private String name;

    public SimpleCase() {
        this(SIMPLE_CASE_NAME);
    }

    public SimpleCase(String name) {
        this.name = SIMPLE_CASE_NAME;
    }

    public String getName() {
        return name;
    }

    @Override
    public Case moveToCase() {
        return null;
    }

    @Override
    public boolean isArrival() {
        return false;
    }

    @Override
    public boolean skipTurn() {
        return false;
    }

    @Override
    public String toString() {
        return "";
    }
}

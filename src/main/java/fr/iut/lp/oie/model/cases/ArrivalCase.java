package fr.iut.lp.oie.model.cases;

/**
 * Created by gimbert on 2014-09-12.
 */
public class ArrivalCase extends SimpleCase {

    private final static String ARRIVAL_CASE_NAME = "Case arrivée";

    public ArrivalCase() {
        super(ARRIVAL_CASE_NAME);
    }

    @Override
    public boolean isArrival() {
        return true;
    }
}

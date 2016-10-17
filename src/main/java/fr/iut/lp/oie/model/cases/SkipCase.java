package fr.iut.lp.oie.model.cases;

/**
 * Created by gimbert on 2014-09-12.
 */
public class SkipCase extends SimpleCase {

    private final static String SKIP_CASE_NAME = "Case skip";

    public SkipCase() {
        super(SKIP_CASE_NAME);
    }

    @Override
    public boolean skipTurn() {
        return true;
    }
}

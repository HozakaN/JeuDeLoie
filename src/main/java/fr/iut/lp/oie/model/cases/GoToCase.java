package fr.iut.lp.oie.model.cases;

import fr.iut.lp.oie.model.Plateau;

import java.util.Random;

/**
 * Created by gimbert on 2014-09-12.
 */
public class GoToCase extends SimpleCase {

    private static Random rand = new Random(System.currentTimeMillis());

    private final static String GOTO_CASE_NAME = "Case goto";
    private int goTo;

    public GoToCase() {
        super(GOTO_CASE_NAME);
        goTo = rand.nextInt(3)+1;
        goTo = goTo*(rand.nextBoolean() ? -1 : 1);
    }

    @Override
    public Case moveToCase() {
        return Plateau.getInstance().getCaseAtPosition(Plateau.getInstance().indexOf(this) + goTo);
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        if (goTo < 0) {
            sb.append(": reculez ");
        } else {
            sb.append(": avancez ");
        }
        sb.append("de ").append(Math.abs(goTo)).append(" case(s)");
        return sb.toString();
    }
}

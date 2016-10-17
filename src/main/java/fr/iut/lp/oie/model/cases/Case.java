package fr.iut.lp.oie.model.cases;

/**
 * Created by gimbert on 2014-09-12.
 */
public interface Case {

    /**
     * Allows a user to move to this case.
     * @return a Case, if the user cannot stand on this one, or null if it's ok
     */
    public Case moveToCase();

    /**
     * indicate if this case is the arrival one
     * @return true if the is the final case
     */
    public boolean isArrival();

    /**
     * Indicates whether or not the player must skip his turn
     * @return
     */
    public boolean skipTurn();

}

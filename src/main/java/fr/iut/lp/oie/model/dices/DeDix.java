package fr.iut.lp.oie.model.dices;

/**
 * Created by gimbert on 2014-09-12.
 */
public class DeDix extends De {
    @Override
    public int lancer() {
        return rand.nextInt(10)+1;
    }
}

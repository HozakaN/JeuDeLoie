package fr.iut.lp.oie.model.dices;

import java.util.Random;

/**
 * Created by gimbert on 2014-09-12.
 */
public class De {

    protected final Random rand;

    public De() {
        rand = new Random(System.currentTimeMillis());
    }

    public int lancer() {
        return rand.nextInt(6)+1;
    }

}

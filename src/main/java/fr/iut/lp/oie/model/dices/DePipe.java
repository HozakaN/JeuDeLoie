package fr.iut.lp.oie.model.dices;

/**
 * Created by gimbert on 2014-10-01.
 */
public class DePipe extends De {
    @Override
    public int lancer() {
        int number = rand.nextInt(8)+1;
        if (number > 6) {
            number = 6;
        }
        return number;
    }
}

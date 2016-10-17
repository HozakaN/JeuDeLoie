package fr.iut.lp.oie.engine;

import fr.iut.lp.oie.model.dices.DePipe;
import fr.iut.lp.oie.model.Plateau;

import java.util.List;

/**
 * Created by gimbert on 2014-09-12.
 */
public class MoteurDeJeuPipe extends MoteurDeJeu {

    public MoteurDeJeuPipe(List<String> playerNames) {
        super(playerNames);
    }

    @Override
    public void prepareDice() {
        Plateau.getInstance().setDe(new DePipe());
    }
}

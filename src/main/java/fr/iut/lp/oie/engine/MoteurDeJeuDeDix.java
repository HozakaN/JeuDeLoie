package fr.iut.lp.oie.engine;

import fr.iut.lp.oie.model.dices.DeDix;
import fr.iut.lp.oie.model.Plateau;

import java.util.List;

/**
 * Created by gimbert on 2014-09-12.
 */
public class MoteurDeJeuDeDix extends MoteurDeJeu {

    public MoteurDeJeuDeDix(List<String> playerNames) {
        super(playerNames);
    }

    @Override
    public void prepareDice() {
        Plateau.getInstance().setDe(new DeDix());
    }
}

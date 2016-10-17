package fr.iut.lp.oie;

import fr.iut.lp.oie.engine.MoteurDeJeu;
import fr.iut.lp.oie.engine.MoteurDeJeuDeDix;
import fr.iut.lp.oie.ui.MenuDeJeu;

import java.util.List;

/**
 * Created by gimbert on 2014-09-12.
 */
public class MainClass {

    public static void main(String[] args) {
        MenuDeJeu menu = new MenuDeJeu();
        List<String> playerNames = menu.obtenirJoueurs();
        int diceType = menu.getDiceToUse();
        MoteurDeJeu moteur = diceType == 0 ? new MoteurDeJeu(playerNames) : new MoteurDeJeuDeDix(playerNames);
        moteur.lancerJeu();
    }

}

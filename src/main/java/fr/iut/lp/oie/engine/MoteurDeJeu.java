package fr.iut.lp.oie.engine;

import fr.iut.lp.oie.model.dices.De;
import fr.iut.lp.oie.model.Joueur;
import fr.iut.lp.oie.model.Plateau;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by gimbert on 2014-09-12.
 */
public class MoteurDeJeu {

    private List<Joueur> players;

    public MoteurDeJeu(List<String> playerNames) {
        players = new ArrayList<Joueur>();
        for (String playerName : playerNames) {
            players.add(new Joueur(playerName));
        }
        prepareDice();
    }

    public void prepareDice() {
        Plateau.getInstance().setDe(new De());
    }

    public void lancerJeu() {
        boolean playerHasWon = false;
        int currentTurn = 0;
        Joueur currentPlayer = null;
        do {
            currentPlayer = players.get(currentTurn % players.size());
            System.out.println(String.format("Tour de %s", currentPlayer.getName()));
            playerHasWon = currentPlayer.jouer();
            ++currentTurn;
        } while (!playerHasWon);
    }

}

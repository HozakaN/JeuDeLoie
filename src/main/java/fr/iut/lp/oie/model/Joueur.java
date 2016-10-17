package fr.iut.lp.oie.model;

import fr.iut.lp.oie.model.cases.Case;

/**
 * Created by gimbert on 2014-09-12.
 */
public class Joueur {

    private static int playerCounter = 0;

    private String name;

    private Case position = null;
    private boolean mustSkipTurn = false;

    public Joueur(String name) {
        playerCounter++;
        this.name = name;
        if (name == null || name.isEmpty()) {
            this.name = "Joueur " + playerCounter;
        }
    }

    public Case getPosition() {
        return position;
    }

    public String getName() {
        return name;
    }

    /**
     * Permet à un joueur de jouer
     * @return si le joueur a gagné ou non
     */
    public boolean jouer() {

        if (position != null) {
            if (position.skipTurn() && mustSkipTurn) {
                System.out.println(String.format("%s passe son tour", name));
                mustSkipTurn = false;
                return false;
            }
        }

        Plateau plateau = Plateau.getInstance();
        int advance = plateau.getDe().lancer();
        System.out.println(String.format("%s lance les dés : %d", name, advance));
        Case aCase = plateau.getCaseAtPosition(plateau.indexOf(position) + advance);

        Case newCase = aCase;
        do {
            System.out.println(String.format("%s arrive sur la case %d %s %s", name, plateau.indexOf(newCase) + 1,
                    newCase.getClass().getSimpleName(), newCase));
            aCase = newCase;
            newCase = newCase.moveToCase();
        } while (newCase != null);

        position = aCase;

        if (aCase.skipTurn()) {
            System.out.println(String.format("%s devra passer le prochain tour", name));
            mustSkipTurn = true;
        }

        if (aCase.isArrival()) {
            System.out.println(String.format("%s a gagné!", name));
            return true;
        }
        return false;
    }
}

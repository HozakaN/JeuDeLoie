package fr.iut.lp.oie.ui;

import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.List;
import java.util.Scanner;

/**
 * Created by gimbert on 2014-09-12.
 */
public class MenuDeJeu {

    private Scanner scanner;

    public MenuDeJeu() {
        scanner = new Scanner(System.in);
    }

    public int getDiceToUse() {
        int diceToUse = -1;

        do {
            System.out.print(String.format("Souhaitez-vous utiliser un dé 6 (0) ou un dé 10 (1) :"));
            try {
                diceToUse = scanner.nextInt();
                if (diceToUse < 0 || diceToUse > 1) {
                    System.out.println(String.format("Entrée utilisateur incorrecte."));
                }
            } catch (InputMismatchException e) {
                System.out.println(String.format("Entrée utilisateur incorrecte."));
                scanner.next(); //forced flush
            }
        } while (diceToUse < 0 || diceToUse > 1);

        return diceToUse;
    }

    public List<String> obtenirJoueurs() {
        return getPlayerNames(getNbPlayers());
    }

    private int getNbPlayers() {
        int nbPlayers = -1;

        do {
            System.out.print(String.format("Choississez le nombre de joueurs :"));
            try {
                nbPlayers = scanner.nextInt();
                if (nbPlayers <= 0) {
                    System.out.println(String.format("Le nombre de joueur(s) doit être supérieur à 0"));
                }
            } catch (InputMismatchException e) {
                System.out.println(String.format("Commande incorrecte. Utilisez un entier"));
                scanner.next(); //forced flush
            }
        } while (nbPlayers <= 0);

        scanner.nextLine(); //forced flush
        return nbPlayers;
    }

    private List<String> getPlayerNames(int nbPlayers) {
        List<String> playerNames = new ArrayList<String>();

        for (int i = 1; i <= nbPlayers; ++i) {
            String playerName;
            do {
                playerName = getPlayerName(i);
                if (playerName == null) {
                    System.out.println(String.format("Le nom n'est pas renseigné, un nom sera choisi automatiquement"));
                    playerNames.add(playerName);
                    playerName = "";
                }
                if (!playerName.equals("") && playerNames.contains(playerName)) {
                    System.out.println(String.format("Le nom %s est déjà pris", playerName));
                    playerName = null;
                }
            } while (playerName == null);
            playerNames.add(playerName);
        }

        return playerNames;
    }

    private String getPlayerName(int playerNumber) {
        String playerName;

        do {
            System.out.print(String.format("Indiquez le nom du joueur %d :", playerNumber));
            playerName = scanner.nextLine();
        } while (playerName == null);

        return playerName;
    }

}

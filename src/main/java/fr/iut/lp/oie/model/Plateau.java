package fr.iut.lp.oie.model;

import fr.iut.lp.oie.model.cases.*;
import fr.iut.lp.oie.model.dices.De;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

/**
 * Created by gimbert on 2014-09-12.
 */
public class Plateau {

    private static Plateau instance;

    public final static int NB_CASES = 63;

    public static Plateau getInstance() {
        if (instance == null) {
            instance = new Plateau();
        }
        return instance;
    }

    private List<Case> cases;
    private De de;

    private Plateau() {
        generateCases();
    }

    public De getDe() {
        return de;
    }

    public void setDe(De de) {

        this.de = de;
    }

    private void generateCases() {
        cases = new ArrayList<Case>(NB_CASES);
        for (int i = 0; i < NB_CASES; ++i) {
            cases.add(i, null);
        }

        cases.set(0, new DepartureCase());
        cases.set(NB_CASES - 1, new ArrivalCase());

        Random rand = new Random(System.currentTimeMillis());
        List<Integer> positions = new ArrayList<Integer>();
        for (int i = 1; i < NB_CASES - 1; ++i) {
            positions.add(i);
        }

        //Il y a 15 cases goto
        for (int i = 0; i < 15; ++i) {
            int position = positions.remove(rand.nextInt(positions.size()));
            cases.set(position, new GoToCase());
        }

        //Il y a 5 cases skip
        for (int i = 0; i < 5; ++i) {
            int position = positions.remove(rand.nextInt(positions.size()));
            cases.set(position, new SkipCase());
        }



        //Les cases restantes sont des cases simples
//        for (int i = 0; i < NB_CASES - 22; ++i) {
//            int position = positions.remove(rand.nextInt(positions.size()));
//            cases.set(position, new SimpleCase());
//        }
        for (Integer position : positions) {
            cases.set(position, new SimpleCase());
        }

    }

    /**
     *
     * @param aCase the case whose the index must be retrieved
     * @return -1 if the case is not on the board, the index of the case in the list ohterwise
     */
    public int indexOf(Case aCase) {
        int index = -1;
        if (aCase == null) {
            index = 0;
        } else if (cases.contains(aCase)) {
            index = cases.indexOf(aCase);
        }
        return index;
    }

    public Case getCaseAtPosition(int position) throws IllegalArgumentException {
        if (position < 0) {
//            throw new IllegalArgumentException("You are trying to access to a non existing case");
            position = 0;
        }
        if (position >= NB_CASES) {
            position = NB_CASES -1;
        }
        return cases.get(position);
    }

}

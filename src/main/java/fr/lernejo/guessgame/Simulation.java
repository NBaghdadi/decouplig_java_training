package fr.lernejo.guessgame;

import fr.lernejo.logger.Logger;
import fr.lernejo.logger.LoggerFactory;

public class Simulation {

    private final Logger logger = LoggerFactory.getLogger("simulation");
    private final Player player;  //TODO add variable type
    private long numberToGuess; //TODO add variable type
    private int loop_number =0;

    public Simulation(Player player) {
        //TODO implement me
        this.player = player;
    }

    public void initialize(long numberToGuess) {
        //TODO implement me
        this.numberToGuess = numberToGuess;
    }

    /**
     * @return true if the player have guessed the right number
     */
    private boolean nextRound() {
        //TODO implement me
        long res = player.askNextGuess();
        if(res == numberToGuess)
        {
            logger.log("Number Found");

            return true;
        }
        else
        {
            if((res - numberToGuess) > 0)
            {
                player.respond(false);

            }
            else
            {
                player.respond(true);
            }
        }
        return false;
    }

    public void loopUntilPlayerSucceed(int max) {
        //TODO implement me
        long t0 = System.currentTimeMillis();
        boolean res = nextRound();
        while(!res && loop_number< max)
        {
            res = nextRound();
            loop_number++;
        }
        if(loop_number <max)
        {
            System.out.println("Le nombre d'iteration sans depasser les limites:  "+ loop_number);
        }
        else{
            System.out.println("Limites depassées ");
        }
        long t1 = System.currentTimeMillis();
        long mm = ((t1-t0)/600000);
        long ss = ((t1-t0)/1000);
        System.out.println(mm+" mm "+ss+" ss "+((t1-t0)-(ss*1000)-(mm*600000))+" SSS");

    }
}

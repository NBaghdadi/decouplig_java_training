package fr.lernejo.guessgame;

import fr.lernejo.logger.Logger;
import fr.lernejo.logger.LoggerFactory;

import java.security.SecureRandom;

public class Launcher {
    public static void main(String[] args)
    {
        Player player;
        Long max = Long.MAX_VALUE;
        String mode = args[0];
        SecureRandom random = new SecureRandom();
        long Number = random.nextInt(100);
        if(args.length==1 && args[0].equals("-interactive"))
            {
                player = new HumanPlayer();
                Simulation simulation = new Simulation(player);
                simulation.initialize(Number);
                simulation.loopUntilPlayerSucceed(Long.MAX_VALUE);
            }
        else if (args.length==2 && args[0].equals("-auto") && args[1].matches("[0-9]+"))

            {

                Number = Long.parseLong(args[1]);
                player = new ComputerPlayer();
                Simulation simulation = new Simulation(player);
                simulation.initialize(Number);
                simulation.loopUntilPlayerSucceed(1000);


            }

        else

        {
            Logger l = LoggerFactory.getLogger("console");
            l.log("Renseigner la methode de jeu a la console");
        }



    }


}

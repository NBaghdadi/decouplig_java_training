package fr.lernejo.guessgame;

import java.security.SecureRandom;

public class Launcher {
    public static void main(String[] args)
    {
        Player player;
        Long max = Long.MAX_VALUE;
        String mode = args[0];
        SecureRandom random = new SecureRandom();
        long Number = random.nextInt(1000);

        if (mode.equals("-interactive"))
        {
            player = new HumanPlayer();
            Simulation simulation = new Simulation(player);
            simulation.initialize(Number);
            simulation.loopUntilPlayerSucceed(1000);
        }

        else if(mode.equals("-auto"))
        {

            Number = Long.parseLong(args[1]);
            player = new ComputerPlayer();
            Simulation simulation = new Simulation(player);
            simulation.initialize(Number);
            simulation.loopUntilPlayerSucceed(1000);


        }
        else
        {
            System.out.println("Renseigner la methode de jeu a la console");
        }



    }


}

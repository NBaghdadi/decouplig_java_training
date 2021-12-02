package fr.lernejo.guessgame;

import fr.lernejo.logger.Logger;
import fr.lernejo.logger.LoggerFactory;
import java.util.Scanner;

public class HumanPlayer implements Player{
    Logger l = LoggerFactory.getLogger("player");
    @Override
    public long askNextGuess()
    {
        Scanner s = new Scanner(System.in);
        return s.nextLong();
    }
    @Override
    public void respond(boolean lowerOrGreater){
        if(lowerOrGreater)
        {
            l.log("Le nombre à deviner est plus Grand");
        }
        else
        {
            l.log("Le nombre à deviner est plus Petit");
        }

    }




}

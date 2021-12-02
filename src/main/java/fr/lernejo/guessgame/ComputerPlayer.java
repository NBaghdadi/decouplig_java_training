package fr.lernejo.guessgame;

import fr.lernejo.logger.Logger;
import fr.lernejo.logger.LoggerFactory;

import java.util.Scanner;

public class ComputerPlayer implements Player{
    Logger l = LoggerFactory.getLogger("ComputerPlayer");
    long min = 0;
    long max = 1000;
    long number;
    @Override
    public long askNextGuess()
    {
        number = (max+min)/2;
        System.out.println(number);
        return number;

    }
    @Override
    public void respond(boolean lowerOrGreater){
        if(lowerOrGreater)
        {
            l.log("Le nombre à deviner est plus Grand");
            min = number;
        }
        else
        {
            l.log("Le nombre à deviner est plus Petit");
            max = number;
        }

    }




}

package factory;

import model.BotDifficultyLevel;
import strategy.BotWinningStrategy.BotPlayingStrategy;
import strategy.BotWinningStrategy.HardBotPlayingStrategy;
import strategy.BotWinningStrategy.LinearBotPlayingStrategy;
import strategy.BotWinningStrategy.MediumBotPlayingStrategy;

public class BotPlayingStrategyFactory {
    public static BotPlayingStrategy getPlayingStrategy(BotDifficultyLevel level){
        //if easy-->LinearBotPlayingStrategy
        //if medium
        if(level==BotDifficultyLevel.EASY){
            return new LinearBotPlayingStrategy();
        }else if(level==BotDifficultyLevel.MEDIUM){
            return new MediumBotPlayingStrategy();
        }else if(level==BotDifficultyLevel.HARD){
            return new HardBotPlayingStrategy();
        }else{
            return null;
        }

    }

}

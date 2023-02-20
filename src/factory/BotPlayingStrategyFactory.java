package factory;

import model.BotDifficultyLevel;
import strategy.BotPlayingStrategy;
import strategy.LinearBotPlayingStrategy;

public class BotPlayingStrategyFactory {
    public static BotPlayingStrategy getPlayingStrategy(BotDifficultyLevel level){

        return new LinearBotPlayingStrategy();
    }

}

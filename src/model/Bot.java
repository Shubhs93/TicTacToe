package model;

import factory.BotPlayingStrategyFactory;
import strategy.BotPlayingStrategy;

public class Bot extends Player{
    private BotDifficultyLevel botDifficultyLevel;

    private BotPlayingStrategy botPlayingStrategy;

    public Bot(char symbol, String name,BotDifficultyLevel botDifficultyLevel ) {
        super(symbol, name, PlayerType.BOT);
        this.botDifficultyLevel=botDifficultyLevel;
        this.botPlayingStrategy= BotPlayingStrategyFactory.getPlayingStrategy(botDifficultyLevel);
    }

    public BotDifficultyLevel getBotDifficultyLevel() {
        return botDifficultyLevel;
    }

    public void setBotDifficultyLevel(BotDifficultyLevel botDifficultyLevel) {
        this.botDifficultyLevel = botDifficultyLevel;
    }

    @Override
    public Move decideMove(Board board){
        return botPlayingStrategy.decideMove(this,board);
    }


}
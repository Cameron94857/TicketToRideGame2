package ttr.up.edu.tickettoride;

import ttr.up.edu.game.GamePlayer;
import ttr.up.edu.game.LocalGame;
import ttr.up.edu.game.actionMsg.GameAction;

/**
 * class TTR_LocalGame
 *
 * is a class to extend LocalGame to implement a playable action-based game in the future.
 *
 * @author Alex
 * @author Cameron
 * @author Nick
 * @author Ben
 * @version October 2018
 *
 */

public class TTR_LocalGame extends LocalGame {

    TTR_GameState gameState;

    public TTR_LocalGame() {
        //gameState = new TTR_GameState(players.length);
    }

    @Override
    public String toString() {

        String str = "";
        return str;
    }

    @Override
    protected String checkIfGameOver() {
        return null;
    }

    @Override
    protected boolean canMove(int playerIdx) {
        return this.gameState.getCurrentPlayer() == playerIdx;
    }

    @Override
    protected boolean makeMove(GameAction action) {

       /*if (action instanceof DrawTrainDeckFaceUpGameAction) return drawTrainFaceUp(action);
       else if (action instanceof DrawTrainDeckGameAction) return false;
       else if (action instanceof DrawRouteDeckGameAction) return false;
       else return false;*/
       return false;

    }

    @Override
    protected void sendUpdatedStateTo(GamePlayer p) {

    }
}

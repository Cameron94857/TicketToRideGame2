package ttr.up.edu.tickettoride;

import org.junit.Before;
import org.junit.Test;

import ttr.up.edu.game.infoMsg.GameState;

import static org.junit.Assert.*;

public class TTR_GameStateTest {

    TTR_GameState state2;

    @Before
    public void setUp() throws Exception {
        state2 = new TTR_GameState(4);
    }

    @Test
    public void copyConstructorReferences(){
        TTR_GameState state = new TTR_GameState(4);
        TTR_GameState state2;
        try {
            state2 = new TTR_GameState(state);
            assertFalse(state.getPlayerHands() == state2.getPlayerHands());
            assertFalse(state.getTrainDeck() == state2.getTrainDeck());
            assertFalse(state.getRouteDeck() == state2.getRouteDeck());
            assertFalse(state.getFaceUpTrainCards() == state2.getFaceUpTrainCards());
            assertFalse(state.getTrainPieceStash() == state2.getTrainPieceStash());
            assertFalse(state.getRouteCards() == state2.getRouteCards());
        }catch(CloneNotSupportedException ex){ }
    }

    @Test
    public void copyConstructorValues(){
        TTR_GameState state = new TTR_GameState(4);
        TTR_GameState state2;
        try {
            state2 = new TTR_GameState(state);
            assertTrue(state.getCurrentPlayer() == state2.getCurrentPlayer());
            assertTrue(state.getNumRouteCardsDrawn() == state2.getNumRouteCardsDrawn());
            assertTrue(state.getNumRouteCardsDrawn() == state2.getNumTrainCardsDrawn());
            assertTrue(state.getCurrentPlayer() == state2.getCurrentPlayer());
            assertTrue(state.getBlueTrains() == state2.getBlueTrains());
            assertTrue(state.getRedTrains() == state2.getRedTrains());
            assertTrue(state.getGreenTrains() == state2.getGreenTrains());
            assertTrue(state.getYellowTrains() == state2.getYellowTrains());
            assertTrue(state.getBlackTrains() == state2.getBlackTrains());
        }catch(CloneNotSupportedException ex){ }
    }

    @Test
    public void drawCardTrainDeck() {
        TTR_GameState state = new TTR_GameState(4);
        int initialLengthCards = state.getTrainDeck().getCards().size();
        int initialLengthDiscard = state.getTrainDeck().getDiscard().size();
        Card c = state.getTrainDeck().draw();
        assertEquals(initialLengthCards, state.getTrainDeck().getCards().size()+1);
        assertEquals(initialLengthDiscard, 0);
    }

    @Test
    public void getFaceUpTrainCards(){
        TTR_GameState state = new TTR_GameState(4);
        Card[] c = state.getFaceUpTrainCards();
        assertFalse(c[0] == null);
        assertFalse(c[1] == null);
        assertFalse(c[2] == null);
        assertFalse(c[3] == null);
        assertFalse(c[4] == null);
        assertFalse(c[0].getName() == null);
        assertFalse(c[1].getName() == null);
        assertFalse(c[2].getName() == null);
        assertFalse(c[3].getName() == null);
        assertFalse(c[4].getName() == null);
    }

    @Test
    public void setGetCurrentPlayer() {
        TTR_GameState state = new TTR_GameState(4);
        int curr = state.getCurrentPlayer();
        state.setCurrentPlayer(3);
        int curr2 = state.getCurrentPlayer();
        assertEquals(curr, 0);
        assertEquals(curr2, 3);
    }

    @Test
    public void setFaceUpTrainCards() {
        TTR_GameState state = new TTR_GameState(4);
        Card[] c = state.getFaceUpTrainCards();
        Card c1 = c[0].clone();
        Card c2 = c[1].clone();
        Card c3 = c[2].clone();
        Card c4 = c[3].clone();
        Card c5 = c[4].clone();

        state.setFaceUpTrainCards(new Card[]{new Card("test1"), new Card("test2"), new Card("test3"), new Card("test4"), new Card("test5")});
        Card[] cc = state.getFaceUpTrainCards();
        Card cc1 = cc[0].clone();
        Card cc2 = cc[1].clone();
        Card cc3 = cc[2].clone();
        Card cc4 = cc[3].clone();
        Card cc5 = cc[4].clone();

        assertFalse(c1.getName().equals(cc1.getName()));
        assertFalse(c2.getName().equals(cc2.getName()));
        assertFalse(c3.getName().equals(cc3.getName()));
        assertFalse(c4.getName().equals(cc4.getName()));
        assertFalse(c5.getName().equals(cc5.getName()));
    }
}
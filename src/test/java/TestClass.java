import api.Player;
import org.junit.jupiter.api.*;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

import com.ginsberg.junit.exit.ExpectSystemExit;

public class TestClass {

    private Player initiator;
    private Player player2;

    @BeforeEach
    public void initialization() {
        initiator = new PlayerImpl("initiator");
        player2 = new PlayerImpl("player2");
    }

    @Test
    public void sendMessageToPlayer2() {
        assertNotNull(initiator.sendMessage(player2, "Initiate game"));
    }

    @Test
    public void whenInitiatorSendsMessageToPlayer_thenPlayer2SendsBackMessageWithCounter() {
        String receivedMessage = initiator.sendMessage(player2, "Initiate game");
        assertEquals("Initiate game1", receivedMessage);
    }

    @Test
    @ExpectSystemExit
    public void when10MessageSentAndReceivedTerminate() {
        for (int i = 0; i < 100; i++) {
            initiator.sendMessage(player2, "Initiate game");
        }
    }
}

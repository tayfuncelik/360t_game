import api.Player;

import java.util.HashMap;
import java.util.Map;
import java.util.logging.Logger;

public class PlayerImpl implements Player {
    Logger LOGGER = Logger.getLogger(PlayerImpl.class.toString());

    private final String name;
    private final Map<Player, Integer> receivedMessages = new HashMap<Player, Integer>();

    public PlayerImpl(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public String sendMessage(Player toPlayer, String message) {
        LOGGER.info(this.name + " sent a message '" + message + "' to " + toPlayer.getName());
        return toPlayer.receiveMessage(this, message);
    }

    public String receiveMessage(Player fromPlayer, String message) {
        Integer counter = receivedMessages.getOrDefault(fromPlayer, 0) + 1;
        receivedMessages.put(fromPlayer, counter);
        LOGGER.info(this.name + " received a (counter: " + counter + ") message '" + message + "' from " + fromPlayer.getName());
        if (counter == 10) {
            System.exit(0);
        }
        return message + counter;
    }
}

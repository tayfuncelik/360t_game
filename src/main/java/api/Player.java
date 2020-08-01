package api;

public interface Player {
    String getName();
    /**
     * Sends message to player
     * @param player a reference to the other player
     * @param message  the message sent to the other player
     * @return returns the reply from the other player
     */
    String sendMessage(Player player, String message);

    /**
     * Receives a message from player.
     * @param player the reference of the other player
     * @param message   the message received from the other player
     * @return  returns a reply to be sent to the sender
     */
    String receiveMessage(Player player, String message) ;
}
package org.jboss.aesh.console.command;

import java.util.Set;

/**
 * A simple registry where all the Commands are stored
 *
 * @author <a href="mailto:stale.pedersen@jboss.org">Ståle W. Pedersen</a>
 */
public interface CommandRegistry {

    /**
     * @param name command name
     * @param line current terminal buffer line
     * @return the matching CommandContainer's name
     * @throws CommandNotFoundException
     */
    CommandContainer getCommand(String name, String line) throws CommandNotFoundException;

    /**
     * @return all specified command names
     */
    Set<String> getAllCommandNames();
}

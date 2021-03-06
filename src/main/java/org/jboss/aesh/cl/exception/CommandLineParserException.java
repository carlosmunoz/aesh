/*
 * Copyright 2012 Red Hat, Inc. and/or its affiliates.
 *
 * Licensed under the Eclipse Public License version 1.0, available at
 * http://www.eclipse.org/legal/epl-v10.html
 */
package org.jboss.aesh.cl.exception;

/**
 * @author <a href="mailto:stale.pedersen@jboss.org">Ståle W. Pedersen</a>
 */
public class CommandLineParserException extends Exception {

    public CommandLineParserException(String msg) {
        super(msg);
    }

    public CommandLineParserException(String msg, Throwable cause) {
       super(msg, cause);
    }
}

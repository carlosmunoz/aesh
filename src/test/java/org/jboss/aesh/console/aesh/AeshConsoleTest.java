/*
 * Copyright 2012 Red Hat, Inc. and/or its affiliates.
 *
 * Licensed under the Eclipse Public License version 1.0, available at
 * http://www.eclipse.org/legal/epl-v10.html
 */
package org.jboss.aesh.console.aesh;

import org.jboss.aesh.cl.Arguments;
import org.jboss.aesh.cl.CommandDefinition;
import org.jboss.aesh.cl.Option;
import org.jboss.aesh.cl.OptionList;
import org.jboss.aesh.cl.builder.CommandBuilder;
import org.jboss.aesh.cl.builder.OptionBuilder;
import org.jboss.aesh.cl.exception.CommandLineParserException;
import org.jboss.aesh.cl.internal.ProcessedCommand;
import org.jboss.aesh.cl.parser.AeshCommandLineParser;
import org.jboss.aesh.cl.validator.OptionValidator;
import org.jboss.aesh.cl.validator.OptionValidatorException;
import org.jboss.aesh.console.AeshConsole;
import org.jboss.aesh.console.AeshConsoleBuilder;
import org.jboss.aesh.console.BaseConsoleTest;
import org.jboss.aesh.console.command.AeshCommandRegistryBuilder;
import org.jboss.aesh.console.command.Command;
import org.jboss.aesh.console.command.CommandInvocation;
import org.jboss.aesh.console.command.CommandRegistry;
import org.jboss.aesh.console.command.CommandResult;
import org.jboss.aesh.console.settings.Settings;
import org.jboss.aesh.console.settings.SettingsBuilder;
import org.jboss.aesh.edit.KeyOperation;
import org.jboss.aesh.edit.actions.Operation;
import org.jboss.aesh.terminal.Key;
import org.jboss.aesh.terminal.TestTerminal;
import org.junit.Test;

import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.IOException;
import java.io.PipedInputStream;
import java.io.PipedOutputStream;
import java.util.List;

import static org.junit.Assert.assertEquals;

/**
 * @author <a href="mailto:stale.pedersen@jboss.org">Ståle W. Pedersen</a>
 */
public class AeshConsoleTest extends BaseConsoleTest {

    private KeyOperation completeChar =  new KeyOperation(Key.CTRL_I, Operation.COMPLETE);

    @Test
    public void testAeshConsole() throws IOException, InterruptedException, CommandLineParserException {
        PipedOutputStream outputStream = new PipedOutputStream();
        PipedInputStream pipedInputStream = new PipedInputStream(outputStream);

        Settings settings = new SettingsBuilder()
                .terminal(new TestTerminal())
                .inputStream(pipedInputStream)
                .outputStream(new ByteArrayOutputStream())
                .logging(true)
                .create();

        ProcessedCommand fooCommand = new CommandBuilder()
                .name("foo")
                .description("fooing")
                .addOption(new OptionBuilder()
                        .name("bar")
                        .addDefaultValue("en")
                        .addDefaultValue("to")
                        .type(String.class)
                        .fieldName("bar")
                        .create())
                .generateParameter();

        CommandRegistry registry = new AeshCommandRegistryBuilder()
                .command(new AeshCommandLineParser(fooCommand), FooTestCommand.class)
                .command(LsCommand.class)
                .create();

        AeshConsoleBuilder consoleBuilder = new AeshConsoleBuilder()
                .settings(settings)
                .commandRegistry(registry);

        AeshConsole aeshConsole = consoleBuilder.create();
        aeshConsole.start();

        outputStream.write(("foo").getBytes());
        //outputStream.write(completeChar.getFirstValue());
        outputStream.write("\n".getBytes());

        outputStream.write("ls --files /home:/tmp".getBytes());
        outputStream.write("\n".getBytes());

        Thread.sleep(100);
        aeshConsole.stop();
    }

    public static class FooTestCommand implements Command {

        private String bar;

        public CommandResult execute(CommandInvocation commandInvocation) throws IOException {
            assertEquals("en", bar);
            return CommandResult.SUCCESS;
        }
    }

    @CommandDefinition(name="ls", description = "[OPTION]... [FILE]...")
    public class LsCommand implements Command {

        @Option(hasValue = false, description = "set foo to true/false")
        private Boolean foo;

        @Option(hasValue = false, description = "set the bar")
        private boolean bar;

        @Option(defaultValue = {"MORE"}, argument = "SIZE")
        private String less;

        @OptionList(defaultValue = "/tmp", description = "file location", valueSeparator = ':',
                validator = DirectoryValidator.class)
        List<File> files;

        @Option(hasValue = false, description = "display this help and exit")
        private boolean help;

        @Arguments
        private java.util.List<File> arguments;

        @Override
        public CommandResult execute(CommandInvocation commandInvocation) throws IOException {
            assertEquals(2, files.size());
            return CommandResult.SUCCESS;
        }
    }

    public class DirectoryValidator implements OptionValidator<File> {
        @Override
        public void validate(File value) throws OptionValidatorException {
            if(!value.isDirectory()) {
                throw new OptionValidatorException("File validation failed, must be a directory.");
            }
        }
    }
}

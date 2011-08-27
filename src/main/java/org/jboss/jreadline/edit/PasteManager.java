/*
 * JBoss, Home of Professional Open Source
 * Copyright 2010, Red Hat Middleware LLC, and individual contributors
 * by the @authors tag. See the copyright.txt in the distribution for a
 * full listing of individual contributors.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 * http://www.apache.org/licenses/LICENSE-2.0
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package org.jboss.jreadline.edit;

import java.util.ArrayList;
import java.util.List;

/**
 * Keep track of edits for paste
 *
 * @author Ståle W. Pedersen <stale.pedersen@jboss.org>
 */
public class PasteManager {

    private static final int PASTE_SIZE = 10;
    private List<StringBuilder> pasteStack;

    public PasteManager() {
        pasteStack = new ArrayList<StringBuilder>(PASTE_SIZE);
    }

    public void addText(StringBuilder buffer) {
        checkSize();
        pasteStack.add(buffer);
    }

    private void checkSize() {
        if(pasteStack.size() >= PASTE_SIZE) {
            pasteStack.remove(0);
        }
    }

    public StringBuilder get(int index) {
        if(index < pasteStack.size())
            return pasteStack.get((pasteStack.size()-index-1));
        else
            return pasteStack.get(0);
    }
}
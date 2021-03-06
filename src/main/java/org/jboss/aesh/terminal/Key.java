/*
 * Copyright 2012 Red Hat, Inc. and/or its affiliates.
 *
 * Licensed under the Eclipse Public License version 1.0, available at
 * http://www.eclipse.org/legal/epl-v10.html
 */
package org.jboss.aesh.terminal;

import org.jboss.aesh.console.Config;

/**
 * ANSCII enum key chart
 *
 * @author <a href="mailto:stale.pedersen@jboss.org">Ståle W. Pedersen</a>
 */
public enum Key {

    CTRL_A(new int[]{1}),
    CTRL_B(new int[]{2}),
    CTRL_C(new int[]{3}),
    CTRL_D(new int[]{4}),
    CTRL_E(new int[]{5}),
    CTRL_F(new int[]{6}),
    CTRL_G(new int[]{7}),
    CTRL_H(new int[]{8}),
    CTRL_I(new int[]{9}),
    CTRL_J(new int[]{10}),
    CTRL_K(new int[]{11}),
    CTRL_L(new int[]{12}),
    CTRL_M(new int[]{13}),
    CTRL_N(new int[]{14}),
    CTRL_O(new int[]{15}),
    CTRL_P(new int[]{16}),
    CTRL_Q(new int[]{17}),
    CTRL_R(new int[]{18}),
    CTRL_S(new int[]{19}),
    CTRL_T(new int[]{20}),
    CTRL_U(new int[]{21}),
    CTRL_V(new int[]{22}),
    CTRL_W(new int[]{23}),
    CTRL_X(new int[]{24}),
    CTRL_Y(new int[]{25}),
    CTRL_Z(new int[]{26}),
    ESC(new int[]{27}), //ctrl-[ and esc
    FILE_SEPARATOR(new int[]{28}), //ctrl-\
    GROUP_SEPARATOR(new int[]{29}), //ctrl-]
    RECORD_SEPARATOR(new int[]{30}), //ctrl-ctrl
    UNIT_SEPARATOR(new int[]{31}), //ctrl-_

    SPACE(new int[]{32}),
    EXCLAMATION(new int[]{33}), // !
    QUOTE(new int[]{34}), // "
    HASH(new int[]{35}), // #
    DOLLAR(new int[]{36}), // $
    PERCENT(new int[]{37}), // %
    AMPERSAND(new int[]{38}), // &
    APOSTROPHE(new int[]{39}), // '
    LEFT_PARANTHESIS(new int[]{40}), // (
    RIGHT_PARANTHESIS(new int[]{41}), // )
    STAR(new int[]{42}), // *
    PLUS(new int[]{43}), // +
    COMMA(new int[]{44}), // ,
    MINUS(new int[]{45}), // -
    PERIOD(new int[]{46}), // .
    SLASH(new int[]{47}), // /
    ZERO(new int[]{48}), // 0
    ONE(new int[]{49}), // 0
    TWO(new int[]{50}), // 0
    THREE(new int[]{51}), // 0
    FOUR(new int[]{52}), // 0
    FIVE(new int[]{53}), // 0
    SIX(new int[]{54}), // 0
    SEVEN(new int[]{55}), // 0
    EIGHT(new int[]{56}), // 0
    NINE(new int[]{57}), // 0
    COLON(new int[]{58}), // :
    SEMI_COLON(new int[]{59}), // :
    LESS_THAN(new int[]{60}), // <
    EQUALS(new int[]{61}), // =
    GREATER_THAN(new int[]{62}), // >
    QUESTION_MARK(new int[]{63}), // ?
    AT(new int[]{64}), // @
    A(new int[]{65}),
    B(new int[]{66}),
    C(new int[]{67}),
    D(new int[]{68}),
    E(new int[]{69}),
    F(new int[]{70}),
    G(new int[]{71}),
    H(new int[]{72}),
    I(new int[]{73}),
    J(new int[]{74}),
    K(new int[]{75}),
    L(new int[]{76}),
    M(new int[]{77}),
    N(new int[]{78}),
    O(new int[]{79}),
    P(new int[]{80}),
    Q(new int[]{81}),
    R(new int[]{82}),
    S(new int[]{83}),
    T(new int[]{84}),
    U(new int[]{85}),
    V(new int[]{86}),
    W(new int[]{87}),
    X(new int[]{88}),
    Y(new int[]{89}),
    Z(new int[]{90}),
    LEFT_SQUARE_BRACKET(new int[]{91}), // [
    BACKSLASH(new int[]{92}), // \
    RIGHT_SQUARE_BRACKET(new int[]{93}), // ]
    HAT(new int[]{94}), // ^
    UNDERSCORE(new int[]{95}), // _
    GRAVE(new int[]{96}), // `
    a(new int[]{97}),
    b(new int[]{98}),
    c(new int[]{99}),
    d(new int[]{100}),
    e(new int[]{101}),
    f(new int[]{102}),
    g(new int[]{103}),
    h(new int[]{104}),
    i(new int[]{105}),
    j(new int[]{106}),
    k(new int[]{107}),
    l(new int[]{108}),
    m(new int[]{109}),
    n(new int[]{110}),
    o(new int[]{111}),
    p(new int[]{112}),
    q(new int[]{113}),
    r(new int[]{114}),
    s(new int[]{115}),
    t(new int[]{116}),
    u(new int[]{117}),
    v(new int[]{118}),
    w(new int[]{119}),
    x(new int[]{120}),
    y(new int[]{121}),
    z(new int[]{122}),
    LEFT_CURLY_BRACKET(new int[]{123}), // {
    VERTICAL_BAR(new int[]{124}), // {
    RIGHT_CURLY_BRACKET(new int[]{125}), // {
    TILDE(new int[]{126}), // ~
    //movement
    UP(Config.isOSPOSIXCompatible() ?
            new int[]{27,91,65} : new int[]{224,72}),
    DOWN(Config.isOSPOSIXCompatible() ?
            new int[]{27,91,66} : new int[]{224,80}),
    RIGHT(Config.isOSPOSIXCompatible() ?
            new int[]{27,91,67} : new int[]{224,77}),
    LEFT(Config.isOSPOSIXCompatible() ?
            new int[]{27,91,68} : new int[]{224,75}),

    UP_2(Config.isOSPOSIXCompatible() ?
            InfocmpManager.getUp() : new int[]{224,72}),
    DOWN_2(Config.isOSPOSIXCompatible() ?
            InfocmpManager.getDown() : new int[]{224,80}),
    RIGHT_2(Config.isOSPOSIXCompatible() ?
            InfocmpManager.getRight() : new int[]{224,77}),
    LEFT_2(Config.isOSPOSIXCompatible() ?
            InfocmpManager.getLeft() : new int[]{224,75}),
    //meta
    META_F(Config.isOSPOSIXCompatible() ?
            new int[]{27,102} : new int[]{0,33}),
    META_B(Config.isOSPOSIXCompatible() ?
            new int[]{27,98} : new int[]{0,48}),
    META_D(Config.isOSPOSIXCompatible() ?
            new int[]{27,100} : new int[]{0,32}),
    META_A(new int[]{27,97}),
    //div
    DELETE(Config.isOSPOSIXCompatible() ?
            InfocmpManager.getDelete() : new int[]{224,83}),
    INSERT(Config.isOSPOSIXCompatible() ?
            InfocmpManager.getIns() : new int[]{224,82}),
    PGUP(Config.isOSPOSIXCompatible() ?
            InfocmpManager.getPgUp() : new int[]{224,73}),
    PGDOWN(Config.isOSPOSIXCompatible() ?
            InfocmpManager.getPgDown() : new int[]{224,81}),
    HOME(Config.isOSPOSIXCompatible() ?
            InfocmpManager.getKeyHome() : new int[]{224,71}),
    HOME_2(Config.isOSPOSIXCompatible() ?
            InfocmpManager.getCursorHome() : new int[]{224,71}),
    END(Config.isOSPOSIXCompatible() ?
            InfocmpManager.getEnd() : new int[]{224,79}),
    END_2(Config.isOSPOSIXCompatible() ? new int[]{27,91,70} : new int[]{224,79}),
    META_CTRL_J(Config.isOSPOSIXCompatible() ?
            new int[]{27,10} : new int[]{0,36}),
    META_CTRL_D(new int[]{27,4}),
    CTRL_X_CTRL_U(Config.isOSPOSIXCompatible() ?
            new int[]{24,21} : new int[]{0,36}),
    BACKSPACE(Config.isOSPOSIXCompatible() ?
            new int[]{127} : new int[]{8}),
    ENTER(Config.isOSPOSIXCompatible() ?
            new int[]{10} : new int[]{13});

    private int[] keyValues;

    Key(int[] keyValues) {
        this.keyValues = keyValues;
        }

    /**
     * is of type a-z or A-Z
     */
    public boolean isCharacter() {
        return (keyValues.length == 1 &&
                ((keyValues[0] > 63 && keyValues[0] < 91) || (keyValues[0] > 96 && keyValues[0] < 123)));
    }

    /**
     * @return true if input is 0-9
     */
    public boolean isNumber() {
        return (keyValues.length == 1 && ((keyValues[0] > 47) && (keyValues[0] < 58)));
    }

    /**
     * @return true if input is a valid char
     */
    public boolean isValidInput() {
        return (keyValues.length == 1 && (keyValues[0] > 31 && keyValues[0] < 127));
    }

    public char getAsChar() {
        return (char) keyValues[0];
    }

    public int[] getKeyValues() {
        return keyValues;
    }

    public int getFirstValue() {
        return keyValues[0];
    }

    public static Key getKey(int[] otherValues) {
        for(Key key : Key.values()) {
            if(key.equalTo(otherValues))
                return key;
        }
        return null;
    }

    public boolean containKey(int[] input) {
        for(int i=0; i < input.length; i++) {
            if(input[i] == keyValues[0]) {
                if(keyValues.length == 1)
                    return true;
                else if((i + keyValues.length) < input.length) {
                    int j = i;
                    for(int k : keyValues) {
                        if(input[j] != k) {
                            return false;
                        }
                        j++;
                    }
                    return true;
                }
            }
        }
        return false;
    }

    public boolean equalTo(int[] otherValues) {
        if(keyValues.length == otherValues.length) {
            for(int i=0; i < keyValues.length; i++) {
                if(keyValues[i] != otherValues[i])
                    return false;
            }
            return true;
        }
        return false;
    }



}

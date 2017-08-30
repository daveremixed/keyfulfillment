package com.gonzobeans.keyfulfillment.util;

import com.gonzobeans.keyfulfillment.model.CodeType;

import java.util.UUID;
import java.util.concurrent.ThreadLocalRandom;

/**
 * Created by Dave on 5/28/2017.
 */
public class CodeGenerator {

    // Character arrays allow for fast access to members to build random passwords.  As singletons,
    // they do not need to be created every time.  Depending on the character set selected, easily
    // confused characters are removed such as O and 0.
    private static final char[] ALPHA_CAPS_CHARACTERS = "ABCDEFGHIJKLMNOPQRSTUVWXYZ".toCharArray();
    private static final char[] ALPHA_CHARACTERS = "ABCDEFGHJKLMNOPQRSTUVWXYZabcdefghijkmnopqrstuvwxyz".toCharArray();
    private static final char[] ALPHA_NUMERIC_CAPS_CHARACTERS ="ABCDEFGHIJKLMNPQRSTUVWXYZ23456789".toCharArray();
    private static final char[] ALPHA_NUMERIC_CHARACTERS = "ABCDEFGHJKLMNPQRSTUVWXYZ23456789abcdefghjkmnopqrstuvwxyz".toCharArray();
    private static final char[] NUMERIC_CHARACTERS = "0123456789".toCharArray();


    public static String getCode(CodeType type, int codeSize) {
        return generateCode(codeSize, getCharacters(type));
    }

    public static String createSecret() {
        return UUID.randomUUID().toString().replaceAll("-", "");
    }

    private static String generateCode(int codeSize, char[] characters) {
        StringBuilder code = new StringBuilder();
        for (int i=0; i < codeSize; i++) {
            code.append(characters[ThreadLocalRandom.current().nextInt(0, characters.length)]);
        }
        return code.toString();
    }

    private static char[] getCharacters(CodeType type) {
        switch(type) {
            case ALPHA:
                return ALPHA_CHARACTERS;
            case ALPHACAPS:
                return ALPHA_CAPS_CHARACTERS;
            case ALPHANUMERIC:
                return ALPHA_NUMERIC_CHARACTERS;
            case ALPHANUMERIC_CAPS:
                return ALPHA_NUMERIC_CAPS_CHARACTERS;
            case NUMERIC:
                return NUMERIC_CHARACTERS;
            default:
                return ALPHA_CAPS_CHARACTERS;
        }
    }
}

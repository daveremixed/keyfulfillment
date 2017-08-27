package com.gonzobeans.keyfulfillment.util;

import com.gonzobeans.keyfulfillment.model.CodeType;

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
    private static final char[] ALPHA_NUMERIC_CAPS_CHARACTERS ="ABCDEFGHIJKLMNPQRSTUVWXY3456789".toCharArray();
    private static final char[] ALPHA_NUMERIC_CHARACTERS = "ABCDEFGHJKLMNPQRSTUVWXY3456789abcdefghjkmnopqrstuvwxyz".toCharArray();
    private static final char[] NUMERIC_CHARACTERS = "0123456789".toCharArray();


    public static String getCode(CodeType type, int codeSize) {
        switch(type) {
            case ALPHA:
                return generateCode(codeSize, ALPHA_CHARACTERS);
            case ALPHACAPS:
                return generateCode(codeSize, ALPHA_CAPS_CHARACTERS);
            case ALPHANUMERIC:
                return generateCode(codeSize, ALPHA_NUMERIC_CHARACTERS);
            case ALPHANUMERIC_CAPS:
                return generateCode(codeSize, ALPHA_NUMERIC_CAPS_CHARACTERS);
            case NUMERIC:
                return generateCode(codeSize, NUMERIC_CHARACTERS);
            default:
                return generateCode(codeSize, ALPHA_CAPS_CHARACTERS);
        }
    }

    public static String createSecret() {

    }

    private static String generateCode(int codeSize, char[] characters) {
        StringBuilder code = new StringBuilder();
        for (int i=0; i < codeSize; i++) {
            code.append(characters[ThreadLocalRandom.current().nextInt(0, characters.length)]);
        }
        return code.toString();
    }
}

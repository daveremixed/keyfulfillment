package com.gonzobeans.keyfulfillment.util;

import com.gonzobeans.keyfulfillment.entity.CodeType;
import org.junit.Assert;
import org.junit.Test;

/**
 * Created by Dave on 5/28/2017.
 */
public class CodeGeneratorTest {
    @Test
    public void getCode() {
        String myCode = CodeGenerator.getCode(CodeType.ALPHACAPS,7);
        System.out.println(myCode);
        Assert.assertEquals(7, myCode.length());
    }

}

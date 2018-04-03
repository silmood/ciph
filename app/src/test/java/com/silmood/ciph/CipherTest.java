package com.silmood.ciph;

import org.junit.Test;

import static junit.framework.Assert.assertEquals;

public class CipherTest {

    @Test
    public void cipherRot13() {
        String message = "Hello World";

        Cipher ciph = new Cipher();
        String result = ciph.rot13("Hello World");

        assertEquals(result, "Uryyb Jbeyq");
    }
}

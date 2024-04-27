package com.hcl.hackton.helper;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static com.hcl.hackton.helper.Helper.translateFiledName;
import static org.junit.jupiter.api.Assertions.*;

class HelperTest {


    @Test
    @DisplayName("should translate success")
    void shouldTranslateSuccess() {

        assertNull(translateFiledName("SomeTxt"));
        assertEquals("customer_id",translateFiledName("customerId"));
        assertEquals("transcation_ref",translateFiledName("transcationRef"));
    }
}
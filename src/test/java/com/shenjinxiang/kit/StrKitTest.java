package com.shenjinxiang.kit;

import junit.framework.Assert;
import org.junit.Test;

public class StrKitTest {

    @Test
    public void isBlank() {
        Assert.assertTrue(StrKit.isBlank(""));
        Assert.assertTrue(StrKit.isBlank(null));
        Assert.assertFalse(StrKit.isBlank(" shenjinxiang "));
        Assert.assertFalse(StrKit.isBlank("shenjinxiang"));
        Assert.assertFalse(StrKit.isBlank(" "));
    }
}

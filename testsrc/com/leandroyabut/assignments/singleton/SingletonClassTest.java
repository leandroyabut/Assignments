package com.leandroyabut.assignments.singleton;

import org.junit.Assert;
import org.junit.Test;

public class SingletonClassTest {

    @Test
    public void singletonClassTest() {
        Assert.assertNotEquals(null, SingletonClass.getInstance());
    }

}

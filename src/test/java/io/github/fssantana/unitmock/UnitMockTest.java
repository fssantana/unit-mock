package io.github.fssantana.unitmock;

import org.junit.Test;

import java.time.LocalDate;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

public class UnitMockTest {

    @Test
    public void shouldBuildLocalDate(){
        LocalDate localDate = UnitMock.localDate();
        assertEquals(LocalDate.class, localDate.getClass());
        assertNotNull(localDate);
    }

}
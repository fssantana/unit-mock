package io.github.fssantana.unitmock;

import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class UnitMockIntegerSequenceTest {

    @Test
    public void shouldBuildStartingWithZeroAndIncrementByTwoThreeTimes(){
        UnitMockIntegerSequence sequence = UnitMockIntegerSequence
                .init()
                .startWith(0)
                .incrementStep(2)
                .build();

        Integer firstId = sequence.next();
        Integer secondId = sequence.next();
        Integer thirdId = sequence.next();

        assertEquals(0, firstId.intValue());
        assertEquals(2, secondId.intValue());
        assertEquals(4, thirdId.intValue());
    }

    @Test
    public void shouldBuildStartingWithTenAndIncrementByThreeFourTimes(){
        UnitMockIntegerSequence sequence = UnitMockIntegerSequence
                .init()
                .startWith(10)
                .incrementStep(3)
                .build();

        Integer firstId = sequence.next();
        Integer secondId = sequence.next();
        Integer thirdId = sequence.next();
        Integer lastId = sequence.next();

        assertEquals(10, firstId.intValue());
        assertEquals(13, secondId.intValue());
        assertEquals(16, thirdId.intValue());
        assertEquals(19, lastId.intValue());
    }

    @Test
    public void shouldBuildStartingWithMinusThreeAndIncrementByOneFourTimes(){
        UnitMockIntegerSequence sequence = UnitMockIntegerSequence
                .init()
                .startWith(-3)
                .incrementStep(1)
                .build();

        Integer firstId = sequence.next();
        Integer secondId = sequence.next();
        Integer thirdId = sequence.next();
        Integer lastId = sequence.next();

        assertEquals(-3, firstId.intValue());
        assertEquals(-2, secondId.intValue());
        assertEquals(-1, thirdId.intValue());
        assertEquals(0, lastId.intValue());
    }

}
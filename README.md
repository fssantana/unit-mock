## Unit Mock
---
[![Build Status](https://travis-ci.org/fssantana/unit-mock.svg?branch=master)](https://travis-ci.org/fssantana/unit-mock)

Set of tools to help build mocks for unit testing purpose.

### Usage
* Use methods in UnitMock class to create simple mocks:
```java
public class TestExample {

    @Test
    public void testLocalDate(){
        LocalDate localDate = UnitMock.localDate();
    }
    
    @Test
    public void testLocalDateTime(){
        LocalDate localDate = UnitMock.localDateTime();
    }
}

```

* You can build an filled instance like this:
```java
public class TestExample {

    @Test
    public void test(){
        MyClass myInstance = UnitMock.buildFor(MyClass.class);
    }
    
    /**
    * This will fill all subclasses with 10 depth 
    */
    @Test
    public void testInDepth(){
        MyClass myInstance = UnitMock.buildFor(MyClass.class, 10);
    }
    
}
```

* You can mock incremental integer (like a relational database)
```java
public class TestExample {
    
    @Test
    public void integerSequenceTest(){
    UnitMockIntegerSequence sequence = UnitMockIntegerSequence
                    .init()
                    .startWith(0)
                    .incrementStep(2)
                    .build();
    
            Integer firstId = sequence.next();   //0
            Integer secondId = sequence.next();  //2
            Integer thirdId = sequence.next();   //4
    }
}
```
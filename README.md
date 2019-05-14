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
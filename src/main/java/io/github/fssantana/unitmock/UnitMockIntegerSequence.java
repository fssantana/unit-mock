package io.github.fssantana.unitmock;

public class UnitMockIntegerSequence {

    private Integer current;
    private Integer incrementStep;
    private Boolean first;

    private UnitMockIntegerSequence(){}

    public static UnitMockIntegerSequenceBuilder init(){
        return new UnitMockIntegerSequenceBuilder();
    }

    private void setFirst(Boolean first) {
        this.first = first;
    }

    private void setCurrent(Integer current) {
        this.current = current;
    }

    private void setIncrementStep(Integer incrementStep) {
        this.incrementStep = incrementStep;
    }

    private Integer getCurrent() {
        return current;
    }

    public Integer getIncrementStep() {
        return incrementStep;
    }

    public Integer next() {
        if(first){
            first = Boolean.FALSE;
            return current;
        }
        this.current += incrementStep;
        return this.current;
    }

    public Integer current(){
        return current;
    }

    public static class UnitMockIntegerSequenceBuilder{

        private UnitMockIntegerSequence integerSequence;

        private UnitMockIntegerSequenceBuilder(){
            UnitMockIntegerSequence integerSequence = new UnitMockIntegerSequence();

            integerSequence.setFirst(Boolean.TRUE);
            integerSequence.setCurrent(0);
            integerSequence.setIncrementStep(1);

            this.integerSequence = integerSequence;
        }

        public UnitMockIntegerSequenceBuilder incrementStep(int incrementStep){
            integerSequence.setIncrementStep(incrementStep);
            return this;
        }

        public UnitMockIntegerSequenceBuilder startWith(int firstInteger){
            integerSequence.setCurrent(firstInteger);
            return this;
        }

        public UnitMockIntegerSequence build(){
            return integerSequence;
        }
    }

}

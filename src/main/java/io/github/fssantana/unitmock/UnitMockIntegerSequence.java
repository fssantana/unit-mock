package io.github.fssantana.unitmock;

/**
 * @author fsantana
 * @since 0.1.0
 *
 * Class that contains methods to mock an incremental Integer
 *
 *
 */
public class UnitMockIntegerSequence {

    private Integer current;
    private Integer incrementStep;
    private Boolean first;

    private UnitMockIntegerSequence(){}

    /**
     * Create an Integer Sequence builder
     *
     * @return
     */
    public static UnitMockIntegerSequenceBuilder init(){
        return new UnitMockIntegerSequenceBuilder();
    }

    /**
     * Flag first time that increment is called. This must be initiated as True
     * @param first
     */
    private void setFirst(Boolean first) {
        this.first = first;
    }

    /**
     * Current integer
     * @param current
     */
    private void setCurrent(Integer current) {
        this.current = current;
    }

    /**
     * Incremental step to sum
     *
     * @param incrementStep
     */
    private void setIncrementStep(Integer incrementStep) {
        this.incrementStep = incrementStep;
    }

    /**
     * Current number
     *
     * @return
     */
    private Integer getCurrent() {
        return current;
    }

    /**
     *
     * @return
     */
    public Integer getIncrementStep() {
        return incrementStep;
    }

    /**
     * Get next incremented integer
     *
     * @return
     */
    public Integer next() {
        if(first){
            first = Boolean.FALSE;
            return current;
        }
        this.current += incrementStep;
        return this.current;
    }

    /**
     * Get current integer
     * @return
     */
    public Integer current(){
        return current;
    }

    /**
     * @author fsantana
     * @since 0.1.0
     *
     * Class used to build an UnitMockIntegerSequence instance
     *
     */
    public static class UnitMockIntegerSequenceBuilder{

        private UnitMockIntegerSequence integerSequence;

        /**
         * Constructor <br>
         * Build an UnitMockIntegerSequence with current as zero and increment step as 1
         *
         */
        private UnitMockIntegerSequenceBuilder(){
            UnitMockIntegerSequence integerSequence = new UnitMockIntegerSequence();

            integerSequence.setFirst(Boolean.TRUE);
            integerSequence.setCurrent(0);
            integerSequence.setIncrementStep(1);

            this.integerSequence = integerSequence;
        }

        /**
         * Set increment steps
         *
         * @param incrementStep
         * @return
         */
        public UnitMockIntegerSequenceBuilder incrementStep(int incrementStep){
            integerSequence.setIncrementStep(incrementStep);
            return this;
        }

        /**
         * Set first integer
         *
         * @param firstInteger
         * @return
         */
        public UnitMockIntegerSequenceBuilder startWith(int firstInteger){
            integerSequence.setCurrent(firstInteger);
            return this;
        }

        /**
         * Build and return UnitMockIntegerSequence
         * @return
         */
        public UnitMockIntegerSequence build(){
            return integerSequence;
        }
    }

}

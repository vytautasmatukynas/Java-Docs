/**
 * This Java code defines an outer class called 'OuterClass' and an inner class called 'InnerClass'.
 * The outer class has a private integer field 'outerField', and the inner class contains a method
 * 'doSomething' that prints the value of 'outerField'. Inner classes can access the private members
 * of the outer class. This code demonstrates the concept of inner classes in Java.
 */
class OuterClass {
    private int outerField;

    class InnerClass {
        void doSomething() {
            System.out.println("InnerClass: " + outerField);
        }
    }
}


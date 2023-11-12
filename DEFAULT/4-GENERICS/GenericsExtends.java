

/*
 'extends' keyword is used to specify an UPPER BOUND for a type parameter. When you use 'extends' in
 the declaration of a generic type, you are essentially saying that the type parameter should be
 a subtype of the specified class or interface. This means that the type parameter can be the specified
 class or any of its subclasses.
 */
public class GenericsExtends {
    public static void main(String[] args) {
        // Create an instance of SampleGenericClass with Integer as the type argument.
        SampleGenericClass<Integer> integerInstance = new SampleGenericClass<>(42);
        integerInstance.displayValue();

        // Create another instance with Double as the type argument.
        SampleGenericClass<Double> doubleInstance = new SampleGenericClass<>(3.14);
        doubleInstance.displayValue();

        // Attempting to create an instance with String as the type argument (compilation error).
        // SampleGenericClass<String> stringInstance = new SampleGenericClass<>("Hello, World!");
    }
}

/*
The type parameter T is restricted to types that are either of type Number or its subtypes.
In other words, T can only be a numeric type:
    Integer
    Double
    Float
    Long
    Short
    Byte
 */

// Define a generic class called SampleGenericClass with a type parameter T.
// Can only be used 'double', 'integer', 'float',
class SampleGenericClass<T extends Number> {
    // Declare a private field of type T to hold the value.
    private T value;

    // Constructor for initializing the value with a parameter of type T.
    public SampleGenericClass(T value) {
        this.value = value;
    }

    // A method to retrieve the stored value.
    public T getValue() {
        return value;
    }

    // A method to display the value to the console.
    public void displayValue() {
        System.out.println("Value: " + value);
    }
}



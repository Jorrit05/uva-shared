# Writing assignment 3, Java

|   |   |
|---|---|
| Authors:| Rein Spanjer, Bob Schijf,  Jorrit Stutterheim |
| Group number:| 10 |
| Student ID Jorrit Stutterheim |  13957899 |
| Student ID Rein Spanjer | 13558307 |
| Student ID Bob Schijf | 14076357 |
| Study: | Premaster software engineering |
| Course: | Programmeertalen |


## Table of Contents

[1. Primitive types and reference types](#primitive-types-and-reference-types) </br>
[2. Classes and inheritance](#classes-and-inheritance) </br>
[3. Additional bonus questions](#additional-bonus-questions) </br>
[4. References](#references) </br>

## Primitive types and reference types

__Q1 For every primitive type there is a reference type counterpart. Name at least 3 primitive types and their reference type counterpart.__

| primitive |  Reference |
|---|---|
| boolean  | java.lang.Boolean  |
| int  | java.lang.Integer  | 
|  long |  java.lang.Long | 

__Q2 The boxing conversion converts the value of a primitive type to an object of the corresponding reference type. Give a code example on which the Java compiler performs this conversion automatically and explain why this conversion is helpful to the programmer in this example.__

```java
Boolean bool = true;
```

The reference types contains more then only the value. It contains functions that can be used like ```equals```.

```java
boolean boolFalse = false;
Boolean boolTrue = true;

boolTrue.equals(boolFalse); // Will return false
```

```boolFalse.equals``` is not possible because it is a primitive type and it doesn't contain the function ```equals```.


It is also helpful because it is less verbose. If this is not possible
```java
Boolean bool = true;
```

you would have to write it like this:
```java
Boolean bool = Boolean.TRUE;
```

and when using other objects.

```java
boolean boolFalse = false;
Boolean bool = boolFalse;
```
you dont have to do it like the following:

```java
boolean boolFalse = false;
Boolean bool = (Boolean) boolFalse;
```

__Q3 Given that primitive types have a reference type counterpart, one might argue that the primitive types are redundant. Provide at least one argument motivating the existence of primitive types in Java and at least one argument against their existence.__

Primitives are way more performant. Because primitives aren't objects and when they are used a lot then it can save a lot of memory and performance. 

```java
true == true;
Boolean.TRUE.equals(Boolean.FALSE);
```

__Q4 Which parameter-passing strategy does Java apply? Explain your answer.__

__Q5 What is the difference between the following two valid Java expressions in which s1 and s2 are both of type String.__

```JAVA
s1 == s2
s1.equals(s2)
```

__Q6 In your own words, explain the difference between == and .equals() for all types.__

__Q7 Reflect on the previous questions and discuss for each whether it is about syntactic, semantic or pragmatic aspects of the language.__

__Q8 In your own words, explain the concept of definite assignment. Why is it useful and why is it not perfect? Make a comparison with C and/or C++. How does definite assignment relate to the final keyword?__

## Classes and inheritance

__Q9  If a language supports multiple inheritance, a class can inherit methods and variables from multiple parent classes. However, if multiple parents define the same method, this causes ambiguity in determining which of the versions of the method is actually inherited. Does Java support multiple inheritance? If so, how is the problem of ambiguity resolved or addressed? Explain your answer__

Java does not support multiple inheritance.<sup>1</sup> However, a class can implement one or more interfaces, which has helped Java get rid of the impossibility of multiple inheritance<sup>1</sup>.

Classes can then implement these interfaces and have to make a custom implementation for the functions of the interface, example<sup>1</sup>:

```JAVA
public interface Hockey extends Sports, Event

interface Event {
   public void start();
}
interface Sports {
   public void play();
}
interface Hockey extends Sports, Event{
   public void show();
}
public class Tester{
   public static void main(String[] args){
      Hockey hockey = new Hockey() {
         public void start() {
            System.out.println("Start Event");
         }
         public void play() {
            System.out.println("Play Sports.");
         }
         public void show() {
            System.out.println("Show Hockey.");
         }
      };

      hockey.start();
      hockey.play();
      hockey.show();
   }
}
```

__Q10  What is the difference between a method declared with the static keyword and one without the static keyword within the same class? Refer in your answer to instance variables and explicitly address both syntactic, semantic and pragmatic differences.__

A static method (or member variable) is class method that is the same in every instantiation of the class. Thus, a static method can only interact with static members of the class.

An advantages of a static method is that it is bound during compilation, and can be optimized during compilation, so it is more efficient and uses less memory. A danger is here that if a static member variable is changed in one object, it will be changed in all existing objects of this class, which is fine as long is that is intended behavior.


__Q11 In Java it is possible to define classes within classes (i.e. to nest class definitions). Such classes are referred to as inner classes. What kinds of inner classes exist? Explain why inner classes can be useful__

__Q12  In your own words, explain the overloading concept in Java.__

__Q13  In your own words, explain the overriding concept in Java. How does it relate to the final keyword?__

## Additional bonus questions

__Q14  Write the shortest syntactically valid Java program you can come up with that sends something to the standard output.__

__Q15  Write the shortest syntactically valid Java program you can come up with.__

__Q16  Enum declarations simplify working with types of enumerable values. Enum declarations intro- duce normal classes (and are in that sense redundant) but add certain conveniences to the programmer. What functionality is generated by the Java compiler for Enum declarations? How do Enum declarations simplify working with enumerable types for the programmer?__

## References

1 https://www.tutorialspoint.com/java-and-multiple-inheritance
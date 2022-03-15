package com.playground;

/**
 * Hello world!
 *
 */
public class App 
{
    public static void main( String[] args )
    {
        System.out.println( "Hello World!" );
        boolean boolFalse = false;
        Boolean boolTrue = true;
        
        System.out.println(boolTrue.equals(boolFalse));
        Boolean parsed = (Boolean) boolFalse;
        System.out.println(parsed);
    }
}

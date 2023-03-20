package org.example;

/**
 * Hello world!
 *
 */
public class App 
{
    public static void main( String[] args )
    {
        String string = "004-034556";
        String[] parts = string.split("(-)");
        String part1 = parts[0];
        String part2 = parts[1];
        System.out.println(part1);
//        double value  = Double.parseDouble(part2);
//        System.out.println(value);
    }
}

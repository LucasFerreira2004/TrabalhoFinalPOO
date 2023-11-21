package view;

import java.util.Scanner;

public abstract class ViewModel {
    public abstract void show(control.Data data);

    protected static Scanner scanner = new Scanner(System.in);
    protected static String  input()                { return scanner.nextLine();        }
    protected static double  toDouble(String value)   { return Double.parseDouble(value); }
    protected static int  toInt(String value)   { return Integer.parseInt(value); }
    protected static void    println(Object value)  { System.out.println(value);        }
    protected static void    print(Object value)    { System.out.print(value);          }
}

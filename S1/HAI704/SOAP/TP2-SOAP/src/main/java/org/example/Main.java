package org.example;

// Press Shift twice to open the Search Everywhere dialog and type `show whitespaces`,
// then press Enter. You can now see whitespace characters in your code.
import org.tempuri.Add;
import org.tempuri.Calculator;
import org.tempuri.CalculatorSoap;

import java.net.MalformedURLException;
import java.net.URL;

public class Main {

     public static void main(String[] args) {
        try {
            URL url = new URL("http://www.dneonline.com/calculator.asmx?WSDL");
            Calculator serviceImpl = new Calculator(url);
            CalculatorSoap proxy = serviceImpl.getCalculatorSoap();

            int a = 2;
            int b = 4;
            System.out.println("________Utilisation de API SOAP (Client)________");
            System.out.println(a + " + " + b + " = " + proxy.add(a, b));
            System.out.println(a + "-" + b + " = " + proxy.subtract(a, b));
            System.out.println(a + " * " + b + " = " + proxy.multiply(a, b));
            System.out.println(a + " / " + b + " = " + proxy.divide(a, b));
            System.out.println("______________________FIN_______________________");
        } catch (MalformedURLException e) {
            System.out.println(e);
        }

    }

}
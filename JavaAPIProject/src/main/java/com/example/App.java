package com.example;
import javax.swing.JFrame;
public class App 
{
    
    public static void main( String[] args )
    {
        gImage img1 = new gImage("https://serpapi.com/search.json?q=Apple&engine=google_images&ijn=0");
        System.err.println(img1);
    }
}

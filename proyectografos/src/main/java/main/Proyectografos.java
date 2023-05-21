/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */

package main;

import app.LoadText;
import primitivas.List;
/**
 *
 * @author DELL
 */
public class Proyectografos {

    public static void main(String[] args) {
        List grath = new List();
//      System.out.println("Hello World!");
        LoadText loadtext = new LoadText();
        grath = loadtext.loadText();
        loadtext.writeTxt(grath);
    }
}

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package app;
import java.io.File;
import java.io.FileWriter;
import java.io.PrintWriter;

import java.io.FileNotFoundException;
import java.util.Scanner;
import javax.swing.JFileChooser;
//import javax.swing.filechooser.FileFilter;

import primitivas.User;
import primitivas.List;
import primitivas.Nodo;
import primitivas.Bridge;
import primitivas.Graph;
/**
 *
 * @author DELL
 */
public class LoadText {
    private String ruta;
    public LoadText() {
    }
    public List loadText(){
        List<User> Vertex = new List();
        List<Bridge> Bridges = new List();
        
        Scanner entrada = null;
        JFileChooser fileChooser = new JFileChooser();
//        fileChooser.showOpenDialog(fileChooser);
        
        int valor = fileChooser.showOpenDialog(fileChooser);
        if (valor == JFileChooser.APPROVE_OPTION) {
            ruta = fileChooser.getSelectedFile().getAbsolutePath();
            System.out.println(ruta);
            String[] confirmation = ruta.split("\\.");
//            System.out.println(confirmation[0]);
//            System.out.println(confirmation[1]);
            System.out.println(confirmation.length);
            if("txt".equals(confirmation[confirmation.length-1].replace(" ", ""))){
                    try {
                        File f = new File(ruta);
                        entrada = new Scanner(f);
                        while (entrada.hasNext()) {
                            String[] parts = entrada.nextLine().replace(" ", "").split(",");
                            if(parts.length == 2){
                                User newuser = new User(parts[0],parts[1]);
        //                        Nodo<User> pNew = new Nodo(newuser);
                                Vertex.appendLast(newuser);
                            }else if(parts.length == 3){
                                Bridge newbridge = new Bridge(parts[0],parts[1],parts[2]);
                                Bridge newbridge2 = new Bridge(parts[1],parts[0],parts[2]);
        //                        Nodo<Bridge> pNew = new Nodo(newbridge);
                                Bridges.appendLast(newbridge);
                                Bridges.appendLast(newbridge2);

                                }
        //                    System.out.println(entrada.nextLine());
                        }
                    } catch (FileNotFoundException e) {
                        System.out.println(e.getMessage());
                    } finally {
                        if (entrada != null) {
                            entrada.close();
                        }
                    }
                } else {
                    System.out.println("No se ha seleccionado ningún archivo txt");
                }
            }
        else{
            
        }
       
        return appendBridges(Vertex, Bridges);
         
    }
    public List createList(List bridges, String id1){
        List <Bridge> output  = new List();
        if(bridges.isEmpty()){
            Nodo <Bridge> pAux = bridges.getHead();
            while(pAux != null){
                if(pAux.getValue().getId1().equals(id1)){
                    output.appendLast(pAux.getValue());
                }
                pAux = pAux.getpNext();
            }
        }
            
        return output;
    } 
    public List appendBridges(List vertexs, List bridges){
        List <User> output;
        if(vertexs.isEmpty()){
            Nodo <User> pAux = vertexs.getHead();
            while(pAux != null){
                pAux.getValue().setList(createList(bridges, pAux.getValue().getId()));
//                    output.appendLast(pAux.getValue());
                pAux = pAux.getpNext();
            }
        }
        output = vertexs;
        return output;
    }
    public void writeTxt(Graph mygraph){
        if(mygraph != null){
            FileWriter fichero = null;
            PrintWriter pw = null;
            List<String> myliststring = this.createListString(mygraph.getList());
            Nodo<String> pAux;
            try
            {
                fichero = new FileWriter(ruta);
                pw = new PrintWriter(fichero);
                if(myliststring.isEmpty()){
                    pAux = myliststring.getHead();
                    while(pAux != null){
                        pw.println(pAux.getValue());
                        pAux = pAux.getpNext();
                    }
                }
            } catch (Exception e) {
                e.printStackTrace();
            } finally {
               try {
               // Nuevamente aprovechamos el finally para 
               // asegurarnos que se cierra el fichero.
               if (null != fichero)
                  fichero.close();
               } catch (Exception e2) {
                  e2.printStackTrace();
               }
            }
        }
    }
    public List createListString(List mylist){
        List<String> output = new List();
        List<Bridge> listaux = new List();
        Nodo<User> pAux;
        Nodo<Bridge> pAux2;
        output.appendLast("Usuarios");
        if(mylist.isEmpty()){
             pAux = mylist.getHead();
            while(pAux!= null){
                output.appendLast(pAux.getValue().getId()+ ", " + pAux.getValue().getUsername());
                pAux = pAux.getpNext();
            }
            output.appendLast("Relaciones");
            pAux = mylist.getHead();
            while(pAux!= null){
                if(pAux.getValue().getList().isEmpty()){
                    pAux2 = pAux.getValue().getList().getHead();
                    while(pAux2 != null){
                        if(this.searchNodo(listaux,pAux2.getValue()) ){
                            output.appendLast(pAux2.getValue().getId1()+ ", " + pAux2.getValue().getId2() + ", " + pAux2.getValue().getYears());
                            listaux.appendLast(pAux2.getValue());
                            
                        }
                        pAux2 = pAux2.getpNext();
                    }     
                }
                pAux = pAux.getpNext();
            }
        }
       return output; 
    }
    public boolean searchNodo(List<Bridge> mylist, Bridge pSearch){
      Nodo<Bridge> temp = mylist.getHead();
      while(temp != null){
          if(pSearch.getId1().equals(temp.getValue().getId2()) && pSearch.getId2().equals(temp.getValue().getId1())){
              return false;
          }
          temp = temp.getpNext();
      }
      return true;
}
}

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package app;
//import primitivas.List;
//import primitivas.Nodo;
import primitivas.*;
/**
 *
 * @author DELL
 */
public class BFS {

    public BFS() {
    }
    public List callBFS(Graph mygraph, Nodo<User> base){
        List list = new List();
        List list_o = new List();
        while(!mygraph.isVisited()){
            list = new List();
            this.BFS(mygraph,base,list);
            list_o.appendLast(list.showAttribute());
            base = mygraph.searchNotVisited();
            System.out.println(!mygraph.isVisited());
        }
        mygraph.setFalse();
        return list_o;
    }
    
    public void BFS(Graph mygraph, Nodo<User> base, List list_o){
        if(base != null){
            if(!base.getValue().isVisited()){
                Nodo<Bridge> temp2 = base.getValue().getList().getHead();
                Nodo<User> temp;
                base.getValue().setVisited(true);
                while(temp2 != null){
                    temp = mygraph.searchNodo(temp2.getValue().getId2());
                    System.out.println(temp.getValue().getId());
                    BFS(mygraph,temp,list_o);
                    temp2 = temp2.getpNext();
                }
                    list_o.appendFirst(base.getValue().getId());
            }
        }
        
//        return list _o;
    }
    
    public String stringBFS(List<List> mylist){
        String newline1 = System.lineSeparator();
        String output = "Cantidad de islas: " + mylist.getSize() + newline1;
        Nodo<String> temp = mylist.getHead();
        int count = 1;
        while(temp != null){
            output += "Isla "+ count + " :" + temp.getValue() + newline1;
            count++;
            temp = temp.getpNext();
        }
        return output;
    }
}

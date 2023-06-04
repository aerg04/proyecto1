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
            this.BFS(mygraph,base,list);
            list_o.appendLast(list.showAttribute());
            base = mygraph.searchNotVisited();
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
                    BFS(mygraph,temp,list_o);
                    temp2 = temp2.getpNext();
                }
                    list_o.appendFirst(base);
            }
        }
//        return list _o;
    }
}

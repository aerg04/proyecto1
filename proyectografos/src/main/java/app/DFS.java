/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package app;
import javax.swing.JOptionPane;
import primitivas.*;


/**
 *
 * @author DELL
 */
public class DFS {
    public DFS(){
    }
    public List searchDFS(Graph mygraph,Nodo<User> base){
        List list_o = new List();
        while(!mygraph.isVisited()){
            list_o.appendLast(this.DFS(mygraph,base).showAttribute());
            base = mygraph.searchNotVisited();
        }
        mygraph.setFalse();
        return list_o;
    }
            
    public List DFS(Graph mygraph,Nodo<User> base){
        List<String> list_o = new List();
        List<User> list = new List();
        Nodo<User> temp,temp3;
        Nodo<Bridge> temp2;
        
        list_o.appendLast(base.getValue().getId());
        list.appendLast(base.getValue());
        base.getValue().setVisited(true);
            while(list.isEmpty()){
                temp = list_o.getHead();
                list_o.delete(temp);
                temp2 = temp.getValue().getList().getHead();
                while(temp2 != null){
                    temp3 = mygraph.searchNodo(temp2.getValue().getId2());
                    if(temp3.getValue().isVisited()){
                        list.appendLast(temp3);
                        list_o.appendLast(temp3.getValue().getId());
                        
                        }
                        temp2 = temp2.getpNext();
                }
        }
            return list_o;
    }
}

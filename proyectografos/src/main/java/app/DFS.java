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
                temp = list.getHead();
                list.delete(temp);
//                list_o.appendLast(temp.getValue().getId());
                
                temp2 = temp.getValue().getList().getHead();
                while(temp2 != null){
                    temp3 = mygraph.searchNodo(temp2.getValue().getId2());
                    if(!temp3.getValue().isVisited()){
                        temp3.getValue().setVisited(true);
                        list.appendLast(temp3.getValue());
                        list_o.appendLast(temp3.getValue().getId());
                        
                        }
                        temp2 = temp2.getpNext();
                    }
            }
            return list_o;
    }
    public String stringDFS(List<String> mylist){
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
    public List searchBridgeF(Graph graph){
        List output = new List ();
        Graph mygraph = this.copyGraph(graph);
        List bridges = new List();
        Nodo<User> temp = mygraph.getList().getHead();
        Nodo<User> temp3;
//        Nodo <>
        Nodo<Bridge> temp2, temp4, temp5;
        int count = this.searchDFS(mygraph, temp).getSize();
        while(temp != null){
                temp2 = temp.getValue().getList().getHead();
                    for (int i = 0; i < temp.getValue().getList().getSize(); i++) {
                        if(this.searchNodoBridge(bridges, temp2.getValue())){
                            temp3 = mygraph.searchNodo(temp2.getValue().getId2());
    //                        System.out.println(temp3);
                            temp4 = mygraph.searchBridge(temp3, temp.getValue().getId());
                            System.out.println(temp.getValue().getId() + temp3.getValue().getId());
                            mygraph.deleteBridge(temp2, temp4);
                            System.out.println(mygraph.showAttributes());
    //                        System.out.println(temp.getValue().getId());
    //                        System.out.println(this.searchDFS(mygraph, temp).showAttribute());
//                              System.out.println(this.searchDFS(mygraph, mygraph.getList().getHead()).showAttribute());
                                if(count<this.searchDFS(mygraph, mygraph.getList().getHead()).getSize()){
                                    output.appendLast(temp2.getValue().getId1() + "-"+ temp2.getValue().getId2());
                                    bridges.appendLast(temp2.getValue());
                                    }
                            mygraph.insertBridge(temp2.getValue(), temp4.getValue());
                            }

                        temp2 = temp.getValue().getList().getHead();
                        System.out.println(temp2 != null);
                        }
                    
                temp = temp.getpNext();
            }
        return output;
    }
    
    public boolean searchNodoBridge(List<Bridge> mylist, Bridge pSearch){
      Nodo<Bridge> temp = mylist.getHead();
      while(temp != null){
          if(pSearch.getId1().equals(temp.getValue().getId2()) && pSearch.getId2().equals(temp.getValue().getId1())){
              return false;
          }
          temp = temp.getpNext();
      }
      return true;
}
public Graph copyGraph(Graph ograph){
        Graph output = new Graph (new List<User>());
//        String newline1 = System.lineSeparator();
        List <Bridge> bridges ;
        Nodo <User> pAux = ograph.getList().getHead();
        Nodo <User> pAuxc;
        Nodo <Bridge> pAux2;
//        User copyuser = 
        while(pAux != null){
            output.getList().appendLast(new User(pAux.getValue().getId(),pAux.getValue().getUsername()));
            pAux = pAux.getpNext();
        }
        pAux = ograph.getList().getHead();
        pAuxc = output.getList().getHead();
        while(pAux != null){
            bridges = new List();
            if(pAux.getValue().getList() != null){
                pAux2 = pAux.getValue().getList().getHead();
                while(pAux2 != null){
                    bridges.appendLast(new Bridge(pAux2.getValue().getId1(),pAux2.getValue().getId2(), pAux2.getValue().getYears()));
                    
                    pAux2 = pAux2.getpNext();
                    }
                }
            pAuxc.getValue().setList(bridges);
            pAux = pAux.getpNext();
            pAuxc = pAuxc.getpNext();
        }
        return output;
    }


}

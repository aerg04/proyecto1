/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package primitivas;
import primitivas.*;
/**
 *
 * @author DELL
 */
public class Graph {
    List<User> list;
            
    public Graph(List<User> list) {
        this.list = list;
        
    }

    public List<User> getList() {
        return list;
    }
//  Eliminar
    public void deleteUser(Nodo<User> pDelete){
        Nodo <User> pAux = list.getHead();
        Nodo <Bridge> pAux2;
        
        list.delete(pDelete);
        
        while(pAux != null){
            pAux2 = pAux.getValue().getList().getHead();
            while(pAux2 != null){
                if(pAux2.getValue().getId2().equals(pDelete.getValue().getId())){
                    pAux.getValue().getList().delete(pAux2);
                }
                pAux2 = pAux2.getpNext();
            }
            pAux = pAux.getpNext();
        }
    }
    public void deleteBridge(Nodo <User> pUser, Nodo<Bridge> pBridge){
//        se debe elimar la conexion en los 2 nodos
        pUser.getValue().getList().delete(pBridge);
        Nodo<User> temp = list.getHead();
        if(pBridge != null){
            while(temp != null){
                    if(temp.getValue().getId().equals(pBridge.getValue().getId2())){
                        temp.getValue().getList().delete(this.searchBridge(temp, pBridge.getValue().getId1()));
                    }   
                }
                temp = temp.getpNext();
            }
    }
//
//  Añadir
    public void insertBridge(Bridge pNew, Bridge pNew2){
        Nodo<User> temp = list.getHead();
        while(temp != null){
            if(pNew.equals(temp.getValue().getId())){
               temp.getValue().getList().appendLast(pNew);
            }else if(pNew2.getId1().equals(temp.getValue().getId())){
               temp.getValue().getList().appendLast(pNew2);
            }
            temp = temp.getpNext();
            }
    }
    public void insertUser(Nodo<User> pNew){
        list.appendLast(pNew);
        
    }
    public Nodo searchBridge(Nodo<User> pUser, String pBridge ){
           Nodo<Bridge> temp = pUser.getValue().getList().getHead();
           while(temp != null){
                if(temp.getValue().getId2().equals(pBridge)){
                    return temp;
                }
                temp = temp.getpNext();
                }
           return null;
    }
    
    public Nodo searchNodo( String id){
        Nodo<User> temp = list.getHead();
        while(temp != null){
            if(temp.getValue().getId().equals(id)){
                return temp;
            }
            temp = temp.getpNext();
            }
        return null;    
    }
    public Nodo searchNotVisited(){
        Nodo<User> temp = list.getHead();
        while(temp != null){
            if(!temp.getValue().isVisited()){
                return temp;
            }
            temp = temp.getpNext();
            }
        return null;
    }
    
    
    public void setFalse(){
        Nodo<User> temp = list.getHead();
        while(temp != null){
            temp.getValue().setVisited(false);
            temp = temp.getpNext();
            }
        
    }
    public boolean isVisited(){
        Nodo<User> temp = list.getHead();
        while(temp != null){
            if(temp.getValue().isVisited() != true)
                return false;
            temp = temp.getpNext();
            }
        
            return true;
    }
    public String showAttributes(){
        String output = "";
        Nodo <User> pAux = list.getHead();
        Nodo <Bridge> pAux2;
        String newline1 = System.lineSeparator();
        while(pAux != null){
            output += "[" + pAux.getValue().getId() + ", " + pAux.getValue().getUsername() + "] -> [";
            pAux2 = pAux.getValue().getList().getHead();
            while(pAux2 != null){
                output += "(" + pAux2.getValue().getId2() + ", "+  pAux2.getValue().getYears() + "),";
                pAux2 = pAux2.getpNext();
            }
            output += "]" + newline1 ;
            pAux = pAux.getpNext();
        }
        return output;
    }
   

}

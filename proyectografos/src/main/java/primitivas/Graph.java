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
            if(pAux.getValue().getList() != null){
                pAux2 = pAux.getValue().getList().getHead();
                while(pAux2 != null){
//                    System.out.println(pAux2.getValue().getId2() + pDelete.getValue().getId());
                    if(pAux2.getValue().getId2().equals(pDelete.getValue().getId())){
                        pAux.getValue().getList().delete(pAux2);
//                        System.out.println("pene");
                    }
                    
                    pAux2 = pAux2.getpNext();
                }
                
            }
            pAux = pAux.getpNext();
        }
    }
    public void deleteBridge(Nodo<Bridge> pBridge, Nodo<Bridge> pBridge2){
//        se debe elimar la conexion en los 2 nodos
        Nodo<User> temp = this.searchNodo(pBridge.getValue().getId1());
        Nodo<User> temp2 = this.searchNodo(pBridge2.getValue().getId1());
        
//        System.out.println(temp2.getValue().getId());
        temp.getValue().getList().delete(pBridge);
        temp2.getValue().getList().delete(pBridge2);
        
        System.out.println(temp.getValue().getList().showAttribute());
        System.out.println(temp2.getValue().getList().showAttribute());
//        temp2.getValue().getList().showAttribute();
    }
//
//  Añadir
    public void insertBridge(Bridge pNew, Bridge pNew2){
        
        Nodo<User> temp = this.searchNodo(pNew.getId1());
        Nodo<User> temp2 = this.searchNodo(pNew2.getId1());
        
      
        temp.getValue().getList().appendLast(pNew);

        temp2.getValue().getList().appendLast(pNew2);
        
    }
    public void insertUser(Nodo<User> pNew){
        list.appendLast(pNew);
        
    }
    public Nodo searchBridge(Nodo<User> pUser, String Bridge ){
        if(pUser.getValue().getList() != null){
           Nodo<Bridge> temp = pUser.getValue().getList().getHead();
           while(temp != null){
//               System.out.println(temp.getValue().getId2() + " " + Bridge);
                if(temp.getValue().getId2().equals(Bridge)){
                    return temp;
                }
                temp = temp.getpNext();
                } 
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
            if(pAux.getValue().getList() != null){
                pAux2 = pAux.getValue().getList().getHead();
                while(pAux2 != null){
                    output += "(" + pAux2.getValue().getId2() + ", "+  pAux2.getValue().getYears() + "),";
                    pAux2 = pAux2.getpNext();
                }
                output += "]" + newline1 ;
            }
                pAux = pAux.getpNext();
        }
        return output;
    }
}

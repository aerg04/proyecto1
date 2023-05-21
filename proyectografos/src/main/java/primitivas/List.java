/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package primitivas;

/**
 *
 * @author DELL
 * @param <T>
 */
public class List <T>{
    Nodo<T> head;
    Nodo<T> last;
    int size;
    
    public List() {
        head = null;
        last = null;
        size = 0;
    }
    public boolean isEmpty(){
        return head!=null;
    }
    
    public void appendFirst(T x){
        Nodo <T> pNew = new Nodo <> (x);
        if(isEmpty()){
            pNew.setpNext(head);
            head = pNew;
        }
        else{
            head = pNew;
        }
        size++;
    }
    public void appendLast(T x){
//        Nodo pNew = new Nodo (x);
        Nodo <T> pNew = new Nodo <> (x);
        if(isEmpty()){
            last.setpNext(pNew);
            last = pNew;
        }
        else{
            head = last = pNew;
        }
        size++;
    }

    public Nodo getHead() {
        return head;
    }
//    public void appendFirst(Nodo pNew){
////        Nodo pNew = new Nodo (x);
//        if(isEmpty()){
//            pNew.setpNext(head);
//            head = pNew;
//        }
//        else{
//            head = pNew = last;
//        }
//        size++;
//    }

//    public void setHead(Nodo head) {
//        this.head = head;
//    }
    
//    public String showAttributes(){
//        Nodo pAux = head;
//        String output = "[";
//        while(pAux != null){
//            output += pAux.getInfo() + ",";
//            pAux = pAux.getpNext();
//        }
//        output += "]";
//        return output;
//    }
    public void delete(Nodo pDele){
//        Nodo pAux;
        if(this.isEmpty()){
            Nodo<T> pAux = this.getHead();
            if(pAux != pDele){
                head = pAux.getpNext();
                delete(pDele);
                appendFirst(pAux.getValue());
            }
            else{
                head = pDele.getpNext();
                pDele.setpNext(null);
                size--;
            }
        }
        }
//    public void searchPosition(Nodo pNew){
//        if(isEmpty()){
//           Nodo pAux = this.getHead();
//            if(pAux.getInfo() >= pNew.getInfo()){
//                this.appendFirst(pNew);
//            }
//            else{                
//                head = pAux.getpNext();
//                delete(pAux);
//                this.searchPosition(pNew);
//                appendFirst(pAux);
//            } 
//        }
//        else{
//            head = last = pNew;
//        }
//    }
//    public void insert(int x){
//        Nodo pNew = new Nodo(x);
//        searchPosition(pNew);
//    }
//    
//    public void replace(int vChange, int vNew){
//        if(this.isEmpty()){
//        Nodo pAux = head;
//        while(pAux!=null){
//            if(pAux.getInfo() == vChange)
//                pAux.setInfo(vNew);
//            pAux = pAux.getpNext();
//        }   
//        }
//    }
}

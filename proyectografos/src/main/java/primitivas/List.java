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

    public int getSize() {
        return size;
    }

    public Nodo<T> getLast() {
        return last;
    }
    
    
    public List() {
        head = null;
        last = null;
        size = 0;
    }
    public boolean isEmpty(){
        return head!=null;
    }
    public void delete(Nodo pDelete){
//        System.out.println(this.isEmpty());
         if(this.isEmpty()){
             Nodo pAux = head;
             if(head.getValue() != pDelete.getValue()){
                 head = head.getpNext();
                 delete(pDelete);
                 appendFirst(pAux);
             }else{
                 head = pDelete.getpNext();
//        System.out.println(this.isEmpty());
                 pDelete.setpNext(null);
                 size--;
             }
         }else{
             head = last = null;
         }
     }
    
    public void appendFirst(T x){
        Nodo <T> pNew = new Nodo <T> (x);
        if(isEmpty()){
            pNew.setpNext(head);
            head = pNew;
        }
        else{
            head = last = pNew;
            pNew.setpNext(null);
        }
        size++;
    }
    public void appendFirst(Nodo pNew){
//        Nodo <T> pNew = new Nodo <> (x);
        if(isEmpty()){
            pNew.setpNext(head);
            head = pNew;
        }
        else{
            head= last = pNew;
            pNew.setpNext(null);
        }
        size++;
    }
    public void appendLast(Nodo pNew){
//        Nodo pNew = new Nodo (x);
//        Nodo <T> pNew = new Nodo <> (x);
        if(isEmpty()){
            last.setpNext(pNew);
            last = pNew;
            pNew.setpNext(null);
        }
        else{
            head = last = pNew;
            pNew.setpNext(null);
        }
        size++;
    }
    
    public void appendLast(T x){
//        Nodo pNew = new Nodo (x);
        Nodo <T> pNew = new Nodo <T> (x);
        if(isEmpty()){
            last.setpNext(pNew);
            last = pNew;
            pNew.setpNext(null);
        }
        else{
            head = last = pNew;
            pNew.setpNext(null);
        }
        size++;
    }

    public Nodo getHead() {
        return head;
    }
    
    public String showAttribute(){
        Nodo pAux = head;
        String output = "[";
        while(pAux != null){
            output += pAux.getValue() + ",";
            pAux = pAux.getpNext();
        }
        output += "]";
        return output;
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
//        Nodo pAux;
//    public void delete(Nodo pDele){
//        if(this.isEmpty()){
//            Nodo<T> pAux = this.getHead();
//            if(pAux != pDele){
//                head = pAux.getpNext();
//                delete(pDele);
//                appendFirst(pAux.getValue());
//            }
//            else{
//                head = pDele.getpNext();
//                pDele.setpNext(null);
//                size--;
//            }
//        }
}

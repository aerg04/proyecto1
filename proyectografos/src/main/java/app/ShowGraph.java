/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package app;
//mxHierarchicalLayout 
//mxHierarchicalLayout
//mxHierarchicalLayout
import com.mxgraph.layout.hierarchical.mxHierarchicalLayout;
import com.mxgraph.model.mxGraphModel;
import com.mxgraph.swing.mxGraphComponent;
import com.mxgraph.util.mxConstants;
import com.mxgraph.util.mxUtils;
import java.util.Collection;
import javax.swing.JFrame;
import org.jgrapht.graph.*;
import org.jgrapht.ext.JGraphXAdapter;
import  primitivas.*;
import  primitivas.User;
import  primitivas.List;
import  primitivas.Nodo;

//import org.jgrapht.UndirectedGraph;
//import org.jgrapht.graph.DefaultEdge;
//import org.jgrapht.graph.SimpleGraph;
//import org.jgrapht.*;
//import com.mxgraph.view.mxGraph;
//import org.jgrapht.*;
//import org.jgrapht.alg.*;
//import org.jgrapht.graph.AsWeightedGraph;

public class ShowGraph extends JFrame {
            ListenableDirectedWeightedGraph<String, MyEdge>  graph;
  public ShowGraph(Graph mygraph){
            List mylist = mygraph.getList();
            graph = new ListenableDirectedWeightedGraph<String, MyEdge>(MyEdge.class);
            List listbridges = new List();
            JGraphXAdapter<String, MyEdge > jgxAdapter;
//            Recorrido 1
            if(mylist.isEmpty()){
                Nodo<User> temp = mylist.getHead();
                while(temp != null){
                    graph.addVertex(temp.getValue().getId());
                    temp = temp.getpNext();
                }
                temp = mylist.getHead();
                Nodo<Bridge> temp2;
                MyEdge e1;
                while(temp != null){
                    temp2 = temp.getValue().getList().getHead();
                    while(temp2 != null){
                        if(searchNodo(listbridges,temp2)){
                            e1 = graph.addEdge(temp2.getValue().getId1(), temp2.getValue().getId2());
                            if(e1 != null){
                                graph.setEdgeWeight(e1, Double.parseDouble(temp2.getValue().getYears())) ;
                                listbridges.appendLast(temp2.getValue());
                            }
                        }
                        temp2 = temp2.getpNext();
                    }
                    temp = temp.getpNext();
                }
            }
//            Graph<String, DefaultEdge

    jgxAdapter = new JGraphXAdapter <String, MyEdge>(graph);
    mxGraphComponent graphComponent = new mxGraphComponent(jgxAdapter);
    mxGraphModel graphModel  =       (mxGraphModel)graphComponent.getGraph().getModel(); 
    Collection<Object> cells =  graphModel.getCells().values(); 
    mxUtils.setCellStyles(graphComponent.getGraph().getModel(), 
    cells.toArray(), mxConstants.STYLE_ENDARROW, mxConstants.NONE);
    getContentPane().add(graphComponent);


    mxHierarchicalLayout layout = new mxHierarchicalLayout(jgxAdapter);
    layout.execute(jgxAdapter.getDefaultParent());
//    setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }
  public boolean searchNodo(List<Bridge> mylist, Nodo<Bridge> pSearch){
      Nodo<Bridge> temp = mylist.getHead();
      while(temp != null){
          if(pSearch.getValue().getId1().equals(temp.getValue().getId2()) && pSearch.getValue().getId2().equals(temp.getValue().getId1())){
              return false;
          }
          temp = temp.getpNext();
      }
      return true;
  }
  public void displayGraph() {

    //pasarle el grafo list user en el constructor 
          this.setTitle(" graph ");
//          this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
          this.pack();
          this.setVisible(true);
          this.setLocationRelativeTo(null);
//          g.setEnabled(false);
  }
  public void disposeGraph(){
//            graph. = null;
  }
  public static class MyEdge extends DefaultWeightedEdge {
        @Override
        public String toString() {
            return String.valueOf(getWeight()).replaceAll(".0", "");
        }

  }
}
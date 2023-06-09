/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package primitivas;

/**
 *
 * @author DELL
 */
public class User {
    private String id;
    private String username;
    private List list;
    private boolean visited;

    public boolean isVisited() {
        return visited;
    }

    public void setVisited(boolean visited) {
        this.visited = visited;
    }

    public User(String id, String username) {
        this.id = id;
        this.username = username;
        this.list = new List<Bridge>();
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }   

    public List getList() {
        return list;
    }

    public void setList(List list) {
        this.list = list;
    }
    
}

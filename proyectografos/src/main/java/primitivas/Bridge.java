/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package primitivas;

/**
 *
 * @author DELL
 */
public class Bridge {
    private String years;
    private String id1;
    private String id2;

    public String getYears() {
        return years;
    }

    public void setYears(String years) {
        this.years = years;
    }

    public String getId2() {
        return id2;
    }

    public void setId2(String id) {
        this.id2 = id2;
    }

    public Bridge(String id1, String id2, String years) {
        this.years = years;
        this.id1 = id1;
        this.id2 = id2;
    }

    public String getId1() {
        return id1;
    }

    public void setId1(String id1) {
        this.id1 = id1;
    }
    
}

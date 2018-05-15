/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package employeerecordsystem.gui;

/**
 *
 * @author Raizen
 */
public class Action {
    private String val; 
    private String csv; 
    public String  getString()
    {
        return this.val;
    }
     public String  getcsvPath()
    {
        return this.csv;
    }
    public  void setString(String value)
    { 
     this.val += value;
    }
    public  void setcsvPath(String value)
    { 
     this.csv = value;
    }

    void setString(Employee employee) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
}

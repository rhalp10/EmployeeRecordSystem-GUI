/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package employeerecordsystem.gui;


import java.io.BufferedOutputStream;
import java.io.DataOutputStream;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.Date;
import javax.swing.JOptionPane;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
/**
 *
 * @author Cyril
 */
public class Employee {
    private int id;
    private String name;
    private int age;
    private Date birthDate;
    private double salary;
    private String position;

    public Employee() {

    }

    public Employee(int id, String name, int age, String position, double salary) {
        this.id = id;
        this.name = name;
        this.age = age;
//        this.birthDate = birthDate;
        this.salary = salary;
        this.position = position;
    }

    
    public void setAge(int age) {
        this.age = age;
    }

    public void setBirthDate(Date birthDate) {
        this.birthDate = birthDate;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setPosition(String position) {
        this.position = position;
    }

    public void setSalary(double salary) {
        this.salary = salary;
    }

    public int getAge() {
        return age;
    }

    public Date getBirthDate() {
        return birthDate;
    }

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public double getSalary() {
        return salary;
    }

    public void saveTo(File file) throws IOException {
        DataOutputStream dataOut = null;
        try {
            dataOut = new DataOutputStream(
                    new BufferedOutputStream(
                            new FileOutputStream(file, true)));
            dataOut.writeInt(id);
            dataOut.writeUTF(name);
            dataOut.writeInt(age);
            dataOut.writeUTF(position);
            dataOut.writeDouble(salary);
           
            Add_Emp add = new Add_Emp();
            // i dont know why dispose not working i try to dispose the jframe ey
            add.dispose();
            JOptionPane.showMessageDialog(add, "Successfully Added!");
            
        } catch (FileNotFoundException ex) {
            System.out.println(ex);
        } finally {
            dataOut.close();
        }   
    }
    
    public String toCSVFormat(){
        return id + "," + name + "," + age + "," +
                position + "," + String.format("%.2f", salary) + "\n";
    }

    @Override
    public String toString() {
        return "ID: " + id + "\nName: " + name + 
                "\nAge: " + age + "\nPosition: " + position +
                "\nSalary: " + String.format("%.2f", salary) + "\n";
    }
}
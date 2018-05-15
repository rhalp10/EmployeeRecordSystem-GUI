/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package employeerecordsystem.gui;


import java.io.BufferedInputStream;
import java.io.BufferedWriter;
import java.io.DataInputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Random;
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
public class Utils {
    
    
    public static void readEmployeeData(File file) {
        DataInputStream dataIn = null;
        
        try {
            dataIn = new DataInputStream(
                    new BufferedInputStream(
                            new FileInputStream(file)));
            while (dataIn.available() > 0) {
                Employee employee = new Employee(dataIn.readInt(), 
                        dataIn.readUTF(), dataIn.readInt(), 
                        dataIn.readUTF(), dataIn.readDouble());
               
                 
                
                System.out.println(employee);
                
            }
        } catch (FileNotFoundException ex) {
            System.err.println("File not found");
        } catch (IOException ex) {
            System.err.println(ex);
        } finally {
            try {
                dataIn.close();
            } catch (IOException ex) {
                System.err.println(ex);
            }
        }
    }
    
    public static int genId(){
        return new Random().nextInt(10000);
    }
    
    public static Employee getEmployee(File file, int id){
        Employee employee = null;
        DataInputStream dataIn = null;
        try {
            dataIn = new DataInputStream(
                    new BufferedInputStream(
                            new FileInputStream(file)));
            while (dataIn.available() > 0) {
                int empId = dataIn.readInt();
                String name = dataIn.readUTF();
                int age = dataIn.readInt();
                String position = dataIn.readUTF();
                double salary = dataIn.readDouble();
                if (empId == id) {
                    employee = new Employee(empId, name, 
                    age, position, salary);
                    break;
                }
            }
        } catch (FileNotFoundException ex) {
            System.err.println("File not found");
        } catch (IOException ex) {
            System.err.println(ex);
        } finally {
            try {
                dataIn.close();
            } catch (IOException ex) {
                System.err.println(ex);
            }
        }
        return employee;
    }
    
    public static void genEmployeeRecord(File file) throws IOException {
        File csvFile = new File("employees.csv");
        FileWriter fileWriter = new FileWriter(csvFile);
        BufferedWriter bufferedWriter = new BufferedWriter(fileWriter);
        DataInputStream dataIn = null;
        try {
            dataIn = new DataInputStream(
                    new BufferedInputStream(
                            new FileInputStream(file)));
            while (dataIn.available() > 0) {
                Employee employee = new Employee(dataIn.readInt(), 
                        dataIn.readUTF(), dataIn.readInt(), 
                        dataIn.readUTF(), dataIn.readDouble());
                bufferedWriter.write(employee.toCSVFormat());
            }
            
            JOptionPane.showMessageDialog(null, "Record generated in: "+csvFile.getAbsolutePath());
   
           
        } catch (FileNotFoundException ex) {
            System.err.println("File not found");
        } catch (IOException ex) {
            System.err.println(ex);
        } finally {
            try {
                dataIn.close();
                bufferedWriter.close();
            } catch (IOException ex) {
                System.err.println(ex);
            }
        }
    }
    
  


}

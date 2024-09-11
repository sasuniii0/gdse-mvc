/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package gdse.mvc.model;

import gdse.mvc.db.DBConnection;
import gdse.mvc.dto.CustomerDto;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

/**
 *
 * @author sasuni
 */
public class CustomerModel {
    public String saveCustomer(CustomerDto customerDto) throws SQLException, ClassNotFoundException{
        Connection connection = DBConnection.getInstance().getConnection();
        String sql = "INSERT INTO Item VALUES (?,?,?,?,?,?,?,?,?)";
        PreparedStatement statement = connection.prepareStatement(sql);
        statement.setString(1, customerDto.getId());
        statement.setString(2, customerDto.getTitle());
        statement.setString(3, customerDto.getName());
        statement.setString(4, customerDto.getDob());
        statement.setDouble(5, customerDto.getSalary());
        statement.setString(6, customerDto.getAddress());
        statement.setString(7, customerDto.getCity());
        statement.setString(8, customerDto.getProvince());
        statement.setString(9, customerDto.getPostalCode());
        
        int resp = statement.executeUpdate();
        return resp > 0 ? "Success" : "Fail";
        
    }
    
     public static ArrayList<CustomerDto> getAllCustomers()throws SQLException, ClassNotFoundException {
      
        Connection connection = DBConnection.getInstance().getConnection();
        
        String query = "SELECT * FROM Customer";
        
        PreparedStatement statement = connection.prepareStatement(query);
        
        ResultSet rst = statement.executeQuery();
        
        ArrayList<CustomerDto> customerDto = new ArrayList<>();
        
         while (rst.next()) {            
            CustomerDto cm = new CustomerDto(
                    rst.getString(1),
                    rst.getString(2), 
                    rst.getString(3), 
                    rst.getString(4), 
                    rst.getDouble(5),
                    rst.getString(6), 
                    rst.getString(7), 
                    rst.getString(8), 
                    rst.getString(9));
            
            customerDto.add(cm);
        }
        return customerDto;
    }
}

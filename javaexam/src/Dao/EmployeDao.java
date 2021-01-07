/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Dao;

import java.io.FileNotFoundException;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import models.Employe;

/**
 *
 * @author abdel
 */
public class EmployeDao implements IDao<Employe>  {
    
    private final String SQL_SELECT_ALL_EMPLOYE = "SELECT * FROM `employe`";
    private final String SQL_INSERT_EMPLOYE = "INSERT INTO `employe` (`nomComplet`, `date`) VALUES (?, ?)";
    
    
    private final Mysql mysql;

    public EmployeDao() {
        mysql = new Mysql();
    }

    @Override
    public Employe add(Employe employe) {
        mysql.getConnection();
        
        mysql.initPS(SQL_INSERT_EMPLOYE);
       
        PreparedStatement psmt = mysql.getPstm();
        
        try {
            psmt.setString(1, employe.getNomComplet());
            psmt.setString(2, employe.getDate());

            psmt.executeUpdate();
            ResultSet rs = psmt.getGeneratedKeys();
            if (rs.next()) {
                int id = rs.getInt(1);
                employe.setId(id);
            }

        } catch (SQLException ex) {
            Logger.getLogger(EmployeDao.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            mysql.closeConnection();
        }

        return employe;
    }

    @Override
    public ObservableList<Employe> selectAll() {
        ObservableList<Employe> employes = FXCollections.observableArrayList();
        mysql.getConnection();
        mysql.initPS(SQL_SELECT_ALL_EMPLOYE);
        PreparedStatement ps = mysql.getPstm();
        try {
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                Employe employe = new Employe();
                employe.setId(rs.getInt("Id"));
                employe.setNomComplet(rs.getString("nomComplet"));
                employes.add(employe);
            }

        } catch (SQLException ex) {
            Logger.getLogger(EmployeDao.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            mysql.closeConnection();
        }
        return employes;
    
    }
    
}

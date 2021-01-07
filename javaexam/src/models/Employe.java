/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package models;

/**
 *
 * @author abdel
 */
public class Employe {
    private int Id;
    private String nomComplet;
    private String date;

    public Employe(int Id, String nomComplet, String date) {
        this.Id = Id;
        this.nomComplet = nomComplet;
        this.date = date;
    }

    public Employe(String nomComplet, String date) {
        this.nomComplet = nomComplet;
        this.date = date;
    }

    public String getNomComplet() {
        return nomComplet;
    }

    public void setNomComplet(String nomComplet) {
        this.nomComplet = nomComplet;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }
    
    public void setId(int Id) {
        this.Id = Id;
    }

    public int getId() {
        return Id;
    }
    
    @Override
    public String toString() {
        return "Employe{" + "Id=" + Id + ", nom Cpmplet=" + nomComplet + ", date d'embauche =" + date + '}';
    }
}

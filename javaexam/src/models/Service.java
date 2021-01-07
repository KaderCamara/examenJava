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
public class Service {
    
    private int Id;
    private int libelle;
    private Employe idEmploye;

    public Service(int Id, int libelle, Employe idEmploye) {
        this.Id = Id;
        this.libelle = libelle;
        this.idEmploye = idEmploye;
    }

    public Service(int libelle, Employe idEmploye) {
        this.libelle = libelle;
        this.idEmploye = idEmploye;
    }

    public int getLibelle() {
        return libelle;
    }

    public void setLibelle(int libelle) {
        this.libelle = libelle;
    }

    public Employe getIdEmploye() {
        return idEmploye;
    }

    public void setIdEmploye(Employe idEmploye) {
        this.idEmploye = idEmploye;
    }
    
    public void setId(int Id) {
        this.Id = Id;
    }

    public int getId() {
        return Id;
    }
    
    @Override
    public String toString() {
        return "Service{" + "Id=" + Id + ", libelle=" + libelle + '}';
    }
}

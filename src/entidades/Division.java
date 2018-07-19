/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package entidades;
import conexiones.ConexionBase;
import java.awt.HeadlessException;
import java.sql.*;
import javax.swing.JOptionPane;
/**
 *
 * @author Usuario
 */
public class Division {
        int iddivision;
    int idcursos;
    int idpreseptor;
    int idturno;
    String nombredivision;
    int idaula;  
    public Division(int iddivision, int idcursos, int idpreseptor, int idturno, String nombredivision, int idaula) {
        this.iddivision = iddivision;
        this.idcursos = idcursos;
        this.idpreseptor = idpreseptor;
        this.idturno = idturno;
        this.nombredivision = nombredivision;
        this.idaula = idaula;
    }

    public Division(int idcursos, int idpreseptor, int idturno, String nombredivision, int idaula) {
        this.idcursos = idcursos;
        this.idpreseptor = idpreseptor;
        this.idturno = idturno;
        this.nombredivision = nombredivision;
        this.idaula = idaula;
    }

    public int getIddivision() {
        return iddivision;
    }

    public void setIddivision(int iddivision) {
        this.iddivision = iddivision;
    }

    public int getIdcursos() {
        return idcursos;
    }

    public void setIdcursos(int idcursos) {
        this.idcursos = idcursos;
    }

    public int getIdpreseptor() {
        return idpreseptor;
    }

    public void setIdpreseptor(int idpreseptor) {
        this.idpreseptor = idpreseptor;
    }

    public int getIdturno() {
        return idturno;
    }

    public void setIdturno(int idturno) {
        this.idturno = idturno;
    }

    public String getNombredivision() {
        return nombredivision;
    }

    public void setNombredivision(String nombredivision) {
        this.nombredivision = nombredivision;
    }

    public int getIdaula() {
        return idaula;
    }

    public void setIdaula(int idaula) {
        this.idaula = idaula;
    }
   
    public void AgregarDivision(){
         ConexionBase conectar= new ConexionBase();
             Connection base=conectar.getConnection();
             try{
           PreparedStatement ps = base.prepareStatement("INSERT INTO division (iddivision,idcursos,idpreseptor,idturno,nombredivision,idaula) VALUES(?,?,?,?,?,?)");
           ps.setInt(1,iddivision );
           ps.setInt(2,idcursos );
           ps.setInt(3,idpreseptor );
           ps.setInt(4,idturno);
           ps.setString(5,nombredivision);
           ps.setInt(6,idaula);
           
            ps.executeUpdate();
            JOptionPane.showMessageDialog(null, " Division Agregado con exito");
        } catch(SQLException | HeadlessException e){
            JOptionPane.showMessageDialog(null, e, "Error al guardar division ",1);
    }
}
}


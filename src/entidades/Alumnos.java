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
 * @author Administrador
 */
public class Alumnos {
    int idalumno;
    int idpersona; 
    int numlibreta;
    Date fechainscripcion;
    public Alumnos() {
    }

    public Alumnos(int idalumno, int idpersona, int numlibreta, Date fechainscripcion) {
        this.idalumno = idalumno;
        this.idpersona = idpersona;
        this.numlibreta = numlibreta;
        this.fechainscripcion = fechainscripcion;
    }

    public Alumnos(int idpersona, int numlibreta, Date fechainscripcion) {
        this.idpersona = idpersona;
        this.numlibreta = numlibreta;
        this.fechainscripcion = fechainscripcion;
    }

    public int getIdalumno() {
        return idalumno;
    }

    public void setIdalumno(int idalumno) {
        this.idalumno = idalumno;
    }

    public int getIdpersona() {
        return idpersona;
    }

    public void setIdpersona(int idpersona) {
        this.idpersona = idpersona;
    }

    public int getNumlibreta() {
        return numlibreta;
    }

    public void setNumlibreta(int numlibreta) {
        this.numlibreta = numlibreta;
    }

    public Date getFechainscripcion() {
        return fechainscripcion;
    }

    public void setFechainscripcion(Date fechainscripcion) {
        this.fechainscripcion = fechainscripcion;
    }
  
       
    public void RegistrarAlumno(){
        ConexionBase conectar= new ConexionBase();
             Connection base=conectar.getConnection();
        try{
           PreparedStatement ps = base.prepareStatement("INSERT INTO alumno (idalumno,idpersona,numlibreta,fechainscripcion) VALUES(?,?,?,?)");
           ps.setInt(1, idalumno);
           ps.setInt(2, idpersona);
           ps.setInt(3, idalumno);
           ps.setDate(4, fechainscripcion);
            ps.executeUpdate();
            JOptionPane.showMessageDialog(null, " Alumno Agregado con exito");
        } catch(SQLException | HeadlessException e){
            JOptionPane.showMessageDialog(null, e, "Error al guardar alumno ",1);
        }
    }
    public void CancelarAlumno(){
        
    }
    
}
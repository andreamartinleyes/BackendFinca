/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package tutoria.Repositorio;

import java.util.ArrayList;
import java.util.Date;
import tutoria.Interface.InterfaceReservacion;
import tutoria.Modelo.Reservacion;
import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import tutoria.Modelo.Cliente;


/**
 *
 * @author USUARIO
 */
@Repository
public class ReservacionRepositorio {
     @Autowired
    private InterfaceReservacion crud4;
    
    public List<Reservacion> getAll(){
        return (List<Reservacion>) crud4.findAll();
    }
    public Optional<Reservacion> getReservation(int id){
        return crud4.findById(id);
    }
    public Reservacion save(Reservacion reservation){
        return crud4.save(reservation);
    }
     public void delete(Reservacion reservacion){
        crud4.delete(reservacion);
    }
   
     public List<Reservacion> ReservacionStatusRepositorio (String status){
         return crud4.findAllByStatus(status);
     }
     
     public List<Reservacion> ReservacionTiempoRepositorio (Date a, Date b){
         return crud4.findAllByStartDateAfterAndStartDateBefore(a, b);
     
     }
     
     public List<ContadorCliente> getClienteRepositorio(){
         List<ContadorCliente> res = new ArrayList<>();
         List<Object[]> report = crud4.countTotalReservationsByCliente();
         for(int i=0; i<report.size(); i++){
             res.add(new ContadorCliente((Long)report.get(i)[1],(Cliente) report.get(i)[0]));
         }
         return res;
     }

}

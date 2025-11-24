package controller;

import model.dao.ReservaDAO;
import model.entities.Reserva;

public class GestorReservas {

    private ReservaDAO dao;
    
   public GestorReservas(){
       dao = new ReservaDAO();
       
   }
   
   public boolean realizarReserva(Reserva r){
       return dao.realizarReserva(r);
   }
}

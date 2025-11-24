
package model.strategy;

public class GestorValidacion {
    
    private ValidacionStrategy strategy;
    
    public void setStrategy(ValidacionStrategy Strategy){
        this.strategy = strategy;
    }
    
    public boolean ejecutar(){
        return strategy.validar();
    }
    public String getMensaje(){
        return strategy.getMensaje();
    }
}

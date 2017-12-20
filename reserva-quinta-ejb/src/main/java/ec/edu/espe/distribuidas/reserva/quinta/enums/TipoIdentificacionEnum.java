/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ec.edu.espe.distribuidas.reserva.quinta.enums;

/**
 *
 * @author toshiba
 */
public enum TipoIdentificacionEnum {
    
    CED("CEDULA"),
    PAS("PASAPORTE"),
    RUC("RUC");
    
    private String texto;

    private TipoIdentificacionEnum(String texto) {
        this.texto = texto;
    }
    
    public String getTexto() {
        return texto;
    }
   
    
}

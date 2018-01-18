/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ec.edu.espe.distribuidas.reserva.quinta.service;

import ec.edu.espe.distribuidas.reserva.quinta.dao.UsuarioFacade;
import ec.edu.espe.distribuidas.reserva.quinta.model.Usuario;
import javax.ejb.EJB;
import javax.ejb.LocalBean;
import javax.ejb.Stateless;

/**
 *
 * @author Ing Alvaro Vasquez
 */
@LocalBean
@Stateless
public class AutenticacionService {
    
    @EJB
    private UsuarioFacade usuarioFacade;
    
    public Usuario login(String codUsuario, String clave) {
        Usuario usuario = this.usuarioFacade.find(codUsuario);
        if (usuario!=null && usuario.getClave().equals(clave)) {
            return usuario;
        } else {
            return null;
        }
    }
}

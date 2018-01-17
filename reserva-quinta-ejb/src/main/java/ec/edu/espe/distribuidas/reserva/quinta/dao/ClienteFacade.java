/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ec.edu.espe.distribuidas.reserva.quinta.dao;

import ec.edu.espe.distribuidas.reserva.quinta.enums.TipoIdentificacionEnum;
import ec.edu.espe.distribuidas.reserva.quinta.model.Cliente;
import java.util.List;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

/**
 *
 * @author toshiba
 */
@Stateless
public class ClienteFacade extends AbstractFacade<Cliente> {

    @PersistenceContext(unitName = "ec.edu.espe.distribuidas_reserva-quinta-ejb_ejb_1PU")
    private EntityManager em;

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    public ClienteFacade() {
        super(Cliente.class);
    }
    
      public List<Cliente> findByTipo(TipoIdentificacionEnum tipo) {
        Query qry = this.em.createQuery("SELECT obj FROM Cliente obj WHERE obj.tipo=?1");
        qry.setParameter(1, tipo);
        return qry.getResultList();
    }
    
}

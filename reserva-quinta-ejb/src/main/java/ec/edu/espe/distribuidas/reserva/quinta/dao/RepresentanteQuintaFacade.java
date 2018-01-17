/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ec.edu.espe.distribuidas.reserva.quinta.dao;

import ec.edu.espe.distribuidas.reserva.quinta.enums.TipoIdentificacionEnum;
import ec.edu.espe.distribuidas.reserva.quinta.model.RepresentanteQuinta;
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
public class RepresentanteQuintaFacade extends AbstractFacade<RepresentanteQuinta> {

    @PersistenceContext(unitName = "ec.edu.espe.distribuidas_reserva-quinta-ejb_ejb_1PU")
    private EntityManager em;

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    public RepresentanteQuintaFacade() {
        super(RepresentanteQuinta.class);
    }
    
     public List<RepresentanteQuinta> findByTipo(TipoIdentificacionEnum tipo) {
        Query qry = this.em.createQuery("SELECT obj FROM RepresentanteQuinta obj WHERE obj.tipo=?1");
        qry.setParameter(1, tipo);
        return qry.getResultList();
    }

  
}

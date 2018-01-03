/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ec.edu.espe.distribuidas.reserva.quinta.dao;

import ec.edu.espe.distribuidas.reserva.quinta.model.TipoSitio;
import javax.ejb.LocalBean;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

/**
 *
 * @author Quinta Search
 */
@Stateless
@LocalBean
public class TipoSitioFacade extends AbstractFacade<TipoSitio> {

    @PersistenceContext(unitName = "ec.edu.espe.distribuidas_reserva-quinta-ejb_ejb_1PU")
    private EntityManager em;

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    public TipoSitioFacade() {
        super(TipoSitio.class);
    }
    
}

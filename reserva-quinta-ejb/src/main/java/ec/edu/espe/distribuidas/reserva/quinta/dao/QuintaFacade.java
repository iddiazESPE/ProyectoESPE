/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ec.edu.espe.distribuidas.reserva.quinta.dao;

import ec.edu.espe.distribuidas.reserva.quinta.model.Direccion;
import ec.edu.espe.distribuidas.reserva.quinta.model.Provincia;
import ec.edu.espe.distribuidas.reserva.quinta.model.Quinta;
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
public class QuintaFacade extends AbstractFacade<Quinta> {

    @PersistenceContext(unitName = "ec.edu.espe.distribuidas_reserva-quinta-ejb_ejb_1PU")
    private EntityManager em;

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    public QuintaFacade() {
        super(Quinta.class);
    }
    
    public List<Quinta> findByProvincia(Provincia codigo) {
        Query qry = this.em.createQuery("SELECT obj FROM Quinta obj WHERE obj.codigo=?1");
        qry.setParameter(1, codigo);
        return qry.getResultList();
    }
    
    public List<Quinta> findByCodigo(Integer codigo) {
        Query qry = this.em.createQuery("SELECT obj FROM Quinta obj WHERE obj.codigo=?1");
        qry.setParameter(1, codigo);
        return qry.getResultList();
    }
    
    
}

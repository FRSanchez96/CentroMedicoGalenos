/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package JSF;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

/**
 *
 * @author Felipe
 */
@Stateless
public class BoletaFacade extends AbstractFacade<Boleta> {
    @PersistenceContext(unitName = "ExamenPU")
    private EntityManager em;

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    public BoletaFacade() {
        super(Boleta.class);
    }
    
}

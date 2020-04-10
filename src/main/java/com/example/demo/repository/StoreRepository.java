package com.example.demo.repository;


import com.example.demo.domain.Store;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.util.StringUtils;


import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;
import javax.persistence.criteria.*;
import java.util.ArrayList;
import java.util.List;


@Repository
@RequiredArgsConstructor
public class StoreRepository {

    @PersistenceContext
    EntityManager em;


    @Transactional
    public void save(Store store) {
        em.persist(store);
    }
    public  Store findOne(Long id) {
        return em.find(Store.class, id);
    }

//    public Store findById(String name){
//        return em.find(Store.class, name);
//    }

    public List<Store> findStore(Store store) {
        CriteriaBuilder cb = em.getCriteriaBuilder();
        CriteriaQuery<Store> cq = cb.createQuery(Store.class);
        Root<Store> s = cq.from(Store.class);
        List<Predicate> criteria = new ArrayList<Predicate>();

        if (StringUtils.hasText(store.getName())) {
            Predicate info =
                    cb.equal(s.get("storeInfo"), Store.class);
            criteria.add(info);

        }

        cq.where(cb.and(criteria.toArray(new Predicate[criteria.size()])));
        TypedQuery<Store> query =
                em.createQuery(cq).setMaxResults(100);
        return query.getResultList();
    }




    public List<Store> findAll_chicken(){
        return em.createQuery("select s  from Store s where s.name = 'BBQ' OR s.name = 'KFC'", Store.class)
                .getResultList();
    }


    public List<Store> findAll_pizza(){
        return em.createQuery("select s from Store s where s.name ='DOMINO' OR s.name = 'PIZZAHUT'", Store.class)
                .getResultList();


    }


    public List<Store> findAll_zokbal(){
        return em.createQuery("select s from Store s where s.name = 'Gazok' OR s.name = 'hyeonwuZok'", Store.class)
                .getResultList();
    }


    public List<Store> findAll_korea(){
        return em.createQuery("select s from Store s where s.name = 'KIMBABHEAVEN' OR s.name ='Kimbabhell'", Store.class)

                .getResultList();
    }


}

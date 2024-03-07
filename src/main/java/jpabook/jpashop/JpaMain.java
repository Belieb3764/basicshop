package jpabook.jpashop;

import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.EntityTransaction;
import jakarta.persistence.Persistence;
import jakarta.persistence.criteria.CriteriaBuilder;
import jakarta.persistence.criteria.CriteriaQuery;
import jakarta.persistence.criteria.Root;
import jpabook.jpashop.domain.Book;
import jpabook.jpashop.domain.Member;
import jpabook.jpashop.domain.Order;
import jpabook.jpashop.domain.OrderItem;

import java.util.List;

public class JpaMain {

    public static void main(String[] args) {
    EntityManagerFactory emf = Persistence.createEntityManagerFactory("hello");

    EntityManager em = emf.createEntityManager();

    EntityTransaction tx = em.getTransaction();
        tx.begin();

        try{

            /**
             * Criteria 사용 준비
             */
            CriteriaBuilder cb = em.getCriteriaBuilder();
            CriteriaQuery<Member> query =  cb.createQuery(Member.class);

            Root<Member> m = query.from(Member.class);

            CriteriaQuery<Member> cq = query.select(m);

            String username = "dsafas";
            if(username !=  null) {
                cq.where(cb.equal(m.get("username"), "kim"));
            }

            List<Member> reusultList = em.createQuery(cq)
                    .getResultList();


            /**
             * JPQL
             */
//            List<Member> result = em.createQuery(
//                    "select m From Member m where m.name like '%kim%'",
//                    Member.class
//            ).getResultList();
//
//            for (Member member : result) {
//                System.out.println("member = " + member);
//
//            }

//            Book book = new Book();
//            book.setName("JPA");
//            book.setAuthor("김영한");
//
//            em.persist(book);

//            Order order = new Order();
//            em.persist(order);
////            order.addOrderItem(new OrderItem());
//
//            OrderItem orderItem = new OrderItem();
//            orderItem.setOrder(order);
//
//            em.persist(orderItem);

            tx.commit();
        } catch (Exception e) {
            tx.rollback();
        }finally {
            em.close();
        }
        emf.close();

    }

}

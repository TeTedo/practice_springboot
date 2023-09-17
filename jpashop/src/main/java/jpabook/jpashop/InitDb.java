package jpabook.jpashop;

import jakarta.annotation.PostConstruct;
import jakarta.persistence.EntityManager;
import jpabook.jpashop.domain.*;
import jpabook.jpashop.domain.item.Book;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

@Component
@RequiredArgsConstructor
public class InitDb {

    private final InitService initService;

    @PostConstruct
    public void init(){
        initService.dbInit1();
        initService.dbInit2();
    }

    @Component
    @Transactional
    @RequiredArgsConstructor
    static class InitService{



        private final EntityManager em;

        public void dbInit1() {
            Member member = createMember("userA");
            em.persist(member);

            Book book1 = createBook("JPA1 Book",20000);
            em.persist(book1);

            Book book2 = createBook("JPA2 Book",20000);
            em.persist(book2);

            OrderItem orderItem1 = OrderItem.createOrderItem(book1, 30000, 1);
            OrderItem orderItem2 = OrderItem.createOrderItem(book2, 20000, 2);

            Order order = getOrder(member, orderItem1, orderItem2);
            em.persist(order);
        }




        public void dbInit2() {
            Member member = createMember("userB");
            em.persist(member);

            Book book1 = createBook("JPA1 Book",10000);
            em.persist(book1);

            Book book2 = createBook("JPA2 Book",10000);
            em.persist(book2);

            OrderItem orderItem1 = OrderItem.createOrderItem(book1, 10000, 1);
            OrderItem orderItem2 = OrderItem.createOrderItem(book2, 20000, 2);

            Order order = getOrder(member, orderItem1, orderItem2);
            em.persist(order);
        }

        private static Member createMember(String username) {
            Member member = new Member();
            member.setName(username);
            member.setAddress(new Address("서울", "1", "111"));
            return member;
        }

        private static Book createBook(String JPA1_Book, int price) {
            Book book1 = new Book();
            book1.setName(JPA1_Book);
            book1.setPrice(price);
            book1.setStockQuantity(100);
            return book1;
        }

        private static Order getOrder(Member member, OrderItem orderItem1, OrderItem orderItem2) {
            Delivery delivery = new Delivery();
            delivery.setAddress(member.getAddress());
            Order order = Order.createOrder(member, delivery, orderItem1, orderItem2);
            return order;
        }
    }

}

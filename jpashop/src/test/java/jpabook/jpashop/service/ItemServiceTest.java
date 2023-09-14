package jpabook.jpashop.service;

import jpabook.jpashop.domain.item.Album;
import jpabook.jpashop.domain.item.Item;
import jpabook.jpashop.exception.NotEnoughStockException;
import jpabook.jpashop.repository.ItemRepository;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.transaction.annotation.Transactional;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
@Transactional
class ItemServiceTest {

    @Autowired
    private ItemRepository itemRepository;

    @Autowired
    private ItemService itemService;

    @Test
    public void 아이템_저장() throws Exception {
        //given
        Item item = new Album();
        item.setName("앨범");

        //when
        Long savedId = itemService.saveItem(item);

        //then
        assertEquals(item, itemRepository.findOne(savedId));
    }

    @Test
    public void 수량_부족() throws Exception {
        //given
        Item item = new Album();
        item.setStockQuantity(10);

        //when && then
        assertThrows(NotEnoughStockException.class, () -> {
            item.removeStock(11);
        }, "수량부족 에러가 떠야한다.");
    }

}
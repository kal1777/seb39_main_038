package com.main_39.Spring.menu.entity;

import com.main_39.Spring.order.entity.OrderMenu;
import com.main_39.Spring.store.entity.Store;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@Getter
@NoArgsConstructor
public class Menu {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long menuId;

    private String name;

    private int price;

    private String content;

    private String image;

    @OneToMany(mappedBy = "menu", cascade = CascadeType.ALL, fetch = FetchType.EAGER) // 1010 추가
    private List<OrderMenu> orderMenus = new ArrayList<>();

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "store_id")
    private Store store;

    @Builder
    public Menu(Store store, String name, int price, String content, String image) {
        this.store = store;
        this.name = name;
        this.price = price;
        this.content = content;
        this.image = image;
    }
    public void addName(String name) {
        this.name = name;
    }

    public void addPrice(int price) {
        this.price = price;
    }

    public void addContent(String content) {
        this.content = content;
    }

    public void addImage(String image) {
        this.image = image;
    }

    public void addStore(Store store) {
        this.store = store;
        if(!store.getMenus().contains(this))
            store.getMenus().add(this);
    }

    public void addMenuId(Long menuId) {
        this.menuId = menuId;
    }

    public void addOrderMenu(OrderMenu orderMenu) {
        this.orderMenus.add(orderMenu);
        if(orderMenu.getMenu() != this) {
            orderMenu.addMenu(this);
        }
    }
}
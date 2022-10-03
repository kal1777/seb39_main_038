package com.main_39.Spring.menu.dto;

import lombok.Builder;
import lombok.Getter;

@Getter
public class MenuResponse {
    private long menuId;
    private String name;
    private int price;
    private String image;

    @Builder
    public MenuResponse(long menuId, String name, int price, String image) {
        this.menuId = menuId;
        this.name = name;
        this.price = price;
        this.image = image;
    }
}
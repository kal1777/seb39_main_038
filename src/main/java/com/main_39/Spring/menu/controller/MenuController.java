package com.main_39.Spring.menu.controller;

import com.main_39.Spring.menu.MenuMapper;
import com.main_39.Spring.menu.dto.MenuRequest;
import com.main_39.Spring.menu.dto.MenuResponse;
import com.main_39.Spring.menu.entity.Menu;
import com.main_39.Spring.menu.service.MenuService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/menu")
@RequiredArgsConstructor
public class MenuController {

    private final MenuService menuService;

    private final MenuMapper mapper;

    /**
     * 메뉴 등록
     */
    @PostMapping
    public ResponseEntity<Void> createMenu(@RequestBody MenuRequest menuRequest) {

        menuService.createMenu(mapper.menuRequestToMenu(menuRequest));

        return new ResponseEntity<>(HttpStatus.CREATED);
    }

    /**
     * 단일 메뉴 불러오기
     */
    @GetMapping("/{menu-id}")
    public ResponseEntity<MenuResponse> getMenu(@PathVariable("menu-id") long menuId) {

        Menu findMenu = menuService.findVerifiedMenu(menuId);

        return new ResponseEntity<>(mapper.menuToMenuResponse(findMenu), HttpStatus.OK);
    }
    /**
     * TODO : 상점별 메뉴 불러오기
     */
    @GetMapping("/{store-id}/menus")
    public ResponseEntity getMenus() {

        return new ResponseEntity("", HttpStatus.OK);
    }

    /**
     * 메뉴 수정
     */
    @PatchMapping("/{menu-id}")
    public ResponseEntity<Void> updateMenu(@PathVariable("menu-id") long menuId,
                                           @RequestBody MenuRequest menuRequest) {

        menuService.updateMenu(menuId, menuRequest);

        return new ResponseEntity<>(HttpStatus.OK);
    }

    /**
     * 메뉴 삭제
     */
    @DeleteMapping("/{menu-id}")
    public ResponseEntity<Void> deleteMenu(@PathVariable("menu-id") long menuId) {

        menuService.deleteMenu(menuId);

        return new ResponseEntity<>(HttpStatus.OK);
    }
}

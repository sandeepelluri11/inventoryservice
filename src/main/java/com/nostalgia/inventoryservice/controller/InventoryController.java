package com.nostalgia.inventoryservice.controller;

import com.nostalgia.inventoryservice.dto.InventoryProductRequest;
import com.nostalgia.inventoryservice.dto.InventoryRequest;
import com.nostalgia.inventoryservice.dto.InventoryResponse;
import com.nostalgia.inventoryservice.model.Inventory;
import com.nostalgia.inventoryservice.service.InventoryService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/inventory")
@RequiredArgsConstructor
public class InventoryController {

    private final InventoryService inventoryService;

    @GetMapping
    @ResponseStatus(HttpStatus.OK)
    public List<InventoryResponse> checkInventory(@RequestParam List<String> skucode){
        return inventoryService.checkInventory(skucode);
    }

    @PostMapping("/addproduct")
    @ResponseStatus(HttpStatus.CREATED)
    public void addProductToInventory(@RequestBody InventoryProductRequest inventoryProductRequest){
        inventoryService.addProductToInventory(inventoryProductRequest);
    }
}

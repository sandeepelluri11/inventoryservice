package com.nostalgia.inventoryservice.service;

import com.nostalgia.inventoryservice.dto.InventoryProductRequest;
import com.nostalgia.inventoryservice.dto.InventoryRequest;
import com.nostalgia.inventoryservice.dto.InventoryResponse;
import com.nostalgia.inventoryservice.model.Inventory;
import com.nostalgia.inventoryservice.repository.InventoryRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
@Slf4j
public class InventoryService {

    private final InventoryRepository inventoryRepository;

    public List<InventoryResponse> checkInventory(List<String> skucode){

        List<Inventory> inventories = inventoryRepository.findBySkucodeIn(skucode);

        List<InventoryResponse> inventoryResponses = inventories.stream().map(this::mapToInventoryResponse).toList();

        return inventoryResponses;
    }

    public InventoryResponse mapToInventoryResponse(Inventory inventory){
        return InventoryResponse.builder()
                .skucode(inventory.getSkucode())
                .isinstock(inventory.getQuantity()>0)
                .build();
    }

    public void addProductToInventory(InventoryProductRequest inventoryProductRequest){
        Inventory product = Inventory.builder()
                .skucode(inventoryProductRequest.getSkucode())
                .quantity(inventoryProductRequest.getQuantity())
                .build();

        inventoryRepository.save(product);
        log.info("Product {} added to inventory",inventoryProductRequest.getSkucode());
    }
}

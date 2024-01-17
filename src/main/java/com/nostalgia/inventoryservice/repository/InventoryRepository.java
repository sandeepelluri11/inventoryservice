package com.nostalgia.inventoryservice.repository;

import com.nostalgia.inventoryservice.dto.InventoryResponse;
import com.nostalgia.inventoryservice.model.Inventory;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;
import java.util.Optional;

public interface InventoryRepository extends JpaRepository<Inventory,Long> {
    List<Inventory> findBySkucodeIn(List<String> skucode);

//    @Query("select id,quantity,skucode,quantity from inventoryservice.n_inventory where skucode=:skucode and quantity>=:quantity")
//    Inventory findBySkucodeAndQuantity(String skucode, Long quantity);
}

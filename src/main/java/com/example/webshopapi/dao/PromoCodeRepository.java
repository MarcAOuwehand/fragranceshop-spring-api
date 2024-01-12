package com.example.webshopapi.dao;
import com.example.webshopapi.model.PromoCode;
import org.springframework.data.repository.CrudRepository;

import java.util.UUID;

public interface PromoCodeRepository extends CrudRepository<PromoCode, UUID> {
}

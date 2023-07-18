package com.jtech.os.api.repository;

import com.jtech.os.api.entity.Order;
import org.springframework.data.mongodb.repository.MongoRepository;
/**
 * Order repository interface for retrieve order info from table.
 *
 * @author Manikandan
 */
public interface OrderRepository extends MongoRepository<Order,Integer> {
}

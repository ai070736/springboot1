package com.simk.mapper;

import com.simk.entities.Bill;
import com.simk.entities.BillProvider;
import com.simk.entities.Provider;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.cache.annotation.Cacheable;

import java.util.List;

@Mapper
public interface BillMapper {
    List<BillProvider> getBills(Bill bill);
    @Cacheable(cacheNames = "comment")
    BillProvider getBillByBid(Integer bid);
    int addBill(Bill bill);
    int updateBill(Bill bill);
    int deteleBillByBid(Integer bid);
}

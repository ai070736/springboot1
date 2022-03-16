package com.simk.service.impl;

import com.simk.entities.Bill;
import com.simk.entities.BillProvider;
import com.simk.entities.Provider;
import com.simk.mapper.BillMapper;
import com.simk.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserServiceImpl implements UserService {
    @Override
    public void say() {
        System.out.println("say");
    }



    @Autowired
    BillMapper billMapper;
    @Cacheable(cacheNames = "comment")
    @Override
    public List<BillProvider> getBills(Bill bill) {
        List<BillProvider> bills = billMapper.getBills(bill);
        return bills;
    }

}

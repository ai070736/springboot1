package com.simk.service;

import com.simk.entities.Bill;
import com.simk.entities.BillProvider;
import com.simk.entities.Provider;

import java.util.List;

public interface UserService {
    void say();
    List<BillProvider> getBills(Bill bill);
}

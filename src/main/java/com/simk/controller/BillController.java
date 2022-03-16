package com.simk.controller;

import com.simk.entities.Bill;
import com.simk.entities.BillProvider;
import com.simk.entities.Provider;
import com.simk.mapper.BillMapper;
import com.simk.mapper.ProviderMapper;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

@Controller
public class BillController {
    Logger logger = LoggerFactory.getLogger(getClass());

    @Autowired
    BillMapper billMapper;
    @Autowired
    ProviderMapper providerMapper;

    @GetMapping("/bills")
    public String list(Map<String, Object> map, BillProvider billProvider) {

        List<BillProvider> billProviders = billMapper.getBills(billProvider);
        //查出所有供应商
        List<Provider> providers = providerMapper.getProviders(null);

        map.put("billProviders", billProviders);
        map.put("billName", billProvider.getBillName());
        map.put("pid", billProvider.getPid());
        map.put("pay", billProvider.getPay());
        map.put("providers", providers);
        return "bill/list";
    }


    @GetMapping("/bill/{bid}")
    public String view(@PathVariable("bid") Integer bid,
                       @RequestParam(value="type", defaultValue = "view") String type,
                       Map<String, Object> map) {
        logger.info("查询" + bid + "的帐单详细信息");
        BillProvider billProvider = billMapper.getBillByBid(bid);
        map.put("billProvider", billProvider);
        //查询所有供应商
        if("update".equals(type)) {
            map.put("providers", providerMapper.getProviders(null));
        }
        // type = null 则进入view.html， type=update 则是进入update.html
        return "bill/" + type;
    }
    //修改
    @PutMapping("/bill")
    public String update(Bill bill) {
        logger.info("更改帐单信息。。。");
        logger.info("更新："+bill);
        //更新操作
        billMapper.updateBill(bill);
        return "redirect:bills";
    }
    //前往添加 页面
    @GetMapping("/bill")
    public String toAddPage(Map<String, Object> map) {
        //查询所有供应商
        map.put("providers", providerMapper.getProviders(null));
        return "bill/add";
    }
    //添加数据
    @PostMapping("/bill")
    public String add(Bill bill) {
        logger.info("添加帐单数据" + bill);
        //保存数据操作
        billMapper.addBill(bill);
        return "redirect:/bills";
    }
    //删除
    @DeleteMapping("/bill/{bid}")
    public String delete(@PathVariable("bid") Integer bid) {
        logger.info("删除操作, bid=" + bid);
        billMapper.deteleBillByBid(bid);
        return "redirect:/bills";
    }
}

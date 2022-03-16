package com.simk.controller;

import com.simk.entities.Provider;
import com.simk.mapper.ProviderMapper;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.Collection;
import java.util.Date;
import java.util.List;
import java.util.Map;

@Controller
public class ProviderController {
    @Autowired
    ProviderMapper providerMapper;

    Logger logger = LoggerFactory.getLogger(getClass());

    //跳转-》查询供应商管理
    //    @RequestMapping(value = "/providers",method = RequestMethod.GET)
    @GetMapping("/providers")
    public String list(String providerName, Map<String, Object> map) {
        logger.info("供应商列表查询");
        Provider provider = new Provider();
        provider.setProviderName(providerName);
        List<Provider> providers = providerMapper.getProviders(provider);
        map.put("providers", providers);
//        回写搜索框
        map.put("providerName", providerName);
        return "provider/list";
    }

    //    type=null 默认view详情页面，type=update 修改页面
    @GetMapping("/provider/{pid}")
    public String view(@PathVariable("pid") Integer pid, Map<String, Object> map,
                       @RequestParam(value = "type", defaultValue = "view") String type) {
        logger.info("查询{}的供应商详细信息", pid);
//        Provider provider = providerDao.getProvider(pid);
        Provider providerByPid = providerMapper.getProviderByPid(pid);
        map.put("provider", providerByPid);
        return "provider/" + type;
    }

    //    修改
    @PutMapping("/provider")
    public String update(Provider provider) {
        logger.info("修改provider：{}", provider);
//        providerDao.save(provider);
        int i = providerMapper.updateProvider(provider);
        return "redirect:providers";
    }

    //添加供应商 页面跳转
    @GetMapping("/provider")
    public String toAddPage() {
        //前往添加供应商页面
        return "provider/add";
    }

    //处理添加供应商请求
    @PostMapping("/provider")
    public String addProvider(Provider provider) {
        //SpringMVC会自动将请求参数与形参对象的属性一一绑定
        //要求：请求参数名要与形参对象的属性名相同
        logger.info("添加供应商信息：" + provider);
//        provider.setCreateDate(new Date());
//        providerDao.save(provider);
        int i = providerMapper.addProvider(provider);
        //添加完成,回到供应商列表页面
        //通过redirect重定向 或forward转发到一个请求地址, / 代表当前项目路径
        return "redirect:providers";
    }


    //删除操作
    @DeleteMapping("provider/{pid}")
    public String delete(@PathVariable("pid") Integer pid) {
        logger.info("删除供应商：" + pid);
//        providerDao.delete(pid);
        int i = providerMapper.deleteProvider(pid);
        return "redirect:/providers";
    }
}

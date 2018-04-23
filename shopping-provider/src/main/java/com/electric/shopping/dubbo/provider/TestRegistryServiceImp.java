package com.electric.shopping.dubbo.provider;
import com.electric.dubbo.registry.service.TestRegistryService;

/**
 * @author guoshuai.li
 * @date 2018-04-22 12:19:56
 * @desc 生产者
 */
public class TestRegistryServiceImp implements TestRegistryService {
    public String hello(String name) {
        return "hello"+name;
    }
}

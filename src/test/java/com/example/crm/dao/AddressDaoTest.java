package com.example.crm.dao;

import com.example.crm.entity.Address;
import org.junit.Ignore;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.List;

/**
 * @ Author     ：Bin Liu
 * @ Date       ：2018/11/3 9:28
 * @ Description：
 * @ Modified By：
 */
@RunWith(SpringRunner.class)
@SpringBootTest
public class AddressDaoTest {
    @Autowired
    private AddressDao addressDao;

    @Test
    //@Ignore
    public void getAddress(){
        System.out.println(addressDao.getAddress(1));
    }

    @Test
    //@Ignore
    public void insertAddress(){
        Address address = new Address();
        address.setAddressId(1);
        address.setMailStreet("小谷围街道");
        address.setMailPoBox("邮箱1");
        address.setMailCity("番禺");
        address.setMailCountry("广州");
        address.setMailState("美国");
        address.setOtherStreet("桂岭大道");
        address.setOtherPoBox("邮箱2");
        address.setOtherCity("蕉岭");
        address.setOtherCountry("梅州");
        System.out.println("插入前" + address.getAddressId());
        System.out.println(addressDao.insertAddress(address));
        System.out.println("插入后" + address.getAddressId());
    }

    @Test
    //@Ignore
    public void updateAddress(){
        Address address= addressDao.getAddress(2);
        address.setMailStreet("小谷围街道");
        address.setMailPoBox("邮箱1");
        address.setMailCity("番禺");
        address.setMailCountry("广州");
        address.setMailState("中国");
        address.setOtherStreet("桂岭大道");
        address.setMailPoBox("邮箱2");
        address.setMailCity("蕉岭");
        address.setMailCountry("梅州");
        System.out.println(addressDao.updateAddress(address));
    }

    @Test
    //@Ignore
    public void deleteAddress(){
        System.out.println(addressDao.deleteAddress(1));
    }

}
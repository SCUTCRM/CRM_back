package com.example.crm.dao;

import com.example.crm.entity.Organization;
import com.example.crm.entity.Product;
import com.example.crm.entity.Ticket;
import org.junit.Ignore;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.internal.matchers.Or;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.Date;

import static org.junit.Assert.*;

/**
 * @ Author     ：Bin Liu
 * @ Date       ：2018/11/4 11:53
 * @ Description：${description}
 * @ Modified By：
 */
@RunWith(SpringRunner.class)
@SpringBootTest
public class TicketDaoTest {
    @Autowired
    private TicketDao ticketDao;

    @Test
    //@Ignore
    public void getTicketList() {
        System.out.println(ticketDao.getTicketList());
    }

    @Test
    //@Ignore
    public void getTicket() {
        System.out.println(ticketDao.getTicketById(1));
    }

    @Test
    //@Ignore
    public void insertTicket() {
        Ticket ticket=new Ticket();
        ticket.setTicketId(1);
        ticket.setTitle("thinkpad售后");
        ticket.setStatus(1);
        ticket.setPriority(1);
        ticket.setAssignTo(1);
        ticket.setHourNum("5小时");
        ticket.setCategory("电脑");
        ticket.setCreateTime(new Date());
        ticket.setModifiedTime(new Date());
        ticket.setSeverity(1);
        ticket.setDays(5);
        ticket.setDescription("测试");
        ticket.setUpdateInfo("插入售后服务");
        Organization organization=new Organization();
        organization.setOrganizationId(1);
        ticket.setOrganization(organization);
        Product product=new Product();
        product.setProductId(1);
        ticket.setProduct(product);
        System.out.println(ticketDao.insertTicket(ticket));
    }

    @Test
    //@Ignore
    public void updateTicket() {
        Ticket ticket=ticketDao.getTicketById(2);
        ticket.setTitle("macbookpro售后");
        ticket.setStatus(1);
        ticket.setPriority(1);
        ticket.setAssignTo(1);
        ticket.setHourNum("5小时");
        ticket.setCategory("电脑");
        ticket.setCreateTime(new Date());
        ticket.setModifiedTime(new Date());
        ticket.setSeverity(1);
        ticket.setDays(5);
        ticket.setDescription("测试");
        ticket.setUpdateInfo("更改售后服务");
        Organization organization=new Organization();
        organization.setOrganizationId(1);
        ticket.setOrganization(organization);
        Product product=new Product();
        product.setProductId(1);
        ticket.setProduct(product);
        System.out.println(ticketDao.updateTicket(ticket));
    }

    @Test
    //@Ignore
    public void deleteTicket() {
        System.out.println(ticketDao.deleteTicket(2));
    }
}
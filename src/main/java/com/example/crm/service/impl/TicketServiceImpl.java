package com.example.crm.service.impl;

import com.example.crm.dao.TicketDao;
import com.example.crm.entity.Ticket;
import com.example.crm.exception.TicketException;
import com.example.crm.service.TicketService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * @ Author     ：Bin Liu
 * @ Date       ：2018/11/1 15:22
 * @ Description：售后业务逻辑实现类
 * @ Modified By：
 */
@Service
public class TicketServiceImpl implements TicketService {
    @Autowired
    private TicketDao ticketDao;

    @Override
    public List<Ticket> getTicketList() {
        return ticketDao.getTicketList();
    }

    @Override
    public Ticket getTicketById(Integer ticketId) {
        return ticketDao.getTicketById(ticketId);
    }

    @Override
    public Ticket getTicket(Ticket ticket) {
        return ticketDao.getTicket(ticket);
    }

    @Transactional
    @Override
    public int insertTicket(Ticket ticket) {
        if (ticket == null) {
            return 0;
        }
        try {
            int result = ticketDao.insertTicket(ticket);
            return result;
        } catch (Exception e) {
            throw new TicketException("插入售后失败", -1);
        }
    }

    @Transactional
    @Override
    public int updateTicket(Ticket ticket) {
        if (ticket == null || ticket.getTicketId() == null) {
            return 0;
        }
        try {
            int result = ticketDao.updateTicket(ticket);
            return result;
        } catch (Exception e) {
            throw new TicketException("更新售后失败", -1);
        }
    }

    @Transactional
    @Override
    public int deleteTicket(Integer ticketId) {
        if (ticketId == null) {
            return 0;
        }
        try {
            int result = ticketDao.deleteTicket(ticketId);
            return result;
        } catch (Exception e) {
            throw new TicketException("删除售后失败", -2);
        }
    }

    @Override
    public List<Ticket> getRecentlyModified() {
        return ticketDao.getRecentlyModified();
    }

    @Override
    public Ticket getUpdateInfo(Integer ticketId) {
        return ticketDao.getUpdateInfo(ticketId);
    }

    @Override
    public Ticket getTicketByProductId(Integer productId) {
        return ticketDao.getTicketByProductId(productId);
    }

    @Override
    public Ticket getTicketByOrganizationId(Integer organizationId) {
        return ticketDao.getTicketByOrganizationId(organizationId);
    }
}

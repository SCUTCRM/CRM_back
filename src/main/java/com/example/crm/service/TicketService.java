package com.example.crm.service;

import com.example.crm.entity.Ticket;

import java.util.List;

/**
 * @ Author     ：Bin Liu
 * @ Date       ：2018/11/1 10:55
 * @ Description：售后业务逻辑接口
 * @ Modified By：
 */
public interface TicketService {
    List<Ticket> getTicketList();

    Ticket getTicketById(Integer ticketId);

    Ticket getTicket(Ticket ticket);

    int insertTicket(Ticket ticket);

    int updateTicket(Ticket ticket);

    int deleteTicket(Integer ticketId);

    List<Ticket> getRecentlyModified();

    Ticket getUpdateInfo(Integer ticketId);

    Ticket getTicketByProductId(Integer productId);
}

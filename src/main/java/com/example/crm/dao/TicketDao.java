package com.example.crm.dao;

import com.example.crm.entity.Ticket;
import org.springframework.stereotype.Component;

import java.util.List;

/**
 * @ Author     ：Bin Liu
 * @ Date       ：2018/11/1 10:27
 * @ Description：售后服务数据库访问层接口
 * @ Modified By：
 */
@Component
public interface TicketDao {
    /**
     * create by: Bin Liu
     * description: 获取所有的售后服务信息
     * create time: 2018/11/1 10:30
     *
     * @return
     * @Param: null
     */
    List<Ticket> getTicketList();

    /**
     * create by: Bin Liu
     * description: 根据id获取售后服务信息
     * create time: 2018/11/1 10:34
     *
     * @return
     * @Param: null
     */
    Ticket getTicket(Integer ticketId);

    /**
     * create by: Bin Liu
     * description: 插入一条售后服务信息
     * create time: 2018/11/1 10:36
     *
     * @return
     * @Param: null
     */
    int insertTicket(Ticket ticket);

    /**
     * create by: Bin Liu
     * description: 更新一条售后服务信息
     * create time: 2018/11/1 10:36
     *
     * @return
     * @Param: null
     */
    int updateTicket(Ticket ticket);

    /**
     * create by: Bin Liu
     * description: 删除一条售后服务信息
     * create time: 2018/11/1 10:37
     *
     * @return
     * @Param: null
     */
    int deleteTicket(Integer ticketId);
}

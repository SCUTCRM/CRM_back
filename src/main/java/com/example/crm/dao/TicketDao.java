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
    Ticket getTicketById(Integer ticketId);

    /**
     * create by: Bin Liu
     * description: 动态获取售后服务
     * create time: 2018/11/8 23:22
     * @Param: null
     * @return 
     */
    Ticket getTicket(Ticket ticket);
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
    
    /**
     * create by: Bin Liu
     * description: 根据id获取更新信息
     * create time: 2018/11/6 22:48
     * @Param: null
     * @return 
     */
    List<Ticket> getRecentlyModified();

    /**
     * create by: Bin Liu
     * description: 获取更新信息
     * create time: 2018/11/12 23:13
     * @Param: null
     * @return
     */
    Ticket getUpdateInfo(Integer ticketId);


    /**
     * create by: Bin Liu
     * description: 查看相关的售后信息
     * create time: 2018/11/14 19:54
     * @Param: null
     * @return
     */
    Ticket getTicketByProductId(Integer productId);
}

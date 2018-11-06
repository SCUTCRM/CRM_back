package com.example.crm.web;

import com.example.crm.dto.ProductDto;
import com.example.crm.dto.TicketDto;
import com.example.crm.entity.Product;
import com.example.crm.entity.Ticket;
import com.example.crm.enums.SystemErrorEnum;
import com.example.crm.exception.ProductException;
import com.example.crm.service.TicketService;
import com.example.crm.util.HttpServletRequestUtil;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

/**
 * @ Author     ：Bin Liu
 * @ Date       ：2018/11/1 16:57
 * @ Description：售后操作相关控制层类
 * @ Modified By：
 */
@RestController
@RequestMapping("")
public class TicketController {
    @Autowired
    private TicketService ticketService;

    //获取售后信息
    @GetMapping("/ticket/tickets")
    private HashMap<String, Object> listTicket() {
        HashMap<String, Object> resultMap = new HashMap<>();
        try {
            List<Ticket> ticketList = ticketService.getTicketList();
            //前端只能识别字段为value的值
            List<TicketDto> tickets = new ArrayList<>();
            for (Ticket t : ticketList) {
                TicketDto tto = new TicketDto();
                tto.setValue(t.getTitle());
                tto.setId(t.getTicketId());
                tickets.add(tto);
            }
            resultMap.put("tickets", tickets);
            resultMap.put("success", true);
            resultMap.put("code", 200);
            resultMap.put("msg", "数据获取成功");
        } catch (Exception ex) {
            resultMap.put("success", false);
            resultMap.put("code", -200);
            resultMap.put("msg", SystemErrorEnum.SYSTEM_INNER_ERROR.getMsg());
        }
        return resultMap;
    }

    @GetMapping("/ticket/getTicket")
    private HashMap<String, Object> getTicket(HttpServletRequest request) {
        HashMap<String, Object> resultMap = new HashMap<>();
        try {
            int ticketId = HttpServletRequestUtil.getInt(request, "ticketId");
            Ticket ticket = ticketService.getTicket(ticketId);
            resultMap.put("ticket", ticket);
            resultMap.put("success", true);
            resultMap.put("code", 200);
            resultMap.put("msg", "数据获取成功");
        } catch (Exception ex) {
            resultMap.put("success", false);
            resultMap.put("code", -200);
            resultMap.put("msg", SystemErrorEnum.SYSTEM_INNER_ERROR.getMsg());
        }
        return resultMap;
    }

    @PostMapping("/ticket/insert")
    private HashMap<String, Object> insertTicket(HttpServletRequest request) {
        HashMap<String, Object> resultMap = new HashMap<>();
        //1.获取ticket对应的json字符串
        String ticketStr = HttpServletRequestUtil.getString(request, "ticket");
        ObjectMapper mapper = new ObjectMapper();
        Ticket ticket = null;
        try {
            ticket = mapper.readValue(ticketStr, Ticket.class);
        } catch (Exception e) {
            resultMap.put("success", false);
            resultMap.put("msg", SystemErrorEnum.SYSTEM_INNER_ERROR.getMsg());
            return resultMap;
        }
        try {
            int result = ticketService.insertTicket(ticket);
            if (result == 1) {
                resultMap.put("success", false);
                resultMap.put("msg", "保存成功");
            } else {
                resultMap.put("success", true);
                resultMap.put("msg", "保存失败");
            }
        } catch (RuntimeException e) {
            resultMap.put("success", false);
            resultMap.put("msg", e.getMessage());
        }
        return resultMap;
    }

    @PostMapping("/tickets/update")
    private HashMap<String, Object> updateTicket(HttpServletRequest request) {
        HashMap<String, Object> resultMap = new HashMap<>();
        //1.将前端传过来的售后服务json字符串转换成实体类
        ObjectMapper mapper = new ObjectMapper();
        String ticketStr = HttpServletRequestUtil.getString(request, "ticket");
        Ticket ticket = null;
        try {
            ticket = mapper.readValue(ticketStr, Ticket.class);
        } catch (Exception e) {
            resultMap.put("success", false);
            resultMap.put("msg", SystemErrorEnum.SYSTEM_INNER_ERROR.getMsg());
            return resultMap;
        }
        //2.更新售后服务信息
        try {
            int result = ticketService.updateTicket(ticket);
            if (result == 1) {
                resultMap.put("success", true);
                resultMap.put("msg", "售后服务更新成功");
            } else {
                resultMap.put("success", false);
                resultMap.put("msg", "售后服务更新失败");
            }
        } catch (ProductException e) {
            resultMap.put("success", false);
            resultMap.put("msg", e.getMessage());
        }
        return resultMap;
    }

    @PostMapping("/ticket/delete")
    private HashMap<String, Object> deleteTicket(HttpServletRequest request) {
        HashMap<String, Object> resultMap = new HashMap<>();
        int ticketId = HttpServletRequestUtil.getInt(request, "ticketId");
        try {
            int result = ticketService.deleteTicket(ticketId);
            if (result == 1) {
                resultMap.put("success", false);
                resultMap.put("msg", "删除成功");
            } else {
                resultMap.put("success", true);
                resultMap.put("msg", "删除失败");
            }
        } catch (RuntimeException e) {
            resultMap.put("success", false);
            resultMap.put("msg", e.getMessage());
        }
        return resultMap;
    }
}

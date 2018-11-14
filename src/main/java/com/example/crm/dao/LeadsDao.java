package com.example.crm.dao;

import com.example.crm.entity.Leads;
import org.springframework.stereotype.Component;

import java.util.List;

/**
 * @ Author     ：Bin Liu
 * @ Date       ：2018/11/1 10:03
 * @ Description：潜在用户数据库访问层接口
 * @ Modified By：
 */
@Component
public interface LeadsDao {
    /**
     * create by: Bin Liu
     * description: 获取所有的潜在客户信息
     * create time: 2018/11/1 10:09
     *
     * @return
     * @Param: null
     */
    List<Leads> getLeadsList();

    /**
     * create by: Bin Liu
     * description: 根据id获取潜在客户信息
     * create time: 2018/11/1 10:19
     *
     * @return
     * @Param: null @Param: null
     */
    Leads getLeadsById(Integer leadId);

    /**
     * create by: Bin Liu
     * description: 增加一条潜在客户信息
     * create time: 2018/11/1 10:09
     *
     * @return
     * @Param: null
     */
    int insertLeads(Leads leads);

    /**
     * create by: Bin Liu
     * description: 更新一个潜在客户信息
     * create time: 2018/11/1 10:10
     *
     * @return
     * @Param: null
     */
    int updateLeads(Leads leads);

    /**
     * create by: Bin Liu
     * description: 删除一个潜在客户信息
     * create time: 2018/11/1 10:11
     *
     * @return
     * @Param: null
     * @Param: null
     */
    int deleteLeads(Integer leadId);

    /**
     * create by: Bin Liu
     * description: 根据id获取更新信息
     * create time: 2018/11/6 22:47
     *
     * @return
     * @Param: null
     */
    List<Leads> getRecentlyModified();

    /**
     * create by: Bin Liu
     * description: 动态获取更新信息
     * create time: 2018/11/8 10:36
     *
     * @return
     * @Param: null
     */
    Leads getLeads(Leads leads);

    /**
     * create by: Bin Liu
     * description: 获取更新信息
     * create time: 2018/11/12 23:12
     * @Param: null
     * @return 
     */
    Leads getUpdateInfo(Integer leadId);
}

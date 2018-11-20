package com.example.crm.dao;

import com.example.crm.entity.Campaign;
import org.springframework.stereotype.Component;

import java.util.List;

/**
 * @ Author     ：Bin Liu
 * @ Date       ：2018/11/1 9:56
 * @ Description：活动数据库访问层接口
 * @ Modified By：
 */
@Component
public interface CampaignDao {
    /**
     * create by: Bin Liu
     * description: 获取所有的活动信息
     * create time: 2018/11/1 9:57
     *
     * @return
     * @Param: null
     */
    List<Campaign> getCampaignList();

    /**
     * create by: Bin Liu
     * description: 根据id获取活动信息
     * create time: 2018/11/1 10:17
     *
     * @return
     * @Param: null
     */
    Campaign getCampaignById(Integer campaignId);

    /**
     * create by: Bin Liu
     * description: 根据OrganizationId获取活动信息
     * create time: 2018/11/17 15:51
     * @Param: null
     * @return
     */
    Campaign getCampaignByOrganizationId(Integer organizationId);
    /**
     * create by: Bin Liu
     * description: 动态获取活动信息
     * create time: 2018/11/8 23:22
     * @Param: null
     * @return 
     */
    Campaign getCampaign(Campaign campaign);

    /**
     * create by: Bin Liu
     * description: 增加一个Campaign信息
     * create time: 2018/11/1 9:58
     *
     * @return
     * @Param: null
     */
    int insertCampaign(Campaign campaign);

    /**
     * create by: Bin Liu
     * description: 更新一个Campaign信息
     * create time: 2018/11/1 9:59
     *
     * @return
     * @Param: null
     */
    int updateCampaign(Campaign campaign);

    /**
     * create by: Bin Liu
     * description: 删除一个活动信息
     * create time: 2018/11/1 9:58
     *
     * @return
     * @Param: null
     */
    int deleteCampaign(Integer campaignId);

    /**
     * create by: Bin Liu
     * description: 获取最近更新信息
     * create time: 2018/11/6 22:49
     * @Param: null
     * @return 
     */
    List<Campaign> getRecentlyModified();

    /**
     * create by: Bin Liu
     * description: 获取更新信息
     * create time: 2018/11/12 23:07
     * @Param: null
     * @return
     */
    Campaign getUpdateInfo(Integer campaignId);

    /**
     * create by: Bin Liu
     * description: 通过productId获得获得信息
     * create time: 2018/11/20 21:49
     * @Param: null
     * @return 
     */
    Campaign getCampaignByProductId(Integer productId);
}

package com.example.crm.dao;

import com.example.crm.entity.Document;
import org.springframework.stereotype.Component;

import java.util.List;

/**
 * @ Author     ：Bin Liu
 * @ Date       ：2018/11/15 15:20
 * @ Description：文件数据库访问层接口
 * @ Modified By：
 */
@Component
public interface DocumentDao {
    /**
     * create by: Bin Liu
     * description: 获取所有的文件信息
     * create time: 2018/11/15 15:24
     * @Param: null
     * @return 
     */
    List<Document> getDocumentList();

    /**
     * create by: Bin Liu
     * description: 根据id获取文件信息
     * create time: 2018/11/15 15:25
     * @Param: null
     * @return 
     */
    Document getDocumentById(Integer documentId);

    /**
     * create by: Bin Liu
     * description: 动态获取文件信息
     * create time: 2018/11/15 15:25
     * @Param: null
     * @return 
     */
    Document getDocument(Document document);

    /**
     * create by: Bin Liu
     * description: 插入一个文件信息
     * create time: 2018/11/15 15:25
     * @Param: null
     * @return 
     */
    int insertDocument(Document document);

    /**
     * create by: Bin Liu
     * description: 更新一个文件信息
     * create time: 2018/11/15 15:25
     * @Param: null
     * @return
     */
    int updateDocument(Document document);

    /**
     * create by: Bin Liu
     * description: 删除一个文件信息
     * create time: 2018/11/15 15:25
     * @Param: null
     * @return
     */
    int deleteDocument(Integer documentId);

    /**
     * create by: Bin Liu
     * description: 获取最近更新信息
     * create time: 2018/11/15 15:26
     * @Param: null
     * @return
     */
    List<Document> getRecentlyModified();

    /**
     * create by: Bin Liu
     * description: 根据id获取更新信息
     * create time: 2018/11/15 15:26
     * @Param: null
     * @return
     */
    Document getUpdateInfo(Integer documentId);
}

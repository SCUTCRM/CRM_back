package com.example.crm.dao;

import com.example.crm.entity.Document;
import org.junit.Ignore;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.Date;

import static org.junit.Assert.*;

/**
 * @ Author     ：Bin Liu
 * @ Date       ：2018/11/15 15:43
 * @ Description：${description}
 * @ Modified By：
 */
@RunWith(SpringRunner.class)
@SpringBootTest
public class DocumentDaoTest {
    @Autowired
    private DocumentDao documentDao;

    @Test
    //@Ignore
    public void getDocumentList() {
        System.out.println(documentDao.getDocumentList());
    }

    @Test
    //@Ignore
    public void getDocumentById() {
        System.out.println(documentDao.getDocumentById(1));
    }

    @Test
    //@Ignore
    public void getDocument() {
        Document document=new Document();
        document.setTitle("数据挖掘比赛");
        document.setFileName("数据挖掘");
        //document.setModifiedTime(new Date());
        document.setAssignTo(1);
        System.out.println(documentDao.getDocument(document));
    }

    @Test
    //@Ignore
    public void insertDocument() {
        Document document=new Document();
        document.setTitle("数据挖掘比赛");
        document.setFileName("数据挖掘");
        document.setDocumentNo(1);
        document.setCreateTime(new Date());
        document.setModifiedTime(new Date());
        document.setAssignTo(1);
        document.setUpdateInfo("插入文件");
        document.setDescription("测试");
        System.out.println(documentDao.insertDocument(document));
    }

    @Test
    //@Ignore
    public void updateDocument() {
        Document document=documentDao.getDocumentById(2);
        document.setTitle("数据挖掘比赛");
        document.setFileName("机器学习");
        document.setDocumentNo(2);
        document.setCreateTime(new Date());
        document.setModifiedTime(new Date());
        document.setAssignTo(1);
        document.setUpdateInfo("修改文件");
        document.setDescription("测试");
        System.out.println(documentDao.updateDocument(document));
    }

    @Test
    //@Ignore
    public void deleteDocument() {
        System.out.println(documentDao.deleteDocument(2));
    }

    @Test
    //@Ignore
    public void getRecentlyModified() {
        System.out.println(documentDao.getRecentlyModified());
    }

    @Test
    //@Ignore
    public void getUpdateInfo() {
        System.out.println(documentDao.getUpdateInfo(1));
    }
}
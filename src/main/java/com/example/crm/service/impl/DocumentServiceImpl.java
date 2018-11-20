package com.example.crm.service.impl;

import com.example.crm.dao.DocumentDao;
import com.example.crm.entity.Document;
import com.example.crm.service.DocumentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * @ Author     ：Bin Liu
 * @ Date       ：2018/11/20 16:35
 * @ Description：文件业务逻辑实现类
 * @ Modified By：
 */
@Service
public class DocumentServiceImpl implements DocumentService {
    @Autowired
    private DocumentDao documentDao;

    @Override
    public List<Document> getDocumentList() {
        return documentDao.getDocumentList();
    }

    @Override
    public Document getDocumentById(Integer documentId) {
        return documentDao.getDocumentById(documentId);
    }

    @Override
    public Document getDocument(Document document) {
        return documentDao.getDocument(document);
    }

    @Transactional
    @Override
    public int insertDocument(Document document) {
        if (document == null) {
            return 0;
        }
        try {
            int result = documentDao.insertDocument(document);
            return result;
        } catch (Exception e) {
            throw new RuntimeException("插入文档失败");
        }
    }

    @Transactional
    @Override
    public int updateDocument(Document document) {
        if (document == null || document.getDocumentId() == null) {
            return 0;
        }
        try {
            int result = documentDao.updateDocument(document);
            return result;
        } catch (Exception e) {
            throw new RuntimeException("更新文档失败");
        }
    }

    @Transactional
    @Override
    public int deleteDocument(Integer documentId) {
        if (documentId == null) {
            return 0;
        }
        try {
            int result = documentDao.deleteDocument(documentId);
            return result;
        } catch (Exception e) {
            throw new RuntimeException("删除文档失败");
        }
    }

    @Override
    public List<Document> getRecentlyModified() {
        return documentDao.getRecentlyModified();
    }

    @Override
    public Document getUpdateInfo(Integer ticketId) {
        return documentDao.getUpdateInfo(ticketId);
    }
}

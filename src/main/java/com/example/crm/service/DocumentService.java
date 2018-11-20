package com.example.crm.service;

import com.example.crm.entity.Document;

import java.util.List;

/**
 * @ Author     ：Bin Liu
 * @ Date       ：2018/11/20 16:34
 * @ Description：文件业务逻辑接口
 * @ Modified By：
 */
public interface DocumentService {
    List<Document> getDocumentList();

    Document getDocumentById(Integer documentId);

    Document getDocument(Document document);

    int insertDocument(Document document);

    int updateDocument(Document document);

    int deleteDocument(Integer documentId);

    List<Document> getRecentlyModified();

    Document getUpdateInfo(Integer ticketId);
}

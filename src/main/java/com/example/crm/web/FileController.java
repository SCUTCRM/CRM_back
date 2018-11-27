package com.example.crm.web;

import com.example.crm.contants.FilePathContants;
import com.example.crm.enums.SystemErrorEnum;

import com.example.crm.exception.SystemException;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.ServletOutputStream;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileInputStream;

/**
 * @ Author     ：Bin Liu
 * @ Date       ：2018/11/26 20:02
 * @ Description：处理文件相关的控制层类
 * @ Modified By：
 */
@Controller
@RequestMapping("")
public class FileController {
    @ResponseBody
    @GetMapping("/Document")
    private void fileStreamHandle(String fileName, HttpServletRequest request, HttpServletResponse response) {
        String rootPath = request.getServletContext().getRealPath("/");
        fileName = (rootPath + fileName).replace("/",FilePathContants.SEPARATOR);
        File file = new File(fileName);
        if (file.exists()) {
            byte[] data = null;
            BufferedInputStream bis = null;
            BufferedOutputStream bos = null;
            try {
                response.setHeader("content-type", "application/vnd.ms-excel;charset=utf-8");
                response.setContentType("application/vnd.ms-excel;charset=utf-8");
                String name = fileName.substring(fileName.lastIndexOf(FilePathContants.SEPARATOR) + 1);
                response.setHeader("Content-Disposition", "attachment;filename=" + new String(name.getBytes(),"iso-8859-1"));
                //允许跨域访问
                response.setHeader("Access-Control-Allow-Origin","http://localhost:8080");
                response.setHeader("Access-Control-Allow-Methods","GET");
                response.setHeader("Access-Control-Allow-Credentials","true");

                FileInputStream input = new FileInputStream(file);
                ServletOutputStream out = response.getOutputStream();
                bis = new BufferedInputStream(input);
                bos = new BufferedOutputStream(out);
                byte[] buff = new byte[2048];
                int bytesRead;
                // Simple read/write loop.
                while (-1 != (bytesRead = bis.read(buff, 0, buff.length))) {
                    bos.write(buff, 0, bytesRead);
                }
                bis.close();
                bos.close();
                input.close();
                out.flush();
                response.flushBuffer();
                //response.flushBuffer();
            }catch (Exception e) {
                throw new SystemException(SystemErrorEnum.SYSTEM_INNER_ERROR.getMsg(),SystemErrorEnum.SYSTEM_INNER_ERROR.getCode());            }
        }
    }
}

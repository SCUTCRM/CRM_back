package com.example.crm.web;

import com.example.crm.entity.Product;
import com.example.crm.enums.SystemErrorEnum;
import com.example.crm.exception.ProductException;
import com.example.crm.service.ProductService;
import com.example.crm.util.HttpServletRequestUtil;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;
import java.util.HashMap;

/**
 * @ Author     ：Bin Liu
 * @ Date       ：2018/10/31 20:53
 * @ Description：产品操作相关控制层类
 * @ Modified By：
 */
@RequestMapping("")
@RestController
public class ProductController {
    @Autowired
    private ProductService productService;

    @PostMapping("/products/update")
    private HashMap<String,Object> updateProduct(HttpServletRequest request) {
        HashMap<String,Object> resultMap = new HashMap<>();
        //1.将前端传过来的产品json字符串转换成实体类
        ObjectMapper mapper = new ObjectMapper();
        String productStr = HttpServletRequestUtil.getString(request,"product");
        Product product = null;
        try {
            product = mapper.readValue(productStr,Product.class);
        } catch (Exception e) {
            resultMap.put("success",false);
            resultMap.put("msg", SystemErrorEnum.SYSTEM_INNER_ERROR.getMsg());
            return resultMap;
        }
        //2.更新产品信息
        try {
            int result = productService.updateProduct(product);
            if (result == 1) {
                resultMap.put("success",true);
                resultMap.put("msg", "产品更新成功");
            } else {
                resultMap.put("success",false);
                resultMap.put("msg", "产品更新失败");
            }
        } catch (ProductException e) {
            resultMap.put("success",false);
            resultMap.put("msg", e.getMessage());
        }
        return resultMap;
    }
}

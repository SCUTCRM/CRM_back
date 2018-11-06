package com.example.crm.web;

import com.example.crm.dto.ProductDto;
import com.example.crm.entity.Product;
import com.example.crm.enums.SystemErrorEnum;
import com.example.crm.exception.ProductException;
import com.example.crm.service.ProductService;
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
 * @ Date       ：2018/10/31 20:53
 * @ Description：产品操作相关控制层类
 * @ Modified By：
 */
@RestController
@RequestMapping("")
public class ProductController {
    @Autowired
    private ProductService productService;

    //获取产品信息
    @GetMapping("product/products")
    private HashMap<String, Object> listProduct() {
        HashMap<String, Object> resultMap = new HashMap<>();
        try {
            List<Product> productList = productService.getProductList();
            //前端只能识别字段为value的值
            List<ProductDto> products = new ArrayList<>();
            for (Product p : productList) {
                ProductDto pto = new ProductDto();
                pto.setValue(p.getProductName());
                pto.setId(p.getProductId());
                products.add(pto);
            }
            resultMap.put("products", products);
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

    @GetMapping("/product/getProductById")
    private HashMap<String, Object> getProductById(HttpServletRequest request) {
        HashMap<String, Object> resultMap = new HashMap<>();
        try {
            int productId = HttpServletRequestUtil.getInt(request, "productId");
            Product product = productService.getProductById(productId);
            resultMap.put("product", product);
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

    @GetMapping("/product/getProductByProductName")
    private HashMap<String, Object> getProductProductName(HttpServletRequest request) {
        HashMap<String, Object> resultMap = new HashMap<>();
        try {
            String productName = HttpServletRequestUtil.getString(request, "productName");
            Product product = productService.getProductByProductName(productName);
            resultMap.put("product", product);
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

    @GetMapping("/product/getProductByPartNumber")
    private HashMap<String, Object> getProductPartNumber(HttpServletRequest request) {
        HashMap<String, Object> resultMap = new HashMap<>();
        try {
            int partNumber = HttpServletRequestUtil.getInt(request, "partNumber");
            Product product = productService.getProductByPartNumber(partNumber);
            resultMap.put("product", product);
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

    @GetMapping("/product/getProductByCommissionRate")
    private HashMap<String, Object> getProductCommissionRate(HttpServletRequest request) {
        HashMap<String, Object> resultMap = new HashMap<>();
        try {
            Double commissionRate = HttpServletRequestUtil.getDouble(request, "commissionRate");
            Product product = productService.getProductByCommissionRate(commissionRate);
            resultMap.put("product", product);
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

    @GetMapping("/product/getProductByQtyInStock")
    private HashMap<String, Object> getProductByQtyInStock(HttpServletRequest request) {
        HashMap<String, Object> resultMap = new HashMap<>();
        try {
            int qtyInStock = HttpServletRequestUtil.getInt(request, "qtyInStock");
            Product product = productService.getProductByQtyInStock(qtyInStock);
            resultMap.put("product", product);
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

    @GetMapping("/product/getProductByUnit")
    private HashMap<String, Object> getProductByUnit(HttpServletRequest request) {
        HashMap<String, Object> resultMap = new HashMap<>();
        try {
            int unit = HttpServletRequestUtil.getInt(request, "unit");
            Product product = productService.getProductByQtyUnit(unit);
            resultMap.put("product", product);
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

    @GetMapping("/product/getProductByUnitPrice")
    private HashMap<String, Object> getProductByUnitPrice(HttpServletRequest request) {
        HashMap<String, Object> resultMap = new HashMap<>();
        try {
            Double unitPrice = HttpServletRequestUtil.getDouble(request, "unitPrice");
            Product product = productService.getProductByUnitPrice(unitPrice);
            resultMap.put("product", product);
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

    @PostMapping("/product/insert")
    private HashMap<String, Object> insertProduct(HttpServletRequest request) {
        HashMap<String, Object> resultMap = new HashMap<>();
        //1.获取product对应的json字符串
        String productStr = HttpServletRequestUtil.getString(request, "product");
        ObjectMapper mapper = new ObjectMapper();
        Product product = null;
        try {
            product = mapper.readValue(productStr, Product.class);
        } catch (Exception e) {
            resultMap.put("success", false);
            resultMap.put("msg", SystemErrorEnum.SYSTEM_INNER_ERROR.getMsg());
            return resultMap;
        }
        try {
            int result = productService.insertProduct(product);
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

    @PostMapping("/product/update")
    private HashMap<String, Object> updateProduct(HttpServletRequest request) {
        HashMap<String, Object> resultMap = new HashMap<>();
        //1.将前端传过来的产品json字符串转换成实体类
        ObjectMapper mapper = new ObjectMapper();
        String productStr = HttpServletRequestUtil.getString(request, "product");
        Product product = null;
        try {
            product = mapper.readValue(productStr, Product.class);
        } catch (Exception e) {
            resultMap.put("success", false);
            resultMap.put("msg", SystemErrorEnum.SYSTEM_INNER_ERROR.getMsg());
            return resultMap;
        }
        //2.更新产品信息
        try {
            int result = productService.updateProduct(product);
            if (result == 1) {
                resultMap.put("success", true);
                resultMap.put("msg", "产品更新成功");
            } else {
                resultMap.put("success", false);
                resultMap.put("msg", "产品更新失败");
            }
        } catch (ProductException e) {
            resultMap.put("success", false);
            resultMap.put("msg", e.getMessage());
        }
        return resultMap;
    }

    @PostMapping("/product/delete")
    private HashMap<String, Object> deleteProduct(HttpServletRequest request) {
        HashMap<String, Object> resultMap = new HashMap<>();
        int productId = HttpServletRequestUtil.getInt(request, "productId");
        try {
            int result = productService.deleteProduct(productId);
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

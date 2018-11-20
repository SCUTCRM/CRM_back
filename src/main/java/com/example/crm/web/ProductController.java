package com.example.crm.web;

import com.example.crm.dao.PriceDao;
import com.example.crm.dao.StockInfoDao;
import com.example.crm.dto.ProductDto;
import com.example.crm.entity.*;
import com.example.crm.enums.SystemErrorEnum;
import com.example.crm.exception.ProductException;
import com.example.crm.service.*;
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
    @Autowired
    private OpportunityService opportunityService;
    @Autowired
    private OrganizationService organizationService;
    @Autowired
    private TicketService ticketService;
    @Autowired
    private LeadsService leadsService;
    @Autowired
    private DocumentService documentService;
    @Autowired
    private ContactService contactService;
    @Autowired
    private PriceDao priceDao;
    @Autowired
    private StockInfoDao stockInfoDao;

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

    @GetMapping("/product/getProduct")
    private HashMap<String, Object> getProduct(HttpServletRequest request) {
        HashMap<String, Object> resultMap = new HashMap<>();
        try {
            Product product=new Product();
            String productName = HttpServletRequestUtil.getString(request, "productName");
            Integer partNumber =  HttpServletRequestUtil.getInt(request, "partNumber");
            Price price1=new Price();
            Double unitPrice = HttpServletRequestUtil.getDouble(request, "unitPrice");
            price1.setUnitPrice(unitPrice);
            Double commissionRate = HttpServletRequestUtil.getDouble(request, "commissionRate");
            price1.setCommissionRate(commissionRate);
            Price price=priceDao.getPrice(price1);
            product.setPrice(price);
            StockInfo stockInfo1=new StockInfo();
            Integer qtyInStock= HttpServletRequestUtil.getInt(request, "qtyInStock");
            stockInfo1.setQtyInStock(qtyInStock);
            Integer unit= HttpServletRequestUtil.getInt(request, "unit");
            stockInfo1.setUnit(unit);
            StockInfo stockInfo=stockInfoDao.getStockInfo(stockInfo1);
            product.setStockInfo(stockInfo);
            List<Product> products = productService.getProduct(product);
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

    @GetMapping("product/recentlyModified")
    private HashMap<String, Object> getRecentlyModified() {
        HashMap<String, Object> resultMap = new HashMap<>();
        try {
            List<Product> productList = productService.getRecentlyModified();
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

    //获取产品信息
    @GetMapping("product/getUpdateInfo")
    private HashMap<String, Object> getUpdateInfo(HttpServletRequest request) {
        HashMap<String, Object> resultMap = new HashMap<>();
        try {
            int productId = HttpServletRequestUtil.getInt(request, "productId");
            Product product = productService.getUpdateInfo(productId);
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

    @GetMapping("product/getOpportunityByProductId")
    private HashMap<String, Object> getOpportunityByProductId(HttpServletRequest request) {
        HashMap<String, Object> resultMap = new HashMap<>();
        try {
            int productId = HttpServletRequestUtil.getInt(request, "productId");
            Organization organization=organizationService.getOrganizationByProductId(productId);
            Contact contact= contactService.getContactByOrganizationId(organization.getOrganizationId());
            Opportunity opportunity=opportunityService.getOpportunityByContactId(contact.getContactId());
            resultMap.put("opportunity", opportunity);
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

    @GetMapping("product/getLeadsByProductId")
    private HashMap<String, Object> getLeadsByProductId(HttpServletRequest request) {
        HashMap<String, Object> resultMap = new HashMap<>();
        try {
            int productId = HttpServletRequestUtil.getInt(request, "productId");
            Leads leads = leadsService.getLeadsByProductId(productId);
            resultMap.put("leads", leads);
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

    @GetMapping("product/getOrganizationByProductId")
    private HashMap<String, Object> getOrganizationByProductId(HttpServletRequest request) {
        HashMap<String, Object> resultMap = new HashMap<>();
        try {
            int productId = HttpServletRequestUtil.getInt(request, "productId");
            Organization organization = organizationService.getOrganizationByProductId(productId);
            resultMap.put("organization", organization);
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

    @GetMapping("product/getTicketByProductId")
    private HashMap<String, Object> getContactByTicketId(HttpServletRequest request) {
        HashMap<String, Object> resultMap = new HashMap<>();
        try {
            int productId = HttpServletRequestUtil.getInt(request, "productId");
            Ticket ticket = ticketService.getTicketByProductId(productId);
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

    @GetMapping("product/getContactByProductId")
    private HashMap<String, Object> getContactByProductId(HttpServletRequest request) {
        HashMap<String, Object> resultMap = new HashMap<>();
        try {
            int productId = HttpServletRequestUtil.getInt(request, "productId");
            Organization organization=organizationService.getOrganizationByProductId(productId);
            Contact contact=contactService.getContactByOrganizationId(organization.getOrganizationId());
            resultMap.put("contact", contact);
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

    @GetMapping("product/getDocumentByProductId")
    private HashMap<String, Object> getDocumentByProductId(HttpServletRequest request) {
        HashMap<String, Object> resultMap = new HashMap<>();
        try {
            int productId = HttpServletRequestUtil.getInt(request, "productId");
            Product product=productService.getProductById(productId);
            Document document=documentService.getDocumentById(product.getDocument().getDocumentId());
            resultMap.put("document", document);
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
}

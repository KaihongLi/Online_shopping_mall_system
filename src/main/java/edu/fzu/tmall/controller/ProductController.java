
package edu.fzu.tmall.controller;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import com.github.pagehelper.PageInfo;
import edu.fzu.tmall.pojo.Product;
import edu.fzu.tmall.service.CategoryService;
import edu.fzu.tmall.service.ProductService;
import edu.fzu.tmall.util.Page;


@Controller
@RequestMapping("/product")
public class ProductController {
    @Autowired
    CategoryService categoryService;
    @Autowired
    ProductService productService;

    @RequestMapping("/add")
    public String add(Model model, Product p) {
        productService.add(p);
        return "redirect:admin_product_list?cid="+p.getCategory().getId();
    }

    @RequestMapping("/delete")
    public String delete(int id) {
        return "";
    }

    @RequestMapping("/edit")
    public String edit(Model model, int id) {
        Map map = productService.edit(id);
        model.addAttribute("product", map.get("product"));
        model.addAttribute("categories", map.get("categories"));
        return "admin/product/editProduct";
    }

    @RequestMapping("/update")
    public String update(Product product) {
        productService.update(product);
        return "redirect:list?cid="+product.getCategory().getId();
    }

    @RequestMapping("/list")
    public String list(@RequestParam(required = false)Integer cid,@RequestParam(required = false)String keyword,  Model model, @RequestParam(required = false) Integer start) {
        Page<Product> page;
    	if (start==null) {
			page=new Page<Product>(0, 10);
		}else {
			page=new Page<Product>(start, 10);
		}
        Page<Product> result = productService.list(cid,keyword,page);
        if(cid!=null)
        	page.setParam("&cid="+cid);
        model.addAttribute("products", result.getRows());
        model.addAttribute("page", result);
        return "admin/product/listProduct";
    }
}


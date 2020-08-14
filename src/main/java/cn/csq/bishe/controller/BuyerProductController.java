package cn.csq.bishe.controller;

import cn.csq.bishe.VO.ProductInfoVO;
import cn.csq.bishe.VO.ProductVO;
import cn.csq.bishe.VO.ResultVO;
import cn.csq.bishe.dataobject.ProductCategory;
import cn.csq.bishe.dataobject.ProductInfo;
import cn.csq.bishe.service.ProductCategoryService;
import cn.csq.bishe.service.ProductInfoService;
import cn.csq.bishe.utils.ResultVOUtil;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

/**
 * 买家商品端
 * 返回视图 是带状态码和信息的 商品菜单 按照商品类别分类的显示的所有上架商品的列表
 * ResultVO 第一层 ProductVO 商品简单对象 ProductInfoVO 商品信息对象
 *
 * code状态码：
 * msg信息：
 * data数据：
 *      {
 *          商品类别name：
 *          商品列别编号type：
 *          food商品信息列表：
 *          {
 *             id；
 *             name；
 *             price：
 *             description：
 *             ico：
 *          }，
 *             food商品信息：
 *  *          {
 *  *             id；
 *  *             name；
 *  *             price：
 *  *             description：
 *  *             ico：
 *  *          }
 *      }
 * @ClassName : BuyerProductController
 * @Author : CSQ
 * @Date: 2020-03-11 14:01
 */
@RestController
@RequestMapping("/buyer/product")
public class BuyerProductController {


    @Autowired
    private ProductInfoService productInfoService;

    @Autowired
    private ProductCategoryService productCategoryService;

    @GetMapping("/list")
    public ResultVO list() {
        //1.查询所有上架商品
        List<ProductInfo> productInfoList = productInfoService.findUpAll();
        //2.查询类目(一次性查询)
        /* ArrayList<Integer> categoryTypeList = new ArrayList<>();
        //传统方法
        for (ProductInfo productInfo : productInfoList) {
            categoryTypeList.add(productInfo.getCategoryType());
        }*/
        //精简方法 lambda 将商品信息列表中的商品类别编号查询出来
        List<Integer> categoryTypeList = productInfoList.stream()
                .map(e -> e.getCategoryType())
                .collect(Collectors.toList());
        //根据编号查询到所有商品类别
        List<ProductCategory> productCategoryList = productCategoryService.findByCategoryTypeIn(categoryTypeList);

        // 3.数据拼装
        List<ProductVO> productVOList = new ArrayList<>();

        for (ProductCategory productCategory : productCategoryList) {
            ProductVO productVO = new ProductVO();
            productVO.setCategoryName(productCategory.getCategoryName());
            productVO.setCategoryType(productCategory.getCategoryType());
            List<ProductInfoVO> productInfoVOList= new ArrayList<>();
            for (ProductInfo productInfo : productInfoList) {
                if (productInfo.getCategoryType().equals(productCategory.getCategoryType())) {
                    ProductInfoVO productInfoVO = new ProductInfoVO();
                    //左---copy到--右
                    BeanUtils.copyProperties(productInfo, productInfoVO);
                    productInfoVOList.add(productInfoVO);
                }
            }
            productVO.setProductInfoVOList(productInfoVOList);
            productVOList.add(productVO);
        }
        return ResultVOUtil.success(productVOList);
    }

}

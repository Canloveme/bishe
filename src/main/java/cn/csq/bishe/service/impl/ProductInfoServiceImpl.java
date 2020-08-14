package cn.csq.bishe.service.impl;


import cn.csq.bishe.dataobject.ProductInfo;
import cn.csq.bishe.dto.CarDTO;
import cn.csq.bishe.enums.ProductStatusEnum;
import cn.csq.bishe.enums.ResultEnum;
import cn.csq.bishe.exception.MyException;
import cn.csq.bishe.repository.ProductInfoRepository;
import cn.csq.bishe.service.ProductInfoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * 商品服务实现
 *
 * @ClassName : ProductInfoServiceImpl
 * @Author : CSQ
 * @Date: 2020-03-11 03:01
 */
@Service
public class ProductInfoServiceImpl implements ProductInfoService {

    @Autowired
    private ProductInfoRepository productInfoRepository;

    @Override
    public ProductInfo findOne(String productId) {
        return productInfoRepository.getOne(productId);
    }

    @Override
    public List<ProductInfo> findUpAll() {
        return productInfoRepository.findByProductStatus(ProductStatusEnum.UP.getCode());
    }

    @Override
    public Page<ProductInfo> findAll(Pageable pageable) {
        return productInfoRepository.findAll(pageable);
    }

    @Override
    public ProductInfo save(ProductInfo productInfo) {
        return productInfoRepository.save(productInfo);
    }

    @Transactional
    @Override
    public void increaseStock(List<CarDTO> carDTOList) {
        for (CarDTO carDTO : carDTOList) {
            ProductInfo productInfo = productInfoRepository.getOne(carDTO.getProductId());
            if (productInfo.getProductStock() == null) {
                //商品不存在
                throw new MyException(ResultEnum.PRODUCT_NOT_EXIST);
            }
            //添加库存
            Integer result = productInfo.getProductStock() + carDTO.getProductQuantity();
            productInfo.setProductStock(result);
            productInfoRepository.save(productInfo);
        }
    }

    @Transactional
    @Override
    public void decreaseStock(List<CarDTO> carDTOList) {
        for (CarDTO carDTO : carDTOList) {
            ProductInfo productInfo = productInfoRepository.getOne(carDTO.getProductId());
            if (productInfo == null) {
                //商品不存在
                throw new MyException(ResultEnum.PRODUCT_NOT_EXIST);
            }
            Integer result = productInfo.getProductStock() - carDTO.getProductQuantity();
            if (result < 0) {
                //库存不足
                throw new MyException(ResultEnum.PRODUCT_STOCK_ERROR);
            }
            //保存库存
            productInfo.setProductStock(result);
            productInfoRepository.save(productInfo);
        }
    }

    @Override
    public ProductInfo onSale(String productId) {
        ProductInfo productInfo = productInfoRepository.getOne(productId);
        if (productInfo == null) {
            throw new MyException(ResultEnum.PRODUCT_NOT_EXIST);
        }
        if (productInfo.getProductStatusEnum() == ProductStatusEnum.UP) {
            throw new MyException(ResultEnum.PRODUCT_STATUS_ERROR);
        }
        productInfo.setProductStatus(ProductStatusEnum.UP.getCode());
        return productInfoRepository.save(productInfo);
    }

    @Override
    public ProductInfo offSale(String productId) {
        ProductInfo productInfo = productInfoRepository.getOne(productId);
        if (productInfo == null) {
            throw new MyException(ResultEnum.PRODUCT_NOT_EXIST);
        }
        if (productInfo.getProductStatusEnum() == ProductStatusEnum.DOWN) {
            throw new MyException(ResultEnum.PRODUCT_STATUS_ERROR);
        }
        productInfo.setProductStatus(ProductStatusEnum.DOWN.getCode());
        return productInfoRepository.save(productInfo);
    }
}

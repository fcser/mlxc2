package com.jxxy.mlxc.business.service.impl;

import com.jxxy.mlxc.business.api.dto.ProductDto;
import com.jxxy.mlxc.business.api.query.ProductQuery;
import com.jxxy.mlxc.business.api.service.ProductService;
import com.jxxy.mlxc.business.mapper.ProductDao;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * @Project:mlxc-parent
 * @Class:ProductServiceImpl
 * @author:zhouyangmin
 * @CreateTime:2019年03月26日17:07
 * @Description:商品服务类
 * @Version: 1.0.0
 */
@Service
@Slf4j
@Transactional(rollbackFor=Exception.class)
public class ProductServiceImpl implements ProductService {
    @Autowired
    private ProductDao productDao;
    @Override
    public Long add(ProductDto dto) {
        productDao.insert(dto);
        return dto.getId();
    }

    @Override
    public void update(ProductDto dto) {
        productDao.update(dto);
    }

    @Override
    public void delete(Long id) {
        productDao.delete(id);
    }

    @Override
    public int batchDelete(List<Long> ids) {
        return productDao.batchDelete(ids);
    }

    @Override
    public List<ProductDto> listProduct(ProductQuery query) {
        return productDao.listProduct(query);
    }

    @Override
    public ProductDto showProduct() {
        List<ProductDto> list=listProduct(null);
        return null==list&&list.size()>0?null:list.get(0);
    }

    @Override
    public ProductDto getProductById(Long id) {
        return productDao.getProduct(id);
    }
}

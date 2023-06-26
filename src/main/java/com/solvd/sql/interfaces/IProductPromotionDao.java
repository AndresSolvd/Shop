package com.solvd.sql.interfaces;

import com.solvd.sql.model.ProductPromotion;

public interface IProductPromotionDao extends IBaseDAO<ProductPromotion> {

    ProductPromotion getPromotionByProductName(String productName);
}

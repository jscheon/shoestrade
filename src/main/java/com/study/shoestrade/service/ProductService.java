package com.study.shoestrade.service;

import com.study.shoestrade.dto.ProductLoadDto;
import com.study.shoestrade.dto.ProductSaveDto;
import com.study.shoestrade.dto.ProductImageAddDto;
import com.study.shoestrade.dto.ProductSearchDto;

import java.util.List;

public interface ProductService {

    /**
     * 상품 등록
     *
     * @param productDto 등록할 상품 정보
     * @return 등록한 상품 id
     */
    ProductSaveDto saveProduct(ProductSaveDto productDto);

    /**
     * 상품 삭제
     *
     * @param productId 삭제할 상품 id
     */
    void deleteProduct(Long productId);

    /**
     * 상품 전체 검색
     *
     * @return 검색 결과
     */
    List<ProductLoadDto> findProductAll();


    /**
     * 상품 이름으로 검색
     *
     * @param name 상품명
     * @return 검색 결과
     */
    List<ProductLoadDto> findProductByName(String name);


    /**
     * 선택된 브랜드 내에 있는 상품 이름으로 검색
     *
     * @param productSearchDto 검색어, 브랜드 이름 리스트
     * @return 검색 결과
     */
    List<ProductLoadDto> findProductByNameInBrand(ProductSearchDto productSearchDto);

    /**
     * 상품 정보 변경
     *
     * @param productDto 변경할 정보
     */
    void updateProduct(ProductSaveDto productDto);

    /**
     * 상품 이미지 등록
     *
     * @param productImageAddDto 등록할 상품 id, 이미지 정보
     */
    void addProductImage(ProductImageAddDto productImageAddDto);

}

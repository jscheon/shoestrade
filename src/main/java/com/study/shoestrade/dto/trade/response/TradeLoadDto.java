package com.study.shoestrade.dto.trade.response;

import com.querydsl.core.annotations.QueryProjection;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class TradeLoadDto {

    private Long id;
    private String productKorName;

    private int size;
    private int price;

    private String image;

    @Builder
    @QueryProjection
    public TradeLoadDto(Long id, String productKorName, int size, int price, String image) {
        this.id = id;
        this.productKorName = productKorName;
        this.size = size;
        this.price = price;
        this.image = image;
    }

    @QueryProjection
    public TradeLoadDto(Long id, int size, int price) {
        this.id = id;
        this.size = size;
        this.price = price;
    }
}
package com.study.shoestrade.repository.trade;

import com.study.shoestrade.domain.trade.Trade;
import com.study.shoestrade.domain.trade.TradeState;
import com.study.shoestrade.dto.trade.response.TradeDoneDto;
import com.study.shoestrade.dto.trade.response.TradeTransactionDto;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface TradeRepository extends JpaRepository<Trade, Long>, TradeRepositoryCustom {

    /**
     * 상품 체결 내역
     *
     * @param productId 상품 id
     * @param pageable  페이지 정보
     * @return 검색 결과
     */
    @Query("select new com.study.shoestrade.dto.trade.response.TradeDoneDto(p.size, t.price, t.lastModifiedDate) " +
            "from Trade t " +
            "join t.productSize p " +
            "where p.product.id = :productId and t.tradeState = 'DONE' " +
            "order by t.lastModifiedDate desc")
    Page<TradeDoneDto> findDoneTrade(@Param("productId") Long productId, Pageable pageable);

    /**
     * 상품 입찰 내역
     *
     * @param productId  상품 id
     * @param tradeState 입찰 상태(구매, 판매)
     * @param pageable   페이지 정보
     * @return 검색 결과
     */
    @Query("select new com.study.shoestrade.dto.trade.response.TradeTransactionDto(p.size, t.price, count(t.price)) " +
            "from Trade t " +
            "join t.productSize p " +
            "where t.tradeState= :tradeState and p.product.id = :productId " +
            "group by t.price, p.size")
    Page<TradeTransactionDto> findTransactionTrade(@Param("productId") Long productId, @Param("tradeState") TradeState tradeState, Pageable pageable);
}
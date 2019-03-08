package com.homics.messaging.model;

import java.util.List;

public class ImpactStockMessage {

    private Long operationId;
    private List<ArticleStockDto> articleStocks;

    public ImpactStockMessage() {
    }

    public ImpactStockMessage(Long operationId, List<ArticleStockDto> articleStocks) {
        this.operationId = operationId;
        this.articleStocks = articleStocks;
    }

    public Long getOperationId() {
        return operationId;
    }

    public void setOperationId(Long operationId) {
        this.operationId = operationId;
    }

    public List<ArticleStockDto> getArticleStocks() {
        return articleStocks;
    }

    public void setArticleStocks(List<ArticleStockDto> articleStocks) {
        this.articleStocks = articleStocks;
    }

    @Override
    public String toString() {
        return "ImpactStockMessage{" +
                "operationId=" + operationId +
                ", articleStocks=" + articleStocks +
                '}';
    }
}

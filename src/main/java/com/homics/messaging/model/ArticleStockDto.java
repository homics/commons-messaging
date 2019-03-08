package com.homics.messaging.model;

public class ArticleStockDto {
    private Long articleId;
    private Long deltaStock;

    public ArticleStockDto() {
    }

    public ArticleStockDto(Long articleId, Long deltaStock) {
        this.articleId = articleId;
        this.deltaStock = deltaStock;
    }

    public Long getArticleId() {
        return articleId;
    }

    public void setArticleId(Long articleId) {
        this.articleId = articleId;
    }

    public Long getDeltaStock() {
        return deltaStock;
    }

    public void setDeltaStock(Long deltaStock) {
        this.deltaStock = deltaStock;
    }

    @Override
    public String toString() {
        return "ArticleStock{" +
                "articleId=" + articleId +
                ", deltaStock=" + deltaStock +
                '}';
    }
}

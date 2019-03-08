package com.homics.messaging.model;

public class StockAcknowledgmentMessage {

    private Long operationId;
    private boolean succeed;

    public StockAcknowledgmentMessage() {
    }

    public StockAcknowledgmentMessage(Long operationId, boolean succeed) {
        this.operationId = operationId;
        this.succeed = succeed;
    }

    public Long getOperationId() {
        return operationId;
    }

    public void setOperationId(Long operationId) {
        this.operationId = operationId;
    }

    public boolean isSucceed() {
        return succeed;
    }

    public void setSucceed(boolean succeed) {
        this.succeed = succeed;
    }
}

package com.seerbit.seerbitandroid.view.webviews;

import com.google.gson.annotations.SerializedName;

public class PaymentModel {
    @SerializedName("reference")
    String reference;
    @SerializedName("linkingreference")
    String linkingReference;
    @SerializedName("amount")
    String amount;
    @SerializedName("publicKey")
    String publicKey;
    @SerializedName("productDescription")
    String productDescription;
    @SerializedName("maskedPan")
    String maskedPan;
    @SerializedName("gatewayMessage")
    String gatewayMessage;
    @SerializedName("gatewayCode")
    String gatewayCode;
    @SerializedName("cardBin")
    String cardBin;
    @SerializedName("lastFourDigits")
    String lastFourDigits;
    @SerializedName("country")
    String country;
    @SerializedName("currency")
    String currency;
    @SerializedName("paymentReference")
    String paymentReference;
    @SerializedName("transactionProcessTime")
    String transactionProcessTime;
    @SerializedName("processorCode")
    String processorCode;
    @SerializedName("processorMessage")
    String processorMessage;
    @SerializedName("reason")
    String reason;

    public String getReference() {
        return reference;
    }

    public void setReference(String reference) {
        this.reference = reference;
    }

    public String getLinkingReference() {
        return linkingReference;
    }

    public void setLinkingReference(String linkingReference) {
        this.linkingReference = linkingReference;
    }

    public String getAmount() {
        return amount;
    }

    public void setAmount(String amount) {
        this.amount = amount;
    }

    public String getPublicKey() {
        return publicKey;
    }

    public void setPublicKey(String publicKey) {
        this.publicKey = publicKey;
    }

    public String getProductDescription() {
        return productDescription;
    }

    public void setProductDescription(String productDescription) {
        this.productDescription = productDescription;
    }

    public String getMaskedPan() {
        return maskedPan;
    }

    public void setMaskedPan(String maskedPan) {
        this.maskedPan = maskedPan;
    }

    public String getGatewayMessage() {
        return gatewayMessage;
    }

    public void setGatewayMessage(String gatewayMessage) {
        this.gatewayMessage = gatewayMessage;
    }

    public String getGatewayCode() {
        return gatewayCode;
    }

    public void setGatewayCode(String gatewayCode) {
        this.gatewayCode = gatewayCode;
    }

    public String getCardBin() {
        return cardBin;
    }

    public void setCardBin(String cardBin) {
        this.cardBin = cardBin;
    }

    public String getLastFourDigits() {
        return lastFourDigits;
    }

    public void setLastFourDigits(String lastFourDigits) {
        this.lastFourDigits = lastFourDigits;
    }

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    public String getCurrency() {
        return currency;
    }

    public void setCurrency(String currency) {
        this.currency = currency;
    }

    public String getPaymentReference() {
        return paymentReference;
    }

    public void setPaymentReference(String paymentReference) {
        this.paymentReference = paymentReference;
    }

    public String getTransactionProcessTime() {
        return transactionProcessTime;
    }

    public void setTransactionProcessTime(String transactionProcessTime) {
        this.transactionProcessTime = transactionProcessTime;
    }

    public String getProcessorCode() {
        return processorCode;
    }

    public void setProcessorCode(String processorCode) {
        this.processorCode = processorCode;
    }

    public String getProcessorMessage() {
        return processorMessage;
    }

    public void setProcessorMessage(String processorMessage) {
        this.processorMessage = processorMessage;
    }

    public String getReason() {
        return reason;
    }

    public void setReason(String reason) {
        this.reason = reason;
    }
}

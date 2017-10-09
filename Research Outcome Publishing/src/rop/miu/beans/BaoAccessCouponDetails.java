package rop.miu.beans;

import java.io.Serializable;
import java.util.Date;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

public class BaoAccessCouponDetails implements Serializable {
    private static final long serialVersionUID = 1L;
    private Integer couponTypeId;
    private Serializable paidElementId;
    private String bankTransactionNum;
    private String paymentMode;
    private Date creationDate;
    private Date paymentDate;
    private String paymentDesc;
    private String additionalInfo;
    
    public BaoAccessCouponDetails(Integer couponTypeId, Serializable paidElementId,
			String paymentDesc) {
		this.couponTypeId = couponTypeId;
		this.paidElementId = paidElementId;
		this.paymentDesc = paymentDesc;
		this.creationDate = new Date();
	}

	public Integer getCouponTypeId() {
		return couponTypeId;
	}

	public void setCouponTypeId(Integer couponTypeId) {
		this.couponTypeId = couponTypeId;
	}

	public Serializable getPaidElementId() {
		return paidElementId;
	}

	public void setPaidElementId(Serializable paidElementId) {
		this.paidElementId = paidElementId;
	}

	public String getBankTransactionNum() {
		return bankTransactionNum;
	}

	public void setBankTransactionNum(String bankTransactionNum) {
		this.bankTransactionNum = bankTransactionNum;
	}

	public String getPaymentMode() {
		return paymentMode;
	}

	public void setPaymentMode(String paymentMode) {
		this.paymentMode = paymentMode;
	}

	public Date getCreationDate() {
		return creationDate;
	}

	public void setCreationDate(Date creationDate) {
		this.creationDate = creationDate;
	}

	public Date getPaymentDate() {
		return paymentDate;
	}

	public void setPaymentDate(Date paymentDate) {
		this.paymentDate = paymentDate;
	}

	public String getPaymentDesc() {
		return paymentDesc;
	}

	public void setPaymentDesc(String paymentDesc) {
		this.paymentDesc = paymentDesc;
	}

	public String getAdditionalInfo() {
		return additionalInfo;
	}

	public void setAdditionalInfo(String additionalInfo) {
		this.additionalInfo = additionalInfo;
	}

	public String toJson(){
    	String json = null;
    	final GsonBuilder builder = new GsonBuilder();
        final Gson gson = builder.create();
        json = gson.toJson(this, BaoAccessCouponDetails.class);
    	return json;
    }
}

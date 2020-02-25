package com.fred.learning.blacklist;


import java.io.Serializable;

public class BlackListDubboVO implements Serializable{

    private static final long serialVersionUID = -5439282454891625782L;

    /**
     * 是否已还款0:否,1:是
     */
//    @JSONField(name = "payed")
    private Boolean isPayed = false;

    /**
     * 逾期当次对应的申请借款时间
     */
//    @JSONField(name = "apply_time")
    private String applyTime;

    /**
     * 逾期当次对应的放款时间
     */
//    @JSONField(name = "loan_time")
    private String loanTime;

    /**
     * 最近一次应还款日
     */
//    @JSONField(name = "last_billing_date")
    private String lastBillingDate;

    /**
     * 最近一次实际还款日
     */
//    @JSONField(name = "last_repayment_date")
    private String lastRepaymentDate;


    /**
     * 逾期当次对应的逾期金额区间
     */
//    @JSONField(name = "amount_interval")
    private String amountInterval;


    /**
     * 逾期当次对应的逾期时间区间
     */
//    @JSONField(name = "overdue_tag")
    private String overdueTag;

    /**
     * 是否失联0:否1是
     */
    private Boolean lostContact;

    private Integer overdueDays;

    private Long overdueAmount;


    public String getApplyTime() {
        return applyTime;
    }

    public void setApplyTime(String applyTime) {
        this.applyTime = applyTime;
    }

    public String getLoanTime() {
        return loanTime;
    }

    public void setLoanTime(String loanTime) {
        this.loanTime = loanTime;
    }

    public String getLastBillingDate() {
        return lastBillingDate;
    }

    public void setLastBillingDate(String lastBillingDate) {
        this.lastBillingDate = lastBillingDate;
    }

    public String getLastRepaymentDate() {
        return lastRepaymentDate;
    }

    public void setLastRepaymentDate(String lastRepaymentDate) {
        this.lastRepaymentDate = lastRepaymentDate;
    }

    public Boolean getLostContact() {
        return lostContact;
    }

    public void setLostContact(Boolean lostContact) {
        this.lostContact = lostContact;
    }

    public Boolean getPayed() {
        return isPayed;
    }

    public void setPayed(Boolean payed) {
        isPayed = payed;
    }

    public String getAmountInterval() {
        return amountInterval;
    }

    public void setAmountInterval(String amountInterval) {
        this.amountInterval = amountInterval;
    }

    public String getOverdueTag() {
        return overdueTag;
    }

    public void setOverdueTag(String overdueTag) {
        this.overdueTag = overdueTag;
    }

    public Integer getOverdueDays() {
        return overdueDays;
    }

    public void setOverdueDays(Integer overdueDays) {
        this.overdueDays = overdueDays;
    }

    public Long getOverdueAmount() {
        return overdueAmount;
    }

    public void setOverdueAmount(Long overdueAmount) {
        this.overdueAmount = overdueAmount;
    }
}

package com.megatravel.agentbackend.dto;

import com.megatravel.agentbackend.model.Accommodation;

import java.util.List;

public class AccommodationDto {


    private long accId;
    private long accDbId;
    private String accName;
    private String accDescription;
    private int accCapacity;
    private List<byte[]> accPictures;
    private List<Long> accPricePlanId;
    private Long  accUnavailableId;
    private Long accLocationId;
    private long accCategoryId;
    private Long accTypeId;
    private List<Long> accServicesId;
    private Long accAgentId;
    private int accCancelPeriod;
    private float accAvgRating;

    public AccommodationDto() {
    }

    public long getAccId() {
        return accId;
    }

    public void setAccId(long accId) {
        this.accId = accId;
    }

    public long getAccDbId() {
        return accDbId;
    }

    public void setAccDbId(long accDbId) {
        this.accDbId = accDbId;
    }

    public String getAccName() {
        return accName;
    }

    public void setAccName(String accName) {
        this.accName = accName;
    }

    public String getAccDescription() {
        return accDescription;
    }

    public void setAccDescription(String accDescription) {
        this.accDescription = accDescription;
    }

    public int getAccCapacity() {
        return accCapacity;
    }

    public void setAccCapacity(int accCapacity) {
        this.accCapacity = accCapacity;
    }

    public List<byte[]> getAccPictures() {
        return accPictures;
    }

    public void setAccPictures(List<byte[]> accPictures) {
        this.accPictures = accPictures;
    }

    public List<Long> getAccPricePlanId() {
        return accPricePlanId;
    }

    public void setAccPricePlanId(List<Long> accPricePlanId) {
        this.accPricePlanId = accPricePlanId;
    }

    public Long getAccUnavailableId() {
        return accUnavailableId;
    }

    public void setAccUnavailableId(Long accUnavailableId) {
        this.accUnavailableId = accUnavailableId;
    }

    public Long getAccLocationId() {
        return accLocationId;
    }

    public void setAccLocationId(Long accLocationId) {
        this.accLocationId = accLocationId;
    }

    public long getAccCategoryId() {
        return accCategoryId;
    }

    public void setAccCategoryId(long accCategoryId) {
        this.accCategoryId = accCategoryId;
    }

    public Long getAccTypeId() {
        return accTypeId;
    }

    public void setAccTypeId(Long accTypeId) {
        this.accTypeId = accTypeId;
    }

    public List<Long> getAccServicesId() {
        return accServicesId;
    }

    public void setAccServicesId(List<Long> accServicesId) {
        this.accServicesId = accServicesId;
    }

    public Long getAccAgentId() {
        return accAgentId;
    }

    public void setAccAgentId(Long accAgentId) {
        this.accAgentId = accAgentId;
    }

    public int getAccCancelPeriod() {
        return accCancelPeriod;
    }

    public void setAccCancelPeriod(int accCancelPeriod) {
        this.accCancelPeriod = accCancelPeriod;
    }

    public float getAccAvgRating() {
        return accAvgRating;
    }

    public void setAccAvgRating(float accAvgRating) {
        this.accAvgRating = accAvgRating;
    }

    @Override
    public String toString() {
        return "AccommodationDTO{" +
                "accId=" + accId +
                ", accName='" + accName + '\'' +
                ", accDescription='" + accDescription + '\'' +
                ", accCapacity=" + accCapacity +
                ", accPictures=" + accPictures +
                ", accPricePlanId=" + accPricePlanId +
                ", accUnavailableId=" + accUnavailableId +
                ", accLocationId=" + accLocationId +
                ", accCategoryId=" + accCategoryId +
                ", accTypeId=" + accTypeId +
                ", accServicesId=" + accServicesId +
                ", accAgentId=" + accAgentId +
                ", accCancelPeriod=" + accCancelPeriod +
                ", accAvgRating=" + accAvgRating +
                '}';
    }
}

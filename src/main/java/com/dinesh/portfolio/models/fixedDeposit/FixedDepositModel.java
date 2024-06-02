package com.dinesh.portfolio.models.fixedDeposit;

import lombok.Data;

@Data
public class FixedDepositModel {
        private Long fixedDepositId;
        private String bankName;
        private Integer depositAmount;
        private Integer numberOfMonths;
        private Integer rateOfInterest;
        private String fixedDepositDocURL;
}

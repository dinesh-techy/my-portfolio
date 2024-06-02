package com.dinesh.portfolio.models.fixedDeposit;

import lombok.Data;
import org.springframework.data.annotation.Id;

@Data
public class FixedDepositRequest{
    @Id
    private Long userId;
    private FixedDepositModel fixedDeposit;
}

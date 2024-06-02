package com.dinesh.portfolio.models.fixedDeposit;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.ArrayList;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Document("fixedDeposit")
public class FixedDeposit {
    @Id
    private Long userId;
    private ArrayList<FixedDepositModel> fixedDeposit;
}

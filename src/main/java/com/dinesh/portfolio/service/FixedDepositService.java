package com.dinesh.portfolio.service;

import com.dinesh.portfolio.models.fixedDeposit.FixedDeposit;
import com.dinesh.portfolio.models.fixedDeposit.FixedDepositRequest;
import com.dinesh.portfolio.repository.fixedDeposit.FixedDepositRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.stereotype.Service;

@Service
public class FixedDepositService {

    @Autowired
    private FixedDepositRepo fixedDepositRepo;
    @Autowired
    private MongoTemplate mongoTemplate;
    public String addFixedDeposit(FixedDepositRequest fixedDepositRequest){
        fixedDepositRepo.addFixedDeposit(fixedDepositRequest.getUserId(),fixedDepositRequest.getFixedDeposit());
        return "FixedDeposit Added";
    }
    public FixedDeposit getFixedDeposit(Long userId){
        return fixedDepositRepo.getFixedDepositData(userId);
    }
    public String deleteFixedDeposit(Long userId,Long fixedDepositId){
        fixedDepositRepo.deleteFixedDepositData(userId,fixedDepositId);
        return "Delete FD";
    }
}

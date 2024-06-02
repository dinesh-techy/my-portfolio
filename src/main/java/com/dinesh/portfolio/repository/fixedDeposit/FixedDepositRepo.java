package com.dinesh.portfolio.repository.fixedDeposit;

import com.dinesh.portfolio.models.fixedDeposit.FixedDeposit;
import com.dinesh.portfolio.models.fixedDeposit.FixedDepositModel;
import com.mongodb.client.result.UpdateResult;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.FindAndModifyOptions;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.data.mongodb.core.query.Update;
import org.springframework.stereotype.Component;

import static org.springframework.data.mongodb.core.query.Criteria.where;

@Component
public class FixedDepositRepo {
    @Autowired
    private MongoTemplate mongoTemplate;

    public void addFixedDeposit(Long userId, FixedDepositModel fixedDeposit){
        Update update = new Update();
        update.addToSet("fixedDeposit",fixedDeposit);
        Query query = new Query(Criteria.where("userId").is(userId));
        mongoTemplate.findAndModify(query,update, FindAndModifyOptions.options().upsert(true),FixedDeposit.class);
    }
    public FixedDeposit getFixedDepositData(Long userId){
        return mongoTemplate.findById(userId, FixedDeposit.class);
    }
    public String deleteFixedDepositData(Long userId,Long fixedDepositId){
        Query removeQuery = new Query(Criteria.where("userId").is(userId));
        UpdateResult updateResult = mongoTemplate.upsert(removeQuery,new Update().pull("fixedDeposit",Query.query(Criteria.where("fixedDepositId").is(fixedDepositId))), FixedDeposit.class);
        System.out.println(updateResult);
        return "Delete FD";
    }
}

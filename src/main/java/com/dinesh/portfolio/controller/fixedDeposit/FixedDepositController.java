package com.dinesh.portfolio.controller.fixedDeposit;

import com.dinesh.portfolio.models.fixedDeposit.FixedDeposit;
import com.dinesh.portfolio.models.fixedDeposit.FixedDepositRequest;
import com.dinesh.portfolio.service.FixedDepositService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/fixedDeposit")
public class FixedDepositController {
    @Autowired
    private FixedDepositService fixedDepositService;

    @PostMapping("/addFD")
    public String addFixedDeposit(@RequestBody FixedDepositRequest fixedDepositRequest){
        return fixedDepositService.addFixedDeposit(fixedDepositRequest);
    }
    @GetMapping("/getFD")
    public FixedDeposit getFixedDeposit(@RequestParam Long userId){
        return fixedDepositService.getFixedDeposit(userId);
    }
    @DeleteMapping("/deleteFD")
    public String deleteFixedDeposit(@RequestParam Long userId,Long fixedDepositId){
        return fixedDepositService.deleteFixedDeposit(userId,fixedDepositId);
    }
}

package com.oocl.coldplay.transaction;

import com.oocl.coldplay.common.model.Result;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/transactions")
@RequiredArgsConstructor
public class TransactionController {

    private final TransactionService transactionService;

    @GetMapping("/channels")
    public Result getChannels() {
        return Result.ok(transactionService.getChannels());
    }

    @PostMapping
    public Result createTransaction(@RequestBody TransactionDTO transactionDTO) {
        return Result.ok(transactionService.createTransaction(transactionDTO));
    }
}

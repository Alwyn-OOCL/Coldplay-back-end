package com.oocl.coldplay.transaction;

import java.util.List;
import org.springframework.stereotype.Service;

@Service
public class TransactionService {

    public List<ChannelDTO> getChannels() {
        return ChannelEnum.getChannels();
    }

    public Boolean createTransaction(TransactionDTO transactionDTO) {
        // TODO: implement
        return true;
    }
}

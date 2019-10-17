package com.vergil.Aspect.domain.enumaration;

import java.util.Arrays;
import java.util.Optional;

public enum TransactionType {
    DEBIT("débito"),
    CREDIT("crédito");
    
    private final String value;

    TransactionType(String value){
        this.value = value;
    }

    public String getValue() {
        return value;
    }
    public static Optional<TransactionType> getTransactionTypeByValue(String value) {
        return Arrays.stream(TransactionType.values())
                .filter(e -> e.value.equals(value.toLowerCase()))
            .findFirst();
    }
}

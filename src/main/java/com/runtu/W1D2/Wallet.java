package com.runtu.W1D2;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Wallet {


    private final List<String> records = new ArrayList<>();

    public Wallet(){
        records.add("空白记录");
    }

    public List<String> getRecords()
    {
       return Collections.unmodifiableList(records);
    }


}
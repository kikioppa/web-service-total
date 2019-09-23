package org.salem.service;


import org.springframework.stereotype.Service;


import java.util.List;

import org.salem.login.model.Record;

@Service
public interface RecordService {

    Iterable<Record> listAllRecords();
    
    Record getRecordById(Integer id);

    Record saveRecord(Record record);

    void deleteRecord(Integer id);

}
package org.salem.service;

import org.salem.login.model.Record;

import org.salem.login.repository.RecordRepository;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * Product service implement.
 */
@Service
public class RecordServiceImpl implements RecordService {

    private RecordRepository recordRepository;

    @Autowired
    public void setRecordRepository(RecordRepository recordRepository) {
        this.recordRepository = recordRepository;
    }
    
 
    @Override
    public Iterable<Record> listAllRecords() {
        return recordRepository.findAll();
    }

    @Override
    public Record getRecordById(Integer id) {
        return recordRepository.findAllById(id);
    }

    @Override
    public Record saveRecord(Record record) {
        return recordRepository.save(record);
    }

    @Override
    public void deleteRecord(Integer id) {
    	recordRepository.deleteById(id);
    }



}
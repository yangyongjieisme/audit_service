package com.hcl.hackton.mapper;

import com.hcl.hackton.domain.Instruments;
import com.hcl.hackton.input.wrapper.AuditSearch;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Result;
import org.apache.ibatis.annotations.Results;
import org.apache.ibatis.annotations.Select;


@Mapper
public interface InstrumentsMapper {


    @Select("SELECT instrument_id,instrument_name,instrument_type,instrument_value FROM instruments WHERE instrument_id = #{instrumentId}")
    @Results(id="auditMap", value={
            @Result(property = "instrumentId", column = "instrument_id"),
            @Result(property = "instrumentName", column = "instrument_name"),
            @Result(property = "instrumentType", column = "instrument_type"),
            @Result(property = "instrumentValue", column = "instrument_value"),

    })
    Instruments getById(String instrumentId);

}
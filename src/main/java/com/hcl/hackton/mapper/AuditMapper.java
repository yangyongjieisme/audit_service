package com.hcl.hackton.mapper;

import com.hcl.hackton.domain.Audit;
import com.hcl.hackton.input.wrapper.AuditSearch;
import org.apache.ibatis.annotations.*;

import java.util.List;


@Mapper
public interface AuditMapper {


    @Select("SELECT customer_id, transcation_ref,instrument_id,instrument_name,trade_type,audit_date FROM audit WHERE customer_id = #{customerId} ${query} limit #{pageNumber},#{pageSize}")
    @Results(id="auditMap", value={
            @Result(property = "customerId", column = "customer_id"),
            @Result(property = "transcationRef", column = "transcation_ref"),
            @Result(property = "instrumentId", column = "instrument_id"),
            @Result(property = "instrumentName", column = "instrument_name"),
            @Result(property = "tradeType", column = "trade_type"),
            @Result(property = "auditDate", column = "audit_date"),
    })
    List<Audit> list(AuditSearch auditSearch);

    @Insert({"insert into audit(id,customer_id, transcation_ref,instrument_id,instrument_name,trade_type,audit_date) values(#{id},#{customerId},#{transcationRef},#{instrumentId},#{instrumentName},#{tradeType},#{auditDate})"})
    void insert(Audit audit);

}
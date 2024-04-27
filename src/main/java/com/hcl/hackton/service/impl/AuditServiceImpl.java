package com.hcl.hackton.service.impl;

import com.hcl.hackton.domain.Audit;
import com.hcl.hackton.input.AuditSearchVO;
import com.hcl.hackton.input.SearchFiled;
import com.hcl.hackton.input.wrapper.AuditSearch;
import com.hcl.hackton.mapper.AuditMapper;
import com.hcl.hackton.service.AuditService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.CollectionUtils;

import java.util.List;

import static com.hcl.hackton.helper.Helper.translateFiledName;

@Service
@Slf4j
public class AuditServiceImpl implements AuditService {

    @Autowired
    AuditMapper auditMapper;

    @Override
    public List<Audit> list(AuditSearchVO searchVO) {

        AuditSearch searchObj = new AuditSearch();
        searchObj.setCustomerId(searchVO.getCustomerId());
        searchObj.setPageSize(searchVO.getPageSize());
        searchObj.setPageNumber(searchVO.getPageNumber() - 1);
        List<SearchFiled> filters = searchVO.getFilters();
        StringBuilder queryBuilder = new StringBuilder();
        if (!CollectionUtils.isEmpty(filters)) {
            for (SearchFiled filter : filters) {
                queryBuilder.append(" and ").append(translateFiledName(filter.getField())).append(" like '%").append(filter.getValue()).append("%'");
            }
        }
        queryBuilder.append(" order by ").append(searchVO.getOder());
        searchObj.setQuery(queryBuilder.toString());
        return auditMapper.list(searchObj);

    }
}

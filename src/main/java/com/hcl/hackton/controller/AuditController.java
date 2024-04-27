package com.hcl.hackton.controller;

import com.hcl.hackton.domain.Audit;
import com.hcl.hackton.input.AuditSearchVO;
import com.hcl.hackton.service.AuditService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import javax.validation.constraints.NotNull;
import java.util.List;
@RestController
@RequestMapping(value = "/audit")
@Slf4j
public class AuditController {

	@Autowired
	AuditService auditService;

	@PostMapping (value = "/list")
	@ResponseBody
	public List<Audit> list(
			@RequestBody @NotNull @Valid AuditSearchVO searchVO) {
		log.info("aduit list incoming params {}: ", searchVO.toString());
		return auditService.list(searchVO);

	}

}

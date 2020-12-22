package com.dv.mgmt.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.dv.mgmt.service.MgmtService;

@RestController
@RequestMapping("/dv/mgmt")
public class MgmtController {
		private static Logger logger = LoggerFactory.getLogger(MgmtController.class);
		
		@Autowired
		MgmtService service;
}

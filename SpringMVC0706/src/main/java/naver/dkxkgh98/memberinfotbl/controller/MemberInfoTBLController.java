package naver.dkxkgh98.memberinfotbl.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

import naver.dkxkgh98.memberinfotbl.service.MemberInfoTBLService;



@Controller
public class MemberInfoTBLController {
@Autowired
  private MemberInfoTBLService  memberInfoTBLService;
}

#Author: reneliu2006@126.com

@TableCommit
Feature: 
 Submission of application materials for enterprises to resume work

  @tag1
  Scenario: Select Unit status
    When open the url
		Then save screenShot and click step 2
		Given second page input applicant 自动化
		And  second page input contact 13888888888
		Then save screenShot and click step 3
		Given third page input unit 测试公司
		And third page input number 99 
		And third page input employees 0 
		And third page input header CEO 
		And third page input contact1 13888888888 
		And third page input plan 测试内容
		Then commit and save success screenShot
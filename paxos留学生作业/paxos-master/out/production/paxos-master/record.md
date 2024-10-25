# 运行记录
输入config.json文件的路径,运行driver的main方法,
终端记录如下:
```text
NEW SCENARIO: Assignment Scenario
	Two councillors send voting proposals for themselves at the same time. 
	M1, M2, M3 send voting proposals for themselves. 
	M1 is never unavailable and response immediately. 
	M2 is available for short-burts of time and has LATE replies. 
	M3 becomes unavailable indefinitely but while he is available has MEDIUM replies. 
	All other councillors have varied responses but will not propose any value. 
	These members never become unavailable.
Member 1:
	timeToPropose: 0
	timeToFail: -1
	timeToRestart: -1
	ambition: true
	responseTime: IMMEDIATE
Member 2:
	timeToPropose: 0
	timeToFail: 2000
	timeToRestart: 4000
	ambition: true
	responseTime: LATE
Member 3:
	timeToPropose: 250
	timeToFail: 4000
	timeToRestart: -1
	ambition: true
	responseTime: MEDIUM
Member 4:
	timeToPropose: -1
	timeToFail: -1
	timeToRestart: -1
	ambition: false
	responseTime: NEVER
Member 5:
	timeToPropose: -1
	timeToFail: -1
	timeToRestart: -1
	ambition: false
	responseTime: LATE
Member 6:
	timeToPropose: -1
	timeToFail: -1
	timeToRestart: -1
	ambition: false
	responseTime: MEDIUM
Member 7:
	timeToPropose: -1
	timeToFail: -1
	timeToRestart: -1
	ambition: false
	responseTime: IMMEDIATE
Member 8:
	timeToPropose: -1
	timeToFail: -1
	timeToRestart: -1
	ambition: false
	responseTime: LATE
Member 9:
	timeToPropose: -1
	timeToFail: -1
	timeToRestart: -1
	ambition: false
	responseTime: MEDIUM
VOTING BEGIN:
Member 1 broadcasting prepare: 1 for value 1
Member 0 broadcasting prepare: 0 for value 0
Member 2 promises proposal 0
Member 6 promises proposal 0
Member 5 promises proposal 0
Member 4 promises proposal 0
Member 3 promises proposal 0
Member 7 promises proposal 0
Member 8 promises proposal 0
Member 9 promises proposal 0
Member 2 broadcasting prepare: 2 for value 2
Member 1 promises proposal 2
Member 2 promises proposal 2
Member 5 promises proposal 2
Member 4 promises proposal 2
Member 2 is now unavailable
Member 6 promises proposal 2
Member 7 promises proposal 2
Member 8 promises proposal 2
Member 9 promises proposal 2
Member 3 promises proposal 1
Member 1 cannot promise proposal 1
Member 4 cannot promise proposal 1
Member 6 cannot promise proposal 1
Member 1 broadcasting prepare: 10 for value 1
Member 5 cannot promise proposal 1
Member 1 broadcasting proposal: 0 for value 0
Member 2 cannot accept proposal 0
Member 4 cannot accept proposal 0
Member 5 cannot accept proposal 0
Member 6 cannot accept proposal 0
Member 7 cannot accept proposal 0
Member 8 cannot accept proposal 0
Member 9 cannot accept proposal 0
Member 0 broadcasting prepare: 9 for value 0
Member 4 promises proposal 9
Member 5 promises proposal 9
Member 6 promises proposal 9
Member 7 promises proposal 9
Member 8 promises proposal 9
Member 9 promises proposal 9
Member 3 broadcasting proposal: 2 for value 2
Member 2 is now back
Member 6 cannot accept proposal 2
Member 4 cannot accept proposal 2
Member 1 accepts proposal 2 with value 2
Member 2 accepts proposal 2 with value 2
Member 5 cannot accept proposal 2
Member 7 cannot accept proposal 2
Member 8 cannot accept proposal 2
Member 9 cannot accept proposal 2
Member 2 is now unavailable
Member 7 cannot promise proposal 1
Member 8 cannot promise proposal 1
Member 1 broadcasting prepare: 19 for value 1
Member 9 cannot promise proposal 1
Member 1 broadcasting proposal: 9 for value 0
Member 2 accepts proposal 9 with value 0
Member 4 accepts proposal 9 with value 0
Member 5 accepts proposal 9 with value 0
Member 8 accepts proposal 9 with value 0
Member 7 accepts proposal 9 with value 0
Member 6 accepts proposal 9 with value 0
Member 9 accepts proposal 9 with value 0
Member 2 is now back
Member 1 promises proposal 10
Member 4 promises proposal 10
Member 5 promises proposal 10
Member 6 promises proposal 10
PROPOSAL HAS BEEN CHOSEN: 9
NEW PRESIDENT IS: 0
Member 1 Shutting down
Member 2 Shutting down
Member 3 Shutting down
Member 4 Shutting down
Member 5 Shutting down
Member 6 Shutting down
Member 7 Shutting down
Member 8 Shutting down
Member 9 Shutting down

Process finished with exit code 0

```
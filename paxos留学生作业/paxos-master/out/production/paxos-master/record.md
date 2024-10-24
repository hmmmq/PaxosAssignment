# 运行记录
输入config.json文件的路径,运行driver的main方法,
终端记录如下:
```text

NEW SCENARIO: Two Proposers
	(Assignment Scenario)Two councillors send voting proposals for themselves at the same time. 
	M1, M2, M3 send voting proposals for themselves. 
	M1 is never unavailable and response immediately. 
	M2 is available for short-burts of time and has LATE replies. 
	M3 becomes unavailable indefinitely but while he is available has MEDIUM replies. 
	All other councillors have varied responses but will not propose any value. 
	These members never become unavailable.
Member 0:
	timeToPropose: 0
	timeToFail: -1
	timeToRestart: -1
	ambition: true
	responseTime: IMMEDIATE
Member 1:
	timeToPropose: 0
	timeToFail: 2000
	timeToRestart: 4000
	ambition: true
	responseTime: IMMEDIATE
Member 2:
	timeToPropose: 250
	timeToFail: 4000
	timeToRestart: -1
	ambition: true
	responseTime: IMMEDIATE
Member 3:
	timeToPropose: -1
	timeToFail: -1
	timeToRestart: -1
	ambition: false
	responseTime: IMMEDIATE
Member 4:
	timeToPropose: -1
	timeToFail: -1
	timeToRestart: -1
	ambition: false
	responseTime: IMMEDIATE
Member 5:
	timeToPropose: -1
	timeToFail: -1
	timeToRestart: -1
	ambition: false
	responseTime: IMMEDIATE
Member 6:
	timeToPropose: -1
	timeToFail: -1
	timeToRestart: -1
	ambition: false
	responseTime: IMMEDIATE
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
	responseTime: IMMEDIATE
VOTING BEGIN:
Member 0 broadcasting prepare: 0 for value 0
Member 1 broadcasting prepare: 1 for value 1
Member 0 promises proposal 1
Member 1 promises proposal 0
Member 8 promises proposal 1
Member 5 promises proposal 1
Member 7 promises proposal 1
Member 8 cannot promise proposal 0
Member 4 promises proposal 1
Member 3 promises proposal 0
Member 2 promises proposal 1
Member 6 promises proposal 1
Member 3 promises proposal 1
Member 2 cannot promise proposal 0
Member 4 cannot promise proposal 0
Member 5 cannot promise proposal 0
Member 6 cannot promise proposal 0
Member 7 cannot promise proposal 0
Member 0 broadcasting prepare: 9 for value 0
Member 1 promises proposal 9
Member 2 promises proposal 9
Member 3 promises proposal 9
Member 4 promises proposal 9
Member 5 promises proposal 9
Member 6 promises proposal 9
Member 8 promises proposal 9
Member 7 promises proposal 9
Member 2 broadcasting prepare: 2 for value 2
Member 0 broadcasting prepare: 18 for value 0
Member 1 broadcasting proposal: 1 for value 1
Member 1 promises proposal 18
Member 2 promises proposal 18
Member 2 cannot accept proposal 1
Member 0 accepts proposal 1 with value 1
Member 3 promises proposal 18
Member 5 promises proposal 18
Member 7 promises proposal 18
Member 8 promises proposal 18
Member 6 promises proposal 18
Member 0 broadcasting prepare: 27 for value 0
Member 4 cannot accept proposal 1
Member 4 promises proposal 18
Member 3 cannot accept proposal 1
Member 1 promises proposal 27
Member 4 promises proposal 27
Member 3 promises proposal 27
Member 5 cannot accept proposal 1
Member 2 promises proposal 27
Member 5 promises proposal 27
Member 7 cannot accept proposal 1
Member 0 broadcasting prepare: 36 for value 0
Member 6 cannot accept proposal 1
Member 7 promises proposal 27
Member 8 cannot accept proposal 1
Member 6 promises proposal 27
Member 8 promises proposal 27
Member 1 promises proposal 36
Member 2 promises proposal 36
Member 3 promises proposal 36
Member 4 promises proposal 36
Member 5 promises proposal 36
Member 7 promises proposal 36
Member 6 promises proposal 36
Member 1 broadcasting prepare: 10 for value 1
Member 8 promises proposal 36
Member 0 promises proposal 10
Member 2 cannot promise proposal 10
Member 3 cannot promise proposal 10
Member 4 cannot promise proposal 10
Member 6 cannot promise proposal 10
Member 7 cannot promise proposal 10
Member 5 cannot promise proposal 10
Member 8 cannot promise proposal 10
Member 1 broadcasting prepare: 19 for value 1
Member 0 promises proposal 19
Member 2 cannot promise proposal 19
Member 3 cannot promise proposal 19
Member 4 cannot promise proposal 19
Member 5 cannot promise proposal 19
Member 6 cannot promise proposal 19
Member 8 cannot promise proposal 19
Member 7 cannot promise proposal 19
Member 1 broadcasting prepare: 28 for value 1
Member 0 promises proposal 28
Member 2 cannot promise proposal 28
Member 3 cannot promise proposal 28
Member 4 cannot promise proposal 28
Member 5 cannot promise proposal 28
Member 6 cannot promise proposal 28
Member 7 cannot promise proposal 28
Member 8 cannot promise proposal 28
Member 1 broadcasting prepare: 37 for value 1
Member 0 promises proposal 37
Member 2 promises proposal 37
Member 3 promises proposal 37
Member 4 promises proposal 37
Member 5 promises proposal 37
Member 7 promises proposal 37
Member 6 promises proposal 37
Member 8 promises proposal 37
Member 0 cannot promise proposal 2
Member 1 cannot promise proposal 2
Member 2 broadcasting prepare: 11 for value 2
Member 2 broadcasting prepare: 20 for value 2
Member 1 is now unavailable
Member 3 cannot promise proposal 2
Member 4 cannot promise proposal 2
Member 5 cannot promise proposal 2
Member 7 cannot promise proposal 2
Member 6 cannot promise proposal 2
Member 2 broadcasting prepare: 29 for value 2
Member 8 cannot promise proposal 2
Member 0 broadcasting proposal: 36 for value 0
Member 2 cannot accept proposal 36
Member 1 accepts proposal 36 with value 0
Member 4 cannot accept proposal 36
Member 3 cannot accept proposal 36
Member 5 cannot accept proposal 36
Member 7 cannot accept proposal 36
Member 6 cannot accept proposal 36
Member 8 cannot accept proposal 36
Member 0 broadcasting prepare: 45 for value 0
Member 2 promises proposal 45
Member 3 promises proposal 45
Member 6 promises proposal 45
Member 4 promises proposal 45
Member 5 promises proposal 45
Member 8 promises proposal 45
Member 7 promises proposal 45
Member 2 broadcasting prepare: 38 for value 2
Member 0 broadcasting prepare: 54 for value 0
Member 0 broadcasting prepare: 63 for value 0
Member 3 promises proposal 54
Member 2 promises proposal 54
Member 5 promises proposal 54
Member 4 promises proposal 54
Member 6 promises proposal 54
Member 7 promises proposal 54
Member 8 promises proposal 54
Member 6 promises proposal 63
Member 3 promises proposal 63
Member 4 promises proposal 63
Member 7 promises proposal 63
Member 8 promises proposal 63
Member 5 promises proposal 63
Member 0 cannot promise proposal 11
Member 2 broadcasting prepare: 47 for value 2
Member 4 cannot promise proposal 11
Member 3 cannot promise proposal 11
Member 6 cannot promise proposal 11
Member 5 cannot promise proposal 11
Member 1 is now back
Member 7 cannot promise proposal 11
Member 8 cannot promise proposal 11
Member 0 cannot promise proposal 20
Member 3 cannot promise proposal 20
Member 1 cannot promise proposal 20
Member 5 cannot promise proposal 20
Member 4 cannot promise proposal 20
Member 6 cannot promise proposal 20
Member 8 cannot promise proposal 20
Member 7 cannot promise proposal 20
Member 1 is now unavailable
Member 1 broadcasting prepare: 46 for value 1
Member 0 promises proposal 46
Member 6 cannot promise proposal 46
Member 3 cannot promise proposal 46
Member 7 cannot promise proposal 46
Member 5 cannot promise proposal 46
Member 8 cannot promise proposal 46
Member 4 cannot promise proposal 46
Member 0 cannot promise proposal 29
Member 3 cannot promise proposal 29
Member 1 cannot promise proposal 29
Member 4 cannot promise proposal 29
Member 5 cannot promise proposal 29
Member 6 cannot promise proposal 29
Member 7 cannot promise proposal 29
Member 8 cannot promise proposal 29
Member 3 cannot promise proposal 38
Member 0 cannot promise proposal 38
Member 4 cannot promise proposal 38
Member 5 cannot promise proposal 38
Member 7 cannot promise proposal 38
Member 6 cannot promise proposal 38
Member 8 cannot promise proposal 38
Member 0 promises proposal 47
Member 1 is now back
Member 1 promises proposal 47
Member 4 cannot promise proposal 47
Member 3 cannot promise proposal 47
Member 5 cannot promise proposal 47
Member 6 cannot promise proposal 47
Member 7 cannot promise proposal 47
Member 8 cannot promise proposal 47
Member 1 is now unavailable
Member 0 broadcasting proposal: 63 for value 0
Member 1 accepts proposal 63 with value 0
Member 3 accepts proposal 63 with value 0
Member 4 accepts proposal 63 with value 0
Member 8 accepts proposal 63 with value 0
Member 6 accepts proposal 63 with value 0
Member 5 accepts proposal 63 with value 0
Member 7 accepts proposal 63 with value 0
Member 1 broadcasting prepare: 55 for value 1
Member 0 promises proposal 55
Member 3 cannot promise proposal 55
Member 6 cannot promise proposal 55
Member 5 cannot promise proposal 55
Member 4 cannot promise proposal 55
Member 8 cannot promise proposal 55
Member 7 cannot promise proposal 55
Member 1 is now back
Member 1 broadcasting prepare: 64 for value 1
Member 1 broadcasting prepare: 73 for value 1
Member 0 promises proposal 64
Member 3 promises proposal 64
Member 4 promises proposal 64
Member 5 promises proposal 64
Member 7 promises proposal 64
Member 8 promises proposal 64
Member 0 promises proposal 73
Member 6 promises proposal 64
Member 3 promises proposal 73
Member 5 promises proposal 73
Member 6 promises proposal 73
Member 7 promises proposal 73
Member 8 promises proposal 73
Member 4 promises proposal 73
Member 1 is now unavailable
PROPOSAL HAS BEEN CHOSEN: 63
NEW PRESIDENT IS: 0
Member 0 Shutting down
Member 1 Shutting down
Member 2 Shutting down
Member 3 Shutting down
Member 4 Shutting down
Member 5 Shutting down
Member 6 Shutting down
Member 7 Shutting down
Member 8 Shutting down

Process finished with exit code 0
```
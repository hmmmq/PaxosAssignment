
# 项目场景要求
Assignment Description
Objective
To gain an understanding of consensus and voting protocols in the presence of failures of one or more of the participants.
Welcome to the Adelaide Suburbs Council Election!
This year, Adelaide Suburbs Council is holding elections for council president. Any member of its nine person council is eligible to become council president.
Member M1 - M1 has wanted to be council president for a very long time. M1 is very chatty over social media and responds to emails/ texts/calls almost instantly. It is as if M1 has an in-brain connection with their mobile phone!
Member M2 - M2 has also wanted to be council president for a very long time, except their very long time is longer than everybody else's. M2 lives in the Adelaide Hills and thus their internet connection is really poor, almost non-existent. Responses to emails come in very late, and sometimes only to one of the emails in the email thread, so it is unclear whether M2 has read/understood them all. However, M2 sometimes likes to work at Sheoak Café. When that happens, their responses are instant and M2 replies to all emails.
Member M3 - M3 has also wanted to be council president. M3 is not as responsive as M1, nor as late as M2, however sometimes emails completely do not get to M3. The other councillors suspect that it's because sometimes M3 goes camping in the Coorong, completely disconnected from the world.
Members M4-M9 have no particular ambitions about council presidency and no particular preferences or animosities, so they will try to vote fairly. Their jobs keep them fairly busy and as such their response times will vary.
How does voting happen: On the day of the vote, one of the councillors will send out an email/message to all councillors with a proposal for a president. A majority (half+1) is required for somebody to be elected president.
Your assignment will be marked out of 100 points, as following:
• 10 points - Paxos implementation works when two councillors send voting proposals at the same time
• 30 points - Paxos implementation works in the case where all M1-M9 have immediate responses to voting queries
• 30 points - Paxos implementation works when M1 - M9 have responses to voting queries suggested by several profiles (immediate response, small delay, large delay and no response), including when M2 or M3 propose and then go offline
• 20 points - Testing harness for the above scenarios + evidence that they work (in the form of printouts)

这个要求描述了一个关于共识和投票协议的项目任务，特别是在参与者出现故障的情况下。以下是详细解释：

### 项目目标
理解在一个或多个参与者出现故障的情况下，共识和投票协议的工作原理。

### 背景
阿德莱德郊区委员会正在举行委员会主席选举。委员会的九名成员中，任何人都有资格成为委员会主席。

### 成员描述
- **M1**：非常想成为委员会主席，响应非常迅速，几乎是即时的。
- **M2**：也非常想成为委员会主席，但网络连接很差，响应非常迟缓，有时甚至不完整。但在某些情况下（如在咖啡馆工作时），响应会非常快。
- **M3**：也想成为委员会主席，响应速度介于 M1 和 M2 之间，有时完全无法收到邮件。
- **M4-M9**：没有特别的主席意图，响应时间各不相同。

### 投票过程
在投票当天，一名议员会向所有议员发送一封提案邮件。需要超过半数（即 5 票）才能选出主席。

### 评分标准
- **10 分**：Paxos 实现能够在两个议员同时发送投票提案时工作。
- **30 分**：Paxos 实现能够在所有 M1-M9 对投票查询有即时响应的情况下工作。
- **30 分**：Paxos 实现能够在 M1-M9 对投票查询有不同响应时间（即时响应、小延迟、大延迟和无响应）的情况下工作，包括 M2 或 M3 提出提案后离线的情况。
- **20 分**：测试工具能够验证上述场景，并提供工作证据（如打印输出）。


这个代码实现了一个模拟的Paxos选举协议。以下是对代码的详细解释：

1. **`Member` 类**：
   - **功能**：表示一个成员，包含成员的ID、响应时间和可用性。
   - **主要方法**：
      - `vote(String candidate)`：模拟成员投票给候选人，如果成员不可用则返回`false`，否则模拟响应延迟后返回`true`。

2. **`PaxosServer` 类**：
   - **功能**：管理投票和选举结果。
   - **主要方法**：
      - `receiveVote(String memberId, String candidate)`：接收成员的投票，如果成员已经投票则返回`false`，否则记录投票并返回`true`。
      - `checkMajority(String candidate)`：检查某个候选人是否获得了多数票。
      - `announceResult()`：宣布选举结果，统计每个候选人的票数。

3. **`PaxosProtocol` 类**：
   - **功能**：实现Paxos选举协议，管理选举过程。
   - **主要方法**：
      - `startElection(String candidate)`：启动选举，所有成员并发投票，等待所有投票完成后检查候选人是否获得多数票。

4. **`PaxosElectionSimulation` 类**：
   - **功能**：主类，模拟Paxos选举过程。
   - **主要方法**：
      - `main(String[] args)`：创建成员和服务器，启动多个选举线程，模拟并发选举过程，最后宣布选举结果。

代码的主要流程如下：
1. 创建9个成员，每个成员有不同的响应时间。
2. 创建一个`PaxosServer`实例来管理投票。
3. 创建一个`PaxosProtocol`实例来管理选举过程。
4. 启动三个选举线程，模拟并发选举：
   - M1和M2同时启动选举。
   - M3在500毫秒后启动选举。
5. 等待所有选举线程完成后，宣布最终的选举结果。
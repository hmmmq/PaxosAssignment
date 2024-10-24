
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
# driver包
[PaxosDriver.java](main%2Fdriver%2FPaxosDriver.java)
`PaxosDriver` 类用于模拟投票场景。它从一个配置文件（`config.json`）中读取场景配置，并根据这些配置运行投票模拟。具体功能包括：
1. **读取配置文件**：从命令行参数中获取配置文件路径，并读取其中的 JSON 数据。
2. **运行场景**：遍历 JSON 数据中的每个场景，调用 `runScenario` 方法运行每个场景。
3. **模拟投票**：在 `runScenario` 方法中，调用 `simulateVoting` 方法模拟投票过程。
4. **启动邮件服务器**：在 `simulateVoting` 方法中，启动一个邮件服务器。
5. **创建成员线程**：根据配置文件中的成员信息，创建并启动多个成员线程。
6. **等待投票结束**：等待所有成员线程完成投票过程。
7. **处理线程终止**：在投票结束后，终止所有成员线程。

该类主要用于测试和模拟分布式系统中的投票协议（如 Paxos 协议）。
## 配置文件config.json
`config.json` 文件包含了两个不同的场景配置，每个场景描述了多个成员的行为和响应时间。以下是对每个场景的详细解释：

1. **All Proposers**：
    - **描述**：两个议员同时为自己发送投票提案。M0, M1, M3 为自己发送投票提案。M0 永远可用并立即响应。M1 短时间内可用并有延迟回复。M2 无限期不可用，但在可用时有中等回复。其他议员有不同的响应时间，但不会提出任何值。这些成员永远不会变得不可用。
    - **成员**：
        - 前两个成员M1,M2 (`timeToPropose` 为 0) 会同时提出提案，并且 `ambition` 属性为 `true`，表示他们有提案的意图。
        - M1 (`timeToPropose` 为 250, `ambition` 为 `true`, `responseTime` 为 `IMMEDIATE`) 会立即提出提案。
      、- M2 (`timeToPropose` 为 1900, `ambition` 为 `true`, `timeToFail` 为 2000, `timeToRestart` 为 4000, `responseTime` 为 `LATE`) 会在短时间内提出提案，并有延迟回复。
        - M3 (`timeToPropose` 为 250, `ambition` 为 `true`, `timeToFail` 为 4000, `timeToRestart` 为 -1, `responseTime` 为 `MEDIUM`) 会在可用时提出提案，并有中等回复。
        - 其余成员 (`timeToPropose` 为 -1) 不会提出提案,并且`ambition` 属性为 `false`，表示他们没有提案的意图。
        - 其余成员有不同的响应时间 (`responseTime` 为 `NEVER`, `LATE`, `MEDIUM`, `LATE`, `IMMEDIATE`, `MEDIUM`)，但不会提出任何值。


# eclient包
这个文件包含两个类，分别是 `EmailClient` 和 `SocketConnecter`。以下是它们的功能：

1. **`EmailClient` 类**：
    - **功能**：维护与服务器的一对一连接，提供发送和接收消息的服务。
    - **主要方法**：
        - `send(String message, int recipient)`：向服务器发送消息。
        - `receive()`：接收一条消息。
        - `stripMessage(String message)`：去除消息中的收件人 ID，并检查收件人是否正确。
        - `ensureConnection()`：确保与服务器的连接已建立。
        - `initializeInbox()`：初始化一个线程，将接收到的消息缓冲到收件箱中。

2. **`SocketConnecter` 类**：
    - **功能**：用于异步连接服务器，允许用户在主线程中继续操作。
    - **主要方法**：
        - `getConnection()`：返回一个 `Future<Socket>`，用于获取服务器连接。
        - `SocketConnecterCallable` 内部类：实现 `Callable<Socket>` 接口，轮询服务器连接并返回一个 `Socket` 对象。
# eserver包
`src/main/eserver/EmailConnection.java` 文件包含两个类，分别是 `EmailConnection` 和 `ResponderRunnable`。以下是它们的功能：

1. **`EmailConnection` 类**：
    - **功能**：监听单个电子邮件连接，接收并根据 ID 将电子邮件发送给收件人。
    - **主要方法**：
        - `send(String message)`：向客户端发送消息。
        - `join()`：优雅地停止响应线程。
        - `respond(ConcurrentMap<Integer, EmailConnection> emailRegistry)`：初始化响应线程。

2. **`ResponderRunnable` 类**：
    - **功能**：监听与电子邮件客户端的单个连接，并使用 `emailRegistry` 将消息发送给不同的收件人。
    - **主要方法**：
        - `run()`：读取客户端 ID 并将其注册到 `emailRegistry`，然后监听电子邮件客户端并将消息重定向给收件人。
        - `respond(BufferedReader reader)`：监听电子邮件客户端并将邮件重定向给收件人。

`src/main/eserver/EmailServer.java` 文件包含一个类：

3. **`EmailServer` 类**：
    - **功能**：监听并接受电子邮件连接。
    - **主要方法**：
        - `run()`：启动服务器套接字，监听指定端口，并为每个连接创建一个新的 `EmailConnection` 实例。

# paxos包
`src/main/paxos/AcceptorRunnable.java` 文件包含一个类：

1. **`AcceptorRunnable` 类**：
    - **功能**：响应来自生产者/消费者队列的准备和提案消息。
    - **主要方法**：
        - `run()`：启动线程，接收消息并处理准备和提案请求。
        - `receiveMessages()`：接收并处理消息，根据消息类型调用相应的处理方法。
        - `handlePrepare(String message)`：处理准备请求，发送承诺或拒绝消息。
        - `handleProposal(String message)`：处理提案请求，发送接受或拒绝消息。

`src/main/paxos/DelayedMessageExecutor.java` 文件包含一个类：
2. **`DelayedMessageExecutor` 类**：
    - **功能**：在预定义的延迟后异步发送消息，使用固定线程池。
    - **主要方法**：
        - `send(String message, int recipient)`：提交任务到线程池，并在某些延迟后发送消息。

`src/main/paxos/MemberRunnable.java` 文件包含一个类：

3. **`MemberRunnable` 类**：
    - **功能**：实现 Paxos 协议，管理提议者和接受者线程，并处理模拟故障。
    - **主要方法**：
        - `run()`：启动提议者和接受者线程，并处理故障模拟。
        - `handleFailure(Timer timer)`：计算当前是否处于故障状态，并设置定时器。
        - `multiplexMessages()`：接收消息并将其分发到相应的队列。
        - `gracefulShutdown()`：优雅地关闭提议者和接受者线程。

`src/main/paxos/MessageCodes.java` 文件包含一个类：

4. **`MessageCodes` 类**：
    - **功能**：定义用于标识五种消息类型的字符常量。
    - **主要常量**：
        - `PREPARE`：表示准备消息的字符常量。
        - `PROMISE`：表示承诺消息的字符常量。
        - `PROPOSAL`：表示提案消息的字符常量。
        - `ACCEPT`：表示接受消息的字符常量。
        - `PREPARENACK`：表示准备否定确认消息的字符常量。
        - `PROPOSALNACK`：表示提案否定确认消息的字符常量。

`src/main/paxos/ProposerRunnable.java` 文件包含一个类：

5. **`ProposerRunnable` 类**：
    - **功能**：实现 Paxos 协议中的提议者角色，尝试发出准备请求和提案请求。
    - **主要方法**：
        - `run()`：线程入口点，接收消息并根据状态机处理。
        - `receiveMessage()`：读取消息队列并处理不同类型的消息。
        - `next(int newState)`：状态机的状态转换方法。
        - `receivePromise(String message)`：处理承诺消息。
        - `receivePromisenack()`：处理承诺否定确认消息。
        - `receiveAccept(String message)`：处理接受消息。
        - `receiveAcceptnack()`：处理提案否定确认消息。
        - `timeout()`：处理超时事件。
        - `setUniqueProposal()`：设置全局唯一的提案 ID。
        - `broadCastPrepare()`：广播准备请求。
        - `broadCastProposal()`：广播提案请求。

`src/main/paxos/ResponseTime.java` 文件包含一个枚举类：

6. **`ResponseTime` 枚举类**：
    - **功能**：定义成员的不同响应时间变量。
    - **枚举常量**：
        - `IMMEDIATE`：立即响应。
        - `MEDIUM`：中等响应时间。
        - `LATE`：延迟响应。
        - `NEVER`：不响应。
          `src/main/paxos/Timer.java` 文件包含一个类：

7. **`Timer` 类**：
    - **功能**：在特定时间后中断线程。
    - **主要方法**：
        - `setTimeout(Thread interruptee, int timeout)`：在指定的超时时间后中断传入的线程。
    - **成员变量**：
        - `ExecutorService executor`：用于执行定时任务的单线程执行器。
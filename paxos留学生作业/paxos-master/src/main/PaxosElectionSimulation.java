package main;

import java.util.*;
import java.util.concurrent.*;

class Member {
    String id;
    int responseTime; // In milliseconds
    boolean available;

    public Member(String id, int responseTime, boolean available) {
        this.id = id;
        this.responseTime = responseTime;
        this.available = available;
    }

    public boolean vote(String candidate) {
        if (!available) {
            System.out.println(id + " is unavailable.");
            return false;
        }
        try {
            Thread.sleep(responseTime);  // Simulating response delay
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println(id + " votes for " + candidate);
        return true;
    }
}

class PaxosServer {
    Map<String, String> votes = new ConcurrentHashMap<>(); // member -> vote
    int majority;
    String currentProposal; // Store the latest proposal

    public PaxosServer(int totalMembers) {
        this.majority = totalMembers / 2 + 1;
    }

    public synchronized boolean receiveVote(String memberId, String candidate) {
        if (votes.containsKey(memberId)) {
            System.out.println(memberId + " has already voted.");
            return false;
        }
        votes.put(memberId, candidate);
        return true;
    }

    public boolean checkMajority(String candidate) {
        long count = votes.values().stream().filter(c -> c.equals(candidate)).count();
        return count >= majority;
    }

    public void announceResult() {
        Map<String, Long> results = new HashMap<>();
        for (String candidate : votes.values()) {
            results.put(candidate, results.getOrDefault(candidate, 0L) + 1);
        }
        System.out.println("Election Results: " + results);
    }
}

class PaxosProtocol {
    private final PaxosServer server;
    private final List<Member> members;

    public PaxosProtocol(List<Member> members, PaxosServer server) {
        this.members = members;
        this.server = server;
    }

    public void startElection(String candidate) {
        System.out.println(candidate + " is starting an election.");
        ExecutorService executor = Executors.newFixedThreadPool(members.size());

        for (Member member : members) {
            executor.submit(() -> {
                if (member.vote(candidate)) {
                    server.receiveVote(member.id, candidate);
                }
            });
        }

        executor.shutdown();
        try {
            executor.awaitTermination(10, TimeUnit.SECONDS);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        if (server.checkMajority(candidate)) {
            System.out.println(candidate + " is elected as council president!");
        } else {
            System.out.println(candidate + " did not get a majority vote.");
        }
    }
}

public class PaxosElectionSimulation {
    public static void main(String[] args) {
        // Members M1 - M9
        List<Member> members = Arrays.asList(
                new Member("M1", 100, true),   // Fastest response
                new Member("M2", 300, true),   // More delayed response
                new Member("M3", 200, true),   // Slightly delayed response
                new Member("M4", 300, true),
                new Member("M5", 100, true),
                new Member("M6", 500, true),
                new Member("M7", 400, true),
                new Member("M8", 250, true),
                new Member("M9", 800, true)
        );

        PaxosServer server = new PaxosServer(members.size());
        PaxosProtocol protocol = new PaxosProtocol(members, server);

        // Start elections in separate threads to simulate concurrent proposals
        ExecutorService electionExecutor = Executors.newFixedThreadPool(3);

        // M1 and M2 start elections at the same time
        electionExecutor.submit(() -> protocol.startElection("M1"));
        electionExecutor.submit(() -> protocol.startElection("M2"));

        // M3 starts election after a delay
        electionExecutor.submit(() -> {
            try {
                Thread.sleep(500); // Delay M3's election proposal
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            protocol.startElection("M3");
        });

        electionExecutor.shutdown();
        try {
            electionExecutor.awaitTermination(10, TimeUnit.SECONDS);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        // Announce final result
        server.announceResult();
    }
}

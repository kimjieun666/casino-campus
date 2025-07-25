package game.participants.dealer;

import game.components.deck.Deck;
import game.participants.player.Player;

import java.util.ArrayList;
import java.util.List;

/**
 * 딜러의 기본 동작을 정의하는 클래스입니다.
 * 딜러는 게임을 진행하고, 카드를 나누고, 승자를 결정하는 역할을 합니다.
 * 
 * 구현이 필요한 메서드:
 * - startNewGame() 메서드: 새 게임 시작
 * - dealCards() 메서드: 카드 분배
 * - determineWinners() 메서드: 승자 판정
 * - distributePrize() 메서드: 상금 분배
 * - playGame() 메서드: 전체 게임 진행
 * 
 * @author XIYO
 * @version 1.0
 * @since 2024-01-01
 */
public class Dealer {
    private Deck deck;
    private static final int CARDS_PER_PLAYER = 5;
    private static final int PRIZE_PER_ROUND = 100;

    /**
     * Dealer 생성자
     */
    public Dealer() {
        this.deck = new Deck();
    }

    /**
     * 새로운 게임을 시작합니다.
     * 덱을 초기화하고 셔플합니다.
     */
    public void startNewGame() {
        // TODO: 구현하세요
        // 1. deck.reset()으로 덱 초기화
        deck = new Deck();
        // 2. deck.shuffle()로 카드 섞기
        deck.shuffle();
    }

    /**
     * 플레이어들에게 카드를 분배합니다.
     *
     * @param players 카드를 받을 플레이어 목록
     */
    public void dealCards(List<? extends Player> players) {
        // TODO: 구현하세요
        // 힌트:
        // 1. 각 플레이어의 핸드를 clean() 기존 남아 있는 카드 비우기
        for (Player player : players) {
            player.getHand().clear();
        }
        // 2. 각 플레이어에게 CARDS_PER_PLAYER장씩 분배    // CARDS_PER_PLAYER장  한장씩 ++1
        for (int i = 0; i < CARDS_PER_PLAYER; i++) {
            for (Player player : players) {//덱에서 한 장씩 뽑고
                // 3. deck.drawCard()를 사용하여 카드를 뽑고
                var card = deck.drawCard();
                player.getHand().add(card);
            }
        }
    }

    /**
     * 라운드의 승자를 결정합니다.
     *
     * @param players 참가 플레이어 목록
     * @return 승자 목록 (동점일 경우 여러 명)
     */
    public List<? extends Player> determineWinners(List<? extends Player> players) {
        // TODO: 구현하세요
        // 힌트:
        // 1. 최고 점수를 가진 플레이어들을 찾기 // 2. List<Player> winners = new ArrayList<>();]
        List<Player> winners = new ArrayList<>();
        int 최고점수 = 0;
        for (Player player : players) {
            // 3. 각 플레이어의 hand.evaluateHand()로 핸드 순위 확인
            int 점수 = player.getHand().evaluate().getScore(); // 최고점수 -1 <=
            // 4. 가장 높은 점수를 가진 플레이어들을 winners에 추가
            for (int i = 0; i < CARDS_PER_PLAYER; i++) {
                winners.add(player);
                // 5. 동점자가 있을 수 있음을 고려
                if (최고점수==점수); //최고점수==점수
                return winners; //승자들에게 상금을 분배합니다.
            }
        }
    /**
     *
     * 
     * @param winners 승자 목록
     * @param prizeAmount 각 승자가 받을 상금
     */
    public void distributePrize(List<? extends Player> winners, int prizeAmount) {
        // TODO: 구현하세요
        // 힌트:
        // 1. 각 승자에게 prizeAmount만큼 돈 추가
        // 2. winner.addMoney(prizeAmount) 사용
        throw new UnsupportedOperationException("Not implemented yet");
    }
    
    /**
     * 전체 게임을 진행합니다.
     * 
     * @param players 참가 플레이어 목록
     * @param rounds 진행할 라운드 수
     */
    public void playGame(List<? extends Player> players, int rounds) {
        if (players == null || players.isEmpty()) {
            throw new IllegalArgumentException("플레이어가 없습니다.");
        }
        if (rounds <= 0) {
            throw new IllegalArgumentException("라운드 수는 양수여야 합니다.");
        }
        
        // TODO: 구현하세요
        // 힌트:
        // for (int round = 1; round <= rounds; round++) {
        //     1. startNewGame()으로 새 게임 시작
        //     2. dealCards(players)로 카드 분배
        //     3. List<? extends Player> winners = determineWinners(players)
        //     4. distributePrize(winners, PRIZE_PER_ROUND)
        //     5. 기록 업데이트:
        //        - 승자들: winner.recordWin()
        //        - 패자들: loser.recordLose()
        //        - 동점자가 여러명이면: 모두 recordDraw()
        // }
        throw new UnsupportedOperationException("Not implemented yet");
    }
}
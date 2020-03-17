package practices.hackerrank.medium;

import static org.junit.Assert.assertEquals;

import java.util.Arrays;
import java.util.Comparator;
import java.util.Scanner;

import org.junit.Test;

class Checker implements Comparator<Player> {
	@Override
	public int compare(Player p1, Player p2) {
		if (p1.score < p2.score) {
			return 1;
		} else if (p1.score == p2.score) {
			return p1.name.compareTo(p2.name);
		} else if (p1.score > p2.score) {
			return -1;
		}
		return Integer.MAX_VALUE;
	}
}

class Player {
	String name;
	int score;

	Player(String name, int score) {
		this.name = name;
		this.score = score;
	}
}

public class JavaComparator {

	@Test
	public void test1() {
		int n = 5;

		Player[] player = new Player[n];
		Checker checker = new Checker();

		int idx = 0;
		player[idx++] = new Player("amy", 100);
		player[idx++] = new Player("david", 100);
		player[idx++] = new Player("heraldo", 50);
		player[idx++] = new Player("aakansha", 75);
		player[idx++] = new Player("aleksa", 150);

		Arrays.sort(player, checker);

		idx = 0;
		assertEquals("aleksa", player[idx++].name);
		assertEquals("amy", player[idx++].name);
		assertEquals("david", player[idx++].name);
		assertEquals("aakansha", player[idx++].name);
		assertEquals("heraldo", player[idx++].name);

		for (int i = 0; i < player.length; i++) {
			System.out.printf("%s %s\n", player[i].name, player[i].score);
		}
	}

	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		int n = scan.nextInt();

		Player[] player = new Player[n];
		Checker checker = new Checker();

		for (int i = 0; i < n; i++) {
			player[i] = new Player(scan.next(), scan.nextInt());
		}
		scan.close();

		Arrays.sort(player, checker);
		for (int i = 0; i < player.length; i++) {
			System.out.printf("%s %s\n", player[i].name, player[i].score);
		}
	}
}

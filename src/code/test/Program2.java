package code.test;

import static org.junit.Assert.assertArrayEquals;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

import org.junit.Test;

public class Program2 {
//	문제 설명
//	하루 동안 영화 관람객이 예매한 영화들이 무작위로 섞여서 주어집니다. 
//	이때 가장 많이 예매된 순서대로 영화 제목을 정렬하려고 합니다. 
//	관람객이 예매한 영화의 목록 movie가 매개변수로 주어질 때, 
//	가장 많이 예매된 영화 순으로 영화 제목을 정렬하여 return 하도록 solution 함수를 완성해 주세요. 
//	예매 수가 같은 영화는 사전 순으로 정렬하세요.
//
//	제한사항
//	예매된 영화 목록의 길이는 1이상 10,000이하 입니다.
//	영화 제목의 길이는 1자 이상 50자 이하이며, 공백없이 모두 소문자입니다.
//	같은 제목의 서로 다른 영화는 없다고 가정합니다.

	public String[] solution(String[] movie) {

		// 무비 제목 중복 제거 해서 저장하기
		String[] uniqueMovies = getUniqueMovie(movie);
		Arrays.sort(uniqueMovies, Collections.reverseOrder());
		int length = uniqueMovies.length;

		// 저장된 무비 제목으로 카운트 세서 저장하기
		int[] movieCnt = new int[length];
		for (int i = 0; i < length; i++) {
			for (int j = 0; j < movie.length; j++) {
				if (uniqueMovies[i].equals(movie[j])) {
					movieCnt[i]++;
				}
			}
		}

		// 갯수 저장된 array : movieCnt
		// 무비제목 array : uniqueMovies
		// 오름차순으로 갯수를 정렬한 array
		int[] sortedMovieCnt = movieCnt.clone();
		Arrays.sort(sortedMovieCnt);

		// 새로운 공간에 저장
		String[] sortedMovies = new String[length];
		for (int i = 0; i < length; i++) {
			for (int j = 0; j < length; j++) {
				if (sortedMovieCnt[i] == movieCnt[j]) {
					sortedMovies[i] = uniqueMovies[j];
					movieCnt[j] = -1;
					break;
				}

			}
		}

		// 오름차순에서 내림차순으로 순서 바꾸기
		String[] answer = new String[length];
		int answerIdx = 0;
		for (int i = length - 1; i >= 0; i--) {
			answer[answerIdx++] = sortedMovies[i];
		}
		return answer;

	}

	public String[] getUniqueMovie(String[] movie) {
		List<String> uniqueMovieNames = new ArrayList<String>();
		boolean isNotUnique = false;
		for (int i = 0; i < movie.length; i++) {
			if (i < 1) {
				uniqueMovieNames.add(movie[i]);
			} else {
				for (int j = 0; j < uniqueMovieNames.size(); j++) {
					isNotUnique = movie[i].equals(uniqueMovieNames.get(j));
					if (isNotUnique)
						break;
				}

				if (!isNotUnique) {
					uniqueMovieNames.add(movie[i]);
				}
			}
		}

		String[] array = new String[uniqueMovieNames.size()];
		uniqueMovieNames.toArray(array);
		return array;
	}

	@Test
	public void testGetUniqueMovie() {
		String[] movie = { "spy", "ray", "spy", "room", "once", "ray", "spy", "once" };
		String[] expecteds = { "spy", "ray", "room", "once" };
		assertArrayEquals(expecteds, getUniqueMovie(movie));

	}

	@Test
	public void test1() {
		String[] movie = { "spy", "ray", "spy", "room", "once", "ray", "spy", "once" };
		String[] expected = { "spy", "once", "ray", "room" };
		assertArrayEquals(expected, solution(movie));
	}
}

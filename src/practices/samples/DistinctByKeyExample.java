package practices.samples;

import static org.junit.Assert.assertArrayEquals;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import java.util.function.Function;
import java.util.function.Predicate;
import java.util.stream.Collectors;

import org.junit.Test;

public class DistinctByKeyExample {
	class Album {
		int idx;
		String genre;

		Album(int idx, String genre) {
			this.idx = idx;
			this.genre = genre;
		}

		@Override
		public String toString() {
			return "Album [idx=" + idx + ", genre=" + genre + "]";
		}

	}

	// 중복 제거를 위한 함수
	public static <T> Predicate<T> distinctByKey(Function<? super T, Object> keyExtractor) {
		Map<Object, Boolean> seen = new ConcurrentHashMap<>();
		return t -> seen.putIfAbsent(keyExtractor.apply(t), Boolean.TRUE) == null;
	}

	public String[] solution(String[] genres) {
		List<Album> albums = new ArrayList<>();
		for (int i = 0; i < genres.length; i++) {
			albums.add(new Album(i, genres[i]));
		}

		List<Album> distinctAlbums = albums.stream().filter(distinctByKey(o -> o.genre)).collect(Collectors.toList());
		String[] answer = new String[distinctAlbums.size()];
		for (int i = 0; i < answer.length; i++) {
			answer[i] = distinctAlbums.get(i).genre;
		}

		return answer;
	}

	@Test
	public void test1() {
		String[] expecteds = { "classic", "pop" };
		String[] genres = { "classic", "pop", "classic", "classic", "pop" };
		assertArrayEquals(expecteds, solution(genres));
	}
}

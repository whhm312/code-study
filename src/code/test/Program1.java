package code.test;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

public class Program1 {
//	g-index는 연구자의 연구 업적을 평가하는 지표의 하나입니다. 
//	어떤 연구자가 발표한 논문의 개수가 N일 때 g-index는 다음과 같습니다.
//
//	g-index : N개의 논문 중 상위 g개의 논문의 인용 횟수의 합이 
//	g제곱 이상이 되도록 하는 g 값 중에서 최댓값
//	
//	어떤 연구자가 발표한 N개의 논문의 각각의 인용 횟수 K가 담긴 배열이 매개변수 paper로 주어질 때, 
//	이 연구자의 g-index를 return 하도록 solution 함수를 완성해 주세요.
//
//	제한사항
//	논문의 개수 N : N은 1,000이하의 자연수
//	각 논문의 인용 횟수 K: K는 0 이상 10,000 이하의 정수

	public int solution(int[] paper) {
		int answer = -1;

		return answer;
	}

	@Test
	public void test1() {
		int[] paper = { 1, 0, 0, 3, 0, 1 };
		int expected = 2;
		assertEquals(expected, solution(paper));
	}

	@Test
	public void test2() {
		int[] paper = { 7, 5, 8, 10, 6, 9, 5 };
		int expected = 7;
		assertEquals(expected, solution(paper));
	}

	@Test
	public void test3() {
		int[] paper = { 3, 0, 3, 0, 3, 0 };
		int expected = 3;
		assertEquals(expected, solution(paper));
	}

}

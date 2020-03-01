package practices.programmers.level1;

import practices.commons.Tools;

class PipiesSolution {
	public static void main(String arg[]) {
		// ()(((()())(())()))(()) -- 17
		// () : 시작점 (아무 작업 안함)
		// ( : 쇠막대 시작점, 연속으로 나타날때 쇠막대의 갯수 1 증가
		// ( () () ) : 한개의 쇠 막대에 두개의 레이저라는 표시
		// (()) : 한개의 쇠 막대에 한개의 레이저 표시,
		// ( () ) : 막대1:레이저1 -> 막대 2 -> (막대*레이저)+1
		// ( () () ) : 막대 1:레이저2 -> 막대 3 -> (막대*레이저)+1

		// (((() : ( 갯수만큼 막대, () 갯수만큼 레이저
		// (()) : () 안에 () - 1막대, 1레이저
		// () : 시작점 - 무시

		String inputPipe = "()((()())(()))";
		String laserForm = "()";
		String startForm = laserForm;
		String pipeForm = "(";
		int laserCnt = 0;
		int pipeCnt = 0;
		int totalPipeCnt = 0;
		if (startForm.equals(inputPipe.substring(0, 2))) {
			inputPipe = inputPipe.substring(2);
			String[] pipes = splitPipes(inputPipe);
			for (int i = 0; i < pipes.length; i++) {
				laserCnt = Tools.count(pipes[i], laserForm);
				pipeCnt = Tools.count(pipes[i], pipeForm) - laserCnt;
				totalPipeCnt += (pipeCnt * laserCnt) + (1 * pipeCnt);
			}
			System.out.println(totalPipeCnt);
		}
	}

	private static String[] splitPipes(String inputPipe) {
		String pipeCutForm = "\\)\\(\\(";
		String[] pipes = inputPipe.split(pipeCutForm);
		for (int i = 0; i < pipes.length; i++) {
			if (i != 0) {
				pipes[i] = "((" + pipes[i];
			} else {
				pipes[i] = pipes[i] + ")";
			}
		}
		return pipes;
	}
}
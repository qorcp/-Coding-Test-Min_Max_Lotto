import java.util.Arrays;

public class Main {

	public static void main(String[] args) {
		
		int[] lottos = new int[] {44, 1, 0, 0, 31, 25};
		int[] win_nums = new int[] {31, 10, 45, 1, 6, 19};
		
		int[] answer = new int[2];
		
		// Input 값을 정렬
		Arrays.sort(lottos);
		Arrays.sort(win_nums);
		int cnt = 0;
		
		// lottos 배열에 0의 갯수 찾기
		for(int i = 0; i < lottos.length; i++) {
			if(lottos[i] != 0) {
				break;
			}else {
				cnt++;
			}
		}
		
		System.out.print("The counting number of zero is : " + cnt + "\n");
		
		//
		for(int i = 0; i < win_nums.length; i++) {
			for(int j = cnt; j < 6; j++) {
				// 구매한 로또와 당청 번호가 같은지 확인
				if(win_nums[i] != lottos[j]) {
					continue;
				}else {
					// answer에 값은 2개뿐 (최고 순위, 최저 순위)
					answer[0]++;
					answer[1]++;
				}
				
			}
		}
		
		// 최고 순위에 0의 갯수를 더하기 (0 은 어떤 숫자도 되기 떄문에 당첨 번호로 바꿀수 있다)
		answer[0] += cnt;
		
		// 최고 순위에 0의 갯수를 더한 다음 당첨 번호항 몇개가 일치 하는지 확인
		for(int num : answer) {
			System.out.print("This is answer : "+num + "\n");
		}
		
		// 현재의 answer 값에 마추어서 최고 및 최저 순위로 바꺼 주기
		for(int i = 0; i < answer.length; i++) {
			if(answer[i] == 6) {
				answer[i] = 1;
			}else if(answer[i] == 5) {
				answer[i] = 2;
			}else if(answer[i] == 4) {
				answer[i] = 3;
			}else if(answer[i] == 3) {
				answer[i] = 4;
			}else if(answer[i] == 2) {
				answer[i] = 5;
			}else {
				answer[i] = 6;
			}
		}
		
		// 결과값 출력
		for(int num : answer) {
			System.out.print("This is final answer : "+num + "\n");
		}
	}

}

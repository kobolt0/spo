package com.example.workflow;

public class CommonUtil {

	public static boolean solution(int num) {
	     int answer = 0;
	     for(int i=2; i<=num; i++){
	         boolean flag = true;
	         for(int j=2; j<=Math.sqrt(i); j++) {
	        	 if(i%j == 0)  { //나누어떨어지면 소수X
	        	   flag = false; //falg를 false로 바꿔서 소수가 아니라고 체크
	                   break; //break를 안해주면 효율성 테스트 통과 못함
	        	  } 
	           }
	      if(flag==true) //소수인 숫자는 flag가 변하지 않고 true 
	         answer++; 
	    }
	   return answer == 1;
	}

	
	public static int solution1(int n) {
	     int answer = 0;
	     for(int i=2; i<=n; i++){
	         boolean flag = true;
	         for(int j=2; j<=Math.sqrt(i); j++) {
	        	 if(i%j == 0)  { //나누어떨어지면 소수X
	        	   flag = false; //falg를 false로 바꿔서 소수가 아니라고 체크
	                   break; //break를 안해주면 효율성 테스트 통과 못함
	        	  } 
	           }
	      if(flag==true) { //소수인 숫자는 flag가 변하지 않고 true 
	         answer++;
	         System.out.println(n);
	      }
	    }
	   return answer;
	}
	
	public static String main1(int count) {

		int i = 0;
		
		int num = 2;
		
		String str = "";
		
		while (i < count) {
			num ++;
			if (solution(num)) {
				str += num + "/";
				System.out.println(str);
				i++;
			}
		}

		return str;
	}

	public static void main(String[] args) {
//		main1(10);
//		solution(5);
		solution1(3);
//		System.out.println(solution1(3));
	}
}
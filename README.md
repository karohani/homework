1. 

Backend : JAVA8, Spring-boot 2.0, spring-data-jpa, lombok,
DB : H2 
FrontEnd : Babel, Webpack, Vuejs, ES6

2. 문제 해결 전략 
이메일이 들어오면 16자리 62자 문자열로 매핑하는 방법을 사용하였습니다. 해당 문자열을 곱하기 연산한 후 모듈러 연산을 통해서 
나오는 나머지 값을 매핑하고 16자리가 넘는 문자열에 대해서 슬라이스를 하였습니다. 

2.1 컬리전 문제 
해당 함수에 대해서 컬리전이 발생할 경우 특정 문자열을 곱해준 다음 다시 함수를 호출하는 전략을 취했습니다. 

3. 빌드 npm run build && mvn compile && mvn package

java -jar target/kakao-0.0.1-SNAPSHOT.jar



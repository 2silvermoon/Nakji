# 근거리 무선 통신 기반의 학생 무인 인증 시스템

__강원대학교 학생 무인 인증시스템 구현__

## 개요
>학생들은 평일 야간 및 주말, 휴일에 학교에 출입하려면 출입 인증이 된 학생증이 필요하다.<br>
하지만 일부 학생들은 학생증을 안만들었거나 출입 인증이 안된 학생증을 가졌고 또는 아예 들고 다니지를 않는다.<br>
이에 학생증이 없더라도 휴대폰을 사용한 학생인증 기능을 만들고자 한다.<br>

## 기간
>2019년 7월 말 ~ 2019년 11월 19일

## 역할
>안드로이드를 통해 들어온 데이터 검증 및 처리 <br>

## 기술 스택
>Spring Boot, MariaDB, Hibernate, JPA<br>

## 결과
>데이터 검증 및 처리에 대해 배울 수 있었고, REST 방식에 대해 알게 되었다.<br>

## Client Side
>https://github.com/2silvermoon/Rojae

## 아쉬운 점
> 도어락의 상태 변화 등 결과를 시각적으로 보여줄 수 없었다. <br>
-> 단순히 True or False로만 출력되기 때문에<br>

> 학교 측과 협의가 불가능했다. <br>
-> 교내 세콤 측과 연락을 했지만 관리자가 자주 방문하지 않았고 따라서 학생 테이블의 구조 등을 파악하기 어려웠다.<br>

## 다이어그램

__Client Side__
![diagram](https://user-images.githubusercontent.com/41769568/70390882-8c12d780-1a12-11ea-9379-86aaf70d6717.png)


__Server Side__ <br>
![Github](https://user-images.githubusercontent.com/37291245/69150331-d98adb80-0b1b-11ea-9463-257a7700feb6.png)

## 실행화면

__로그인__

<img src="https://user-images.githubusercontent.com/41769568/70390928-f3308c00-1a12-11ea-96bb-adfcc4108e25.png" width="230" height="400"></img>
<img src="https://user-images.githubusercontent.com/41769568/70390929-f461b900-1a12-11ea-8f8b-b9f34fea0b39.png" width="230" height="400"></img>

----------------------------------------------------------------------

__회원가입__

<img src="https://user-images.githubusercontent.com/41769568/70390953-28d57500-1a13-11ea-9fd4-d93f0bce11d7.png" width="230" height="400"></img>
----------------------------------------------------------------------


__로딩화면__

<img src="https://user-images.githubusercontent.com/41769568/70390939-11968780-1a13-11ea-9176-239e89b1d06c.png" width="230" height="400"></img>
----------------------------------------------------------------------


__메인화면 및 NFC통신__

<img src="https://user-images.githubusercontent.com/41769568/70390948-1f4c0d00-1a13-11ea-97e4-4a1b3af27ddc.png" width="230" height="400"></img>
<img src="https://user-images.githubusercontent.com/41769568/70390949-207d3a00-1a13-11ea-8721-3bf4c8c04fa2.png" width="230" height="400"></img>

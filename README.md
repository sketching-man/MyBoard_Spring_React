# MyBoard_Spring_React, Backend

## Purpose

내가 게시판을 한 번 만들어보고 싶다.\
기왕에 만들어보는거 제대로 만들어보자 싶어서,\
요구사항 정리 및 프론트 & 백 분리 작업도 진행했고, 각자 다른 서버에서 돌릴 수 있게 구성함.

## Requirements

* Actor list: 사용자, 관리자
1. 사용자는 게시판에 로그인할 수 있다. 사용자의 구분은 로그인 한 계정으로 구분한다.
2. 사용자는 게시판에 글을 작성할 수 있다.
3. 사용자는 게시판에 글을 열람할 수 있다.
4. 사용자는 자신이 작성한 글을 수정할 수 있다.
5. 사용자는 자신이 작성한 글을 삭제할 수 있다.
6. 관리자는 게시판에 로그인할 수 있다. 관리자는 여러 명 존재할 수 있다.
7. 관리자는 게시판에 글을 열람할 수 있다.
8. 관리자는 모든 글을 삭제할 수 있다.
9. 한 페이지에 글은 20개 까지 표시한다.
10. 모든 actor는 글을 제목으로 검색할 수 있다.
11. 모든 actor는 글을 내용으로 검색할 수 있다.
12. 모든 actor는 글을 제목 + 내용으로 검색할 수 있다.
13. 모든 actor는 자신의 회원 정보를 열람할 수 있다.
14. 모든 actor는 자신의 회원 정보를 수정할 수 있다. (단, 고유 ID 제외)

## Tech. Stacks

* Spring as backend
* React as frontend
* PostgreDB as database
* Service on cloud(AWS? GCP?)...? maybe?

## URL 구성

### 공개 url

* /article: 게시판 목록과 관련된 정보를 의미함.
    * GET: 아무 쿼리가 없을 때, 시간 내림차순으로 최신 20개의 게시글을 표시함.\
    page 쿼리가 있을 때, 시간 내림차순으로 20*(n-1) 번째의 게시글을 표시함.\
    title 쿼리가 있을 때, 제목에 해당 쿼리 글귀를 포함하는 20*(n-1) 번째의 게시글을 표시함.\
    body 쿼리가 있을 때, 내용에 해당 쿼리 글귀를 포함하는 20*(n-1) 번째의 게시글을 표시함.\
    anywhere 쿼리가 있을 때, 제목 또는 내용에 해당 쿼리 글귀를 포함하는 20*(n-1) 번째의 게시글을 표시함.
* /article/{article_no}: 게시글과 관련된 정보를 의미함.
    * GET: 해당 번호의 게시글을 열람함.
* /article/{article_no}/edit: 게시글 수정과 관련된 정보를 의미함.
    * GET: 해당 번호의 게시글 수정 페이지를 열람함. 권한 없을 시 열람 불가. (작성자)
* /article/new: 게시글과 관련된 정보를 의미함.
    * GET: 게시글 작성 페이지를 열람함.
* /member: 회원 목록과 관련된 정보를 의미함.
    * GET: 시스템에 등록 된 회원 목록 페이지를 열람함. 권한 없을 시 열람 불가. (관리자)
* /member/{member_no}: 회원과 관련된 정보를 의미함.
    * GET: 해당 회원 번호의 회원 정보 페이지를 열람함. 권한 없을 시 열람 불가. (관리자, 회원)
* /member/{member_no}/edit: 회원 정보 수정과 관련된 정보를 의미함.
    * GET: 해당 회원 번호의 회원 정보 수정 페이지를 열람함. 권한 없을 시 열람 불가. (관리자, 회원)
* /member/new: 회원 가입과 관련된 정보를 의미함.
    * GET: 회원 가입 페이지를 열람함.

### API url

* /api/article?id={page_no}: page_no 번째에 위치하는 게시글의 정보를 의미함.
    * GET: 해당 번호의 페이지 수에 있는 게시글의 ID와 제목, 작성자, 작성 시간을 열람함.
* /api/article: 게시글과 관련된 정보를 의미함.
    * POST: 새로운 게시글을 게시함. Request body에 글 제목 글 내용이 포함.
* /api/article?id={article_no}: article_no ID의 게시글과 관련된 정보를 의미함.
    * GET: 해당 번호의 게시글을 열람함.
    * PUT: 해당 번호의 게시글을 갱신함. Request body에 글 제목 글 내용이 포함.
    * DELETE: 해당 번호의 게시글을 삭제함.
* /api/member?id={page_no}: page_no 번째에 위치하는 회원들의 정보를 의미함.
    * GET: 해당 번호의 페이지 수에 있는 회원들의 ID와 이름을 열람함.
* /api/member: 회원과 관련된 정보를 의미함.
    * POST: 새로운 회원 정보를 게시함. Request body에 글 제목 글 내용이 포함.
* /api/member?id={member_no}: member_no ID의 회원과 관련된 정보를 의미함.
    * GET: 해당 번호의 회원 정보를 열람함.
    * PUT: 해당 번호의 회원 정보를 갱신함. Request body에 글 제목 글 내용이 포함.
    * DELETE: 해당 번호의 회원 정보를 삭제함.

### HackerNews 관련 API

아래 항목은 https://github.com/HackerNews/API 에 소개되는 Live Data 항목, Item 항목을 그대로 받아와 전달하는 정보를 의미함.

* /hackernews/maxitem
* /hackernews/topstories
* /hackernews/newstories
* /hackernews/beststories
* /hackernews/askstories
* /hackernews/showstories
* /hackernews/jobstories
* /hackernews/updates
* /hackernews/item/{item_id}

## 생각이 필요한 부분
* Request body에 회원 정보가 넘어갈 때, 비밀번호는 어떻게 암호화할까?
* API url은 외부 공개되지 않도록 숨겨야 할까? 만약 그렇다면, 어떻게 숨겨야 할까?

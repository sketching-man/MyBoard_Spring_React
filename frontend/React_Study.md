# Header
React 관련 혼자 study한 내용들을 여기에 기록.\
공부한 내용 기록 + Git 잔디심기를 위한 activity!

# React란?
React는 라이브러리이다.\
페이스북이 만든 사용자 UI 구축을 위한 "라이브러리"이며, 오직 사용자의 View 에만 초점을 맞춘다.

# React의 특징
## JSX
JSX는 자바스크립트 안에서 HTML 문법을 사용해서 view를 구성할 수 있게 도와주는 자바스크립트 문법이다.\
```
function App() {
  return (
    <div className="App">
      <header className="App-header">
        <img src={logo} className="App-logo" alt="logo" />
        <p>
          Edit <code>src/App.js</code> and save to reload.
        </p>
        <a
          className="App-link"
          href="https://reactjs.org"
          target="_blank"
          rel="noopener noreferrer"
        >
          Learn React
        </a>
      </header>
    </div>
  );
}
```
원래 JS 안에서는 저런 문법 사용이 불가능 하지만, JSX로는 가능하다.\
물론 HTML 없이도 정상적으로 페이지 생성 가능.

## Component 기반
To be filled!

## Virtual DOM
To be filled!

# 참고한 링크
https://berkbach.com/%EA%B8%B0%EC%B4%88%EB%B6%80%ED%84%B0-%EB%B0%B0%EC%9A%B0%EB%8A%94-react-js-1531b18f7bb2

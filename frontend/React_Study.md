# Header
React 관련 혼자 study한 내용들을 여기에 기록.\
공부한 내용 기록 + Git 잔디심기를 위한 activity!

# React란?
React는 라이브러리이다.\
페이스북이 만든 사용자 UI 구축을 위한 "라이브러리"이며, 오직 사용자의 View 에만 초점을 맞춘다.

# React의 특징
## JSX
JSX는 JavaScript 안에서 HTML 문법을 사용해서 view를 구성할 수 있게 도와주는 JavaScript 문법이다.\
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
여러 부분을 분할 해서 코드의 재사용성과 유지보수성을 올릴 수 있음.\
본 프로젝트의 상기 function App()을 봤을 때, 저런 식으로 만들어 둔 컴포넌트를 다른 여러 페이지나 또 다른 컴포넌트에서 활용이 가능함.\
하나의 객체처럼 만들어 둔다고 이해해도 무방할 듯.\
다만 최근의 JavaScript 환경에서 React는 class 형 component 사용보다는 function 형 component 식 사용을 더 권장한다.
### Class component vs Function component
``` 
// Class Component
import React, {Component} from 'react';

class App extends Component {
  render() {
    const name = 'react';
    return <div className="react">{name}</div>
  }
}

export default App;
```
```
// Function component
import React from 'react';
import './App.css';

function App() {
  const name = 'react';
  return <div className = "react">{name}</div>
}

export default App;
```
To Be Filled


## Virtual DOM
### Dom이란?
To Be Filled

# 참고한 링크
https://berkbach.com/%EA%B8%B0%EC%B4%88%EB%B6%80%ED%84%B0-%EB%B0%B0%EC%9A%B0%EB%8A%94-react-js-1531b18f7bb2\
https://devowen.com/298\
https://velog.io/@sdc337dc/0.%ED%81%B4%EB%9E%98%EC%8A%A4%ED%98%95-%EC%BB%B4%ED%8F%AC%EB%84%8C%ED%8A%B8

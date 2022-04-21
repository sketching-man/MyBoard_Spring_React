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
다만 최근의 JavaScript 환경에서 React는 class component 사용보다는 function component 식 사용을 더 권장한다.
### Class component vs Function component
* 일반적 차이\
클래스형 -\
메모리 자원을 함수형 컴포넌트보다 조금 더 사용한다.\
임의 메서드를 정의할 수 있다.\
함수형 -\
메모리 자원을 함수형 컴포넌트보다 덜 사용한다.\
컴포넌트 선언이 편하다.
* Class component 예시
``` 
// Class Component
import React, {Component} from 'react';

class App extends Component { // 'react'에서 import 받은 Component의 상속을 받는 class여야 함
  render() { // 클래스 내 메서드 중 하나인 render()를 정의하면 page를 그릴 때 call 됨
    const name = 'react';
    return <div className="react">{name}</div>
  }
}

export default App;
```
* Function component
```
// Function component
import React from 'react';
import './App.css';

function App() { // class 선언 필요 없음. Component import 필요 없음.
  const name = 'react';
  return <div className = "react">{name}</div> // render() 메서드 선언 없이 함수 내용만 채우면 됨.
}

export default App;
```
* State 사용에서 차이가 있음: State란? component 내부에서 사용하는 변수\
* class 형의 경우, constructor 안에서 혹은 클래스 안 메서드 밖에서 this.state 초기 값 설정 가능.\
이 때 state는 객체 형식이며, this.setState() 메서드로 state 수정 가능
```
constructor(props) {
  super(props);
  this.state = {
    val1 = "asdf",
  }
}
// 혹은
class MyClass extends Component {
  state = {
    val1 = "asdf",
  }
}
```
```
onClick = {
  () => {
    this.setState({val1 = "qwer"});
  }
}
```
* function 형의 경우, useState 메서드로 state 사용 가능.\
 이 함수를 호출해주면 배열이 반환되는데, 여기서 첫번째 원소는 현재 상태, 두번째 원소는 Setter 함수.
```
import React, { useState } from 'react';

const [number, setNumber] = useState(0);
const onIncrease = () => {
    setNumber(number + 1);
  }
const onDecrease = () => {
    setNumber(number - 1);
  }
```
* props 사용에서 차이가 있음: props(properties의 줄임말)란? 상위 컴포넌트가 하위 컴포넌트에 값을 전달하는 매개체이며, 프로퍼티는 수정할 수 없음.
* class 형의 경우, this.props로 사용.
```
class MyClass extends Component {
  render {
    const {val1, val2, val3} = this.props;
    return (
      <div>
        val1 = {val1}, val2 = {val2}, val3 = {val3}
      </div>
    )
  }
}
```
* function 형의 경우, props.{요소이름} 식으로 사용하거나 이름 직접 선언 후 바로 사용 가능.
```
function MyFunction = ({val1, val2, val3}) => { // 혹은 {props} 로 가능
  return (
    <div>
      val1 = {val1}, val2 = {val2}, val3 = {val3} // {props}로 불렀다면 props.val1
    </div>
  )
}
```

## Virtual DOM
### DOM이란?
![DOM트리](https://miro.medium.com/max/1400/1*Vvi4_infsE8Q0uAStZmiWw.png)
DOM = Document Object Model, 문서 객체 모델임.\
위 그림과 같이 트리 구조로 이루어져 있으며, 어떤 행동으로(JavaScript?) 페이지의 DOM이 수정될 때 전체 트리를 재생성함.\
단, Single Page Application(SPA) 개발 시 이런 액션이 비효율적임.
### Virtual DOM이란?
Virtual DOM은 실제 DOM과 다른, 미리 연산용 공간임.\
DOM이 아니기 때문에 렌더링도 되지 않고 연산 비용이 비교적 실제 DOM 보다는 적음.\
그 가상 DOM의 변화를 마지막에 실제 DOM에게 던져주어, 모든 변화를 한번에 렌더링.\
바뀌지 않은 부분과 바뀐 부분을 자동으로 감지해서 DOM 문서를 선택적으로 업데이트하기 때문에 연산 오버헤드가 최소화.

# 참고한 링크
https://berkbach.com/%EA%B8%B0%EC%B4%88%EB%B6%80%ED%84%B0-%EB%B0%B0%EC%9A%B0%EB%8A%94-react-js-1531b18f7bb2\
https://devowen.com/298\
https://velog.io/@sdc337dc/0.%ED%81%B4%EB%9E%98%EC%8A%A4%ED%98%95-%EC%BB%B4%ED%8F%AC%EB%84%8C%ED%8A%B8\
https://react.vlpt.us/basic/\
https://goddaehee.tistory.com/300
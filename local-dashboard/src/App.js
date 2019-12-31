import React, { Component, Fragment } from 'react';
import './App.css';

import Toolbar from './components/Navigation/Toolbar/Toolbar';
import StatusBoard from './containers/StatusBoard/StatusBoard';

class App extends Component {
  render() {
    return (
      <Fragment>
        <Toolbar></Toolbar>
        <StatusBoard></StatusBoard>
      </Fragment>
    );
  }
}

export default App;

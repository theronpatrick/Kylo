/**
 * Sample React Native App
 * https://github.com/facebook/react-native
 * @flow
 */

import React, { Component } from 'react';
import {
  AppRegistry,
  StyleSheet,
  Text,
  View,
  Dimensions,
  Alert,
  TouchableHighlight
} from 'react-native';

import { Col, Row, Grid } from "react-native-easy-grid";

import Sound from 'react-native-sound';

// List sounds
let sounds = [
  "kick1",
  "bass 2",
  "bass 1",
  "rip 1",
  "shake 1",
  "snare 1"
];

let soundFiles = [];

export default class Kylo extends Component {

  componentWillMount = () => {
    // Load sounds
    for (let i = 0; i < sounds.length; i++) {

      let sound = new Sound(`${sounds[i]}.wav`, Sound.MAIN_BUNDLE, (error) => {
        if (error) {
          console.log('failed to load the sound', error);
        } else { // loaded successfully
          console.log('duration in seconds: ' + sound.getDuration() +
              'number of channels: ' + sound.getNumberOfChannels());
        }
      });

      soundFiles.push(sound);

    }

  }

  padPress = (padNum) => {

    console.log("play sound " , padNum);

    // Cancel if we don't have sound
    if (padNum > soundFiles.length -1) {
      return;
    }

    soundFiles[padNum].stop();
    soundFiles[padNum].play((success) => {
      if (success) {
        console.log('successfully finished playing');
      } else {
        console.log('playback failed due to audio decoding errors');
      }
    });
  }

  getRandomColor = () => {
      var letters = '0123456789ABCDEF'.split('');
      var color = '#';
      for (var i = 0; i < 6; i++ ) {
          color += letters[Math.floor(Math.random() * 16)];
      }
      return color;
  };

  render() {

    console.log("rendering...");

    let width = Dimensions.get('window').width;
    let height = Dimensions.get('window').height;

    let padWidth = {
      "width": width * 0.25
    }

    let numPads = 16;
    let numCols = 4;
    let pads = [];
    let padNum = 0;

    for (let i = 0; i < numPads; i++) {

      let randomColor = this.getRandomColor();

      let rowStyle = {
        backgroundColor: randomColor
      }

      pads.push(<Row
        key={`row-${i}`}
        style={[rowStyle, {flex: 1}]}>
          <TouchableHighlight onPressIn={this.padPress.bind(this, padNum)} underlayColor="gray">
            <View style={[padWidth]}></View>
          </TouchableHighlight>
        </Row>
      )

      padNum++;
    }

    let cols = [];
    for (let j = 0; j < numCols; j++) {

      let rows = pads.slice(4 * j, 4 * j + 4);

      cols.push(<Col key={`col-${j}`}>
          {rows}
        </Col>
      )
    }


    return (
      <View style={[{flex: 1}]}>
        <Grid>
          {cols}
        </Grid>
      </View>
    );
  }
}

const styles = StyleSheet.create({
  container: {
    flex: 1,
    justifyContent: 'center',
    alignItems: 'center',
    flexDirection: "row",
    backgroundColor: '#F5FCFF',
  },
  pad: {
    flex: 0.5,
    flexDirection: "row",
    alignItems: "center"
  },
  blue: {
    backgroundColor: "steelblue"
  },
  green: {
    backgroundColor: "green"
  },
  orange: {
    backgroundColor: "orange"
  },
  purple: {
    backgroundColor: "purple"
  }
});

AppRegistry.registerComponent('Kylo', () => Kylo);

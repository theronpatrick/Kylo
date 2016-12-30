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
  "bass 1",
  "bass 2",
  "kick1",
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

  padPress = () => {

    console.log("play sound");
    soundFiles[0].stop();
    soundFiles[0].play((success) => {
      if (success) {
        console.log('successfully finished playing');
      } else {
        console.log('playback failed due to audio decoding errors');
      }
    });
  }

  render() {

    console.log("rendering...");

    let width = Dimensions.get('window').width;
    let height = Dimensions.get('window').height;

    let padWidth = {
      "width": width * 0.25
    }

    let padNumber = 16;
    let pads = [];

    for (let i = 0; i < padNumber; i++) {
      pads.push(<Row
        style={[styles.green, {flex: 1}]}>
          <TouchableHighlight onPress={this.padPress} underlayColor="gray">
            <View style={[padWidth]}></View>
          </TouchableHighlight>
        </Row>
      )
    }

    return (
      <View style={[{flex: 1}]}>
        <Grid>
          <Col>
            <Row style={styles.blue}>
            </Row>
            <Row style={[styles.green, {flex: 1}]}>
              <TouchableHighlight onPress={this.padPress} underlayColor="gray">
                <View style={[padWidth]}></View>
              </TouchableHighlight>
            </Row>
            <Row style={styles.blue}></Row>
          </Col>
          <Col>
            <Row style={styles.green}></Row>
            <Row style={styles.blue}></Row>
            <Row style={styles.green}></Row>
          </Col>
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
  }
});

AppRegistry.registerComponent('Kylo', () => Kylo);

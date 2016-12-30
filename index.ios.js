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
  Dimensions
} from 'react-native';

import { Col, Row, Grid } from "react-native-easy-grid";

export default class Kylo extends Component {
  render() {

    let width = Dimensions.get('window').width;
    let height = Dimensions.get('window').height;

    let halfWidth = {
      "width": width * 0.5
    }

    return (
      <View style={[{flex: 1}]}>
        <Grid>
          <Col>
            <Row style={styles.blue}></Row>
            <Row style={styles.green}></Row>
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

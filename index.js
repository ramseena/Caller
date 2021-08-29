/**
 * @format
 */

import {AppRegistry} from 'react-native';
import App from './App';
import {name as appName} from './app.json';
import invokeApp from 'react-native-invoke-app'

AppRegistry.registerComponent(appName, () => App);

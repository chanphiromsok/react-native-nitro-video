import type { HybridObject } from 'react-native-nitro-modules';
import type { VideoPlayer } from './VideoPlayer.nitro';

export interface NitroVideo
  extends HybridObject<{ ios: 'swift'; android: 'kotlin' }> {
  createPlayer(uri: string): VideoPlayer;
}

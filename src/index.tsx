import { getHostComponent, NitroModules } from 'react-native-nitro-modules';
import type { NitroVideo } from './spec/NitroPlayer.nitro';
import type { VideoPlayer } from './spec/VideoPlayer.nitro';
import type { VideoViewMethods, VideoViewProps } from './spec/VideoView.nitro';

const VideoViewConfig = require('../nitrogen/generated/shared/json/VideoViewConfig.json');

export const VideoView = getHostComponent<VideoViewProps, VideoViewMethods>(
  'VideoView',
  () => VideoViewConfig
);

const module = NitroModules.createHybridObject<NitroVideo>('NitroVideo');

export function createNitroPlayer(uri: string): VideoPlayer {
  return module.createPlayer(uri);
}

// Export types
export type {
  VideoPlayer,
  VideoPlayerSourceBase,
} from './spec/VideoPlayer.nitro';
export type { VideoViewProps, VideoViewMethods } from './spec/VideoView.nitro';

import type {
  HybridView,
  HybridViewMethods,
  HybridViewProps,
} from 'react-native-nitro-modules';
import type { VideoPlayer } from './VideoPlayer.nitro';

export interface VideoViewProps extends HybridViewProps {
  player?: VideoPlayer;
}
export interface VideoViewMethods extends HybridViewMethods {}

export type VideoView = HybridView<VideoViewProps, VideoViewMethods>;
